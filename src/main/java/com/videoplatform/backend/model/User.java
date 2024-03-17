package com.videoplatform.backend.model;

import java.util.Arrays;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String userId;
	@Column
	private String username;
	@Column
	private String email;
	@Column
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
	
	
	// DO NOT EDIT AFTER THIS: auto generated methods start here
	public User() {
		super();
	}

	public User(String userId, String username, String email, String passwordHash, String firstName, String lastName,
			byte[] profilePicture, List<WatchHistory> watchHistory, List<PartyMember> partyMember) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.passwordHash = passwordHash;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profilePicture = profilePicture;
		this.watchHistory = watchHistory;
		this.partyMember = partyMember;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public List<WatchHistory> getWatchHistory() {
		return watchHistory;
	}

	public void setWatchHistory(List<WatchHistory> watchHistory) {
		this.watchHistory = watchHistory;
	}

	public List<PartyMember> getPartyMember() {
		return partyMember;
	}

	public void setPartyMember(List<PartyMember> partyMember) {
		this.partyMember = partyMember;
	}
	

	@Override
	public String toString() {
		return "User :\n[\n   " + (userId != null ? "userId = " + userId + ", \n   " : "")
				+ (username != null ? "username = " + username + ", \n   " : "")
				+ (email != null ? "email = " + email + ", \n   " : "")
				+ (passwordHash != null ? "passwordHash = " + passwordHash + ", \n   " : "")
				+ (firstName != null ? "firstName = " + firstName + ", \n   " : "")
				+ (lastName != null ? "lastName = " + lastName + ", \n   " : "")
				+ (profilePicture != null ? "profilePicture = " + Arrays.toString(profilePicture) + ", \n   " : "")
				+ (watchHistory != null ? "watchHistory = " + watchHistory + ", \n   " : "")
				+ (partyMember != null ? "partyMember = " + partyMember : "") + "\n]";
	}

	
}
