import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Camp {
    private final List<Boyscout> scouts;

    public Camp(List<Boyscout> scouts) {
        this.scouts = new ArrayList<>(scouts);
    }

    public Map<ScoutProgram.Team, List<Boyscout>> split() {
        return scouts.stream()
                .filter(scout -> scout.getTeam() != null)
                .collect(Collectors.groupingBy(
                        Boyscout::getTeam,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingInt(Boyscout::getAge).reversed())
                                        .collect(Collectors.toList())
                        )
                ));
    }
}
