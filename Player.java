import java.util.Scanner;

public class Player {
	private int number;//生成的随机数
	public int score;//玩家的分数
	public Player() {
		score = 0;
	}
	public void setNumber() {
		number = (int)(Math.random()*10);
	}
	public int getNumber() {
		return number;
	}
	public void addScore() {//回答问题正确后加一分
		score++;
	}
	public int getScore() {//显示分数
		return score;
	}
	public static void main(String[] args) {
		int playerNumber;
		System.out.print("请输入玩家数量:");
		Scanner input = new Scanner(System.in);
		playerNumber = input.nextInt();
		GuessGame game = new GuessGame(playerNumber);
		game.startGame();
	}
}
class GuessGame{
	public Player player[];
	public int playerNumber;//玩家数量
	public GuessGame(int number) {//创建玩家，生成随机数
		playerNumber = number;
		player = new Player[playerNumber];
		for(int i = 0;i < playerNumber;i++) {
			player[i] = new Player();
		}
	}
	public void startGame() {
		int guessNumber;//玩家猜测的数字
		int frequency = 3;//游戏轮数
		for(int j = 0;j < frequency;j++)
		{
			for(int i = 0;i < playerNumber;i++) {
				player[i].setNumber();
				System.out.print("玩家"+(i+1)+"请输入猜测的数字:");
				Scanner input = new Scanner(System.in);
				guessNumber = input.nextInt();
				if(player[i].getNumber() == guessNumber)
				{
					System.out.println("猜测正确，加一分");
					player[i].addScore();
				}
				else
					System.out.println("猜测错误，不加分");
				}
			}
		for(int i = 0;i < playerNumber;i++) {
			System.out.println("玩家"+i+"的分数是"+player[i].getScore());
		}
	}
}
