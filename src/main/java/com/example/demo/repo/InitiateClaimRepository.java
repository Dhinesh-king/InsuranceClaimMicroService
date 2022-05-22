package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.InitiateClaim;
@Repository
public interface InitiateClaimRepository extends JpaRepository<InitiateClaim,Integer> {

}
