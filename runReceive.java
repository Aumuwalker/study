package java_test;

public class runReceive {
	
	public static void main(String[] args) {
		Student student = new Student("����", "����", 3);
		student.showAllSpend();
		Teacher teacher = new Teacher("�㽭", "����", 3);
		teacher.showAllSpend();
		Parent parent = new Parent("����", "����", 3);
		parent.showAllSpend();
		Leader leader = new Leader("�㽭", "����", 3);
		leader.showAllSpend();
		Customer customer = new Customer("����", "����", 3);
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