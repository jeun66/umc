package com.example.chapter4.domain.review.entity;

import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.domain.restaurant.entity.Restaurant;
import com.example.chapter4.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="review",
        indexes = {
                @Index(name="idx_review_member", columnList="member_id"),
                @Index(name="idx_review_restaurant", columnList="restaurant_id")
        })
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class Review extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="member_id", nullable=false)
    private Member member;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="restaurant_id", nullable=false)
    private Restaurant restaurant;

    @Column(length=200)
    private String title;

    @Lob
    private String content;

    @Column(length=20)
    private String rate; // 문자열 평점(필요 시 Integer/Decimal로 교체)

    @OneToOne(mappedBy="review", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private Reply reply;
}
