package Badminton;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class BadmintonScoring extends JFrame implements ActionListener, MouseListener 
{
	/**********变量定义**************/	
	//窗体
	JFrame BadFrame = new JFrame("羽毛球计分器");	//主窗体
	JPanel LeftPane = new JPanel(); //左面板
	JPanel RightPane = new JPanel(); //右面板
	JSplitPane SplitPane;//分割面板，装左右面板
	JPanel panel = new ImagePanel ();//动图
	
	//左面板按钮
	JButton Return = new JButton(new ImageIcon("image/返回.png"));
	JButton Addplayer = new JButton(new ImageIcon("image/添加选手.png")); 
	JButton Start = new JButton(new ImageIcon("image/开始.png"));
	JButton CheckAll = new JButton(new ImageIcon("image/查看.png"));
	JButton Save = new JButton(new ImageIcon("image/保存.png"));
	//右面板按钮
	JButton LeftWin = new JButton(new ImageIcon("image/得分.jpg") );
	JButton RightWin = new JButton(new ImageIcon("image/得分.jpg"));
	JButton LeftReset = new JButton(new ImageIcon("image/撤销.jpg"));
	JButton RightReset = new JButton(new ImageIcon("image/撤销.jpg"));
	JButton New = new JButton(new ImageIcon("image/新局.jpg"));
	JButton Help = new JButton(new ImageIcon("image/帮助.jpg"));
	
	//标签
	JLabel Player1 = new JLabel(new ImageIcon("image/选手1.png"));
	JLabel Player2 = new JLabel(new ImageIcon("image/选手2.png"));
	JLabel PK = new JLabel(new ImageIcon("image/pk.png"));
	JLabel ScoreLeft = new JLabel();
	JLabel ScoreRight = new JLabel();
	JLabel VS = new JLabel(":");
	
	//比分
	int Lbifen = 0;//左比分
	int Rbifen = 0;//右比分
	int Jushu = 1;//局数
	int Lwin = 0;//左方获胜次数
	int Rwin = 0;//右方获胜次数
	boolean Status = false ;//用于监控局分窗体是否被打开，避免重复被打开，false表示未被打开。
	
	//文本框
	JTextField[] ShowName = {new JTextField(10),new JTextField(10),
			new JTextField(10),new JTextField(10)};
	JTextField[] AddName = {new JTextField(10),new JTextField(10),
			new JTextField(10),new JTextField(10),};
	
	//比分数组	
	int[] Zongfen = {0,0,0,0,0,0};
	Vector<Integer> Jufen1_1 = new Vector<Integer>();
	Vector<Integer> Jufen1_2 = new Vector<Integer>();
	Vector<Integer> Jufen2_1 = new Vector<Integer>();
	Vector<Integer> Jufen2_2 = new Vector<Integer>();
	Vector<Integer> Jufen3_1 = new Vector<Integer>();
	Vector<Integer> Jufen3_2 = new Vector<Integer>();
	
	//总分表格
	String[] Colnames = {"赛局","选手1","选手2"," "};
	DefaultTableModel Model = new DefaultTableModel(Colnames,3)
	{
        private static final long serialVersionUID = 1L;
        
        public boolean isCellEditable(int row, int column)
        {
                return false;
        };		
	};
	DefaultTableCellRenderer TableRenderer = new DefaultTableCellRenderer();
	JTable Table = new JTable(Model);
	
	//局分表格	
	String[] Colnames0 = {"参赛人员","0"};
    DefaultTableModel Model0 = new DefaultTableModel(Colnames0,2)
	  {
  	        private static final long serialVersionUID = 1L;	        
	        public boolean isCellEditable(int row, int column)
	        {
	               return false;
	        };		
	  };
	  DefaultTableModel Model1 = new DefaultTableModel(Colnames0,2)
	  {
	  	     private static final long serialVersionUID = 1L;		        
		     public boolean isCellEditable(int row, int column)
		     {
		            return false;
		     };		
	  };
	  DefaultTableModel Model2 = new DefaultTableModel(Colnames0,2)
	  {
	  	     private static final long serialVersionUID = 1L;		        
		     public boolean isCellEditable(int row, int column)
		     {
		            return false;
		     };		
	  };
	  JTable Table0 = new JTable(Model0);//第一局表格
	  JTable Table1 = new JTable(Model1);//第二局表格
	  JTable Table2 = new JTable(Model2);//第三局表格
	
	public BadmintonScoring()
	{		
		/***********按钮设置**********/
		//左面板按钮
		Return.setBounds(30, 10, 101, 94);//设置位置	
		Return.setBorderPainted(false);//设置边框
		Return.setBackground(Color.white);//设置背景
		Addplayer.setBounds(30, 140, 97, 102);
		Addplayer.setBorderPainted(false);
		Addplayer.setBackground(Color.white);
		Start.setBounds(30, 270, 92, 93);
		Start.setBorderPainted(false);
		Start.setBackground(Color.white);
		CheckAll.setBounds(30, 400, 101, 95);
		CheckAll.setBorderPainted(false);
		CheckAll.setBackground(Color.white);
		Save.setBounds(30, 535, 100, 95);
		Save.setBorderPainted(false);
		Save.setBackground(Color.white);
				
		//右面板按钮、标签、文本框设置
		//标签
		Player1.setBounds(0, 10, 101, 94);
		Player2.setBounds(420, 10, 101, 94);
		PK.setBounds(200, 10, 100, 100);
		
		//文本框
		ShowName[0].setBounds(110, 20, 100, 20);
		ShowName[1].setBounds(110, 60, 100, 20);
		ShowName[2].setBounds(310, 20, 100, 20);
		ShowName[3].setBounds(310, 60, 100, 20);
		
		//按钮
		LeftWin.setBounds(80, 500, 110, 60);
		RightWin.setBounds(350, 500, 110, 60);
		LeftReset.setBounds(80, 590, 110, 60);
		RightReset.setBounds(350, 590, 110, 60);
		New.setBounds(215, 550, 110, 60);
		Help.setBounds(450, 120, 50, 30);
		Help.setToolTipText("点击获取帮助");
		
		//比分设置
		panel.setBounds(70, 330, 400, 150);	//设置动图位置
		ScoreLeft.setBounds(30, 170, 200, 150);
		ScoreRight.setBounds(300, 170, 200, 150);
		VS.setBounds(210, 170, 100, 100);
		Font f = new Font("a",1,150);
		ScoreLeft.setText("0");
		ScoreLeft.setFont(f);
		ScoreLeft.setHorizontalAlignment(JLabel.CENTER);
		ScoreRight.setText("0");
		ScoreRight.setFont(f);
		ScoreRight.setHorizontalAlignment(JLabel.CENTER);
		VS.setFont(new Font("a",1,80));
		VS.setHorizontalAlignment(JLabel.CENTER);
		Jufen1_1.add(0);Jufen1_2.add(0);
		Jufen2_1.add(0);Jufen2_2.add(0);
		Jufen3_1.add(0);Jufen3_2.add(0);
			
		/**********面板设置**********/		
		//左面板
		LeftPane.setLayout(null);		
		LeftPane.add(Return);		
		LeftPane.add(Addplayer);
		LeftPane.add(Start);
		LeftPane.add(CheckAll);
		LeftPane.add(Save);
		LeftPane.setOpaque(false);//设置为透明
		
		//右面板
		RightPane.setLayout(null);
		RightPane.add(Player1);
		RightPane.add(PK);
		RightPane.add(Player2);
		RightPane.add(LeftWin);
		RightPane.add(RightWin);
		RightPane.add(VS);
		RightPane.add(LeftReset);
		RightPane.add(RightReset);
		RightPane.add(New);
		RightPane.add(Help);
		RightPane.add(panel);
		RightPane.setOpaque(false);		
		RightPane.add(ScoreRight);		
		RightPane.add(ScoreLeft);
		for(int i=0 ;i<4;i++)
		{
			RightPane.add(ShowName[i]);
		}
		
		//分割面板
		SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, LeftPane, RightPane);
		SplitPane.setDividerLocation(200);
		SplitPane.setDividerSize(4);
		SplitPane.setEnabled(false);
		SplitPane.setOpaque(false);
				
		/**********比分表格初始化***********/
		//局分表格1设置
		Font font = new Font(" ",3,15);
		TableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        Table0.setDefaultRenderer(Object.class, TableRenderer);
        Table0.setFont(font);  	        
        Table0.setSelectionBackground(Color.pink);   
        Table0.setSelectionForeground(Color.black);   
        Table0.setRowHeight(40);  
        Table0.setCellSelectionEnabled(true);        
      	        
        //设置初始值
        Model0.setValueAt("选手组1", 0, 0);
        Model0.setValueAt("选手组2", 1, 0);	
		Model0.setValueAt(Jufen1_1.get(0), 0, 1);
        Model0.setValueAt(Jufen1_2.get(0), 1, 1);
        
        //局分表格2设置
	    TableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        Table1.setDefaultRenderer(Object.class, TableRenderer);
        Table1.setFont(font);  	        
        Table1.setSelectionBackground(Color.pink);   
        Table1.setSelectionForeground(Color.black);   
        Table1.setRowHeight(40);  
        Table1.setCellSelectionEnabled(true);       
      	        
        //设置初始值
        Model1.setValueAt("选手组1", 0, 0);
        Model1.setValueAt("选手组2", 1, 0);	
		Model1.setValueAt(Jufen2_1.get(0), 0, 1);
        Model1.setValueAt(Jufen2_2.get(0), 1, 1); 
  	  
        //局分表格3设置
        TableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        Table2.setDefaultRenderer(Object.class, TableRenderer);
        Table2.setFont(font);  	        
        Table2.setSelectionBackground(Color.pink);   
        Table2.setSelectionForeground(Color.black);   
        Table2.setRowHeight(40);  
        Table2.setCellSelectionEnabled(true);
          	        
        //设置初始值
        Model2.setValueAt("选手组1", 0, 0);
        Model2.setValueAt("选手组2", 1, 0);	
        Model2.setValueAt(Jufen3_1.get(0), 0, 1);
        Model2.setValueAt(Jufen3_2.get(0), 1, 1);
        
		/*********窗体设置*********/
		BadFrame.setSize(750, 700);
		BadFrame.setLayout(new BorderLayout());
		BadFrame.add(SplitPane, BorderLayout.CENTER);
		BadFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		BadFrame.setLocationRelativeTo(null);
		BadFrame.setVisible(true);
		BadFrame.setResizable(false);
		
		//设置背景
		ImageIcon img = new ImageIcon("image/白色背景.jpg");
        JLabel imgLabel = new JLabel(img); 
        BadFrame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());  
        Container cp=BadFrame.getContentPane();  
        cp.setLayout(new BorderLayout());            
        ((JPanel)cp).setOpaque(false);   

		validate();
		
		/*********动作事件监听**********/
		Return.addActionListener(this);
		Addplayer.addActionListener(this);
		Start.addActionListener(this);
		CheckAll.addActionListener(this);
		Save.addActionListener(this);
		LeftWin.addActionListener(this);		
		RightWin.addActionListener(this);
		LeftReset.addActionListener(this);
		RightReset.addActionListener(this);
		New.addActionListener(this);
		Help.addActionListener(this);
		
		//设置可见
		LeftWin.setEnabled(false);
		RightWin.setEnabled(false);
		LeftReset.setEnabled(false);
		RightReset.setEnabled(false);
		New.setEnabled(false);
		Start.setEnabled(false);
	}
	

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == Return) 
		{
			BadFrame.dispose();
		}	
		if(e.getSource() == Addplayer) 
		{		
			final JFrame Addframe = new JFrame("添加运动员");
			Addframe.setBounds(500,300,400,350);
			Addframe.setResizable(false);
			Addframe.setLayout(null);
			
			//标签			
			JLabel[] Player = {new JLabel("选手1-1"),new JLabel("选手1-2"),
					new JLabel("选手2-1"),new JLabel("选手2-2")};
		
		    for(int i=0 ;i<4;i++)
		    {
		    	Player[i].setFont(new Font("选手2",30,25));
		    }
			Player[0].setBounds(50, 70, 150, 30);	
			Player[1].setBounds(50, 120, 150, 30);	;
			Player[2].setBounds(50, 170, 150, 30);
			Player[3].setBounds(50, 220, 150, 30);
			
			JLabel Instruction = new JLabel("请输入选手名字！");
			Instruction.setBounds(70, 10, 400, 50);
			Instruction.setFont(new Font("选手2",1,30));
			Instruction.setForeground(Color.red);
			
			//文本框			
			AddName[0].setBounds(200, 70, 120, 30);
			AddName[1].setBounds(200, 120, 120, 30);
			AddName[2].setBounds(200, 170, 120, 30);
			AddName[3].setBounds(200, 220, 120, 30);
			
			//按钮
			JButton Yes = new JButton("确定");
			Yes.setBounds(170, 270, 80, 40);
			JButton Cancel = new JButton("取消");
			Cancel.setBounds(270, 270, 80, 40);
			
			//副窗体
			Addframe.add(Instruction);
			Addframe.add(Cancel);
			Addframe.add(Yes);	
			Addframe.setVisible(true);			
			for(int i=0 ;i<4;i++)
			{
				Addframe.add(Player[i]);
				Addframe.add(AddName[i]);
				AddName[i].setFont(new Font("",3,20));
			}
			Addframe.addWindowListener(new WindowAdapter() 
			{
				public void windowClosing(WindowEvent e) 
				{
					Addframe.dispose();
					Addplayer.setEnabled(true);
				}
			});
			Addplayer.setEnabled(false);
			
			//监听事件
			Yes.addActionListener(new ActionListener()
					{  
						public void actionPerformed(ActionEvent e)
						{  
		                    Addframe.dispose();		                    
		                    Start.setEnabled(true);
		                    Addplayer.setEnabled(true);
                        }  
                    });
			Cancel.addActionListener(new ActionListener()
					{  
						public void actionPerformed(ActionEvent e)
						{  
		                    Addframe.dispose();
		                    Addplayer.setEnabled(true);
                        }  
                    });
		}
		if(e.getSource()==CheckAll)
		{						
			final JFrame Tableframe = new JFrame("总比分 ");
			Tableframe.setBounds(500,300,400,210);
	        Tableframe.setResizable(false);
	        Tableframe.setLayout(new BorderLayout());
		
	        Font font = new Font(" ",3,20);
							          
	        for(int i=0 ; i<3 ; i++)
	        {
	        	Table.setValueAt(i+1, i, 0);
	        	Table.setValueAt("详细", i, 3);
	        }
	        
	        //添加比分
	        Table.setValueAt(Zongfen[0], 0, 1);
	        Table.setValueAt(Zongfen[1], 0, 2);
	        Table.setValueAt(Zongfen[2], 1, 1);
	        Table.setValueAt(Zongfen[3], 1, 2);
	        Table.setValueAt(Zongfen[4], 2, 1);
	        Table.setValueAt(Zongfen[5], 2, 2);
	        	        
            // 设置table内容居中      
	        TableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	        Table.setDefaultRenderer(Object.class, TableRenderer);
	        Table.setFont(font);
	        TableColumnModel columnModel = Table.getColumnModel();   	        
	         
	        //添加滚动条     
	        JScrollPane ScrollPane = new JScrollPane(Table);
	        Tableframe.add(ScrollPane);
	        
	        Table.setSelectionBackground(Color.pink);   
	        Table.setSelectionForeground(Color.black);   
	        Table.setRowHeight(50);  
	        Table.setCellSelectionEnabled(true);
	        
	        Tableframe.setVisible(true);
			Tableframe.validate();
			Tableframe.addWindowListener(new WindowAdapter() 
			{
				public void windowClosing(WindowEvent e) 
				{
					Tableframe.dispose();	
					CheckAll.setEnabled(true);
				}
			});
			CheckAll.setEnabled(false);
			
			//单元格监听事件
			OpenListener();	
		}
		if(e.getSource()==LeftWin)
		{
			Lbifen++;			
			AddJufen();
			
			ScoreLeft.setText(""+Lbifen);
			int fencha = Lbifen - Rbifen;
			if(fencha<0)
			{
				fencha = 0 - fencha;
			}
			if((fencha>=2 && (Lbifen>20||Rbifen>20))||(Lbifen >= 29||Rbifen >= 29))
			{
				Lwin++;
				LeftWin.setEnabled(false);
				RightWin.setEnabled(false);
	
				if(Jushu < 3)
				{
					if((Rwin ==2 && Lwin == 0)||(Rwin == 0 && Lwin ==2))
					{
						New.setEnabled(false);
						Start.setEnabled(true);
					}
					else New.setEnabled(true);
				}
				AddZongfen();
			}
			if(Lbifen !=0 )
			{
				LeftReset.setEnabled(true);
			}
			
		}
		if(e.getSource() == RightWin)
		{
			Rbifen++;
			AddJufen();
			
			ScoreRight.setText(""+Rbifen);
			int fencha = Rbifen - Lbifen;
			if(fencha<0)
			{
				fencha = 0 - fencha;
			}
			if((fencha>=2 && (Lbifen>20||Rbifen>20))||(Lbifen >= 29 || Rbifen >= 29))
			{
				Rwin++;
				LeftWin.setEnabled(false);
				RightWin.setEnabled(false);
				
				if(Jushu < 3)
				{
					if((Rwin ==2 && Lwin == 0)||(Rwin == 0 && Lwin ==2))
					{
						New.setEnabled(false);
						Start.setEnabled(true);
					}
					else New.setEnabled(true);				
				}
				AddZongfen();					
			}
			if(Rbifen !=0 )
			{
				RightReset.setEnabled(true);
			}			
		}
		if(e.getSource() == LeftReset)
		{
			Lbifen--;
			RemoveJufen();
			ScoreLeft.setText(""+Lbifen);
			if(Lbifen ==0 )
			{
				LeftReset.setEnabled(false);
			}
			if(Lbifen < 21 )
			{
				New.setEnabled(false);
				LeftWin.setEnabled(true);
				RightWin.setEnabled(true);
			}
		}
		if(e.getSource() == RightReset)
		{
			Rbifen--;
			RemoveJufen();
			ScoreRight.setText(""+Rbifen);
			if(Rbifen ==0 )
			{
				RightReset.setEnabled(false);
			}
			if(Rbifen < 21 )
			{
				New.setEnabled(false);
				RightWin.setEnabled(true);
				LeftWin.setEnabled(true);
			}
		}
		if(e.getSource() == New)
		{
			Lbifen = 0;
			Rbifen = 0;
			Jushu ++;
			
			ScoreLeft.setText(""+Lbifen);
			ScoreRight.setText(""+Rbifen);
		
			LeftWin.setEnabled(true);
			RightWin.setEnabled(true);			
			New.setEnabled(false);				
		}
		if(e.getSource() == Start)
		{
			LeftWin.setEnabled(true);
			RightWin.setEnabled(true);
			
			ScoreRight.setText("0");
			ScoreLeft.setText("0");
			
			for(int i=0 ; i<6 ;i++)
			{
				Zongfen[i] = 0;
			}
			
			Lwin = 0;
			Rwin = 0;
			Jushu = 1;
			Lbifen = 0;
			Rbifen = 0;
			Jufen1_1.removeAllElements();Jufen1_1.add(0);			
			Jufen1_2.removeAllElements();Jufen1_2.add(0);			
			Jufen2_1.removeAllElements();Jufen2_1.add(0);			
			Jufen2_2.removeAllElements();Jufen2_2.add(0);			
			Jufen3_1.removeAllElements();Jufen3_1.add(0);			
			Jufen3_2.removeAllElements();Jufen3_2.add(0);
		
			Model0.setColumnCount(2);
			Model1.setColumnCount(2);
			Model2.setColumnCount(2);
				
			Font f = new Font("",3,20);
			for(int i=0;i<4;i++)
			{
				ShowName[i].setText(AddName[i].getText());
				ShowName[i].setFont(f);
			}
			Start.setEnabled(false);
		}
		if(e.getSource() == Save)
		{
			try
			{
				if(!(new File("Scoring/").isDirectory())) 
					new File("Scoring/").mkdir(); //mkdir只创建一个文件夹
			}
			catch(SecurityException e2)
			{
			      e2.printStackTrace();
			}
			
			JFileChooser file = new JFileChooser("Scoring/");
			file.setAcceptAllFileFilterUsed(false);//去掉显示所有文件这个过滤器
			file.addChoosableFileFilter(new FileNameExtensionFilter("Excel表格(.xls)", "xls"));
			int n = file.showSaveDialog(null);
			String FileName = file.getSelectedFile().getName();   
		     
		     if(FileName != null)
				{
					int na = 0;
					String p= FileName;
					while(new File("Scoring/"+p+".xls").exists())//.exists()是判断一个文件是否存在
					{ 
				    	na++;
				    	p = FileName+"("+na+")";				
					}
					FileName=p;		    
					File file1 = new File("Scoring/"+FileName+".xls");
					try 
					{
						file1.createNewFile();
					} 
					catch (IOException e1) 
					{
						e1.printStackTrace();
					}
				
					try 
					{  
			        	ExcelExporter exp = new ExcelExporter();  
			        	exp.exportTable(Table0, file1);  
			        	exp.exportTable(Table1, file1);
			        	exp.exportTable(Table2, file1);
			        } 					
					catch (IOException ex)
					{  
			            System.out.println(ex.getMessage());  
			            ex.printStackTrace();  
			        } 
			    }	
		  }
		if(e.getSource()==Help)
		{
			int n = JOptionPane.showConfirmDialog(null,"该程序由梁青青同学编写\n"+
		            "若需查看详细帮助，请点击“确定”","帮助",JOptionPane.YES_NO_OPTION);
			
			if(n==0)
			{
				try 
				{
					Runtime.getRuntime().exec( "cmd /c start "
							+"Instruction_Of_Badminton/羽毛球计分器使用说明.doc");
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
	}
	
	/*********添加总分*********/
	public void AddZongfen()
	{
		if(Jushu == 1)
		{
			Zongfen[0] = Lbifen;
			Zongfen[1] = Rbifen;
		}
		else if(Jushu == 2)
		{
			Zongfen[2] = Lbifen;
			Zongfen[3] = Rbifen;
		}
		else if(Jushu == 3)
		{
			Zongfen[4] = Lbifen;
			Zongfen[5] = Rbifen;
		}
	}
	
	/********添加局分**********/
	public void AddJufen()
	{
		if(Jushu == 1)
		{
			Jufen1_1.add(Lbifen);
			Jufen1_2.add(Rbifen);
		}
		else if(Jushu == 2)
		{
			Jufen2_1.add(Lbifen);
			Jufen2_2.add(Rbifen);
		}
		else if(Jushu == 3)
		{
			Jufen3_1.add(Lbifen);
			Jufen3_2.add(Rbifen);
		}
	}
    
	/********移除局分中的一个分数**********/
	public void RemoveJufen()
	{
		if(Jushu == 1)
		{
			Jufen1_1.remove(Jufen1_1.size()-1);
			Jufen1_2.remove(Jufen1_2.size()-1);
		}
		else if(Jushu == 2)
		{
			Jufen2_1.remove(Jufen2_1.size()-1);
			Jufen2_2.remove(Jufen2_2.size()-1);
		}
		else if(Jushu == 3)
		{
			Jufen3_1.remove(Jufen2_1.size()-1);
			Jufen3_2.remove(Jufen2_2.size()-1);
		}
	}
	
	/********鼠标点击详细弹出详细比分表格**********/
	public void mouseClicked(MouseEvent e) 
	{ 		
		int RowIndex,ColumnIndex;
		final JFrame Frame0 = new JFrame();
		
		 if (e.getClickCount() == 2) 
		 {
		      RowIndex = Table.rowAtPoint(e.getPoint());
		      ColumnIndex = Table.columnAtPoint(e.getPoint());

		      //查看不同局数的比分
        	  if(ColumnIndex == 3&&RowIndex == 0)
        	  { 
        		  Model0.setColumnCount(Jufen1_1.size()+1);
        		  for(int i=1 ; i<Jufen1_1.size();i++)
        		  {
        			  Table0.getColumnModel().getColumn(i+1).setHeaderValue(i);
      				  Model0.setValueAt(Jufen1_1.get(i), 0, (i+1));
	        		  Model0.setValueAt(Jufen1_2.get(i), 1, (i+1));	        			   			  
  			      }	       		  
        		  setFixColumnWidth(Table0);//设置固定列宽
		          Table0.getColumnModel().getColumn(0).setPreferredWidth(150);	
	  	          JScrollPane ScrollPane0 = new JScrollPane(Table0,
	  	        		 ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
		  	        	 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	  	          Frame0.add(ScrollPane0);
	  	          Frame0.setTitle("第一局比分");
        	  }
        	
        	  if(ColumnIndex == 3&&RowIndex == 1)
        	  {
        		  Model1.setColumnCount(Jufen2_1.size()+1);
        		  for(int i=1 ; i<Jufen2_1.size();i++)
        		  {  
        			  Table1.getColumnModel().getColumn(i+1).setHeaderValue(i);
        		      Model1.setValueAt(Jufen2_1.get(i), 0, (i+1));
        		      Model1.setValueAt(Jufen2_2.get(i), 1, (i+1));	  
        		  }	
        		  setFixColumnWidth(Table1);//设置固定列宽
		          Table1.getColumnModel().getColumn(0).setPreferredWidth(150);	
	  	          JScrollPane ScrollPane1 = new JScrollPane(Table1,
	  	        		 ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
		  	             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        		  Frame0.add(ScrollPane1);
        		  Frame0.setTitle("第二局比分");
        	  }
        	   	        	  
        	  if(ColumnIndex == 3&&RowIndex == 2)
        	  {	 
        		  Model2.setColumnCount(Jufen3_1.size()+1);
        		  for(int i=1 ; i<Jufen3_1.size();i++)
        		  {
        			  Table2.getColumnModel().getColumn(i+1).setHeaderValue(i);
        		      Model2.setValueAt(Jufen3_1.get(i), 0, (i+1));
        		      Model2.setValueAt(Jufen3_2.get(i), 1, (i+1));	        			 
        		  }
        		  setFixColumnWidth(Table2);//设置固定列宽
		          Table2.getColumnModel().getColumn(0).setPreferredWidth(150);	
	  	          JScrollPane ScrollPane2 = new JScrollPane(Table2,
	  	        		 ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
		  	             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	  	          Frame0.add(ScrollPane2);
	  	          Frame0.setTitle("第三局比分");
        	  }
  	              		  
    		  Frame0.setBounds(300, 300, 500, 170);
    		  Frame0.setVisible(true);
    		  Frame0.setResizable(false);
    		  Frame0.addWindowListener(new WindowAdapter()
    		  {
    			  public void windowClosing(WindowEvent e) 
    			  {
    				  Frame0.dispose();
    				  Status = false;
    				  OpenListener();
    			  }
    		  });
    		  Status = true;
    		  OpenListener();
		 }
	}
	public void OpenListener()
	{
		if(Status == true)
		  {
			  Table.removeMouseListener(this);
		  }
		  else if(Status == false)
		  {
			  Table.addMouseListener(this);
		  }
	}
	
	/********设置固定表格列宽**********/
	public void setFixColumnWidth(JTable table)
	{
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
	       
        TableColumnModel tcm = table.getTableHeader().getColumnModel();
        for (int i = 1; i < tcm.getColumnCount(); i++)
        {
            TableColumn tc = tcm.getColumn(i);
            tc.setPreferredWidth(100);
            tc.setMaxWidth(50);
        }
	}

	/********未使用函数**********/
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) {	}
	
	//测试
	public static void main(String[] args)
	{
		new BadmintonScoring();
	}	
}

