package com.example.chapter4.domain.region.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="region")
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class Region {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=200, unique = true)
    private String name;
}
