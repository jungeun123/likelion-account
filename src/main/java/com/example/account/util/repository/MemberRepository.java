package com.example.account.util.repository;

import com.example.account.util.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MemberRepository extends JpaRepository<Members, Long> {
    Optional<Members> findByUserId(String userId);
}
