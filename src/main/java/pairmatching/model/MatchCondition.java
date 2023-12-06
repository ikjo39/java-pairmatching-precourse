package pairmatching.model;

import java.util.List;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.exception.IllegalArgumentExceptionType;
import pairmatching.util.CrewsFileReader;

public class MatchCondition {
    private static final int INFORMATION_SIZE = 3;
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    private final Course course;
    private final Level level;
    private final String mission;

    private MatchCondition(Course course, Level level, String mission) {
        validateExistedMission(level, mission);
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static MatchCondition from(List<String> information) {
        validateInformationSize(information);
        String courseName = information.get(COURSE_INDEX);
        String levelName = information.get(LEVEL_INDEX);
        return new MatchCondition(Course.from(courseName), Level.from(levelName), information.get(MISSION_INDEX));
    }

    private static void validateInformationSize(List<String> information) {
        if (information.size() != INFORMATION_SIZE) {
            throw IllegalArgumentExceptionType.INVALID_INFORMATION_SIZE.getException();
        }
    }

    private void validateExistedMission(Level level, String missionName) {
        if (!level.hasMission(missionName)) {
            throw IllegalArgumentExceptionType.INVALID_MISSION.getException();
        }
    }

    public Crews getCrews() {
        final CrewsFileReader crewsFileReader = new CrewsFileReader();
        return crewsFileReader.readFiles(course);
    }
}
