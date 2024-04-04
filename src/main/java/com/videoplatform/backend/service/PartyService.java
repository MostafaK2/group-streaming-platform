package com.videoplatform.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoplatform.backend.model.Party;
import com.videoplatform.backend.repository.PartyRepository;

@Service
public class PartyService {
	
	@Autowired
	private PartyRepository partyRepository;

	public void addParty(Party party) {
		
		partyRepository.save(party);
		
	}

	public List<Party> getAllParty() {
		
		return partyRepository.findAll();
	}
}
