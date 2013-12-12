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
	long show,h,m,s;
	int min = 6;
	Timer timer=new Timer();
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
		long start = System.currentTimeMillis();
		final long end = start+min*60*1000;
		Date End = new Date(end);
		timer.schedule(new TimerTask()
		{
			public void run()
				{
					//show��ʣ��ʱ�䣬��Ҫ��ʾ��ʱ��
					show=end-System.currentTimeMillis();
					//h=show/1000/60/60;//ʱ
					 m=show/1000/60%60;//��
					 s=show/1000%60;//��
					if(m<10&&s<10)
						l.setText("0"+m+":"+"0"+s);
					else if(m<10&&s>=10)
						l.setText("0"+m+":"+s);
					else if(m>=10&&s<10)
						l.setText(m+":"+"0"+s);
					else
						l.setText(m+":"+s);
					}
		},0,1000);
	
		timer.schedule(new TimerTask()
		{
			public void run()
			{
				JOptionPane.showMessageDialog(null,"��һ�ڽ���������Ϣһ����");
			}
		}
		, new Date(start+1*60*1000));
	
	timer.schedule(new TimerTask()
	{
		public void run()
		{
			JOptionPane.showMessageDialog(null,"��Ϣʱ����������������");
		}
	}, new Date(start+1*60*1000+30*1000));
	
	timer.schedule(new TimerTask()
	{
		public void run()
		{
			JOptionPane.showMessageDialog(null,"�ڶ��ڽ���������Ϣ������");
		}
	}, new Date(start+2*60*1000+30*1000));
	timer.schedule(new TimerTask()
	{
		public void run()
		{
			JOptionPane.showMessageDialog(null,"�г���Ϣ�������뽻�����ز���������");
		}
	}, new Date(start+3*60*1000+30*1000));
	
	timer.schedule(new TimerTask()
	{
		public void run()
		{
			JOptionPane.showMessageDialog(null,"�����ڽ���������Ϣһ����");
		}
	}, new Date(start+4*60*1000+30*1000));
	
	timer.schedule(new TimerTask()
	{
		public void run()
		{
			JOptionPane.showMessageDialog(null,"��Ϣ���������������");
		}
	}, new Date(start+5*60*1000));
	
	//��ʱ����ʱ��ֹͣȫ��timer��ʱ�ƻ�����
    timer.schedule(new TimerTask()
     {
        public void run()
         {
             timer.cancel();
             JOptionPane.showMessageDialog(null,"ʱ�䵽����������");
         }
     }, End);
	}
	
	
	public void Cancle()
	{
		timer.cancel();
	}
	
}
