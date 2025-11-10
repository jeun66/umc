package com.example.chapter5.repository;

import com.example.chapter4.domain.mission.entity.Mission;
import com.example.chapter5.dto.MissionHomeItem;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("""
        select new com.example.chapter5.dto.MissionHomeItem(
            m.id, r.name, r.category, m.condition, m.point, m.deadline
        )
        from Mission m
        join m.restaurant r
        join r.region rg
        left join com.example.chapter4.domain.usermission.entity.UserMission um
          on um.mission = m and um.user.id = :userId
        where rg.name = :regionName
          and um.id is null
        order by m.deadline asc, m.id desc
    """)
    Page<MissionHomeItem> findHomeItems(
            @Param("regionName") String regionName,
            @Param("userId") Long userId,
            Pageable pageable
    );
}
