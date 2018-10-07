package java_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Time {

	/**
	 * 初始化集合TreeSet，集合大小为n，另外对于ArrayList和HashSet只需要做一点小更改即可
	 * @param n
	 * @return
	 */
	public static TreeSet<String> initSet(int n){
		String[] array = new String[n];
		for(int i = 0;i<n;i++)
		{
			array[i] = (int)(Math.random()*n)+"";
		}
		TreeSet<String> list = new TreeSet<>(Arrays.asList(array));
		return list;
	}
	
	public static void main(String[] args) {
		//集合个数从10000到1000000
		for(int n = 10000;n <= 1000000;n = n+10000)
		{
			String str = null;
			TreeSet<String> list = initSet(n);
			//需要查找的元素
			str = (int)(Math.random()*n/2)+"";
			//创建迭代器，通过迭代器进行查找
			Iterator iterator = list.iterator();
			//记录查找开始的时间
			long startTime = System.currentTimeMillis();
			while(iterator.hasNext())
			{
				if(str.equals(iterator.next()))
					break;
			}
			//记录查找结束的时间
			long endTime = System.currentTimeMillis();
			System.out.println(n/10000+" "+(endTime - startTime));
		}
	}
}
