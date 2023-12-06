package pairmatching.constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import pairmatching.exception.IllegalArgumentExceptionType;

public enum Level {
    LEVEL_ONE("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL_TWO("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL_THREE("레벨3", Collections.emptyList()),
    LEVEL_FOUR("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL_FIVE("레벨5", Collections.emptyList()),
    ;

    private final String name;
    private final List<String> missions;

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level from(String levelName) {
        return Arrays.stream(Level.values())
                .filter(level -> level.name.equals(levelName))
                .findFirst()
                .orElseThrow(IllegalArgumentExceptionType.INVALID_LEVEL::getException);
    }

    public boolean hasMission(String mission) {
        return missions.contains(mission);
    }

    public String getName() {
        return name;
    }

    public List<String> getMissions() {
        return missions;
    }
}
