package com.videoplatform.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videoplatform.backend.model.PartyMember;


@Repository
public interface PartyMemberRepository extends JpaRepository<PartyMember, String>{

}
