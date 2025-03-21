package org.howard.edu.lsp.midterm.question3;



/**
 * The VotingMachineTest class demonstrates the usage of the VotingMachine class.
 */
public class VotingMachineTest {
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();

        // Adding candidates
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");

        // Casting votes
        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        
        // Attempt to vote for a non-existent candidate
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success);

        // Displaying the winner
        System.out.println("Winner: " + vm.getWinner());
    }
}
