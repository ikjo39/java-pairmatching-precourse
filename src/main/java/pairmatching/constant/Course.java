package pairmatching.constant;

public enum Course {
    BACK_END("백엔드"),
    FRONT_END("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
