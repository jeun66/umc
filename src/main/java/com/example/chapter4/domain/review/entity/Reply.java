package com.example.chapter4.domain.review.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="reply")
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class Reply {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ERD상 Reply 테이블에 review_id가 FK → 여기서 FK를 가짐 (1:1)
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="review_id", nullable=false, unique=true)
    private Review review;

    @Lob
    private String content;
}
