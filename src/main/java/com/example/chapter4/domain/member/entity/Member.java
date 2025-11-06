package com.example.chapter4.domain.member.entity;

import com.example.chapter4.domain.common.Gender;
import com.example.chapter4.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member",
        indexes = {
                @Index(name = "idx_member_email", columnList = "email"),
                @Index(name = "idx_member_phone", columnList = "phone")
        })
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=20)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name="birth_year", length=4)
    private String birthYear;

    @Column(name="birth_month", length=2)
    private String birthMonth;

    @Column(name="birth_day", length=2)
    private String birthDay;

    @Column(length=200)
    private String address;

    // createdAt/updatedAt은 BaseEntity로 자동 관리

    @Column(length=20)
    private String status;

    @Column(length=20)
    private String field;   // ERD의 field 컬럼(의미에 맞게 수정 가능)

    private Integer point;

    @Column(length=20)
    private String nickname;

    @Column(length=200, unique = true)
    private String email;

    @Column(length=20, unique = true)
    private String phone;
}
