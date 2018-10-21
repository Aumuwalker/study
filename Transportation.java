package java_test;

import java.util.Date;

public abstract class Transportation {
	
	//��ͨ��ʽ
	String transportMode;
	//����ʱ��
	Date leaveTime;
	//����ʱ��
	Date arriveTime;
	//����ʱ��
	Date returnTime;
	//ȡƱʱ��
	Date getTicketTime;
	//����ʱ��
	Date securityCheckTime;
	//��ʱ��
	Date waitTime;
	//��������
	String leaveArea;
	//�������
	String arriveArea;
	//���ؾ���
	double distance;
	//����
	double speed;
	//����
	double price;
	
	//��������ʱ��
	public double spendTime() {
		//�õ�ʱ���
		long milliSeconds = arriveTime.getTime() - leaveTime.getTime();
		double hour = milliSeconds/(1000.0 * 60 * 60);
		return hour;
	}
	//���㻨��
	public abstract double cost();
}

interface ShowInf{
	//������ʾÿ���������Ϣ
	public abstract void show();
}