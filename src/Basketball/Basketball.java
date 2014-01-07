package Score;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
	Vector VectorA= new Vector();
	Vector VectorB = new Vector();
	Vector VectorAall,VectorBall;
	DefaultTableModel Mytable;
	JTable table;
	int an,bn,aall,ball;
	int [] a = new int[5];
	int [] b = new int[5];
	int j = 0;
	
	public Basketball()
	{
    screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    VectorA.add("A��");
    VectorB.add("B��");
    /**
     * ��ǩ�����������ã�
     * ��������A�ӣ�B�ӱ�ǩ
     */
    
	Labelpanel = new JPanel();
	
	/*A�ӱ�ǩ��������*/
	Return = new JButton("Return");
	
	Return.setPreferredSize(new Dimension(150,80));
	Return.setFont(new Font("��������",Font.BOLD,32));
	Return.addActionListener(this);
	
	Labelpanel.add(Return);
	
	Help = new JButton("Help");
	
	Help.setPreferredSize(new Dimension(150,80));
	Help.setFont(new Font("��������",Font.BOLD,32));
	Help.addActionListener(this);
	
	Labelpanel.add(Help);
	
	ALabel = new JLabel(new ImageIcon("Source\\10.png"));
	JTextField Aname = new JTextField(3);
	Aname.setText("A��");
	Aname.setFont(new Font("����",Font.BOLD,36));
	Aname.setEditable(false);
	Labelpanel.add(ALabel);
	Labelpanel.add(Aname);
	
	/*����ʱ����ʾ�����ӱ�ǩ���м�*/
	time = new CountTime();
	time.setOpaque(false);
	Labelpanel.add(time);
	
	/*B�ӱ�ǩ��������*/
	BLabel = new JLabel(new ImageIcon("Source\\11.png"));
	JTextField Bname = new JTextField(3);
	Bname.setText("B��");
	Bname.setFont(new Font("����",Font.BOLD,36));
	Bname.setEditable(false);
	Labelpanel.add(Bname);
	Labelpanel.add(BLabel);	
	
	Labelpanel.setLayout(new FlowLayout());
	Labelpanel.setOpaque(false);
	
	/**
	 * �����������ã�
	 * ����A��B�Ӹ�����Ա
	 * ������ķ������
	 */
	
	Foulpanel = new JPanel();
	Foulpanel.setPreferredSize(new Dimension(screenSize.width/5,screenSize.height/2));
	Foulpanel.setOpaque(false);
	
	/*����A����Ա�����巸�������
	 * ����������Ա��İ�ť�ۼƸ�����Ա�ķ������*/
	
	Apanel = new JPanel();
	
	JTextField ANum = new JTextField("A����Ա");
	ANum.setFont(new Font("����",Font.BOLD,24));
	ANum.setEditable(false);
	
	JTextField AFoul = new JTextField("�������");
	AFoul.setFont(new Font("����",Font.BOLD,24));
	AFoul.setEditable(false);
	
	Apanel.add(ANum);
	Apanel.add(AFoul);
	
	Abutton = new JButton[5];
	Acb = new JComboBox[5];
	
	for(int i=0;i<5;i++)
	{
		Acb[i] = new JComboBox();
		Abutton[i] = new JButton();
		Abutton[i].setText("0��");
		Abutton[i].addActionListener(this);
		Abutton[i].setEnabled(false);
		Apanel.add(Acb[i]);
		Apanel.add(Abutton[i]);
	}
	
	JTextField AFoulAll = new JTextField("��������");
	AFoulAll.setFont(new Font("����",Font.BOLD,24));
	AFoulAll.setEditable(false);
	
	AAll = new JLabel(aall+"��");
	AAll.setFont(new Font("����",Font.BOLD,24));
	AAll.setHorizontalAlignment(0);
	
	Apanel.add(AFoulAll);
	Apanel.add(AAll);

	Apanel.setLayout(new GridLayout(7,2));
	Foulpanel.add(Apanel);
	
	/*
	 * ����B����Ա�����巸�������
	 * ����������Ա��İ�ť�ۼƸ�����Ա�ķ������
	 */
	
	Bpanel = new JPanel();
	
	JTextField BNum = new JTextField("B����Ա");
	BNum.setFont(new Font("����",Font.BOLD,24));
	BNum.setEditable(false);
	
	JTextField BFoul = new JTextField("�������");
	BFoul.setFont(new Font("����",Font.BOLD,24));
	BFoul.setEditable(false);
	
	Bpanel.add(BNum);
	Bpanel.add(BFoul);
	
	Bbutton = new JButton[5];
	Bcb = new JComboBox[5];
	
	for(int i = 0;i<5;i++)
		{
			Bcb[i] = new JComboBox();
			
			Bbutton[i] = new JButton();
			Bbutton[i].setText("0��");
			Bbutton[i].addActionListener(this);
			Bbutton[i].setEnabled(false);
			Bpanel.add(Bcb[i]);
			Bpanel.add(Bbutton[i]);
		}
	
	JTextField BFoulAll = new JTextField("��������");
	BFoulAll.setFont(new Font("����",Font.BOLD,24));
	BFoulAll.setEditable(false);
	
	BAll = new JLabel(ball+"��");
	BAll.setFont(new Font("����",Font.BOLD,24));
	BAll.setHorizontalAlignment(0);
	
	Bpanel.add(BFoulAll);
	Bpanel.add(BAll);
	
	Bpanel.setLayout(new GridLayout(7,2));
	Foulpanel.add(Bpanel);
		
	Foulpanel.setSize(120,450);
	
	/*
	 * A�ӼǷ��ƴ�������
	 * ���Ӹ����ӷְ�ť
	 * ������ʾ����
	  */
	Scorepanel = new JPanel();
	
	Ascorepanel =  new JPanel();
	Ascore = new JLabel("00");
	Ascore.setFont(new Font("����",Font.BOLD,200));
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
	 *A�Ӻ�B�ӷ����м���ʾVS 
	 */
	JLabel VS = new JLabel("VS");
	VS.setFont(new Font("����",Font.BOLD,48));
	
	Scorepanel.add(VS);
	
	/*
	 * B�ӼǷ��Ƶ�����
	 * ͬ������3����ť
	 * �����÷�������ʾ
	 */
	Bscorepanel = new JPanel();
	Bscore = new JLabel("00");
	Bscore.setFont(new Font("����",Font.BOLD,200));
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
	 * �������÷���������Ӹ�����ť
	 * ��ʼ����ͣ����д��Ա��Ϣ�����ˣ�ȷ��
	 * �����ʼ�ȵ��Data��ť
	 * �������������Ա��Ϣ
	 *Ȼ��ſ��Ե��������ʼ
	 */
	
	Start = new JButton("Start");
    Pause = new JButton("Pause");
    Continue = new JButton("Continue");
    Data = new JButton("Data");
    Change = new JButton("Change");
    Sure = new JButton("Sure");
    See = new JButton("See");
    Reset = new JButton("Reset");
    
    StatuesPanel = new JPanel();
    
    StatuesPanel.add(Start);
    StatuesPanel.add(Pause);
    StatuesPanel.add(Continue);
    StatuesPanel.add(Data);
    StatuesPanel.add(Change);
    StatuesPanel.add(Sure);
    StatuesPanel.add(See);
    StatuesPanel.add(Reset);
  
    Start.addActionListener(this);
    Pause.addActionListener(this);
    Continue.addActionListener(this);
	Data.addActionListener(this);
	Change.addActionListener(this);
	Sure.addActionListener(this);
	See.addActionListener(this);
	Reset.addActionListener(this);
	
	//Start.setEnabled(false); 
	See.setEnabled(false);
	Pause.setEnabled(false);
	Continue.setEnabled(false);
	
	StatuesPanel.setOpaque(false);
	Scorepanel.add(StatuesPanel);
	Scorepanel.setOpaque(false);
	
	/*
	 * �ڿɲ�ִ�����
	 * ������Ӷ�Ա����
	 * �ұ����ӼǷ���
	 */
	
	JSplitPane AaBpanel = new JSplitPane(
    		JSplitPane.HORIZONTAL_SPLIT,true,Foulpanel,Scorepanel);
	AaBpanel.setOpaque(false);
	
	/*
	 * ���ô��屳��Ϊ����ɫ
	 * ���������С������
	 * �رմ���ʱ�¼�
	 */
	
    Container cp=getContentPane(); 
    setLayout(new BorderLayout());	
    cp.add(Labelpanel,BorderLayout.NORTH);
    cp.add(AaBpanel,BorderLayout.CENTER);
    
    ImageIcon background = new ImageIcon("Source//whitebackground.png");
    JLabel imgLabel = new JLabel(background);
    getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ���ӵ�jfram��LayeredPane����  
    imgLabel.setBounds(0,0,background.getIconWidth(), background.getIconHeight());
    ((JPanel)cp).setOpaque(false); //ע����������������Ϊ͸��
  
    setBounds(130, 20,1050 ,695 );
    setIconImage(Toolkit.getDefaultToolkit().getImage(
    		"Source//ilovethisgame_002.png"));
    setTitle("����Ʒ���");
    
   setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
   addWindowListener(new WindowAdapter()
   {
        public void windowClosing(WindowEvent e) 
        {
            int exit=JOptionPane.showConfirmDialog(Basketball.this,
            		"ȷ���˳���", "�˳�", JOptionPane.OK_CANCEL_OPTION);
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
		See.setEnabled(true);
		
		time.Start();
		
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
	
	if(e.getSource() == See )
			{	See();	}
	
	if(e.getSource() == Reset)
	{
		time.Reset();
		
		for(int i = 0;i<5;i++)
		{
			Abutton[i].setText("0��");
			Acb[i].removeAllItems();
			
			Bbutton[i].setText("0��");
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
		
		VectorA.clear();VectorA.add("A��");
		VectorB.clear();VectorB.add("B��");
		
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
					"��������д���ӵ�ǰ��λ��Ա","��ʾ",JOptionPane.WARNING_MESSAGE);
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
			}
		if(e.getSource() == BButton_[i])
		{
			bn+=(i+1);
			if(bn<10)
				Bscore.setText("0"+bn);
			else
				Bscore.setText(""+bn);
		}
	
	}
		VectorA.add(an);
		VectorB.add(bn);
	for(int i = 0;i<5;i++)
	{
		if(e.getSource() == Abutton[i])
			{
				++a[i];
				++aall;
				if(a[i]<5)
					Abutton[i].setText(a[i]+"��");
				else
					{
						JOptionPane.showMessageDialog(null,
							"��ѡ�����巸�볡���������Ա","��ʾ",JOptionPane.ERROR_MESSAGE);
						Abutton[i].setText(0+"��");
						a[i]=0;
						for(int j = 0;j<5;j++)
							if(j!=i)
								Acb[j].removeItem(Acb[i].getSelectedItem());
						Acb[i].removeItem(Acb[i].getSelectedItem());
					}
				AAll.setText(aall+"��");
			}
		if(e.getSource() == Bbutton[i])
		{
			++b[i];
			++ball;
			if(b[i]<5)
				Bbutton[i].setText(b[i]+"��");
			else
				{
					JOptionPane.showMessageDialog(null,
							"��ѡ�����巸�볡���������Ա","��ʾ",JOptionPane.ERROR_MESSAGE);
					Bbutton[i].setText(0+"��");
					b[i]=0;
					for(int j = 0;j<5;j++)
						if(j!=i)
							Bcb[j].removeItem(Bcb[i].getSelectedItem());
					Bcb[i].removeItem(Bcb[i].getSelectedItem());
				}
			BAll.setText(ball+"��");
			}
		}
	}

private void Data() 
	{
		JDialog d = new JDialog(this,"��д���Ӷ�Ա����",true);
		
		JTextField a = new JTextField("A����Ա(��������)");
		JTextField b = new JTextField("B����Ա(��������)");
		
		a.setEditable(false);
		b.setEditable(false);
		
		a.setFont(new Font("����",Font.BOLD,24));
		b.setFont(new Font("����",Font.BOLD,24));
		
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
		
				At[i].setFont(new Font("����",Font.PLAIN,20));
				Bt[i].setFont(new Font("����",Font.PLAIN,20));
			}
	
		aandb.setLayout(new GridLayout(11,2));
		
		savedata = new JButton("�밴�պ���_������д��Ա��Ϣ�ٱ���");
	
		savedata.setFont(new Font("����",Font.PLAIN,20));
		savedata.addActionListener(this);
		d.add("South",savedata);
	
		d.setSize(new Dimension(480,550));
		d.setLocation(screenSize.width/3, screenSize.height/8);
		d.setVisible(true);
	}

	private void See() 
	{
		Vector columnnames = new Vector();
		columnnames.add("�غ���");
		for(int i = 0;i<VectorA.size();i++)
			columnnames.add(i);
		Mytable = new DefaultTableModel(columnnames,0);
		++j;
		VectorA.add("�鿴"+j+"��");
		VectorB.add("�鿴"+j+"��");
		Mytable.addRow(VectorA);
		Mytable.addRow(VectorB);
		table = new JTable(Mytable);
		table.add(new DefaultTableCellRenderer());
		table.setColumnSelectionAllowed(false);//������ѡ�������
 		table.setRowSelectionAllowed(true);	//����ѡ�������
	    JScrollPane panel = new JScrollPane(table);
		JFrame Frame = new JFrame();
		Frame.add(panel);
		Frame.pack();
		Frame.setVisible(true);
		table.setPreferredScrollableViewportSize(new Dimension(300,200));
	}

}