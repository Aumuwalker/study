package java_test;

import java.util.ArrayList;
import java.util.List;

public class Master {

	public static List<Song> listSong = new ArrayList<>();
	public Master() {
	}
	public boolean play() {
		int number = listSong.size();
		if(number == 0)
		{
			System.out.println("��ǰ�б�û�и�����");
			return false;
		}
		for(int i = 0;i < number;i++)
		{
			System.out.println("���Ÿ���:"+listSong.get(i).songName);
			if(i != number-1)
				System.out.println("��һ��:"+listSong.get(i+1).songName);
			else
				System.out.println("����Ϊ���һ�ס�");
		}
		return true;
	}
}
