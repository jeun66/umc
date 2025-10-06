package com.example.chapter4.domain.term.entity;

import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter4.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="user_term",
        uniqueConstraints = {
                @UniqueConstraint(name="uk_user_term_member_term", columnNames = {"member_id","term_id"})
        })
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class UserTerm extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="member_id", nullable=false)
    private Member member;

    @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="term_id", nullable=false)
    private Term term;
}
