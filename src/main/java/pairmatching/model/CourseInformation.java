package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;
import pairmatching.exception.IllegalArgumentExceptionType;

public class CourseInformation {

    private static final int INFORMATION_SIZE = 3;
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    private final List<String> information;

    public CourseInformation(List<String> information) {
        validateInformation(information);
        this.information = information;
    }

    private void validateInformation(List<String> information) {
        validateInformationSize(information);
        validateExistedCourse(information.get(COURSE_INDEX));
        validateExistedMission(information.get(LEVEL_INDEX), information.get(MISSION_INDEX));
    }

    private void validateInformationSize(List<String> information) {
        if (information.size() != INFORMATION_SIZE) {
            throw IllegalArgumentExceptionType.INVALID_INFORMATION_SIZE.getException();
        }
    }

    private void validateExistedCourse(String courseName) {
        if (!hasCourseName(courseName)) {
            throw IllegalArgumentExceptionType.INVALID_COURSE.getException();
        }
    }

    private boolean hasCourseName(String courseName) {
        return Arrays.stream(Course.values())
                .anyMatch(course -> course.getName().equals(courseName));
    }

    private void validateExistedMission(String levelName, String missionName) {
        List<String> missions = Arrays.stream(Mission.values())
                .filter(mission -> mission.getLevel().equals(getLevelFrom(levelName)))
                .map(Mission::getMissions)
                .findFirst()
                .orElseThrow(IllegalArgumentExceptionType.INVALID_MISSION::getException);

        if (!missions.contains(missionName)) {
            throw IllegalArgumentExceptionType.INVALID_MISSION.getException();
        }
    }

    private Level getLevelFrom(String levelName) {
        return Arrays.stream(Level.values())
                .filter(level -> level.getName().equals(levelName))
                .findFirst()
                .orElseThrow(IllegalArgumentExceptionType.INVALID_LEVEL::getException);
    }
}
