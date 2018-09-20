import java.util.Scanner;

public class Player {
	private int number;//���ɵ������
	public int score;//��ҵķ���
	public Player() {
		score = 0;
	}
	public void setNumber() {
		number = (int)(Math.random()*10);
	}
	public int getNumber() {
		return number;
	}
	public void addScore() {//�ش�������ȷ���һ��
		score++;
	}
	public int getScore() {//��ʾ����
		return score;
	}
	public static void main(String[] args) {
		int playerNumber;
		System.out.print("�������������:");
		Scanner input = new Scanner(System.in);
		playerNumber = input.nextInt();
		GuessGame game = new GuessGame(playerNumber);
		game.startGame();
	}
}
class GuessGame{
	public Player player[];
	public int playerNumber;//�������
	public GuessGame(int number) {//������ң����������
		playerNumber = number;
		player = new Player[playerNumber];
		for(int i = 0;i < playerNumber;i++) {
			player[i] = new Player();
		}
	}
	public void startGame() {
		int guessNumber;//��Ҳ²������
		int frequency = 3;//��Ϸ����
		for(int j = 0;j < frequency;j++)
		{
			for(int i = 0;i < playerNumber;i++) {
				player[i].setNumber();
				System.out.print("���"+(i+1)+"������²������:");
				Scanner input = new Scanner(System.in);
				guessNumber = input.nextInt();
				if(player[i].getNumber() == guessNumber)
				{
					System.out.println("�²���ȷ����һ��");
					player[i].addScore();
				}
				else
					System.out.println("�²���󣬲��ӷ�");
				}
			}
		for(int i = 0;i < playerNumber;i++) {
			System.out.println("���"+i+"�ķ�����"+player[i].getScore());
		}
	}
}
