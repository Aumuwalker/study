package java_test;

public class RunTransportation {

	public static void main(String[] args) {
		Car car = new Car("湖北", "湖南", 300.0);
		car.show();
		HighSpeedRail highSpeedRail = new HighSpeedRail("江苏", "四川", 600.0);
		highSpeedRail.show();
		Airplane airplane = new Airplane("西安", "浙江", 1000.0);
		airplane.show();
	}
}
