package Score;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Basketball extends JFrame implements ActionListener
{
	JPanel Labelpanel,Foulpanel,Scorepanel,Apanel,Bpanel,StatuesPanel,
				Ascorepanel,Bscorepanel,Abuttonpanel,Bbuttonpanel;
	JLabel ALabel,BLabel,Bscore,Ascore,AAll,BAll;
	JTextField A1,A2,A3,A4,A5,B1,B2,B3,B4,B5;
	JTextField[] At,Bt;
	JComboBox Acb1,Acb2,Acb3,Acb4,Acb5,Bcb1,Bcb2,Bcb3,Bcb4,Bcb5;
	JButton	 Abutton1,Abutton2,Abutton3,Abutton4,Abutton5,Bbutton1,
				Bbutton2,Bbutton3,Bbutton4,Bbutton5,AButton_1,AButton_2,AButton_3,
				BButton_1,BButton_2,BButton_3,Start,Pause,Continue,Data,Change,Sure,See,Reset,savedata;
	ImageIcon startimg,pauseimg,overimg;
	Dimension screenSize;
	CountTime time;
	Vector VectorA,VectorB,VectorAall,VectorBall;
	//DefaultTableModel Mytable;
	//JTable table;
	int an,bn,a1,a2,a3,a4,a5,aall,b1,b2,b3,b4,b5,ball;
	
	@SuppressWarnings("rawtypes")
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
	
	Acb1 = new JComboBox();
	Acb2 = new JComboBox();
	Acb3 = new JComboBox();
	Acb4 = new JComboBox();
	Acb5 = new JComboBox();
	
	Abutton1 = new JButton(0+"次");
	Abutton2 = new JButton(0+"次");
	Abutton3 = new JButton(0+"次");
	Abutton4 = new JButton(0+"次");
	Abutton5 = new JButton(0+"次");
	 
	Abutton1.addActionListener(this);
	Abutton2.addActionListener(this);
	Abutton3.addActionListener(this);
	Abutton4.addActionListener(this);
	Abutton5.addActionListener(this);
	 
	Abutton1.setEnabled(false);
	Abutton2.setEnabled(false);
	Abutton3.setEnabled(false);
	Abutton4.setEnabled(false);
	Abutton5.setEnabled(false);
	 
	Apanel.add(Acb1);
	Apanel.add(Abutton1);
	Apanel.add(Acb2);
	Apanel.add(Abutton2);
	Apanel.add(Acb3);
	Apanel.add(Abutton3);
	Apanel.add(Acb4);
	Apanel.add(Abutton4);
	Apanel.add(Acb5);
	Apanel.add(Abutton5);
	
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
	
	Bcb1 = new JComboBox();
	Bcb2 = new JComboBox();
	Bcb3 = new JComboBox();
	Bcb4 = new JComboBox();
	Bcb5 = new JComboBox();
	
	Bbutton1 = new JButton(0+"次");
	Bbutton2 = new JButton(0+"次");
	Bbutton3 = new JButton(0+"次");
	Bbutton4 = new JButton(0+"次");
	Bbutton5 = new JButton(0+"次");
	 
	Bbutton1.addActionListener(this);
	Bbutton2.addActionListener(this);
	Bbutton3.addActionListener(this);
	Bbutton4.addActionListener(this);
	Bbutton5.addActionListener(this);
	 
	Bbutton1.setEnabled(false);
	Bbutton2.setEnabled(false);
	Bbutton3.setEnabled(false);
	Bbutton4.setEnabled(false);
	Bbutton5.setEnabled(false);
	 
	Bpanel.add(Bcb1);
	Bpanel.add(Bbutton1);
	Bpanel.add(Bcb2);
	Bpanel.add(Bbutton2);
	Bpanel.add(Bcb3);
	Bpanel.add(Bbutton3);
	Bpanel.add(Bcb4);
	Bpanel.add(Bbutton4);
	Bpanel.add(Bcb5);
	Bpanel.add(Bbutton5);
	
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
	
	AButton_1 = new JButton("A + 1");
	AButton_2 = new JButton("A + 2");
	AButton_3 = new JButton("A + 3");
	
	AButton_1.addActionListener(this);
	AButton_2.addActionListener(this);
	AButton_3.addActionListener(this);
	
	AButton_1.setEnabled(false);
	AButton_2.setEnabled(false);
	AButton_3.setEnabled(false);
	
	Abuttonpanel.add(AButton_1);
	Abuttonpanel.add(AButton_2);
	Abuttonpanel.add(AButton_3);
	
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
	BButton_1 = new JButton("B + 1");
	BButton_2 = new JButton("B + 2");
	BButton_3 = new JButton("B + 3");
	
	BButton_1.addActionListener(this);
	BButton_2.addActionListener(this);
	BButton_3.addActionListener(this);
	
	BButton_1.setEnabled(false);
	BButton_2.setEnabled(false);
	BButton_3.setEnabled(false);
	
	Bbuttonpanel.add(BButton_1);
	Bbuttonpanel.add(BButton_2);
	Bbuttonpanel.add(BButton_3);
	
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
	
	Start.setEnabled(false); 
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
	if(e.getSource() == Start)
	{
		Abutton1.setEnabled(true);
		Abutton2.setEnabled(true);
		Abutton3.setEnabled(true);
		Abutton4.setEnabled(true);
		Abutton5.setEnabled(true);
		
		Bbutton1.setEnabled(true);
		Bbutton2.setEnabled(true);
		Bbutton3.setEnabled(true);
		Bbutton4.setEnabled(true);
		Bbutton5.setEnabled(true);
		
		AButton_1.setEnabled(true);
		AButton_2.setEnabled(true);
		AButton_3.setEnabled(true);
		
		BButton_1.setEnabled(true);
		BButton_2.setEnabled(true);
		BButton_3.setEnabled(true);
		
		Start.setEnabled(false);
		Pause.setEnabled(true);
		
		time.Start();
		
		if(time.m == 4&& time.s == 0)
		{VectorAall.add(an);
			VectorBall.add(bn);}
	if(time.m == 3 && time.s == 0)
		{VectorAall.add(an);
		VectorBall.add(bn);}
	if(time.m == 1 && time.s == 0)
		{VectorAall.add(an);
		VectorBall.add(bn);}
	if(time.m == 0 && time.s == 0)
		{VectorAall.add(an);
		VectorBall.add(bn);}
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
		
		Acb1.removeAllItems();
		Acb2.removeAllItems();
		Acb3.removeAllItems();
		Acb4.removeAllItems();
		Acb5.removeAllItems();
		
		Abutton1.setText("0次");
		Abutton2.setText("0次");
		Abutton3.setText("0次");
		Abutton4.setText("0次");
		Abutton5.setText("0次");
		
		AAll.setText("0");
		Ascore.setText("00");
		
		Bcb1.removeAllItems();
		Bcb2.removeAllItems();
		Bcb3.removeAllItems();
		Bcb4.removeAllItems();
		Bcb5.removeAllItems();
		
		Bbutton1.setText("0次");
		Bbutton2.setText("0次");
		Bbutton3.setText("0次");
		Bbutton4.setText("0次");
		Bbutton5.setText("0次");
		
		BAll.setText("0");
		Bscore.setText("00");
		
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
					for(int j =0;j<10;j++)
						{
							if(At[j].getText().length()!=0)
								{
									Acb1.addItem(At[j].getText());
									Acb2.addItem(At[j].getText());
									Acb3.addItem(At[j].getText());
									Acb4.addItem(At[j].getText());
									Acb5.addItem(At[j].getText());
								}
							if(Bt[j].getText().length()!=0)
								{
								Bcb1.addItem(Bt[j].getText());
								Bcb2.addItem(Bt[j].getText());
								Bcb3.addItem(Bt[j].getText());
								Bcb4.addItem(Bt[j].getText());
								Bcb5.addItem(Bt[j].getText());
								}
						}	
				}
			Data.setEnabled(false);
			Start.setEnabled(true);
			
		}
	
	if(e.getSource() == Change )
		{
			Acb1.setEnabled(true);
			Acb2.setEnabled(true);
			Acb3.setEnabled(true);
			Acb4.setEnabled(true);
			Acb5.setEnabled(true);
			
			Bcb1.setEnabled(true);
			Bcb2.setEnabled(true);
			Bcb3.setEnabled(true);
			Bcb4.setEnabled(true);
			Bcb5.setEnabled(true);
		}
	
	if(e.getSource() == Sure )
		{
			Acb1.setEnabled(false);
			Acb2.setEnabled(false);
			Acb3.setEnabled(false);
			Acb4.setEnabled(false);
			Acb5.setEnabled(false);
			
			Bcb1.setEnabled(false);
			Bcb2.setEnabled(false);
			Bcb3.setEnabled(false);
			Bcb4.setEnabled(false);
			Bcb5.setEnabled(false);
	}
	
	if(e.getSource() == AButton_1)
	{
		an+=1;
		if(an<10)
			Ascore.setText("0"+an);
		else
			Ascore.setText(""+an);
		VectorA.add(Ascore);
	}

