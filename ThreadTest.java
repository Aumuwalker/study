package java_test;

import java.util.Random;

public class ThreadTest implements Runnable {

	public static long time = 0;

	@Override
	public void run() {
		Matrix m1 = new Matrix(32, 32, 1);
		Matrix m2 = new Matrix(32, 32, 2);
		Matrix m3 = new Matrix(m1.getRow(), m2.getCol());
		long startTime = 0;
		long endTime = 0;
			startTime = System.currentTimeMillis();
			m3 = m1.MulMatrix(m2);
			endTime = System.currentTimeMillis();
			time = time + endTime - startTime;
		System.out.println("花费时间：" + (time) + "毫秒");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 32; i++) {
			ThreadTest threadTest1 = new ThreadTest();
			Thread thread1 = new Thread(threadTest1);
			thread1.start();
		}
	}
}

class Matrix {
	public int[][] matrix;
	private int row;
	private int col;

	Matrix(int row, int col) {
		this.row = row;
		this.col = col;
		matrix = new int[row][col];
	}

	Matrix(int row, int col, int r) {
		this.row = row;
		this.col = col;
		Random random = new Random(r);
		matrix = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = random.nextInt(100);
			}
		}
	}

	public Matrix MulMatrix(Matrix m) {
		Matrix m1 = new Matrix(this.row, m.getCol());
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < m.getCol(); j++) {
				for (int k = 0; k < col; k++) {
					m1.matrix[i][j] = matrix[i][k] * m.matrix[k][j];
				}
			}
		}
		return m1;
	}

	public void show() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}

// 不划分矩阵1000x1000各一个，一个线程，花费时间为1930毫秒
// 划分矩阵500x1000与1000x500各两个，两个线程，花费时间为1351毫秒
// 划分矩阵500x500各四个，四个线程，花费时间为1216毫秒
// 划分矩阵125x1000与1000x125各八个，八个线程，花费时间为1105毫秒
// 划分矩阵63x63各十六个，十六个线程，花费时间为417毫秒
// 划分矩阵32x32各三十二个，三十二个线程，花费时间为105毫秒
