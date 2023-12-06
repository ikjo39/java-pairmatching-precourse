package pairmatching.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.constant.Course;
import pairmatching.model.Crew;
import pairmatching.model.Crews;

public class CrewsFileReader {
    private static final String ROOT_PATH_FORMAT =
            "src\\main\\resources\\%s";

    public Crews readFiles(Course course) {
        List<Crew> crews = new ArrayList<>();
        String fileName = course.getFileName();
        String fullFilePath = getFullFilePath(fileName);
        try {
            File file = new File(fullFilePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String crewName = bufferedReader.readLine();
            while (crewName != null) {
                crews.add(new Crew(course, crewName));
                crewName = bufferedReader.readLine();
            }
            fileReader.close();
            return new Crews(crews);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private String getFullFilePath(String fileName) {
        return String.format(ROOT_PATH_FORMAT, fileName);
    }
}
