package com.videoplatform.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.videoplatform.backend.model.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, String> {

}
