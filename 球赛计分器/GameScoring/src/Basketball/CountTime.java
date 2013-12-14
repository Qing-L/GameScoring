package Score;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class CountTime extends JPanel //implements ActionListener
{
	JLabel l = new JLabel();
	JPanel LPanel;
	long show,h,m,s,pausetime,continuetime,start;
	int min = 7;
	Timer timer;
	CountTime()
	{
		LPanel = new JPanel();
		l.setText("00:00");
		LPanel.add(l);
		l.setFont(new Font("����",Font.BOLD,48));
		LPanel.setOpaque(false);
		 setLayout(new BorderLayout());
		add("Center",LPanel);   
	}
	
	public void Start()
	{
		timer =new Timer();
		start = System.currentTimeMillis();
		timer.schedule(new TimerTask()
		{
			public void run()
				{
					//show��ʣ��ʱ�䣬��Ҫ��ʾ��ʱ��
					show=start+min*60*1000-System.currentTimeMillis();
					//h=show/1000/60/60;//ʱ
					 m=show/1000/60%60;//��
					 s=show/1000%60;//��
					TimeShow();
					}
		},0,1000);
	}
	
	
	public void Cancle()
	{	timer.cancel();
		timer.purge();	}
	
	
	public void Pause()
	{
		timer.cancel();
		pausetime+= System.currentTimeMillis();
		TimeShow();
	}
	

	public void Continue()
	{
		continuetime+= System.currentTimeMillis();
		timer =new Timer();
		timer.schedule(new TimerTask()
		{
			public void run()
				{
					//show��ʣ��ʱ�䣬��Ҫ��ʾ��ʱ��
					show=start+min*60*1000+continuetime-pausetime-System.currentTimeMillis();
					//h=show/1000/60/60;//ʱ
					 m=show/1000/60%60;//��
					 s=show/1000%60;//��
					TimeShow();
					}
		},0,1000);
	}
	
	
	public void Reset()
	{
		timer.cancel();
		timer.purge();
		l.setText("00:00");
	}
	
	
	public void TimeShow() 
	{
		if(m<10&&s<10)
			l.setText("0"+m+":"+"0"+s);
		else if(m<10&&s>=10)
			l.setText("0"+m+":"+s);
		else if(m>=10&&s<10)
			l.setText(m+":"+"0"+s);
		else
			l.setText(m+":"+s);
		if(m == 6 && s == 0)
			JOptionPane.showMessageDialog(null,"��һ�ڽ���������Ϣ1����");
		if(m == 5 && s == 0)
			JOptionPane.showMessageDialog(null,"��Ϣʱ����������������");
		if(m == 4 && s == 0)
			JOptionPane.showMessageDialog(null,"�ڶ��ڽ���������Ϣ1����");
		if(m == 3 && s == 0)
			JOptionPane.showMessageDialog(null,"�г���Ϣʱ��������뽻�����ز���������");
		if( m == 2 && s == 0)
			JOptionPane.showMessageDialog(null,"�����ڽ���������Ϣ1����");
		if( m == 1 && s == 0)
			JOptionPane.showMessageDialog(null,"��Ϣʱ����������������");
		if( m == 0 && s == 0)
			JOptionPane.showMessageDialog(null,"��������");
	}
	
}
