package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ENTER_FUNCTION_TYPE = "기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";
    private static final String ENTER_COURSE_INFORMATION = "과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주";

    private static final String SPLIT_DELIMITER = ", ";

    public String readFunctionType() {
        System.out.println(ENTER_FUNCTION_TYPE);
        return Console.readLine();
    }

    public List<String> readCourseInformation() {
        final CourseMissionMapper courseMissionMapper = new CourseMissionMapper();
        System.out.println(courseMissionMapper.getCourseText());
        System.out.println(ENTER_COURSE_INFORMATION);
        String input = Console.readLine();
        List<String> information = Arrays.stream(input.split(SPLIT_DELIMITER))
                .collect(Collectors.toList());
        return Arrays.stream(input.split(SPLIT_DELIMITER))
                .collect(Collectors.toList());
    }
}
