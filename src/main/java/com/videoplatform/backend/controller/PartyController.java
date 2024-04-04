package com.videoplatform.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videoplatform.backend.model.Party;
import com.videoplatform.backend.service.PartyService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class PartyController {
	@Autowired
	private HttpServletRequest req;
	
	@Autowired
	private PartyService partyService;
	
	// test remove after
	@GetMapping("partys")
	private List<Party> getAllPartys() {
		return partyService.getAllParty();	
	}
	
	// gets the parties the user is an admin
	@GetMapping("party/admin")
	private List<Party> getPartyByUseremail(Authentication authentication){
		// TODO
		return null;
	}
	
	@PostMapping("party")
	private void addParty(@RequestBody Party party, Authentication authentication) {
		party.setPartyAdmin(authentication.getName());
		partyService.addParty(party);		
	}
	
	

	
}
