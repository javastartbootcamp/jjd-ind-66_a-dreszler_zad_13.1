package pl.javastart.voting;

import static pl.javastart.voting.VoteVariants.*;

// klasa pomocnicza, możesz ją dowolnie zmieniać, albo usunąć
public class Vote {
    private String voter;
    private String vote;

    public Vote(String voter, String vote) {
        this.voter = voter;
        this.vote = vote;
    }

    public String getVoter() {
        return voter;
    }

    public String getVote() {
        return vote;
    }

    @Override
    public String toString() {
        String voteInfo = voter + ": ";
        switch (vote) {
            case FAVOUR -> voteInfo += "ZA";
            case OPPOSE -> voteInfo += "PRZECIW";
            case ABSTAIN -> voteInfo += "WSTRZYMAŁ SIĘ";
            default -> {
                //
            }
        }

        return voteInfo;
    }
}
