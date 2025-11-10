package com.example.chapter6.repository.review;

import com.example.chapter4.domain.review.entity.QReview;
import com.example.chapter4.domain.restaurant.entity.QRestaurant;
import com.example.chapter4.domain.member.entity.QMember;
import com.example.chapter6.dto.ReviewFilter;
import com.example.chapter6.dto.ReviewMyItem;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewQueryRepositoryImpl implements ReviewQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public Page<ReviewMyItem> findMyReviews(Long memberId, ReviewFilter filter, Pageable pageable) {
        QReview review = QReview.review;
        QRestaurant restaurant = QRestaurant.restaurant;
        QMember member = QMember.member;

        BooleanBuilder where = new BooleanBuilder();
        where.and(review.member.id.eq(memberId)); // 로그인한 사용자 기준

        // 가게 필터
        if (filter != null) {
            if (filter.restaurantId() != null) {
                where.and(review.restaurant.id.eq(filter.restaurantId()));
            }
            if (filter.restaurantName() != null && !filter.restaurantName().isBlank()) {
                where.and(review.restaurant.name.containsIgnoreCase(filter.restaurantName()));
            }

            // 별점 필터 (5,4,3,...)
            if (filter.starGrade() != null) {
                double min = Math.max(0, filter.starGrade());
                double max = (min == 5) ? 5.0 : min + 1.0;
                where.and(review.star.goe(min));
                if (min < 5) where.and(review.star.lt(max));
            }
        }

        // 실제 조회 쿼리
        var contentQuery = query
                .select(Projections.constructor(
                        ReviewMyItem.class,
                        review.id,
                        review.restaurant.name,
                        review.content,
                        review.star,
                        review.reply,
                        review.createdAt
                ))
                .from(review)
                .join(review.restaurant, restaurant)
                .join(review.member, member)
                .where(where)
                .orderBy(review.createdAt.desc(), review.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        var content = contentQuery.fetch();

        // count 쿼리
        Long total = query
                .select(review.count())
                .from(review)
                .where(where)
                .fetchOne();

        return new PageImpl<>(content, pageable, total == null ? 0 : total);
    }
}
