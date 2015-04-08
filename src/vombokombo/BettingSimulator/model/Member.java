package vombokombo.BettingSimulator.model;

public class Member {

    private String name;

    public Member(String name) {
        setName(name);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
