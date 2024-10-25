package model;

public class Controller {
    private Player[] players = new Player[20];
    private Referee[] referees = new Referee[12];
    private int playerCount = 0;
    private int refereeCount = 0;

    public void addPlayer(String name, String country, int number, String position) {
        if (playerCount < players.length) {
            players[playerCount++] = new Player(number, name, country, position);
        }
    }

    public void addReferee(String id, String name, String country, String type) {
        if (refereeCount < referees.length) {
            referees[refereeCount++] = new Referee(id, name, country, type);
        }
    }

    public String displayPeople() {
        StringBuilder result = new StringBuilder("People in the Tournament:\n");
        for (int i = 0; i < playerCount; i++) {
            result.append(players[i].toString()).append("\n");
        }
        for (int i = 0; i < refereeCount; i++) {
            result.append(referees[i].toString()).append("\n");
        }
        return result.toString();
    }

    public String getTopScorer() {
        Player topScorer = null;
        int maxGoals = -1;
        for (int i = 0; i < playerCount; i++) {
            if (players[i].getGoals() > maxGoals) {
                maxGoals = players[i].getGoals();
                topScorer = players[i];
            }
        }
        return topScorer != null ? topScorer.getName() : "No goals scored yet.";
    }

    public String refereeCallFoul(String refereeId, int level) {
        for (int i = 0; i < refereeCount; i++) {
            if (referees[i].getId().equals(refereeId) && "Central".equals(referees[i].getType())) {
                return referees[i].callFoul(level);
            }
        }
        return "Central referee not found or incorrect ID.";
    }

    public boolean assistantRefereeRaiseFlag(String refereeId, String foulType) {
        for (int i = 0; i < refereeCount; i++) {
            if (referees[i].getId().equals(refereeId) && "Assistant".equals(referees[i].getType())) {
                return referees[i].raiseFlag(foulType);
            }
        }
        return false;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Referee[] getReferees() {
        return referees;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getRefereeCount() {
        return refereeCount;
    }
}
