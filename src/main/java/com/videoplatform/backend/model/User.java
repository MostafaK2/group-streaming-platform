package com.videoplatform.backend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String userId;
	
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String passwordHash;
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	
	@Column 
	private byte[] profilePicture;
	
	// one to many relationship from user to watch history
	// multiple watch history per user
	@OneToMany(mappedBy="user")
	private List<WatchHistory> watchHistory;
	
	/* one to many relationship from user to watch history
	 * multiple parties user part of
	 */
	@OneToMany(mappedBy="user")
	private List<PartyMember> partyMember;
}
