package com.example.chapter4.domain.food.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="food",
        indexes = @Index(name="idx_food_name", columnList = "name"))
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class Food {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=20, unique = true)
    private String name;
}
