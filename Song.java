package java_test;

import java.util.ArrayList;
import java.util.List;

public class Song {

	public String songName;
	public String songer;
	public double time;
	public static List<Song> allSong = new ArrayList<>();
	public Song() {
		this("null","null",0);
	}
	public Song(String songName,String songer,double time) {
		this.songName = songName;
		this.songer = songer;
		this.time = time;
	}
	public String toString() {
		return new String("����:"+songName+" ����:"+songer+" ��ʱ��:"+time);
	}
	public static void addSong(Song song) {
		allSong.add(song);
	}
}
