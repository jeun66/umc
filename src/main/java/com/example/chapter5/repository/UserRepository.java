package com.example.chapter5.repository;

import com.example.chapter4.domain.member.entity.Member;
import com.example.chapter5.dto.MyPageView;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Member, Long> {

    <T> Optional<T> findProjectedById(Long id, Class<T> type);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select u from User u where u.id = :id")
    Optional<Member> lockById(@Param("id") Long id);
}
