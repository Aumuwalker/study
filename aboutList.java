package java_test;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
public class aboutList {

	public static void main(String[] args) {
		List<Date> list = new ArrayList<>(1);
		Date date = new Date();
		date.setTime(1000000);
		list.add(date);
		System.out.println(list);
		date.setTime(3000000);//��������date
		System.out.println(list);//����list�е�dateҲ�ı��ˣ�˵������add����ֻ�Ǽ�����Ƕ�ԭ�������õĸ��ƣ�����ַ
		Date date2 = list.get(0);
		System.out.println(date2);
		list.get(0).setTime(5000000);//��������list�е�Ԫ�ص�ֵ
		System.out.println(date2);//����date2�ı��ˣ�˵�����渳ֵ������ǽ�����Ԫ�ص����ø�����һ�ݸ���date2
		//�������֤������������ֻ��һ��Date���󣬶�������date��list.get(0)������date2�����Ǵ˶�������á�
	}
}
