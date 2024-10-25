package model;

public interface Foulable {
    String callFoul(int level);
    boolean raiseFlag(String foulType);
}