if(e.getSource() == AButton_2)
	{
		an+=2;
		if(an<10)
			Ascore.setText("0"+an);
		else
			Ascore.setText(""+an);
		VectorA.add(Ascore);
	}

if(e.getSource() == AButton_3)
	{
		an+=3;
		if(an<10)
			Ascore.setText("0"+an);
		else
			Ascore.setText(""+an);
		VectorA.add(Ascore);
	}

if(e.getSource() == BButton_1)
	{
		bn+=1;
		if(bn<10)
			Bscore.setText("0"+bn);
		else
			Bscore.setText(""+bn);
		VectorB.add(Bscore);
		}

if(e.getSource() == BButton_2)
	{
		bn+=2;
		if(bn<10)
			Bscore.setText("0"+bn);
		else
			Bscore.setText(""+bn);
		VectorB.add(Bscore);
	}

if(e.getSource() == BButton_3)
	{
		bn+=3;
		if(bn<10)
			Bscore.setText("0"+bn);
		else
			Bscore.setText(""+bn);
		VectorB.add(Bscore);
	}	

if(e.getSource() == Abutton1)
	{	
		++a1;
		++aall;
		if(a1<5)
			Abutton1.setText(a1+"次");
		else
			{
				JOptionPane.showMessageDialog(null,
						"该选手已五犯离场，请更换队员","提示",JOptionPane.ERROR_MESSAGE);
				Abutton1.setText(0+"次");
				a1=0;
				
				Acb2.removeItem(Acb1.getSelectedItem());
				Acb3.removeItem(Acb1.getSelectedItem());
				Acb4.removeItem(Acb1.getSelectedItem());
				Acb5.removeItem(Acb1.getSelectedItem());
				Acb1.removeItem(Acb1.getSelectedItem());
			}
		AAll.setText(aall+"次");
	}

