package com.example.chapter4.domain.mission.entity;

import com.example.chapter4.domain.restaurant.entity.Restaurant;
import com.example.chapter4.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="mission")
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class Mission extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="restaurant_id", nullable=false)
    private Restaurant restaurant;

    private Integer point;

    private LocalDate deadline;

    @Column(length=20)
    private String condition;
}
