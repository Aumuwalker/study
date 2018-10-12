package java_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Company类，属性包括一年的利润，营业额，员工，经理，股东
 * 方法包括通过输入姓名查找指定的员工，经理或股东
 * 创建制定数量的员工，经理，股东
 * 计算公司一年的总支出
 * 查看每个员工，经理或股东的信息
 * 查看全体人员的信息
 * @author Han
 *
 */
public class Company {

	// 公司一年的利润
	public static double profit;
	// 公司一年的营业额
	public static double turnover = Math.random() * 10000000 + 100000000;
	//公司员工
	public HashSet<Staff> staffSet;
	//公司经理
	public HashSet<Manager> managerSet;
	//公司股东
	public HashSet<ShareHolder> shareHolderSet;
	
	public Company() {
		//默认为10个员工，5个经理，3个股东
		this(10,5,3);
	}
	
	public Company(int staffNumber,int managerNumber,int shareHolderNumber) {
		staffSet = createStaff(staffNumber);
		managerSet = createManager(managerNumber);
		Company.profit = Company.turnover - Company.caculateAllPay(staffSet, managerSet);
		shareHolderSet = createShareHolder(shareHolderNumber);
	}

	// 生成员工,number为员工数量
	private HashSet<Staff> createStaff(int number) {
		Set<Staff> setStaff = new HashSet<>();
		while (setStaff.size() < number) {
			setStaff.add(new Staff());
		}
		return (HashSet<Staff>) setStaff;
	}

	// 生成经理,number为经理数量
	private HashSet<Manager> createManager(int number) {
		Set<Manager> setManager = new HashSet<>();
		while (setManager.size() < number) {
			setManager.add(new Manager());
		}
		return (HashSet<Manager>) setManager;
	}

	// 生成股东,number为股东数量
	private HashSet<ShareHolder> createShareHolder(int number) {
		Set<ShareHolder> setShareHolder = new HashSet<>();
		//公司总股份
		int sharesSurplus = 100;
		//给前number-1个股东通过随机数给各股东股份,
		while (setShareHolder.size() < number-1) {
			int shares = (int)(Math.random()*(sharesSurplus - 10)) + 10;
			sharesSurplus = sharesSurplus - shares;
			setShareHolder.add(new ShareHolder(shares));
		}
		//最后一个股东的股份为剩下的股份
		setShareHolder.add(new ShareHolder(sharesSurplus));
		sharesSurplus = 0;
		return (HashSet<ShareHolder>) setShareHolder;
	}

	//根据姓名查找员工
	public Staff searchStaff(String name) {
		for(Staff staff:staffSet) {
			if(staff.name.equals(name)) {
				return staff;
			}
		}
		return null;
	}
	
	//根据姓名查找经理
	public Manager searchManager(String name) {
		for(Manager manager:managerSet) {
			if(manager.name.equals(name)) {
				return manager;
			}
		}
		return null;
	}
	
	//根据姓名查找股东
	public ShareHolder searchShareHolder(String name) {
		for(ShareHolder shareHolder:shareHolderSet) {
			if(shareHolder.name.equals(name)) {
				return shareHolder;
			}
		}
		return null;
	}
	
	//计算公司一年员工和经理的工资及奖金
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

	//查看所有员工信息
	public void showAllStaff() {
		for(Staff staff:staffSet) {
			System.out.println(staff);
		}
	}
	
	//查看所有经理信息
	public void showAllManager() {
		for(Manager manager:managerSet) {
			System.out.println(manager);
		}
	}
	
	//查看所有股东信息
	public void showAllShareHolder() {
		for(ShareHolder shareHolder:shareHolderSet) {
			System.out.println(shareHolder);
		}
	}
	
	//查看所有人员信息
	public void showAllPeople() {
		showAllStaff();
		showAllManager();
		showAllShareHolder();
	}
	
	public static void main(String[] args) {
		Company company = new Company();
		company.showAllPeople();
		Staff staff = null;
		if((staff = company.searchStaff("严成")) != null)
			System.out.println(staff);
		else
			System.out.println("无此员工");
		Manager manager = null;
		if((manager = company.searchManager("许林")) != null)
			System.out.println(manager);
		else
			System.out.println("无此员工");
		ShareHolder shareHolder = null;
		if((shareHolder = company.searchShareHolder("严树")) != null)
			System.out.println(shareHolder);
		else
			System.out.println("无此员工");
		
	}
}

