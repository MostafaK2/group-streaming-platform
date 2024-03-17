package com.videoplatform.backend.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor
public class PartyMember {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String partyMemberId;
	
	@Column
	private LocalDateTime joinedParty;
	
	// these could be ignored because party members would not be queried by itself.
	@ManyToOne
	@JoinColumn(name = "party_id")
	@JsonIgnore
	private Party party;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
}
