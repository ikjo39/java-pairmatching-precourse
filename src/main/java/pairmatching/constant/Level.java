package pairmatching.constant;

public enum Level {
    ONE(1, "레벨1"),
    TWO(2, "레벨2"),
    THREE(3, "레벨3"),
    FOUR(4, "레벨4"),
    FIVE(5, "레벨5")
    ;
    private final int level;
    private final String name;

    Level(int level, String name) {
        this.level = level;
        this.name = name;
    }
}
