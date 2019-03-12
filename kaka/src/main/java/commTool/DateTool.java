package commTool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author konglinghui
 * @date 2019-02-28
 */

public class DateTool {
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
}
