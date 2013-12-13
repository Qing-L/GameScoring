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
	int min = 54;
	Timer timer;
	CountTime()
	{
		LPanel = new JPanel();
		l.setText("00:00");
		LPanel.add(l);
		l.setFont(new Font("宋体",Font.BOLD,48));
		LPanel.setOpaque(false);
		 setLayout(new BorderLayout());
		add("Center",LPanel);   
	}
	
	public void Start()
	{
		timer =new Timer();
		start = System.currentTimeMillis();
		// final long end = start+min*60*1000;
		//Date End = new Date(end);
		timer.schedule(new TimerTask()
		{
			public void run()
				{
					//show是剩余时间，即要显示的时间
					show=start+min*60*1000-System.currentTimeMillis();
					//h=show/1000/60/60;//时
					 m=show/1000/60%60;//分
					 s=show/1000%60;//秒
					TimeShow();
					}
		},0,1000);

		/*timer.schedule(new TimerTask()
		{
			public void run()
			{	JOptionPane.showMessageDialog(null,"第一节结束，请休息一分钟");	}
		}
		, new Date(start+1*60*1000));
	
		timer.schedule(new TimerTask()
		{
			public void run()
			{	JOptionPane.showMessageDialog(null,"休息时间结束，请继续比赛");	}
	}, new Date(start+1*60*1000+30*1000));
	
	timer.schedule(new TimerTask()
	{
		public void run()
		{		}
	}, new Date(start+2*60*1000+30*1000));
	timer.schedule(new TimerTask()
	{
		public void run()
		{	JOptionPane.showMessageDialog(null,"中场休息结束，请交换场地并继续比赛");	}
	}, new Date(start+3*60*1000+30*1000));
	
	timer.schedule(new TimerTask()
	{
		public void run()
		{		}
	}, new Date(start+4*60*1000+30*1000));
	
	timer.schedule(new TimerTask()
	{
		public void run()
		{	JOptionPane.showMessageDialog(null,"休息结束，请继续比赛");		}
	}, new Date(start+5*60*1000));
	
	//计时结束时候，停止全部timer计时计划任务
    timer.schedule(new TimerTask()
     {
        public void run()
         {
             timer.cancel();
             JOptionPane.showMessageDialog(null,"时间到，比赛结束");
         }
     }, End);*/
	}
	
	
	public void Cancle()
	{	timer.cancel();	}
	
	
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
					//show是剩余时间，即要显示的时间
					show=start+min*60*1000+continuetime-pausetime-System.currentTimeMillis();
					//h=show/1000/60/60;//时
					 m=show/1000/60%60;//分
					 s=show/1000%60;//秒
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
		if(m == 44 && s == 0)
			JOptionPane.showMessageDialog(null,"第一节结束，请休息两分钟");
		if(m == 42 && s == 0)
			JOptionPane.showMessageDialog(null,"休息时间结束，请继续比赛");
		if(m == 32 && s == 0)
			JOptionPane.showMessageDialog(null,"第二节结束，请休息十分钟");
		if(m == 22 && s == 0)
			JOptionPane.showMessageDialog(null,"中场休息时间结束，请交换场地并继续比赛");
		if( m == 12 && s == 0)
			JOptionPane.showMessageDialog(null,"第三节结束，请休息两分钟");
		if( m == 10 && s == 0)
			JOptionPane.showMessageDialog(null,"休息时间结束，请继续比赛");
	}
	
}
