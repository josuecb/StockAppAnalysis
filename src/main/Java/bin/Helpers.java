package bin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Josue on 5/24/2017.
 */
public class Helpers {
    public static int dateToDayOfWeek(int dd, int mm, int yyyy) throws ParseException {
        String someDate = mm + "-" + dd + "-" + yyyy;
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date date = sdf.parse(someDate);

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }

    public static int dateToDayOfWeek(String someDate) throws ParseException {
        System.out.println(someDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(someDate);

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }
}
