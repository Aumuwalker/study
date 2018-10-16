package java_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import connDB.ConnDB;

/**
 * Company�࣬���԰���һ�������Ӫҵ�Ա���������ɶ� ��������ͨ��������������ָ����Ա���������ɶ� �����ƶ�������Ա���������ɶ�
 * ���㹫˾һ�����֧�� �鿴ÿ��Ա���������ɶ�����Ϣ �鿴ȫ����Ա����Ϣ
 * 
 * @author Han
 *
 */
public class Company {

	// ��˾һ�������
	public static double profit;
	// ��˾һ���Ӫҵ��
	public static double turnover = Math.random() * 10000000 + 100000000;
	// ��˾Ա��
	public HashSet<Staff> setStaff = new HashSet<>();
	// ��˾����
	public HashSet<Manager> setManager = new HashSet<>();
	// ��˾�ɶ�
	public HashSet<ShareHolder> setShareHolder = new HashSet<>();

	public Company() throws SQLException {
		// Ĭ��Ϊ10��Ա����5������3���ɶ�
		this(10, 5, 3);
	}

	public Company(int staffNumber, int managerNumber, int shareHolderNumber) throws SQLException {
//		createStaff(staffNumber);
//		createManager(managerNumber);
//		createShareHolder(shareHolderNumber);
//		Company.profit = Company.turnover - caculateAllPay(setStaff, setManager);
		Company.profit = Company.turnover - caculateAllPay();
		setStaff.clear();
		setManager.clear();
		setShareHolder.clear();
	}

	// ����Ա��,numberΪԱ������
	private void createStaff(int number) throws SQLException {
		while (setStaff.size() < number) {
			setStaff.add(new Staff());
		}
		for (Staff staff : setStaff) {
			Statement state = ConnDB.getConnection().createStatement();
			// ��Calendarת����Date
			java.util.Date date = staff.birthday.getTime();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			state.executeUpdate("insert into staff(name,salary,birthday) values(" + "'" + staff.name + "'" + ","
					+ staff.salary + "," + "'" + sqlDate + "'" + ")");
			if (state != null) {
				state.close();
			}
		}
	}

	// ���ɾ���,numberΪ��������
	private void createManager(int number) throws SQLException {
		while (setManager.size() < number) {
			setManager.add(new Manager());
		}
		for (Manager manager : setManager) {
			Statement state = ConnDB.getConnection().createStatement();
			// ��Calendarת����Date
			java.util.Date date = manager.birthday.getTime();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			state.executeUpdate("insert into manager values(" + "'" + manager.name + "'" + ","
					+ manager.salary + "," + "'" + sqlDate + "'" + "," + manager.bonus + ")");
			if (state != null) {
				state.close();
			}
		}
	}

	// ���ɹɶ�,numberΪ�ɶ�����
	private void createShareHolder(int number) throws SQLException {
		// ��˾�ܹɷ�
		int sharesSurplus = 100;
		// ��ǰnumber-1���ɶ�ͨ������������ɶ��ɷ�,
		while (setShareHolder.size() < number - 1) {
			int shares = (int) (Math.random() * (sharesSurplus - 10)) + 10;
			sharesSurplus = sharesSurplus - shares;
			setShareHolder.add(new ShareHolder(shares));
		}
		// ���һ���ɶ��Ĺɷ�Ϊʣ�µĹɷ�
		setShareHolder.add(new ShareHolder(sharesSurplus));
		sharesSurplus = 0;
		for (ShareHolder shareHolder : setShareHolder) {
			Statement state = ConnDB.getConnection().createStatement();
			// ��Calendarת����Date
			state.executeUpdate("insert into shareHolder values(" + "'" + shareHolder.name + "'" + ","
					+ shareHolder.shares + ")");
			if (state != null) {
				state.close();
			}
		}
	}

	// ������������Ա��
	public Staff searchStaff(String name) throws SQLException {
		Staff staff = null;
		Statement state = ConnDB.getConnection().createStatement();
		ResultSet result = state.executeQuery("select * from staff where name = " + "'" + name + "'");
		while (result.next()) {
			java.util.Date date = new java.util.Date(result.getDate("birthday").getTime());
			staff = new Staff(result.getString("name"), result.getDouble("salary"), date);
		}
		if (state != null) {
			state.close();
		}
		if (result != null) {
			result.close();
		}
		return staff;
	}

