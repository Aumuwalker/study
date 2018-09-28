package java_test;

import java.util.Scanner;

public class Player {

	public boolean addSong() {
		System.out.println("ÇëÊäÈë¸èÇúµÄÃû×Ö£º");
		Scanner input = new Scanner(System.in);
		String str = input.next();
		boolean t = false;
		for(int i = 0;i<Song.allSong.size();i++)
		{
			if(Song.allSong.get(i).songName.equals(str))
			{
				t = true;
				Master.listSong.add(Song.allSong.get(i));
				break;
			}
		}
		return t;
	}
}
