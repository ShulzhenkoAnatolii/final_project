package ua.com.alevel.util;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RecordTimeUtil {
    private final static LocalTime START = LocalTime.of(9,0);
    private final static LocalTime END = LocalTime.of(18,0);
    private final static Integer STEP = 30;

    public static List<LocalTime> init() {
        List<LocalTime> recordingTimeList = new ArrayList<>();
        LocalTime count = START;
        while (!count.equals(END)){
            recordingTimeList.add(count);
            count = count.plusMinutes(STEP);
        }
        recordingTimeList.add(END);
        return recordingTimeList;
    }
}
