package hqh.socket.sigle.thinkInJava;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Calendar c=Calendar.getInstance();		
		System.out.println(c.getTime().toString());
		System.out.println(c.getTimeInMillis());
//		SimpleDateFormat sdFormat=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss SSS");
//		System.out.println(sdFormat.format(c.getTime()));
//		System.out.println(sdFormat.format(c.getTime()));
//		
//		System.out.println(System.currentTimeMillis());
//		System.out.println(System.currentTimeMillis());
//		
//		Thread.currentThread();
//		try {
//			Thread.sleep(3);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		getCurrentTime();
	}
	public  static void getCurrentTime(){
		Date nowtime=new Date(System.currentTimeMillis());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss SSS");
		System.out.println(sdf.format(nowtime));
	}

}
