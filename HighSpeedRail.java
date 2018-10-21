package java_test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HighSpeedRail extends Transportation implements ShowInf {
	
	HighSpeedRail(){
		this("无", "无", 0.0, "HighSpeedRail", "2016-01-01 00:00:00", "2016-01-01 00:00:00", "2016-01-01 00:00:00", "2016-01-01 00:00:00", "2016-01-01 00:00:00", "2016-01-01 00:00:00", 120.0, 0.45);
	}
	
	HighSpeedRail(String leaveArea, String arriveArea, double distance){
		this(leaveArea, arriveArea, distance, "HighSpeedRail", "2016-01-01 00:00:00", "2016-01-01 00:00:00", "2016-01-01 00:00:00", "2016-01-01 00:00:00", "2016-01-01 00:00:00", "2016-01-01 00:00:00", 120.0, 0.45);
	}
	
	HighSpeedRail(String leaveArea, String arriveArea, double distance, String transportMode, String leave, String arrive, String returnTime, String getTicket, String securityCheck, String wait,double speed, double price){
		this.leaveArea = leaveArea;
		this.arriveArea = arriveArea;
		this.distance = distance;
		this.transportMode = transportMode;
		try {
		this.leaveTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(leave);
		this.arriveTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arrive);
		this.returnTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(returnTime);
		this.getTicketTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(getTicket);
		this.securityCheckTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(securityCheck);
		this.waitTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(wait);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		this.speed = speed;
		this.price = price;
	}
	
	public double cost() {
		return distance * price;
	}
	
	public void show() {
		System.out.println("出发地区:" + leaveArea);
		System.out.println("到达地区:" + arriveArea);
		System.out.println("两地距离:" + distance);
		System.out.println("交通方式:" + transportMode);
		System.out.println("出发时间:" + leaveTime);
		System.out.println("到达时间:" + arriveTime);
		System.out.println("返回时间" + returnTime);
		System.out.println("取票时间:" + getTicketTime);
		System.out.println("安检时间:" + securityCheckTime);
		System.out.println("候车时间" + waitTime);
		System.out.println("车速:" + speed + "km/h");
		System.out.println("价格" + price + "yuan/km");
		System.out.println("花费时间:" + spendTime());
		System.out.println("花费:" + cost());
	}
}
