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
		System.out.println("����ʱ�䣺" + (time) + "����");
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

// �����־���1000x1000��һ����һ���̣߳�����ʱ��Ϊ1930����
// ���־���500x1000��1000x500�������������̣߳�����ʱ��Ϊ1351����
// ���־���500x500���ĸ����ĸ��̣߳�����ʱ��Ϊ1216����
// ���־���125x1000��1000x125���˸����˸��̣߳�����ʱ��Ϊ1105����
// ���־���63x63��ʮ������ʮ�����̣߳�����ʱ��Ϊ417����
// ���־���32x32����ʮ��������ʮ�����̣߳�����ʱ��Ϊ105����
