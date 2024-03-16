package com.videoplatform.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PartyMember {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String partyMemberId;
	
	@ManyToOne
	@JoinColumn(name = "party_id")
	private Party party;
}
