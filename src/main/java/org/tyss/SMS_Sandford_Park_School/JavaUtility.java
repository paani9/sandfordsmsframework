package org.tyss.SMS_Sandford_Park_School;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists all java reusable actions
 * @author PAAVANI
 *
 */

public class JavaUtility {
	/**
	 * This method is used to generate the random number
	 * @author PAAVANI
	 */
	public int getRandomNumber(int limit)
	{
		
		
		return new Random().nextInt(limit);
		
	}
	/**
	 * This method is used to generate current time and date
	 * @return
	 */
	public String currentTime()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYY_hh_mm_sss");
		String actualDate=sdf.format(date);
		return actualDate;
	}
public void customWait(int duration) throws InterruptedException
{int count=0;
	while(count<duration)
	{
		Thread.sleep(500);
	}
}
}
