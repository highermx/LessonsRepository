public class Boyscout {
    private final String name;
    private final int age;
    private final ScoutProgram.Team team;

    public Boyscout(String name, int age, ScoutProgram.Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public ScoutProgram.Team getTeam() { return team; }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