	// �����������Ҿ���
	public Manager searchManager(String name) throws SQLException {
		Manager manager = null;
		Statement state = ConnDB.getConnection().createStatement();
		ResultSet result = state.executeQuery("select * from manager where name = " + "'" + name + "'");
		while (result.next()) {
			java.util.Date date = new java.util.Date(result.getDate("birthday").getTime());
			manager = new Manager(result.getString("name"), result.getDouble("salary"), date,
					result.getDouble("bonus"));
		}
		if (state != null) {
			state.close();
		}
		if (result != null) {
			result.close();
		}
		return manager;
	}

	// �����������ҹɶ�
	public ShareHolder searchShareHolder(String name) throws SQLException {
		ShareHolder shareHolder = null;
		Statement state = ConnDB.getConnection().createStatement();
		ResultSet result = state.executeQuery("select * from shareHolder where name = " + "'" + name + "'");
		while (result.next()) {
			shareHolder = new ShareHolder(result.getString("name"), result.getInt("shares"));
		}
		if (state != null) {
			state.close();
		}
		if (result != null) {
			result.close();
		}
		return shareHolder;
	}

	// ���㹫˾һ��Ա���;���Ĺ��ʼ�����
	public double caculateAllPay(HashSet<Staff> setStaff, HashSet<Manager> setManager) {
		double sum = 0;
		for (Staff staff : setStaff) {
			sum = sum + staff.salary * 12;
		}
		for (Manager manager : setManager) {
			sum = sum + (manager.salary + manager.bonus) * 12;
		}
		return sum;
	}

	public double caculateAllPay() throws SQLException {
		Statement state = ConnDB.getConnection().createStatement();
		ResultSet result = state.executeQuery("select * from staff");
		while (result.next()) {
			java.util.Date date = new java.util.Date(result.getDate("birthday").getTime());
			setStaff.add(new Staff(result.getString("name"), result.getDouble("salary"), date));
		}
		result = state.executeQuery("select * from manager");
		while (result.next()) {
			java.util.Date date = new java.util.Date(result.getDate("birthday").getTime());
			setManager.add(
					new Manager(result.getString("name"), result.getDouble("salary"), date, result.getDouble("bonus")));
		}
		if (state != null) {
			state.close();
		}
		if (result != null) {
			result.close();
		}
		return caculateAllPay(setStaff, setManager);
	}
	
	// �鿴����Ա����Ϣ
	public void showAllStaff() throws SQLException {
		Statement state = ConnDB.getConnection().createStatement();
		ResultSet result = state.executeQuery("select * from staff");
		while (result.next()) {
			java.util.Date date = new java.util.Date(result.getDate("birthday").getTime());
			setStaff.add(new Staff(result.getString("name"), result.getDouble("salary"), date));
		}
		if (state != null) {
			state.close();
		}
		if (result != null) {
			result.close();
		}
		for(Staff staff:setStaff) {
			System.out.println(staff);
		}
		setStaff.clear();
	}

	// �鿴���о�����Ϣ
	public void showAllManager() throws SQLException {
		Statement state = ConnDB.getConnection().createStatement();
		ResultSet result = state.executeQuery("select * from manager");
		while (result.next()) {
			java.util.Date date = new java.util.Date(result.getDate("birthday").getTime());
			setManager.add(
					new Manager(result.getString("name"), result.getDouble("salary"), date, result.getDouble("bonus")));
		}
		if (state != null) {
			state.close();
		}
		if (result != null) {
			result.close();
		}
		for(Manager manager:setManager) {
			System.out.println(manager);
		}
		setManager.clear();
	}

	// �鿴���йɶ���Ϣ
	public void showAllShareHolder() throws SQLException {
		Statement state = ConnDB.getConnection().createStatement();
		ResultSet result = state.executeQuery("select * from shareHolder");
		while (result.next()) {
			setShareHolder.add(new ShareHolder(result.getString("name"), result.getInt("shares")));
		}
		if (state != null) {
			state.close();
		}
		if (result != null) {
			result.close();
		}
		for(ShareHolder shareHolder:setShareHolder) {
			System.out.println(shareHolder);
		}
		setShareHolder.clear();
	}

	// �鿴������Ա��Ϣ
	public void showAllPeople() throws SQLException {
		showAllStaff();
		showAllManager();
		showAllShareHolder();
	}

	public static void main(String[] args) throws SQLException {
		Company company = new Company();
		company.showAllPeople();
		Staff staff;
		Manager manager;
		ShareHolder shareHolder;
		staff = company.searchStaff("����");
		System.out.println(staff);
		manager = company.searchManager("����");
		System.out.println(manager);
		shareHolder = company.searchShareHolder("����");
		System.out.println(shareHolder);
	}
}

