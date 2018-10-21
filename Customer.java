package java_test;

public class Customer implements Receive, Present {
	
	String leaveArea;
	String arriveArea;
	int spendDay;
	double waySpend;
	double present;
	
	Customer(String leave, String arrive, int day){
		leaveArea = leave;
		arriveArea = arrive;
		spendDay = day;
		waySpend = way();
		present = present();
	}
	
	//一天吃的费用
	public double eat() {
		return 300.0;
	}
	
	//一天住宿的费用
	public double accommodate() {
		return 300.0;
	}
	
	//来去的路费，随机生成
	public double way() {
		return (int)(Math.random()*450 + 50);
	}
	
	//领导的礼物
	public double present() {
		double[] i = {100.0, 200.0, 300.0, 400.0, 500.0};
		double t = i[(int)(Math.random()*5)];
		present = t;
		return t;
	}
	
	public double getAllEat() {
		return spendDay*eat();
	}
	
	public double getAllAccommodate() {
		return spendDay*accommodate();
	}
	
	public double getAllWay() {
		return waySpend;
	}
	
	public double getPresentSpend() {
		return present;
	}
	
	public String getPresentInf() {
		return present + "元红包";
	}
	
	public double getAllSpend() {
		return getAllEat() + getAllAccommodate() + getAllWay() + present;
	}
	
	public void showAllSpend() {
		System.out.println("用餐费用:" + getAllEat());
		System.out.println("住宿费用:" + getAllAccommodate());
		System.out.println("接待车费:" + getAllWay());
		System.out.println("礼物费用:" + getPresentSpend());
		System.out.println("总费用:" + getAllSpend());
	}
}
