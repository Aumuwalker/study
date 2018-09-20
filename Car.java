import java.util.Scanner;

public class Car {
	public String name;//汽车名
	public double tank;//汽车油箱容量
	public double oilSurplus;//汽油剩余量
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
		System.out.println("汽车名:"+name+",汽车油箱容量:"+tank+",汽车剩余油量:"+oilSurplus);
	}
	public static void main(String[] args) {
		int number;//需要创建车的数量
		System.out.print("请输入车的数量:");
		Scanner input = new Scanner(System.in);
		number = input.nextInt();
		Car[] car = new Car[number];
		for(int i = 0;i < number;i++) {
			System.out.println("请输入第"+(i+1)+"个车的名称，油箱容量和汽油剩余量:");
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
			System.out.println("加入油量数字过大或过小，请重新确认");
	}
}