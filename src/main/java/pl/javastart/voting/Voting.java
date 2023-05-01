package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static pl.javastart.voting.VoteVariants.*;

public class Voting {

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        // możesz dowolnie dodawać / usuwać dane testowe
        voters.add("Janusz Kowalski");
        voters.add("Zbigniew Stonoga");
        voters.add("Janusz Korwin-Mikke");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Janusz Kowalski");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        List<Vote> votes = new ArrayList<>();

        for (String voter : voters) {
            boolean voteValid = false;
            Vote vote = null;
            while (!voteValid) {
                System.out.printf("Jak głosuje %s? (z - za, p - przeciw, w - wstrzymanie się)\n", voter);
                switch (scanner.nextLine()) {
                    case FAVOUR -> {
                        vote = new Vote(voter, FAVOUR);
                        voteValid = true;
                    }
                    case OPPOSE -> {
                        vote = new Vote(voter, OPPOSE);
                        voteValid = true;
                    }
                    case ABSTAIN -> {
                        vote = new Vote(voter, ABSTAIN);
                        voteValid = true;
                    }
                    default -> System.out.println("Nieprawidłowa opcja");
                }
            }
            votes.add(vote);
        }

        VotingResult votingResult = new VotingResult(votes);

        return votingResult;
    }

}
