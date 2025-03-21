package org.howard.edu.lsp.midterm.question3;


import java.util.HashMap;
import java.util.Map;

/**
 * The VotingMachine class simulates a simple electronic voting system.
 * It allows candidates to be added, votes to be cast, and results to be tallied.
 */
public class VotingMachine {
    // Map storing candidate names and their vote counts.
    private Map<String, Integer> candidates;

    /**
     * Constructs a VotingMachine with no candidates.
     */
    public VotingMachine() {
        candidates = new HashMap<>();
    }

    /**
     * Adds a candidate to the machine.
     * If the candidate already exists, this method does nothing.
     *
     * @param candidateName the candidate's name.
     */
    public void addCandidate(String candidateName) {
        if (!candidates.containsKey(candidateName)) {
            candidates.put(candidateName, 0);
        }
    }

    /**
     * Casts a vote for the specified candidate.
     * Votes for non-existent candidates are not recorded.
     *
     * @param candidateName the candidate's name.
     * @return true if the vote was successfully cast, false otherwise.
     */
    public boolean castVote(String candidateName) {
        if (!candidates.containsKey(candidateName)) {
            return false;
        }
        candidates.put(candidateName, candidates.get(candidateName) + 1);
        return true;
    }

    /**
     * Determines the candidate with the highest number of votes.
     * In case of a tie, one candidate is chosen arbitrarily.
     *
     * @return a formatted string indicating the winner and their vote count.
     */
    public String getWinner() {
        String winner = "";
        int maxVotes = -1;
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() > maxVotes) {
                winner = entry.getKey();
                maxVotes = entry.getValue();
            }
        }
        return winner + " WINS with " + maxVotes + " votes!!";
    }
}

