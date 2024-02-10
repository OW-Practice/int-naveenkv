package Trello.GenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtilities 
{
	/**
	 * This method will return random numbers
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
	
	/**
	 * This method will give current date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		String date=d.toString();
		return date;
	}
	
	/**
	 * This method will give current date in format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String[]DArr=d.toString().split(" ");
		String date=DArr[2];
		String month=DArr[1];
		String year=DArr[5];
		String time=DArr[3].replace(":", "-");
		String datevalue=date+"-"+month+"-"+year+"-"+time;
		return datevalue;
	}
}
