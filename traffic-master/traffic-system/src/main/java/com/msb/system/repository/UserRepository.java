package com.msb.system.repository;

import com.msb.system.dto.UserInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {
    @Modifying
    @Transactional
    @Query("update UserInfo set ustatus = 1 where uid in (?1)")
    public int deleteUserByIds(Collection<Long> ids);
    public List<UserInfo> findAllByUtimeIsBetween(Date startTime, Date endTime);
}
