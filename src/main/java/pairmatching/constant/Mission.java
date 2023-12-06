package pairmatching.constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Mission {
    LEVEL_ONE(Level.ONE, Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL_TWO(Level.TWO, Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL_THREE(Level.THREE, Collections.emptyList()),
    LEVEL_FOUR(Level.FOUR, Arrays.asList("성능개선", "배포")),
    LEVEL_FIVE(Level.FIVE, Collections.emptyList()),
    ;

    private final Level level;
    private final List<String> missions;

    Mission(Level level, List<String> missions) {
        this.level = level;
        this.missions = missions;
    }

    public Level getLevel() {
        return level;
    }

    public List<String> getMissions() {
        return missions;
    }
}
