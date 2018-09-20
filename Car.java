import java.util.Scanner;

public class Car {
	public String name;//������
	public double tank;//������������
	public double oilSurplus;//����ʣ����
	public Car() {}
	public Car(String carName,double carTank,double carOilSurplus) {
		name = carName;
		tank = carTank;
		oilSurplus = carOilSurplus;
	}
	public boolean addGas(double content) {
		if(content <= 0 || content > (tank - oilSurplus))
			return false;
		else
		{
			oilSurplus = oilSurplus + content;
			return true;
		}
	}
	public void display() {
		System.out.println("������:"+name+",������������:"+tank+",����ʣ������:"+oilSurplus);
	}
	public static void main(String[] args) {
		int number;//��Ҫ������������
		System.out.print("�����복������:");
		Scanner input = new Scanner(System.in);
		number = input.nextInt();
		Car[] car = new Car[number];
		for(int i = 0;i < number;i++) {
			System.out.println("�������"+(i+1)+"���������ƣ���������������ʣ����:");
			String carName = input.next();
			double carTank = input.nextDouble();
			double carOilSurplus = input.nextDouble();
			car[i] = new Car(carName,carTank,carOilSurplus);
					}
		car[0].display();
		car[1].display();
		double content = 20;
		if(car[0].addGas(content))
			car[0].display();
		else
			System.out.println("�����������ֹ�����С��������ȷ��");
	}
}