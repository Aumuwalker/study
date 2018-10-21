package java_test;

public class Student implements Receive {
	
	String leaveArea;
	String arriveArea;
	int spendDay;
	double waySpend;
	
	Student(String leave, String arrive, int day){
		leaveArea = leave;
		arriveArea = arrive;
		spendDay = day;
		waySpend = way();
	}
	
	//一天吃的费用
	public double eat() {
		return 100.0;
	}
	
	//一天住宿的费用
	public double accommodate() {
		return 100.0;
	}
	
	//来去的路费，随机生成
	public double way() {
		return (int)(Math.random()*450 + 50);
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
	
	public double getAllSpend() {
		return getAllEat() + getAllAccommodate() + getAllWay();
	}
	
	public void showAllSpend() {
		System.out.println("用餐费用:" + getAllEat());
		System.out.println("住宿费用:" + getAllAccommodate());
		System.out.println("接待车费:" + getAllWay());
		System.out.println("总费用:" + getAllSpend());
	}
}
