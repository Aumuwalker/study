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
			System.out.println("当前列表没有歌曲。");
			return false;
		}
		for(int i = 0;i < number;i++)
		{
			System.out.println("播放歌曲:"+listSong.get(i).songName);
			if(i != number-1)
				System.out.println("下一首:"+listSong.get(i+1).songName);
			else
				System.out.println("此首为最后一首。");
		}
		return true;
	}
}