/*
 * person类
 * 是Staff，Manager，ShareHolder类的基类
 * 包括人的姓名，工资，生日
 * 方法包括发工资，发奖金，判断当月是否为生日月
 * 重写了equals方法
 */
class Person {
	public String name;
	public double salary;
	public Calendar birthday;

	public Person() {
		// 出生年份为1950到2000
		int year = (int) (Math.random() * 51) + 1950;
		// 出生月份为1到12
		int month = (int) (Math.random() * 12) + 1;
		//出生天数,此处认为一个月为30天
		int day = (int)(Math.random()*30) + 1;
		//初始化日历
		birthday = Calendar.getInstance();
		//设置日历的年，月，日
		birthday.set(year,month,day);
		// 存储姓
		List<String> surnameList;
		// 存储名
		List<String> firstnameList;
		String[] surname = { "李", "刘", "魏", "赵", "冯", "孔", "朱", "许", "严", "吕" };
		String[] firstname = { "华", "葛", "歌", "树", "成", "雾", "阳", "样", "文", "林" };
		surnameList = new ArrayList<>(Arrays.asList(surname));
		firstnameList = new ArrayList<>(Arrays.asList(firstname));
		// 利用随机数生成姓名
		name = surnameList.get((int) (Math.random() * 10)) + firstnameList.get((int) (Math.random() * 10));
	}

	//重写equals方法,根据姓名区分每个职位的每个人
	public boolean equals(Object object) {
		if (object instanceof Person)
			return this.name.equals(((Person) object).name);
		else
			return false;
	}

	// 发工资
	public double payoff() {
		return salary;
	}

	// 判断当月是否是此人的生日
	public boolean isBirthday() {
		Calendar calendar = Calendar.getInstance();
		return (birthday.get(birthday.MONTH) == calendar.MONTH);
	}
	public boolean isBirthday(int month) {
		Calendar calendar = Calendar.getInstance();
		return (birthday.get(birthday.MONTH) == month);
	}

	// 给当月生日的员工或经理发礼物
	public String present() {
		if (isBirthday()) {
			List<String> list = new ArrayList<>(Arrays.asList("玩具", "小熊", "蛋糕", "假期"));
			return list.get((int) (Math.random() * 4));
		} else
			return "此月不是此人生日,无礼物";
	}
}

/*
 * Staff类
 * 重写了toString方法
 */
class Staff extends Person {
	public Staff() {
		super();
		salary = Math.random() * 2000 + 10000;
	}

	//重写toString方法
	public String toString() {
		return "职位:"+"员工"+" "+"姓名:"+name+" "+"工资:"+String.format("%.2f", salary)+" "+"礼物:"+present();
	}
}

/*
 * Manager类
 * 属性有奖金
 * 方法包括发奖金，重写了toString方法
 */
class Manager extends Person {
	// 奖金
	public double bonus;

	public Manager() {
		super();
		salary = Math.random() * 2000 + 20000;
		bonus = Math.random() * 500 + 500;
	}

	// 经理当月奖金
	public double getBonus() {
		return bonus;
	}

	//重写toString方法
	public String toString() {
		return "职位:"+"经理"+" "+"姓名:"+name+" "+"工资:"+String.format("%.2f", salary)+" "+"奖金:"+String.format("%.2f", bonus)+" "+"礼物:"+present();
	}
}

/*
 * ShareHolder类
 * 属性有股份
 * 方法有获得年终分红，得到奖金
 * 重写了toString方法
 */
class ShareHolder extends Person {
	// 股份
	public int shares;

	public ShareHolder(int shares) {
		super();
		salary = 0;
		this.shares = shares;
	}

	// 每月股东的礼物
	public String present() {
		return "股东没有礼物";
	}

	// 股东年终分红
	public double getYearBonus() {
		return (shares/100.0) * Company.profit * 0.1;
	}
	
	//重写toString方法
	public String toString() {
		return "职位:"+"股东"+" "+"姓名:"+name+" "+"工资:"+String.format("%.2f", salary)+"礼物:"+present()+" "+"年终分红:"+String.format("%.2f", getYearBonus());
	}
}