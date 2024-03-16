package com.videoplatform.backend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Party {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String partyId;
	
	@Column
	private String partyName;
	
	@Column 
	private String partyPicture;
	
	@Column
	private String partyAdmin;
	
	@OneToMany(mappedBy = "party")
	private List<PartyMember> partyMembers;
	
	@OneToMany(mappedBy = "party")
	private List<Message> messages;
	
	

}
