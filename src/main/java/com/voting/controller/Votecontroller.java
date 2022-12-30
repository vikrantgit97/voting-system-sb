package com.voting.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voting.service.Voteservice;

@RestController
public class Votecontroller {

	@Autowired
	private Voteservice voteservice;

	@PostMapping("/entercandidate")
	public ResponseEntity<String> enterCanditateName(@RequestParam("name") String candidatename) {
		if (candidatename != null) {
			voteservice.enterCandidate(candidatename);
			return ResponseEntity.ok().body(candidatename);
		} else {
			return ResponseEntity.badRequest().body("not  found");
		}
	}

	@PostMapping("/castvote")
	public ResponseEntity<String> castvote(@RequestParam("name") String candidatename) {
		if (candidatename != null) {
			voteservice.castVotes(candidatename);
			return ResponseEntity.ok().body(candidatename);
		} else {
			return ResponseEntity.badRequest().body("not  found");
		}
	}

	@PostMapping("/countvote")
	public ResponseEntity<String> getCountVotes(@RequestParam("name") String candidatename) {
		if (candidatename != null) {
			Integer votes=voteservice.getVotes(candidatename);
			return ResponseEntity.ok().body(candidatename+" : "+votes);
		} else {
			return ResponseEntity.badRequest().body("not  found");
		}
	}

	@GetMapping("/listvote")
	public ResponseEntity<Map<String, Integer>> getVotelist() {
		return ResponseEntity.ok(voteservice.getList());
	}

	@GetMapping("/getwinner")
	public ResponseEntity<String> getVotingWinner() {
		String winner= voteservice.getWinner();
		if (winner != null) {
			return ResponseEntity.ok().body(" "+winner);
		} else {
			return ResponseEntity.badRequest().body("not  found");
		}
	}
}
