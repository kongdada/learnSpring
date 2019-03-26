package commTool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author konglinghui
 * @date 2019-02-28
 */

public class DateTool {

    private static final long DAYMILLIS = 24L * 60 * 60 * 1000;

    /**
     * @param dateStr
     * @return 获取输入日期是周几
     */
    public static String getDayOfWeek(String dateStr) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = f.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK);
        switch (week) {
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
        }
        return "获取DAY_OF_WEEK失败";
    }

    public static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = f.format(new Date());
        return date;
    }

    /**
     * 获得指定日期所在季度的天数
     */
    public static int getQuarterDayNum(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        int mon = ((cal.get(Calendar.MONTH)) / 3) * 3;
        cal.set(Calendar.MONTH, mon);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        long start = cal.getTimeInMillis();
        cal.add(Calendar.MONTH, 3);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
        long end = cal.getTimeInMillis();
        int quardays = (int) ((end - start) / DAYMILLIS) + 1;
        return quardays;
    }

    public static Date getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 0);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 3);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 4);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 9);
            }
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的结束时间，即2012-03-31 23:59:59
     * @return
     */
    public static Date getCurrentQuarterEndTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getCurrentQuarterStartTime());
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }

    public static void getTimeRange() {
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        System.out.println(f.format(c.getTime()));
        c.set(Calendar.YEAR - 1, Calendar.MONTH, Calendar.DAY_OF_MONTH - 1);
        System.out.println(f.format(c.getTime()));
    }
}
