package java_test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HighSpeedRail extends Transportation implements ShowInf {
	
	HighSpeedRail(){
		this("��", "��", 0.0, "HighSpeedRail", "2016-01-01 00:00:00", "2016-01-01 00:00:00", "2016-01-01 00:00:00", "2016-01-01 00:00:00", "2016-01-01 00:00:00", "2016-01-01 00:00:00", 120.0, 0.45);
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
		System.out.println("��������:" + leaveArea);
		System.out.println("�������:" + arriveArea);
		System.out.println("���ؾ���:" + distance);
		System.out.println("��ͨ��ʽ:" + transportMode);
		System.out.println("����ʱ��:" + leaveTime);
		System.out.println("����ʱ��:" + arriveTime);
		System.out.println("����ʱ��" + returnTime);
		System.out.println("ȡƱʱ��:" + getTicketTime);
		System.out.println("����ʱ��:" + securityCheckTime);
		System.out.println("��ʱ��" + waitTime);
		System.out.println("����:" + speed + "km/h");
		System.out.println("�۸�" + price + "yuan/km");
		System.out.println("����ʱ��:" + spendTime());
		System.out.println("����:" + cost());
	}
}
