package com.voting.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voting.repository.VoteRepository;

@Service
public class Voteservice {

	@Autowired
	private VoteRepository voterepo;

	public void enterCandidate(String name) {
		if (voterepo.checkCandidate(name)) {
			throw new IllegalArgumentException("candidate exist");
		}
		voterepo.enterCandidate(name);
	}

	public void castVote(String name) {
		voterepo.castVote(name);
	}

	public int getVotes(String name) {
		if (!voterepo.checkCandidate(name)) {
			throw new IllegalArgumentException("candidate not exist");
		}
		return voterepo.countVotes(name);
	}

	public Map<String, Integer> getList() {
		return voterepo.getList();
	}

	public String getWinner() {
		String winner = voterepo.getWinner();
		if (winner == null || winner.isBlank()) {
			throw new IllegalArgumentException("candidate not found");
		} else {
			return "winner :" + winner;
		}
	}
}