/*
 * person�� ��Staff��Manager��ShareHolder��Ļ��� �����˵����������ʣ����� �������������ʣ��������жϵ����Ƿ�Ϊ������
 * ��д��equals����
 */
class Person {
	public String name;
	public double salary;
	public Calendar birthday;

	public Person() {
		// �������Ϊ1950��2000
		int year = (int) (Math.random() * 51) + 1950;
		// �����·�Ϊ1��12
		int month = (int) (Math.random() * 12) + 1;
		// ��������,�˴���Ϊһ����Ϊ30��
		int day = (int) (Math.random() * 30) + 1;
		// ��ʼ������
		birthday = Calendar.getInstance();
		// �����������꣬�£���
		birthday.set(year, month, day);
		// �洢��
		List<String> surnameList;
		// �洢��
		List<String> firstnameList;
		String[] surname = { "��", "��", "κ", "��", "��", "��", "��", "��", "��", "��" };
		String[] firstname = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��" };
		surnameList = new ArrayList<>(Arrays.asList(surname));
		firstnameList = new ArrayList<>(Arrays.asList(firstname));
		// �����������������
		name = surnameList.get((int) (Math.random() * 10)) + firstnameList.get((int) (Math.random() * 10));
	}

	// ��дequals����,������������ÿ��ְλ��ÿ����
	public boolean equals(Object object) {
		if (object instanceof Person)
			return this.name.equals(((Person) object).name);
		else
			return false;
	}

	// ������
	public double payoff() {
		return salary;
	}

	// �жϵ����Ƿ��Ǵ��˵�����
	public boolean isBirthday() {
		Calendar calendar = Calendar.getInstance();
		return (birthday.get(birthday.MONTH) == calendar.MONTH);
	}

	public boolean isBirthday(int month) {
		Calendar calendar = Calendar.getInstance();
		return (birthday.get(birthday.MONTH) == month);
	}

	// ���������յ�Ա����������
	public String present() {
		if (isBirthday()) {
			List<String> list = new ArrayList<>(Arrays.asList("���", "С��", "����", "����"));
			return list.get((int) (Math.random() * 4));
		} else
			return "���²��Ǵ�������,������";
	}
}

/*
 * Staff�� ��д��toString����
 */
class Staff extends Person {
	public Staff() {
		super();
		salary = Math.random() * 2000 + 10000;
	}

	public Staff(String name, double salary, java.util.Date date) {
		this.name = name;
		this.salary = salary;
		this.birthday.setTime(date);
	}

	// ��дtoString����
	public String toString() {
		return "ְλ:" + "Ա��" + " " + "����:" + name + " " + "����:" + String.format("%.2f", salary) + " " + "����:"
				+ present();
	}
}

/*
 * Manager�� �����н��� ����������������д��toString����
 */
class Manager extends Person {
	// ����
	public double bonus;

	public Manager() {
		super();
		salary = Math.random() * 2000 + 20000;
		bonus = Math.random() * 500 + 500;
	}

	public Manager(String name, double salary, java.util.Date date, double bonus) {
		this.name = name;
		this.salary = salary;
		this.birthday.setTime(date);
		this.bonus = bonus;
	}

	// �����½���
	public double getBonus() {
		return bonus;
	}

	// ��дtoString����
	public String toString() {
		return "ְλ:" + "����" + " " + "����:" + name + " " + "����:" + String.format("%.2f", salary) + " " + "����:"
				+ String.format("%.2f", bonus) + " " + "����:" + present();
	}
}

/*
 * ShareHolder�� �����йɷ� �����л�����շֺ죬�õ����� ��д��toString����
 */
class ShareHolder extends Person {
	// �ɷ�
	public int shares;

	public ShareHolder(int shares) {
		super();
		salary = 0;
		this.shares = shares;
	}

	public ShareHolder(String name, int shares) {
		this.name = name;
		this.shares = shares;
	}

	// ÿ�¹ɶ�������
	public String present() {
		return "�ɶ�û������";
	}

	// �ɶ����շֺ�
	public double getYearBonus() {
		return (shares / 100.0) * Company.profit * 0.1;
	}

	// ��дtoString����
	public String toString() {
		return "ְλ:" + "�ɶ�" + " " + "����:" + name + " " + "����:" + String.format("%.2f", salary) + "����:" + present() + " "
				+ "���շֺ�:" + String.format("%.2f", getYearBonus());
	}
}