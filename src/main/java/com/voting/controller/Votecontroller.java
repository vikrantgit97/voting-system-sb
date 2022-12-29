package com.voting.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voting.exception.VoteException;
import com.voting.service.Voteservice;

@RestController
public class Votecontroller {

	@Autowired
	private Voteservice voteservice;

	@PostMapping("/entercandidate")
	public ResponseEntity<VoteException> enterCanditateName(@RequestParam("name") String candidatename) {
		voteservice.enterCandidate(candidatename);
		return ResponseEntity.ok(new VoteException("sucessfull"));
	}

	@PostMapping("/castvote")
	public ResponseEntity<VoteException> castvote(@RequestParam("name") String candidatename) {
		voteservice.castVote(candidatename);
		return ResponseEntity.ok(new VoteException("sucessfull"));
	}

	@PostMapping("/countvote")
	public ResponseEntity<VoteException> getCountVotes(@RequestParam("name") String candidatename) {
		voteservice.getVotes(candidatename);
		return ResponseEntity
				.ok(new VoteException("vote of " + candidatename + " : " + voteservice.getVotes(candidatename)));
	}

	@GetMapping("/listvote")
	public ResponseEntity<Map<String, Integer>> getVotelist() {
		return ResponseEntity.ok(voteservice.getList());
	}

	@GetMapping("/getwinner")
	public ResponseEntity<VoteException> getVotingWinner() {
		return ResponseEntity.ok(new VoteException(voteservice.getWinner()));
	}

}