if(e.getSource() == Abutton2)
	{
		++a2;
		++aall;
		if(a2<5)
			Abutton2.setText(a2+"次");
		else
			{
				JOptionPane.showMessageDialog(null,
					"该选手已五犯离场，请更换队员","提示",JOptionPane.ERROR_MESSAGE);
				Abutton2.setText(0+"次");
				a2=0;
				
				Acb1.removeItem(Acb1.getSelectedItem());
				Acb3.removeItem(Acb1.getSelectedItem());
				Acb4.removeItem(Acb1.getSelectedItem());
				Acb5.removeItem(Acb1.getSelectedItem());
				Acb2.removeItem(Acb2.getSelectedItem());
			}	
		AAll.setText(aall+"次");
	}

if(e.getSource() == Abutton3)
	{
		++a3;
		++aall;
		if(a3<5)
			Abutton3.setText(a3+"次");
		else
			{
				JOptionPane.showMessageDialog(null,
						"该选手已五犯离场，请更换队员","提示",JOptionPane.ERROR_MESSAGE);
				Abutton3.setText(0+"次");
				a3=0;
			
				Acb1.removeItem(Acb1.getSelectedItem());
				Acb2.removeItem(Acb2.getSelectedItem());
				Acb4.removeItem(Acb1.getSelectedItem());
				Acb5.removeItem(Acb1.getSelectedItem());
				Acb3.removeItem(Acb3.getSelectedItem());
			}
		AAll.setText(aall+"次");
	}

if(e.getSource() == Abutton4)
	{
		++a4;
		++aall;
		if(a4<5)
			Abutton4.setText(a4+"次");
		else
			{
				JOptionPane.showMessageDialog(null,
						"该选手已五犯离场，请更换队员","提示",JOptionPane.ERROR_MESSAGE);
				Abutton4.setText(0+"次");
				a4=0;
				
				Acb1.removeItem(Acb1.getSelectedItem());
				Acb2.removeItem(Acb2.getSelectedItem());
				Acb3.removeItem(Acb3.getSelectedItem());
				Acb5.removeItem(Acb1.getSelectedItem());
				Acb4.removeItem(Acb4.getSelectedItem());
			}
		AAll.setText(aall+"次");
}

