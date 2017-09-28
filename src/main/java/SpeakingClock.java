import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rahul on 28/09/2017.
 */
public class SpeakingClock {


    static ImmutableMap<Object, Object> timeMap = ImmutableMap.builder()
            .put("0", "twelve")
            .put("1", "one")
            .put("2", "two")
            .put("3", "three")
            .put("4", "four")
            .put("5", "five")
            .put("6", "six")
            .put("7", "seven")
            .put("8", "eight")
            .put("9", "nine")
            .put("10", "ten")
            .put("11", "eleven")
            .put("12", "twelve")
            .put("13", "thirteen")
            .put("14", "fourteen")
            .put("15", "fifteen")
            .put("16", "sixteen")
            .put("17", "seventeen")
            .put("18", "eighteen")
            .put("19", "nineteen")
            .put("20", "twenty")
            .put("30", "thirty")
            .put("40", "forty")
            .put("50", "fifty")
            .build();

    public String getTimeInString(String time) {

        if (time.equals("00:00")) {
            return "midnight";
        }
        if (time.equals("12:00")) {
            return "midday";
        }
        String[] split = time.split(":");
        String hours = split[0];
        String min = split[1];

        int hoursInInt = Integer.parseInt(hours);

        String postFix = "morning";

        if (hoursInInt > 11 && hoursInInt < 18) {
            postFix = "afternoon";
        } else if (hoursInInt >= 18 && hoursInInt <= 23) {
            postFix = "evening";
        }

        int minIntVal = Integer.parseInt(min);
        int minuteKey = minIntVal;
        int minRemainder = 0;
        if (minIntVal > 19) {
            minRemainder = minIntVal % 10;
            minuteKey = minIntVal - minRemainder;
        }

        String hourInSpeech = (String) timeMap.get(String.valueOf(hoursInInt > 12 ? hoursInInt - 12 : hoursInInt));
        String minRemainderSpeech = minRemainder != 0 ? (String) timeMap.get(String.valueOf(minRemainder)) : "";
        String minInSpeech = minuteKey > 0 ? (String) timeMap.get(String.valueOf(minuteKey)) : "";
        if (minRemainderSpeech.length() > 1) {
            minInSpeech = minInSpeech + " " + minRemainderSpeech;
        }

        return hourInSpeech + (minuteKey < 10 && minuteKey > 0 ? " o " : minInSpeech.length() > 0 ? " " : "") + minInSpeech + " in the " + postFix;
    }
}
