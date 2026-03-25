package com.orangeHRM.seleniumUI.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class JavaUtility {
	
	public int getRandomNumber(int range) {
		return new Random().nextInt(range);
	}
	
	public String getCurrentDate(String dateFormat) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		return simpleDateFormat.format(new Date());
	}
	public String getRequiredDate(int days) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
		simpleDateFormat.format(new Date());
		Calendar calendar = simpleDateFormat.getCalendar();
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return simpleDateFormat.format(calendar.getTime());
	}
	public String getRandomValue() {
		return UUID.randomUUID().toString().replace("[^a-zA-Z]", "");
	}
}
