package java_test;

public class SongDrive {

	public Master master;
	public Player player;
	public SongDrive() {
		master = new Master();
		player = new Player();
	}
	public static void createSong() {
		Song.allSong.add(new Song("����","�ܽ���",240));
		Song.allSong.add(new Song("������","�ܽ���",240));
		Song.allSong.add(new Song("����","�ܽ���",240));
		Song.allSong.add(new Song("�������","�ܽ���",240));
		Song.allSong.add(new Song("��ĵ�Ӱ","�ܽ���",240));
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
