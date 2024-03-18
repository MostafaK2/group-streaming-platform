package com.videoplatform.backend.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String userId;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String firstName;
	@Column
	private String lastName;
	
	@Column 
	private String profilePicture;
	@Column 
	private LocalDateTime userCreatedAt;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	
	// one to many relationship from user to watch history
	// multiple watch history per user
	@OneToMany(mappedBy="user")
	private List<WatchHistory> watchHistory;
	
	/* one to many relationship from user to watch history
	 * multiple parties user part of
	 */
	@OneToMany(mappedBy="user")
	private List<PartyMember> partyMember;
	

	// UserDetails implemented methods
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(userType.name()));
	}
	
	@Override
	public String getUsername() {
		return email;
	}


	@Override
	public String getPassword() {
		return password;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	// UserDetails end

	
	
	// DO NOT EDIT AFTER THIS: auto generated methods start here
	public User() {
		super();
	}


	public User(String userId, String username, String email, String passwordHash, String firstName, String lastName,
			String profilePicture, List<WatchHistory> watchHistory, List<PartyMember> partyMember) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = passwordHash;
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


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public String getProfilePicture() {
		return profilePicture;
	}


	public void setProfilePicture(String profilePicture) {
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
				+ (password != null ? "passwordHash = " + password + ", \n   " : "")
				+ (firstName != null ? "firstName = " + firstName + ", \n   " : "")
				+ (lastName != null ? "lastName = " + lastName + ", \n   " : "")
				+ (profilePicture != null ? "profilePicture = " + profilePicture + ", \n   " : "")
				+ (watchHistory != null ? "watchHistory = " + watchHistory + ", \n   " : "")
				+ (partyMember != null ? "partyMember = " + partyMember : "") + "\n]";
	}


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	public LocalDateTime getUserCreatedAt() {
		return userCreatedAt;
	}


	public void setUserCreatedAt(LocalDateTime userCreatedAt) {
		this.userCreatedAt = userCreatedAt;
	}


	


	
}
