package com.voting.repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class VoteRepository {

	private  static  Map<String, Integer> candidate = new HashMap<>();

	public boolean checkCandidate(String name) {
		return candidate.containsKey(name);
	}

	public void enterCandidate(String name) {
		candidate.putIfAbsent(name, 0);
	}

	public void castVote(String name) {
		candidate.compute(name, (key, value) -> {
			if (value == null)
				return 0;
			return value + 1;
		});
	}

	public Integer countVotes(String name) {
		return candidate.get(name);
	}

	public Map<String, Integer> getList() {
		return Collections.unmodifiableMap(candidate);
	}

	public String getWinner() {
		return candidate.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey)
				.orElse(null);
	}
}
