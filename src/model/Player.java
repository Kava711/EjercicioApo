
package model;

public class Player extends Person {
    private int number;
    private String position; 
    private int goals;

    
    public Player(int number, String name, String country, String position) {
        super(name, country);
        this.number = number;
        this.position = position;
        this.goals = 0;
    }

    // Getters and Setters
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public int getGoals() { return goals; }
    public void setGoals(int goals) { this.goals = goals; }

    public void addGoal() { this.goals++; }

    @Override
    public String toString() {
        return super.toString() + ", Number: " + number + ", Position: " + position + ", Goals: " + goals;
    }
}
