package model;

public class Referee extends Person implements Foulable {
    private String id;
    private String type; // Central or Assistant

    public Referee(String id, String name, String country, String type) {
        super(name, country);
        this.id = id;
        this.type = type;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String callFoul(int level) {
        return switch (level) {
            case 0 -> "Verbal Warning";
            case 1 -> "Yellow Card";
            case 2 -> "Red Card";
            default -> "Unknown foul level";
        };
    }

    @Override
    public boolean raiseFlag(String foulType) {
        return foulType.equalsIgnoreCase("Offside") || foulType.equalsIgnoreCase("Corner Kick") ||
               foulType.equalsIgnoreCase("Goal Kick") || foulType.equalsIgnoreCase("Throw-In");
    }

    @Override
    public String toString() {
        return super.toString() + ", ID: " + id + ", Type: " + type;
    }
}
