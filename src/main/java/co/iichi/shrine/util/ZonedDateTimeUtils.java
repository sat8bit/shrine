package co.iichi.shrine.util;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * Created by sat8bit on 2016/07/03.
 */
public class ZonedDateTimeUtils {
    /**
     * ミリ秒は利用しない。
     * @return
     */
    public static ZonedDateTime now() {
        return ZonedDateTime.now().with(ChronoField.MILLI_OF_SECOND, 0);
    }
}
