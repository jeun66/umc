package com.example.chapter4.domain.term.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="term")
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class Term {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=200)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=20)
    private TermType type;
}
