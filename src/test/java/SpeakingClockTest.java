import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rahul on 28/09/2017.
 */
public class SpeakingClockTest {

    @Test
    public void shouldReturnMidday() {
        String time = new SpeakingClock().getTimeInString("00:00");
        assertEquals("midnight", time);
    }

    @Test
    public void shouldReturnMidnight() {
        String time = new SpeakingClock().getTimeInString("12:00");
        assertEquals("midday", time);

    }

    @Test
    public void shouldReturn0012InString() {
        String time = new SpeakingClock().getTimeInString("00:12");
        assertEquals("twelve twelve in the morning", time);

    }

    @Test
    public void shouldReturn1504InString() {
        String time = new SpeakingClock().getTimeInString("15:04");
        assertEquals("three o four in the afternoon", time);

    }

    @Test
    public void shouldReturn1804InString() {
        String time = new SpeakingClock().getTimeInString("18:04");
        assertEquals("six o four in the evening", time);

    }

    @Test
    public void shouldReturn1844InString() {
        String time = new SpeakingClock().getTimeInString("18:44");
        assertEquals("six forty four in the evening", time);

    }

    @Test
    public void shouldReturn1300InString() {
        String time = new SpeakingClock().getTimeInString("13:00");
        assertEquals("one in the afternoon", time);

    }

    @Test
    public void shouldReturn1359InString() {
        String time = new SpeakingClock().getTimeInString("13:59");
        assertEquals("one fifty nine in the afternoon", time);

    }

    @Test
    public void shouldReturn2359InString() {
        String time = new SpeakingClock().getTimeInString("23:59");
        assertEquals("eleven fifty nine in the evening", time);

    }

}
