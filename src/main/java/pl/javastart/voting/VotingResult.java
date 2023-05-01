package pl.javastart.voting;

import java.util.List;

import static pl.javastart.voting.VoteVariants.*;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    private List<Vote> votes;
    private double favourPercentage;
    private double opposePercentage;
    private double abstainPercentage;

    public VotingResult(List<Vote> votes) {
        this.votes = votes;
        this.favourPercentage = getPercentage(FAVOUR);
        this.opposePercentage = getPercentage(OPPOSE);
        this.abstainPercentage = getPercentage(ABSTAIN);
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        System.out.printf("Głosów za: %.2f%%\n", favourPercentage);
        System.out.printf("Głosów przeciw: %.2f%%\n", opposePercentage);
        System.out.printf("Wstrzymało się: %.2f%%\n", abstainPercentage);
    }

    private double getPercentage(String option) {
        return (double) getVotesForGivenOption(option) / this.votes.size() * 100;
    }

    private int getVotesForGivenOption(String option) {
        int votesForGivenOption = 0;
        for (Vote vote : votes) {
            if (vote.getVote().equals(option)) {
                votesForGivenOption++;
            }
        }

        return votesForGivenOption;
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        for (Vote vote : votes) {
            if (vote.getVoter().equals(voterName)) {
                System.out.println(vote);
            }
        }
    }
}
