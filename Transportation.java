package java_test;

import java.util.Date;

public abstract class Transportation {
	
	//交通方式
	String transportMode;
	//出发时间
	Date leaveTime;
	//到达时间
	Date arriveTime;
	//返回时间
	Date returnTime;
	//取票时间
	Date getTicketTime;
	//安检时间
	Date securityCheckTime;
	//候车时间
	Date waitTime;
	//出发地区
	String leaveArea;
	//到达地区
	String arriveArea;
	//两地距离
	double distance;
	//车速
	double speed;
	//单价
	double price;
	
	//计算消耗时间
	public double spendTime() {
		//得到时间差
		long milliSeconds = arriveTime.getTime() - leaveTime.getTime();
		double hour = milliSeconds/(1000.0 * 60 * 60);
		return hour;
	}
	//计算花费
	public abstract double cost();
}

interface ShowInf{
	//用于显示每个对象的信息
	public abstract void show();
}