package pairmatching.view;

import java.util.Arrays;
import java.util.stream.Collectors;
import pairmatching.constant.Course;
import pairmatching.constant.Level;

public class CourseMissionMapper {
    private static final String MISSION_FORMAT = "  - %s: %s%n";
    private static final String COURSE_FORMAT = "#############################################%n"
            + "과정: %s%n"
            + "미션:%n"
            + "%s"
            + "############################################";
    private static final String DELIMITER = " | ";

    public String getCourseText() {
        return String.format(COURSE_FORMAT, getCourseWithFormat(), getMissionsWithFormat());
    }

    private String getCourseWithFormat() {
        return Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    private String getMissionsWithFormat() {
        return Arrays.stream(Level.values())
                .map(level -> {
                    String levelName = level.getName();
                    String missions = String.join(DELIMITER, level.getMissions());
                    return String.format(MISSION_FORMAT, levelName, missions);
                })
                .collect(Collectors.joining());
    }
}
