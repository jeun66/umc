package com.example.chapter4.domain.food.entity;

import com.example.chapter4.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="food_select",
        uniqueConstraints = @UniqueConstraint(name="uk_food_select_member_food", columnNames = {"member_id","food_id"}))
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class FoodSelect {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="member_id", nullable=false)
    private Member member;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="food_id", nullable=false)
    private Food food;
}
