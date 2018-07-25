package com.xk.p2p.base.util;

import org.apache.commons.lang.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 得到一天的最后一秒钟
	 * 
	 * @param d
	 * @return
	 */
	public static Date endOfDay(Date d) {
		return DateUtils.addSeconds(
				DateUtils.addDays(DateUtils.truncate(d, Calendar.DATE), 1), -1);
	}

	public static Date getLastTimeOfTheDay(Date date){
		Calendar todayEnd = Calendar.getInstance();
		String result = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = formatter.format(date);
		String hour = dateStr.split(" ")[1].toString().split(":")[0];
		if (Integer.parseInt(hour)<12){
			todayEnd.set(Calendar.HOUR_OF_DAY,23);
			todayEnd.set(Calendar.MINUTE,59);
			todayEnd.set(Calendar.SECOND, 59);
		}else {
			todayEnd.add(Calendar.DATE, 1);
			todayEnd.set(Calendar.HOUR_OF_DAY,23);
			todayEnd.set(Calendar.MINUTE,59);
			todayEnd.set(Calendar.SECOND, 59);
		}
		return todayEnd.getTime();
	}
	/**
	 * 两个时间的间隔秒
	 * 
	 * @return
	 */
	public static long getSecondsBetween(Date d1, Date d2) {
		return Math.abs((d1.getTime() - d2.getTime()) / 1000);
	}
}