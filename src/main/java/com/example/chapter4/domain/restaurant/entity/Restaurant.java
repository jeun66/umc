package com.example.chapter4.domain.restaurant.entity;

import com.example.chapter4.domain.region.entity.Region;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="restaurant",
        indexes = @Index(name="idx_restaurant_name", columnList = "name"))
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class Restaurant {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="region_id", nullable=false)
    private Region region;

    @Column(nullable=false, length=200)
    private String name;

    @Column(length=200)
    private String address;

    private Integer rate; // 평점(정수 저장. 필요 시 decimal로 변경)
}
