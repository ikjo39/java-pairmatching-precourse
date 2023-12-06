package pairmatching.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import pairmatching.constant.Course;

public class MatchingResults {
    private final Map<Course, List<String>> results = new EnumMap<>(Course.class);

    public MatchingResults() {
    }

    public void clear() {
        results.clear();
    }
}




