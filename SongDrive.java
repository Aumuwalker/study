package java_test;

public class SongDrive {

	public Master master;
	public Player player;
	public SongDrive() {
		master = new Master();
		player = new Player();
	}
	public static void createSong() {
		Song.allSong.add(new Song("稻香","周杰伦",240));
		Song.allSong.add(new Song("七里香","周杰伦",240));
		Song.allSong.add(new Song("晴天","周杰伦",240));
		Song.allSong.add(new Song("告白气球","周杰伦",240));
		Song.allSong.add(new Song("最长的电影","周杰伦",240));
	}
	public static void main(String[] args) {	
		SongDrive.createSong();
		SongDrive songDrive = new SongDrive();
		songDrive.player.addSong();
		songDrive.player.addSong();
		songDrive.player.addSong();
		songDrive.master.play();
	}
}
