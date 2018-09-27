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
		date.setTime(3000000);//重新设置date
		System.out.println(list);//发现list中的date也改变了，说明上面add过程只是加入的是对原对象引用的复制，即地址
		Date date2 = list.get(0);
		System.out.println(date2);
		list.get(0).setTime(5000000);//重新设置list中的元素的值
		System.out.println(date2);//发现date2改变了，说明上面赋值运算符是将其中元素的引用复制了一份给了date2
		//上述结果证明了整个过程只有一个Date对象，而无论是date，list.get(0)，还是date2，都是此对象的引用。
	}
}
