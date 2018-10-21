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
	
	//һ��Եķ���
	public double eat() {
		return 300.0;
	}
	
	//һ��ס�޵ķ���
	public double accommodate() {
		return 300.0;
	}
	
	//��ȥ��·�ѣ��������
	public double way() {
		return (int)(Math.random()*450 + 50);
	}
	
	//�쵼������
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
		return present + "Ԫ���";
	}
	
	public double getAllSpend() {
		return getAllEat() + getAllAccommodate() + getAllWay() + present;
	}
	
	public void showAllSpend() {
		System.out.println("�òͷ���:" + getAllEat());
		System.out.println("ס�޷���:" + getAllAccommodate());
		System.out.println("�Ӵ�����:" + getAllWay());
		System.out.println("�������:" + getPresentSpend());
		System.out.println("�ܷ���:" + getAllSpend());
	}
}
