package java_test;

public class RunTransportation {

	public static void main(String[] args) {
		Car car = new Car("����", "����", 300.0);
		car.show();
		HighSpeedRail highSpeedRail = new HighSpeedRail("����", "�Ĵ�", 600.0);
		highSpeedRail.show();
		Airplane airplane = new Airplane("����", "�㽭", 1000.0);
		airplane.show();
	}
}
