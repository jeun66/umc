package com.example.chapter4.domain.mission.entity;

import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.domain.region.entity.Region;
import com.example.chapter4.domain.restaurant.entity.Restaurant;
import com.example.chapter4.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user_mission",
        indexes = {
                @Index(name="idx_um_member", columnList="member_id"),
                @Index(name="idx_um_mission", columnList="mission_id")
        },
        uniqueConstraints = @UniqueConstraint(name="uk_user_mission_member_mission", columnNames = {"member_id","mission_id"}))
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class UserMission extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="member_id", nullable=false)
    private Member member;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="mission_id", nullable=false)
    private Mission mission;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="region_id")
    private Region region;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    @Column(name="is_complete", nullable=false)
    @Builder.Default
    private boolean complete = false;
}
