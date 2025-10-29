package com.example.chapter5.repository;

import com.example.chapter4.domain.mission.entity.UserMission;
import com.example.chapter5.dto.UserMissionSummary;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    @Query("""
        select new com.example.chapter5.dto.UserMissionSummary(
            r.name,
            m.condition,
            m.point,
            um.isComplete
        )
        from UserMission um
        join um.mission m
        join um.restaurant r
        where um.user.id = :userId
        order by um.id desc
    """)
    Page<UserMissionSummary> findSummariesByUserId(@Param("userId") Long userId, Pageable pageable);
}
