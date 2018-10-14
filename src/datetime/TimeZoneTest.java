package datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class TimeZoneTest {
    public static void main(String[] args) {
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        LocalDateTime dt = LocalDateTime.now();
        List<String> zoneList = new ArrayList<>(allZones);
        Collections.sort(zoneList);
        for(String s : zoneList) {
            ZoneId zone = ZoneId.of(s);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset offset = zdt.getOffset();
            int secondsOfHour = offset.getTotalSeconds() % (60 * 60);
            String out = String.format("%25s %7s%n", zone, offset);
            if(secondsOfHour != 0) {
                System.out.printf(out);
            }
        }
    }
}
