package Score;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.io.IOException;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Basketball extends JFrame implements ActionListener
{
	JPanel Labelpanel,Foulpanel,Scorepanel,Apanel,Bpanel,StatuesPanel,
				Ascorepanel,Bscorepanel,Abuttonpanel,Bbuttonpanel;
	JLabel ALabel,BLabel,Bscore,Ascore,AAll,BAll;
	JTextField[] At,Bt;
	JComboBox [] Bcb,Acb;
	JButton	 Return,Help,Start,Pause,Continue,Data,Change,Sure,See,Reset,savedata;
	JButton[] Abutton,Bbutton,AButton_,BButton_;
	ImageIcon startimg,pauseimg,overimg;
	Dimension screenSize;
	CountTime time;
	Vector VectorA,VectorB,VectorAall,VectorBall;
	//DefaultTableModel Mytable;
	//JTable table;
	int an,bn,aall,ball;
	int [] a = new int[5];
	int [] b = new int[5];

	
	public Basketball()
	{
    screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    VectorAall = new Vector();
    VectorBall = new Vector();
    VectorAall.add("A队");
    VectorBall.add("B队");
    /**
     * 标签栏的所有设置，
     * 包括添加A队，B队标签
     */
    
	Labelpanel = new JPanel();
	
	/*A队标签栏的设置*/
	Return = new JButton("Return");
	
	Return.setPreferredSize(new Dimension(150,80));
	Return.setFont(new Font("方正舒体",Font.BOLD,32));
	Return.addActionListener(this);
	
	Labelpanel.add(Return);
	
	Help = new JButton("Help");
	
	Help.setPreferredSize(new Dimension(150,80));
	Help.setFont(new Font("方正舒体",Font.BOLD,32));
	Help.addActionListener(this);
	
	Labelpanel.add(Help);
	
	ALabel = new JLabel(new ImageIcon("Source\\10.png"));
	JTextField Aname = new JTextField(3);
	Aname.setText("A队");
	Aname.setFont(new Font("宋体",Font.BOLD,36));
	Aname.setEditable(false);
	Labelpanel.add(ALabel);
	Labelpanel.add(Aname);
	
	/*倒计时的显示在两队标签栏中间*/
	time = new CountTime();
	time.setOpaque(false);
	Labelpanel.add(time);
	
	/*B队标签栏的设置*/
	BLabel = new JLabel(new ImageIcon("Source\\11.png"));
	JTextField Bname = new JTextField(3);
	Bname.setText("B队");
	Bname.setFont(new Font("宋体",Font.BOLD,36));
	Bname.setEditable(false);
	Labelpanel.add(Bname);
	Labelpanel.add(BLabel);	
	
	Labelpanel.setLayout(new FlowLayout());
	Labelpanel.setOpaque(false);
	
	/**
	 * 犯规面板的设置，
	 * 添加A，B队各个队员
	 * 和总体的犯规次数
	 */
	
	Foulpanel = new JPanel();
	Foulpanel.setPreferredSize(new Dimension(screenSize.width/5,screenSize.height/2));
	Foulpanel.setOpaque(false);
	
	/*添加A队人员和总体犯规次数，
	 * 单击各个队员后的按钮累计各个队员的犯规次数*/
	
	Apanel = new JPanel();
	
	JTextField ANum = new JTextField("A队人员");
	ANum.setFont(new Font("宋体",Font.BOLD,24));
	ANum.setEditable(false);
	
	JTextField AFoul = new JTextField("犯规次数");
	AFoul.setFont(new Font("宋体",Font.BOLD,24));
	AFoul.setEditable(false);
	
	Apanel.add(ANum);
	Apanel.add(AFoul);
	
	Abutton = new JButton[5];
	Acb = new JComboBox[5];
	
	for(int i=0;i<5;i++)
	{
		Acb[i] = new JComboBox();
		Abutton[i] = new JButton();
		Abutton[i].setText("0次");
		Abutton[i].addActionListener(this);
		Abutton[i].setEnabled(false);
		Apanel.add(Acb[i]);
		Apanel.add(Abutton[i]);
	}
	
	JTextField AFoulAll = new JTextField("犯规总数");
	AFoulAll.setFont(new Font("宋体",Font.BOLD,24));
	AFoulAll.setEditable(false);
	
	AAll = new JLabel(aall+"次");
	AAll.setFont(new Font("宋体",Font.BOLD,24));
	AAll.setHorizontalAlignment(0);
	
	Apanel.add(AFoulAll);
	Apanel.add(AAll);

	Apanel.setLayout(new GridLayout(7,2));
	Foulpanel.add(Apanel);
	
	/*
	 * 添加B队人员和总体犯规次数，
	 * 单击各个队员后的按钮累计各个队员的犯规次数
	 */
	
	Bpanel = new JPanel();
	
	JTextField BNum = new JTextField("B队人员");
	BNum.setFont(new Font("宋体",Font.BOLD,24));
	BNum.setEditable(false);
	
	JTextField BFoul = new JTextField("犯规次数");
	BFoul.setFont(new Font("宋体",Font.BOLD,24));
	BFoul.setEditable(false);
	
	Bpanel.add(BNum);
	Bpanel.add(BFoul);
	
	Bbutton = new JButton[5];
	Bcb = new JComboBox[5];
	
	for(int i = 0;i<5;i++)
		{
			Bcb[i] = new JComboBox();
			
			Bbutton[i] = new JButton();
			Bbutton[i].setText("0次");
			Bbutton[i].addActionListener(this);
			Bbutton[i].setEnabled(false);
			Bpanel.add(Bcb[i]);
			Bpanel.add(Bbutton[i]);
		}
	
	JTextField BFoulAll = new JTextField("犯规总数");
	BFoulAll.setFont(new Font("宋体",Font.BOLD,24));
	BFoulAll.setEditable(false);
	
	BAll = new JLabel(ball+"次");
	BAll.setFont(new Font("宋体",Font.BOLD,24));
	BAll.setHorizontalAlignment(0);
	
	Bpanel.add(BFoulAll);
	Bpanel.add(BAll);
	
	Bpanel.setLayout(new GridLayout(7,2));
	Foulpanel.add(Bpanel);
		
	Foulpanel.setSize(120,450);
	
	/*
	 * A队记分牌处的设置
	 * 添加各个加分按钮
	 * 设置显示分数
	  */
	Scorepanel = new JPanel();
	
	Ascorepanel =  new JPanel();
	Ascore = new JLabel("00");
	Ascore.setFont(new Font("宋体",Font.BOLD,200));
	Ascore.setHorizontalAlignment(0);
	
	Abuttonpanel = new JPanel();
	
	AButton_ = new JButton[3];
	
	for(int i = 0;i<3;i++)
	{
		AButton_[i]  = new JButton();
		AButton_[i].setText("A + "+(i+1));
		AButton_[i].addActionListener(this);
		AButton_[i].setEnabled(false);
		Abuttonpanel.add(AButton_[i]);
	}
	
	Abuttonpanel.setOpaque(false);
	Ascorepanel.setLayout(new BorderLayout());
	Ascorepanel.add("Center",Ascore);
	Ascorepanel.add("South",Abuttonpanel);
	Ascorepanel.setPreferredSize(new Dimension(350,450));
	Ascorepanel.setOpaque(false);
	
	Scorepanel.add(Ascorepanel);
	
	/*
	 *A队和B队分数中间显示VS 
	 */
	JLabel VS = new JLabel("VS");
	VS.setFont(new Font("宋体",Font.BOLD,48));
	
	Scorepanel.add(VS);
	
	/*
	 * B队记分牌的设置
	 * 同样添加3个按钮
	 * 并设置分数的显示
	 */
	Bscorepanel = new JPanel();
	Bscore = new JLabel("00");
	Bscore.setFont(new Font("宋体",Font.BOLD,200));
	Bscore.setHorizontalAlignment(0);
	
	Bbuttonpanel = new JPanel();
	BButton_ = new JButton[3];
	
	for(int i = 0;i<3;i++)
	{
		BButton_[i]  = new JButton();
		BButton_[i].setText("B + "+(i+1));
		BButton_[i].addActionListener(this);
		BButton_[i].setEnabled(false);
		Bbuttonpanel.add(BButton_[i]);
	}
	
	Bbuttonpanel.setOpaque(false);
	
	Bscorepanel.setLayout(new BorderLayout());
	Bscorepanel.add("Center",Bscore);
	Bscorepanel.add("South",Bbuttonpanel);
	Bscorepanel.setPreferredSize(new Dimension(350,450));
	Bscorepanel.setOpaque(false);
	
	Scorepanel.add(Bscorepanel);
	
	/*
	 * 在整个得分面板中添加各个按钮
	 * 开始，暂停，填写队员信息，换人，确定
	 * 比赛最开始先点击Data按钮
	 * 添加至少五个队员信息
	 *然后才可以点击比赛开始
	 */
	
	Start = new JButton("Start");
    Pause = new JButton("Pause");
    Continue = new JButton("Continue");
    Data = new JButton("Data");
    Change = new JButton("Change");
    Sure = new JButton("Sure");
   // See = new JButton("See");
    Reset = new JButton("Reset");
    
    StatuesPanel = new JPanel();
    
    StatuesPanel.add(Start);
    StatuesPanel.add(Pause);
    StatuesPanel.add(Continue);
    StatuesPanel.add(Data);
    StatuesPanel.add(Change);
    StatuesPanel.add(Sure);
    //StatuesPanel.add(See);
    StatuesPanel.add(Reset);
  
    Start.addActionListener(this);
    Pause.addActionListener(this);
    Continue.addActionListener(this);
	Data.addActionListener(this);
	Change.addActionListener(this);
	Sure.addActionListener(this);
	//See.addActionListener(this);
	Reset.addActionListener(this);
	
	//Start.setEnabled(false); 
	Pause.setEnabled(false);
	Continue.setEnabled(false);
	
	StatuesPanel.setOpaque(false);
	Scorepanel.add(StatuesPanel);
	Scorepanel.setOpaque(false);
	
	/*
	 * 在可拆分窗体中
	 * 左边添加队员犯规
	 * 右边添加记分牌
	 */
	
	JSplitPane AaBpanel = new JSplitPane(
    		JSplitPane.HORIZONTAL_SPLIT,true,Foulpanel,Scorepanel);
	AaBpanel.setOpaque(false);
	
	/*
	 * 设置窗体背景为纯白色
	 * 并设置其大小，标题
	 * 关闭窗口时事件
	 */
	
    Container cp=getContentPane(); 
    setLayout(new BorderLayout());	
    cp.add(Labelpanel,BorderLayout.NORTH);
    cp.add(AaBpanel,BorderLayout.CENTER);
    
    ImageIcon background = new ImageIcon("Source//whitebackground.png");//这是背景图片  
    JLabel imgLabel = new JLabel(background);//将背景图放在标签里。  
    getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。  
    imgLabel.setBounds(0,0,background.getIconWidth(), background.getIconHeight());//设置背景标签的位置  
    ((JPanel)cp).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。  
  
    setBounds(130, 20,1050 ,695 );
    setIconImage(Toolkit.getDefaultToolkit().getImage(
    		"Source//ilovethisgame_002.png"));
    setTitle("篮球计分器");
    
   setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
   addWindowListener(new WindowAdapter()
   {
        public void windowClosing(WindowEvent e) 
        {
            int exit=JOptionPane.showConfirmDialog(Basketball.this,
            		"确定退出吗？", "退出", JOptionPane.OK_CANCEL_OPTION);
            if(exit==JOptionPane.OK_OPTION)
            	{
        		dispose();
        		time.Cancle();
        		}
        }
    });
	setVisible(true);
	validate();   
	}
	

@SuppressWarnings("unchecked")
public void actionPerformed(ActionEvent e)
{
	if(e.getSource() == Return)
		{	this.dispose();	}
	if(e.getSource() == Help)
	{
		Runtime run = Runtime.getRuntime();
		try 
		{
			Process process = run.exec("cmd /c call " + "\""
					+ "Source\\help.doc" + "\"");
		} 
		catch (IOException e1)
		{
			e1.printStackTrace();
			System.exit(0);
		}
	}
	if(e.getSource() == Start)
	{
		for(int i = 0 ;i<5;i++)
			{
				Abutton[i].setEnabled(true);
				Bbutton[i].setEnabled(true);
			}
			
		for(int i = 0;i<3;i++)
			{
				AButton_[i].setEnabled(true);
				BButton_[i].setEnabled(true);
			}
		
		Start.setEnabled(false);
		Pause.setEnabled(true);
		
		time.Start();
		
	/*	if(time.m == 6&& time.s == 0)
			{VectorAall.add(an);
			VectorBall.add(bn);System.out.println(VectorAall);}
		if(time.m == 4 && time.s == 0)
			{VectorAall.add(an);
			VectorBall.add(bn);System.out.println(VectorAall);}
		if(time.m == 2 && time.s == 0)
			{VectorAall.add(an);
			VectorBall.add(bn);System.out.println(VectorAall);}
		if(time.m == 0 && time.s == 0)
			{VectorAall.add(an);
			VectorBall.add(bn);System.out.println(VectorAall);}
	*/
	}
	
	if(e.getSource() == Pause)
			{	time.Pause();		
				Pause.setEnabled(false);
				Continue.setEnabled(true);
			}
	
	if(e.getSource() == Continue)
			{	time.Continue();
				Continue.setEnabled(false);
				Pause.setEnabled(true);
				}
	
	if(e.getSource() == Data)
			{	Data();	}
	
	//if(e.getSource() == See )
		//	{	See();	}
	
	if(e.getSource() == Reset)
	{
		time.Reset();
		
		for(int i = 0;i<5;i++)
		{
			Abutton[i].setText("0次");
			Acb[i].removeAllItems();
			
			Bbutton[i].setText("0次");
			Bcb[i].removeAllItems();
		}
		
		AAll.setText("0");
		Ascore.setText("00");
		an = 0;
		aall = 0;
		
		BAll.setText("0");
		Bscore.setText("00");
		bn = 0;
		ball = 0;
		
		Data.setEnabled(true);
		Pause.setEnabled(false);
		Continue.setEnabled(false);
	}
	
	
		
	if(e.getSource() == savedata )
		{
			if(At[0].getText().length()==0||At[1].getText().length()==0||
					At[2].getText().length()==0||At[3].getText().length()==0||
					At[4].getText().length()==0||Bt[0].getText().length()==0||
					Bt[1].getText().length()==0||Bt[2].getText().length()==0||
					Bt[3].getText().length()==0||Bt[4].getText().length()==0)
				JOptionPane.showMessageDialog(null,
					"请至少填写两队的前五位队员","提示",JOptionPane.WARNING_MESSAGE);
			else
				{	
					for(int i =0;i<5;i++)
						for(int j =0;j<10;j++)
							{
								if(At[j].getText().length()!=0)
										Acb[i].addItem(At[j].getText());
								
								if(Bt[j].getText().length()!=0)
										Bcb[i].addItem(Bt[j].getText());
							}	
				}
			Data.setEnabled(false);
			Start.setEnabled(true);
			
		}
	
	if(e.getSource() == Change )
		{
			for(int i = 0;i<5;i++)
				{	Acb[i].setEnabled(false);	
					Bcb[i].setEnabled(true);		}
		}
	
	if(e.getSource() == Sure )
		{
			for(int i = 0;i<5;i++)
				{	Acb[i].setEnabled(false);
					Bcb[i].setEnabled(false);	}
		}
	
	for(int i = 0;i<3;i++)
	{
		if(e.getSource() == AButton_[i])
			{
				an+=(i+1);
				if(an<10)
					Ascore.setText("0"+an);
				else
					Ascore.setText(""+an);
				//VectorA.add(an);
			}
		if(e.getSource() == BButton_[i])
		{
			bn+=(i+1);
			if(bn<10)
				Bscore.setText("0"+bn);
			else
				Bscore.setText(""+bn);
			//VectorB.add(bn);
		}
	}

	for(int i = 0;i<5;i++)
	{
		if(e.getSource() == Abutton[i])
			{
				++a[i];
				++aall;
				if(a[i]<5)
					Abutton[i].setText(a[i]+"次");
				else
					{
						JOptionPane.showMessageDialog(null,
							"该选手已五犯离场，请更换队员","提示",JOptionPane.ERROR_MESSAGE);
						Abutton[i].setText(0+"次");
						a[i]=0;
						for(int j = 0;j<5;j++)
							if(j!=i)
								Acb[j].removeItem(Acb[i].getSelectedItem());
						Acb[i].removeItem(Acb[i].getSelectedItem());
					}
				AAll.setText(aall+"次");
			}
		if(e.getSource() == Bbutton[i])
		{
			++b[i];
			++ball;
			if(b[i]<5)
				Bbutton[i].setText(b[i]+"次");
			else
				{
					JOptionPane.showMessageDialog(null,
							"该选手已五犯离场，请更换队员","提示",JOptionPane.ERROR_MESSAGE);
					Bbutton[i].setText(0+"次");
					b[i]=0;
					for(int j = 0;j<5;j++)
						if(j!=i)
							Bcb[j].removeItem(Bcb[i].getSelectedItem());
					Bcb[i].removeItem(Bcb[i].getSelectedItem());
				}
			BAll.setText(ball+"次");
			}
		}
	}

private void Data() 
	{
		JDialog d = new JDialog(this,"填写两队队员资料",true);
		
		JTextField a = new JTextField("A队人员(至少五人)");
		JTextField b = new JTextField("B队人员(至少五人)");
		
		a.setEditable(false);
		b.setEditable(false);
		
		a.setFont(new Font("宋体",Font.BOLD,24));
		b.setFont(new Font("宋体",Font.BOLD,24));
		
		JPanel aandb = new JPanel();
		
		aandb.add(a);
		aandb.add(b);
		
		d.add("Center",aandb);
		
		At = new JTextField[10];
		Bt = new JTextField[10];

		for(int i = 0;i<10;i++)
			{
				At[i] = new JTextField();
				Bt[i] = new JTextField();
		
				aandb.add(At[i]);
				aandb.add(Bt[i]);
		
				At[i].setFont(new Font("楷体",Font.PLAIN,20));
				Bt[i].setFont(new Font("楷体",Font.PLAIN,20));
			}
	
		aandb.setLayout(new GridLayout(11,2));
		
		savedata = new JButton("请按照号数_名字填写队员信息再保存");
	
		savedata.setFont(new Font("宋体",Font.PLAIN,20));
		savedata.addActionListener(this);
		d.add("South",savedata);
	
		d.setSize(new Dimension(480,550));
		d.setLocation(screenSize.width/3, screenSize.height/8);
		d.setVisible(true);
	}

	/*private void See() 
	{
		String [] columnNames = {"比赛节数 ","第一节","第二节","第三节","第四节"};
		Mytable = new DefaultTableModel(columnNames,2);
		table  = new JTable(Mytable);
		
	    JScrollPane panel = new JScrollPane(table);
		JFrame Frame = new JFrame();
		Frame.add(panel);
		Frame.pack();
		Frame.setVisible(true);
		table.setPreferredScrollableViewportSize(new Dimension(300,200));

		//Mytable.addChildren(VectorAall);
		for(int i=0;i<4;i++)
		{
			Mytable.setValueAt(VectorAall.get(i), 0, i);
			System.out.println(VectorAall.get(i));
		}
	}*/


public static void main(String[] args)
	{
		new Basketball();
	}
}
