package com.example.chapter4.domain.review.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="review_photo",
        indexes = @Index(name="idx_review_photo_review", columnList="review_id"))
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class ReviewPhoto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="review_id", nullable=false)
    private Review review;

    @Column(name="photo_url", length=200, nullable=false)
    private String photoUrl;
}
