package java_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Time {

	/**
	 * ��ʼ������TreeSet�����ϴ�СΪn���������ArrayList��HashSetֻ��Ҫ��һ��С���ļ���
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
		//���ϸ�����10000��1000000
		for(int n = 10000;n <= 1000000;n = n+10000)
		{
			String str = null;
			TreeSet<String> list = initSet(n);
			//��Ҫ���ҵ�Ԫ��
			str = (int)(Math.random()*n/2)+"";
			//������������ͨ�����������в���
			Iterator iterator = list.iterator();
			//��¼���ҿ�ʼ��ʱ��
			long startTime = System.currentTimeMillis();
			while(iterator.hasNext())
			{
				if(str.equals(iterator.next()))
					break;
			}
			//��¼���ҽ�����ʱ��
			long endTime = System.currentTimeMillis();
			System.out.println(n/10000+" "+(endTime - startTime));
		}
	}
}
