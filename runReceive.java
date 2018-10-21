package java_test;

public class runReceive {
	
	public static void main(String[] args) {
		Student student = new Student("湖北", "湖南", 3);
		student.showAllSpend();
		Teacher teacher = new Teacher("浙江", "江苏", 3);
		teacher.showAllSpend();
		Parent parent = new Parent("湖北", "江西", 3);
		parent.showAllSpend();
		Leader leader = new Leader("浙江", "江西", 3);
		leader.showAllSpend();
		Customer customer = new Customer("江苏", "江西", 3);
		customer.showAllSpend();
	}
}

interface Receive{
	double eat();
	double accommodate();
	double way();
}

interface Present{
	double present();
}