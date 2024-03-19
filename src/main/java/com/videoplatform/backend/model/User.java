package com.videoplatform.backend.model;

import java.time.LocalDateTime;
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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// remove builder later
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

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
	@OneToMany(mappedBy = "user")
	private List<WatchHistory> watchHistory;

	/*
	 * one to many relationship from user to watch history
	 * multiple parties user part of
	 */
	@OneToMany(mappedBy = "user")
	private List<PartyMember> partyMember;

	// UserDetails implemented methods

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
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
		return true;
	}

}
