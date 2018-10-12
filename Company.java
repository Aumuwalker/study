package java_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Company�࣬���԰���һ�������Ӫҵ�Ա���������ɶ�
 * ��������ͨ��������������ָ����Ա���������ɶ�
 * �����ƶ�������Ա���������ɶ�
 * ���㹫˾һ�����֧��
 * �鿴ÿ��Ա���������ɶ�����Ϣ
 * �鿴ȫ����Ա����Ϣ
 * @author Han
 *
 */
public class Company {

	// ��˾һ�������
	public static double profit;
	// ��˾һ���Ӫҵ��
	public static double turnover = Math.random() * 10000000 + 100000000;
	//��˾Ա��
	public HashSet<Staff> staffSet;
	//��˾����
	public HashSet<Manager> managerSet;
	//��˾�ɶ�
	public HashSet<ShareHolder> shareHolderSet;
	
	public Company() {
		//Ĭ��Ϊ10��Ա����5������3���ɶ�
		this(10,5,3);
	}
	
	public Company(int staffNumber,int managerNumber,int shareHolderNumber) {
		staffSet = createStaff(staffNumber);
		managerSet = createManager(managerNumber);
		Company.profit = Company.turnover - Company.caculateAllPay(staffSet, managerSet);
		shareHolderSet = createShareHolder(shareHolderNumber);
	}

	// ����Ա��,numberΪԱ������
	private HashSet<Staff> createStaff(int number) {
		Set<Staff> setStaff = new HashSet<>();
		while (setStaff.size() < number) {
			setStaff.add(new Staff());
		}
		return (HashSet<Staff>) setStaff;
	}

	// ���ɾ���,numberΪ��������
	private HashSet<Manager> createManager(int number) {
		Set<Manager> setManager = new HashSet<>();
		while (setManager.size() < number) {
			setManager.add(new Manager());
		}
		return (HashSet<Manager>) setManager;
	}

	// ���ɹɶ�,numberΪ�ɶ�����
	private HashSet<ShareHolder> createShareHolder(int number) {
		Set<ShareHolder> setShareHolder = new HashSet<>();
		//��˾�ܹɷ�
		int sharesSurplus = 100;
		//��ǰnumber-1���ɶ�ͨ������������ɶ��ɷ�,
		while (setShareHolder.size() < number-1) {
			int shares = (int)(Math.random()*(sharesSurplus - 10)) + 10;
			sharesSurplus = sharesSurplus - shares;
			setShareHolder.add(new ShareHolder(shares));
		}
		//���һ���ɶ��Ĺɷ�Ϊʣ�µĹɷ�
		setShareHolder.add(new ShareHolder(sharesSurplus));
		sharesSurplus = 0;
		return (HashSet<ShareHolder>) setShareHolder;
	}

	//������������Ա��
	public Staff searchStaff(String name) {
		for(Staff staff:staffSet) {
			if(staff.name.equals(name)) {
				return staff;
			}
		}
		return null;
	}
	
	//�����������Ҿ���
	public Manager searchManager(String name) {
		for(Manager manager:managerSet) {
			if(manager.name.equals(name)) {
				return manager;
			}
		}
		return null;
	}
	
	//�����������ҹɶ�
	public ShareHolder searchShareHolder(String name) {
		for(ShareHolder shareHolder:shareHolderSet) {
			if(shareHolder.name.equals(name)) {
				return shareHolder;
			}
		}
		return null;
	}
	
	//���㹫˾һ��Ա���;���Ĺ��ʼ�����
	public static double caculateAllPay(HashSet<Staff> setStaff,HashSet<Manager> setManager) {
		double sum = 0;
		for(Staff staff:setStaff) {
			sum = sum + staff.salary*12;
		}
		for(Manager manager:setManager) {
			sum = sum + (manager.salary + manager.bonus)*12;
		}
		return sum;
	}

	//�鿴����Ա����Ϣ
	public void showAllStaff() {
		for(Staff staff:staffSet) {
			System.out.println(staff);
		}
	}
	
	//�鿴���о�����Ϣ
	public void showAllManager() {
		for(Manager manager:managerSet) {
			System.out.println(manager);
		}
	}
	
	//�鿴���йɶ���Ϣ
	public void showAllShareHolder() {
		for(ShareHolder shareHolder:shareHolderSet) {
			System.out.println(shareHolder);
		}
	}
	
	//�鿴������Ա��Ϣ
	public void showAllPeople() {
		showAllStaff();
		showAllManager();
		showAllShareHolder();
	}
	
	public static void main(String[] args) {
		Company company = new Company();
		company.showAllPeople();
		Staff staff = null;
		if((staff = company.searchStaff("�ϳ�")) != null)
			System.out.println(staff);
		else
			System.out.println("�޴�Ա��");
		Manager manager = null;
		if((manager = company.searchManager("����")) != null)
			System.out.println(manager);
		else
			System.out.println("�޴�Ա��");
		ShareHolder shareHolder = null;
		if((shareHolder = company.searchShareHolder("����")) != null)
			System.out.println(shareHolder);
		else
			System.out.println("�޴�Ա��");
		
	}
}

/*
 * person��
 * ��Staff��Manager��ShareHolder��Ļ���
 * �����˵����������ʣ�����
 * �������������ʣ��������жϵ����Ƿ�Ϊ������
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
		//��������,�˴���Ϊһ����Ϊ30��
		int day = (int)(Math.random()*30) + 1;
		//��ʼ������
		birthday = Calendar.getInstance();
		//�����������꣬�£���
		birthday.set(year,month,day);
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

	//��дequals����,������������ÿ��ְλ��ÿ����
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
 * Staff��
 * ��д��toString����
 */
class Staff extends Person {
	public Staff() {
		super();
		salary = Math.random() * 2000 + 10000;
	}

	//��дtoString����
	public String toString() {
		return "ְλ:"+"Ա��"+" "+"����:"+name+" "+"����:"+String.format("%.2f", salary)+" "+"����:"+present();
	}
}

/*
 * Manager��
 * �����н���
 * ����������������д��toString����
 */
class Manager extends Person {
	// ����
	public double bonus;

	public Manager() {
		super();
		salary = Math.random() * 2000 + 20000;
		bonus = Math.random() * 500 + 500;
	}

	// �����½���
	public double getBonus() {
		return bonus;
	}

	//��дtoString����
	public String toString() {
		return "ְλ:"+"����"+" "+"����:"+name+" "+"����:"+String.format("%.2f", salary)+" "+"����:"+String.format("%.2f", bonus)+" "+"����:"+present();
	}
}

/*
 * ShareHolder��
 * �����йɷ�
 * �����л�����շֺ죬�õ�����
 * ��д��toString����
 */
class ShareHolder extends Person {
	// �ɷ�
	public int shares;

	public ShareHolder(int shares) {
		super();
		salary = 0;
		this.shares = shares;
	}

	// ÿ�¹ɶ�������
	public String present() {
		return "�ɶ�û������";
	}

	// �ɶ����շֺ�
	public double getYearBonus() {
		return (shares/100.0) * Company.profit * 0.1;
	}
	
	//��дtoString����
	public String toString() {
		return "ְλ:"+"�ɶ�"+" "+"����:"+name+" "+"����:"+String.format("%.2f", salary)+"����:"+present()+" "+"���շֺ�:"+String.format("%.2f", getYearBonus());
	}
}