if(e.getSource() == Abutton5)
	{
		++a5;
		++aall;
		if(a5<5)
			Abutton5.setText(a5+"次");
		else
			{
				JOptionPane.showMessageDialog(null,
						"该选手已五犯离场，请更换队员","提示",JOptionPane.ERROR_MESSAGE);
				Abutton5.setText(0+"次");
				a5=0;
			
				Acb1.removeItem(Acb1.getSelectedItem());
				Acb2.removeItem(Acb1.getSelectedItem());
				Acb3.removeItem(Acb1.getSelectedItem());
				Acb4.removeItem(Acb1.getSelectedItem());
				Acb5.removeItem(Acb5.getSelectedItem());
			}
		AAll.setText(aall+"次");
	}

	if(e.getSource() == Bbutton1)
		{
			++b1;
			++ball;
			if(b1<5)
				Bbutton1.setText(b1+"次");
			else
				{
					JOptionPane.showMessageDialog(null,
							"该选手已五犯离场，请更换队员","提示",JOptionPane.ERROR_MESSAGE);
					Bbutton1.setText(0+"次");
					b1=0;
					
					Bcb2.removeItem(Bcb1.getSelectedItem());
					Bcb3.removeItem(Bcb1.getSelectedItem());
					Bcb4.removeItem(Bcb1.getSelectedItem());
					Bcb5.removeItem(Bcb1.getSelectedItem());
					Bcb1.removeItem(Bcb1.getSelectedItem());
				}
			BAll.setText(ball+"次");
		}
	
	if(e.getSource() == Bbutton2)
		{
			++b2;
			++ball;
			if(b2<5)
				Bbutton2.setText(b2+"次");
			else
				{
					JOptionPane.showMessageDialog(null,
							"该选手已五犯离场，请更换队员","提示",JOptionPane.ERROR_MESSAGE);
					Bbutton2.setText(0+"次");
					b2=0;
					
					Bcb1.removeItem(Bcb2.getSelectedItem());
					Bcb3.removeItem(Bcb2.getSelectedItem());
					Bcb4.removeItem(Bcb2.getSelectedItem());
					Bcb5.removeItem(Bcb2.getSelectedItem());
					Bcb2.removeItem(Bcb2.getSelectedItem());
				}
			BAll.setText(ball+"次");
		}
if(e.getSource() == Bbutton3)
	{
		++b3;
		++ball;
		if(b3<5)
			Bbutton3.setText(b3+"次");
		else
		{
			JOptionPane.showMessageDialog(null,
				"该选手已五犯离场，请更换队员","提示",JOptionPane.ERROR_MESSAGE);
			Bbutton3.setText(0+"次");
			b3=0;
			
			Bcb1.removeItem(Bcb3.getSelectedItem());
			Bcb2.removeItem(Bcb3.getSelectedItem());
			Bcb4.removeItem(Bcb3.getSelectedItem());
			Bcb5.removeItem(Bcb3.getSelectedItem());
			Bcb3.removeItem(Bcb3.getSelectedItem());
		}
		BAll.setText(ball+"次");
	}
if(e.getSource() == Bbutton4)
	{
		++b4;
		++ball;
		if(b4<5)
			Bbutton4.setText(b4+"次");
		else
			{
				JOptionPane.showMessageDialog(null,
						"该选手已五犯离场，请更换队员","提示",JOptionPane.ERROR_MESSAGE);
				Bbutton4.setText(0+"次");
				b4=0;
				
				Bcb1.removeItem(Bcb4.getSelectedItem());
				Bcb2.removeItem(Bcb4.getSelectedItem());
				Bcb3.removeItem(Bcb4.getSelectedItem());
				Bcb5.removeItem(Bcb4.getSelectedItem());
				Bcb4.removeItem(Bcb4.getSelectedItem());
			}
		BAll.setText(ball+"次");
	}

	if(e.getSource() == Bbutton5)
		{
			++b5;
			++ball;
			if(b5<5)
				Bbutton5.setText(b5+"次");
			else
				{
					JOptionPane.showMessageDialog(null,
							"该选手已五犯离场，请更换队员","提示",JOptionPane.ERROR_MESSAGE);			
					Bbutton5.setText(0+"次");
					b5=0;
					
					Bcb1.removeItem(Bcb5.getSelectedItem());
					Bcb2.removeItem(Bcb5.getSelectedItem());
					Bcb3.removeItem(Bcb5.getSelectedItem());
					Bcb4.removeItem(Bcb5.getSelectedItem());
					Bcb5.removeItem(Bcb5.getSelectedItem());
				}
			BAll.setText(ball+"次");
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
