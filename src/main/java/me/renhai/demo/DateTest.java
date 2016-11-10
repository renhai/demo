package me.renhai.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class DateTest 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DateTest.class);

	private static final SimpleDateFormat D = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat D2 = new SimpleDateFormat("yyyyMM");

    public static void main( String[] args ) throws ParseException
    {
    	String dateStr = "2014-12-28 23:59:59";
    	Date date = D.parse(dateStr);
        System.out.println(getMondayOfWeek(date));
        System.out.println(getSundayOfWeek(date));
        
        System.out.println(getCurrentMonday());
        System.out.println(getCurrentSunday());
        
        int mondayTime = date2Unixtime(getCurrentMonday());
        int lastTime = date2Unixtime(date);
        if (lastTime > mondayTime) {
            LOGGER.info("不合法");
		} else {
			LOGGER.info("合法");
		}
        
        DateTime dt = new DateTime(2014,10,1,0,0,0);
        for (int i = 0; i < 12; i++) {
			dt = dt.plusMonths(1);
	        System.out.println(dt);
		}
        
//    	int from = 0, to = 0;
//        Calendar now = Calendar.getInstance();
//        now.set(2014, Calendar.OCTOBER, 1, 0, 0, 0);
//        for (int i = 0; i < 4; i++) {
//        	from = (int)(now.getTimeInMillis() / 1000L);
//        	now.add(Calendar.MONTH, 1);
//        	to = (int)(now.getTimeInMillis() / 1000L);
//        	
//        	System.out.println("from: " + new DateTime(from * 1000L) + ", to: " + new DateTime(to * 1000L));
//        	System.out.println(D2.format(now.getTime()));
//        }
      
        Calendar now = Calendar.getInstance();
        now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1, 0, 0, 0);
    	int from = date2Unixtime(now.getTime());
    	now.add(Calendar.MONTH, 1);
    	int to = date2Unixtime(now.getTime());
       	int month = Integer.parseInt(D2.format(fromUnixTime(from)));
        
       	System.out.println(from);
       	System.out.println(to);
       	System.out.println(month);
       	
       	
       	Calendar curr = Calendar.getInstance();
       	curr.add(Calendar.MONTH, -3);
       	curr.set(Calendar.DATE, 1);
       	curr.set(Calendar.HOUR_OF_DAY, 0);
       	curr.set(Calendar.MINUTE, 0);
       	curr.set(Calendar.SECOND, 0);
       	System.out.println(D.format(curr.getTime()));
       	
       	curr.add(Calendar.MONTH, 1);
       	System.out.println(D.format(curr.getTime()));
    }
    
    public static Date getMondayOfWeek(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);  
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);  
        return cal.getTime();  
    } 
    
    public static Date getSundayOfWeek(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);  
        return  cal.getTime();  
    } 
    
    public static Date getCurrentMonday() {  
    	return getMondayOfWeek(new Date());
    } 
    
    public static Date getCurrentSunday() {  
    	return getSundayOfWeek(new Date());
    } 
    
    public static int date2Unixtime(Date date) {
        return (int) (date.getTime() / 1000L);
    }
    
    public static Date fromUnixTime(Integer seconds) {
        return new Date(seconds * 1000L);
    }
    
}
