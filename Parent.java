package java_test;

public class Parent implements Receive {
	
	String leaveArea;
	String arriveArea;
	int spendDay;
	double waySpend;
	
	Parent(String leave, String arrive, int day){
		leaveArea = leave;
		arriveArea = arrive;
		spendDay = day;
		waySpend = way();
	}
	
	//һ��Եķ���
	public double eat() {
		return 200.0;
	}
	
	//һ��ס�޵ķ���
	public double accommodate() {
		return 200.0;
	}
	
	//��ȥ��·�ѣ��������
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
		System.out.println("�òͷ���:" + getAllEat());
		System.out.println("ס�޷���:" + getAllAccommodate());
		System.out.println("�Ӵ�����:" + getAllWay());
		System.out.println("�ܷ���:" + getAllSpend());
	}
}