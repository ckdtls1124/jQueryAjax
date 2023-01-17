package org.spring.AjaxProject1.repository;

import org.spring.AjaxProject1.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepo extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByUsername(String username);
}
