package pairmatching.constant;

import java.util.Arrays;
import pairmatching.exception.IllegalArgumentExceptionType;

public enum Course {
    BACK_END("백엔드", "backend-crew.md"),
    FRONT_END("프론트엔드", "frontend-crew.md");

    private final String name;
    private final String fileName;

    Course(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    public static Course from(String courseName) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(courseName))
                .findFirst()
                .orElseThrow(IllegalArgumentExceptionType.INVALID_COURSE::getException);
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return fileName;
    }
}
