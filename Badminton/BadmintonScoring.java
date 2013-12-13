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
	/**********��������**************/	
	//����
	JFrame BadFrame = new JFrame("��ë��Ʒ���");	//������
	JPanel LeftPane = new JPanel(); //�����
	JPanel RightPane = new JPanel(); //�����
	JSplitPane SplitPane;//�ָ���壬װ�������
	JPanel panel = new ImagePanel ();//��ͼ
	
	//����尴ť
	JButton Return = new JButton(new ImageIcon("image/����.png"));
	JButton Addplayer = new JButton(new ImageIcon("image/���ѡ��.png")); 
	JButton Start = new JButton(new ImageIcon("image/��ʼ.png"));
	JButton CheckAll = new JButton(new ImageIcon("image/�鿴.png"));
	JButton Save = new JButton(new ImageIcon("image/����.png"));
	//����尴ť
	JButton LeftWin = new JButton(new ImageIcon("image/�÷�.jpg") );
	JButton RightWin = new JButton(new ImageIcon("image/�÷�.jpg"));
	JButton LeftReset = new JButton(new ImageIcon("image/����.jpg"));
	JButton RightReset = new JButton(new ImageIcon("image/����.jpg"));
	JButton New = new JButton(new ImageIcon("image/�¾�.jpg"));
	JButton Help = new JButton(new ImageIcon("image/����.jpg"));
	
	//��ǩ
	JLabel Player1 = new JLabel(new ImageIcon("image/ѡ��1.png"));
	JLabel Player2 = new JLabel(new ImageIcon("image/ѡ��2.png"));
	JLabel PK = new JLabel(new ImageIcon("image/pk.png"));
	JLabel ScoreLeft = new JLabel();
	JLabel ScoreRight = new JLabel();
	JLabel VS = new JLabel(":");
	
	//�ȷ�
	int Lbifen = 0;//��ȷ�
	int Rbifen = 0;//�ұȷ�
	int Jushu = 1;//����
	int Lwin = 0;//�󷽻�ʤ����
	int Rwin = 0;//�ҷ���ʤ����
	boolean Status = false ;//���ڼ�ؾִַ����Ƿ񱻴򿪣������ظ����򿪣�false��ʾδ���򿪡�
	
	//�ı���
	JTextField[] ShowName = {new JTextField(10),new JTextField(10),
			new JTextField(10),new JTextField(10)};
	JTextField[] AddName = {new JTextField(10),new JTextField(10),
			new JTextField(10),new JTextField(10),};
	
	//�ȷ�����	
	int[] Zongfen = {0,0,0,0,0,0};
	Vector<Integer> Jufen1_1 = new Vector<Integer>();
	Vector<Integer> Jufen1_2 = new Vector<Integer>();
	Vector<Integer> Jufen2_1 = new Vector<Integer>();
	Vector<Integer> Jufen2_2 = new Vector<Integer>();
	Vector<Integer> Jufen3_1 = new Vector<Integer>();
	Vector<Integer> Jufen3_2 = new Vector<Integer>();
	
	//�ֱܷ��
	String[] Colnames = {"����","ѡ��1","ѡ��2"," "};
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
	
	//�ֱַ��	
	String[] Colnames0 = {"������Ա","0"};
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
	  JTable Table0 = new JTable(Model0);//��һ�ֱ��
	  JTable Table1 = new JTable(Model1);//�ڶ��ֱ��
	  JTable Table2 = new JTable(Model2);//�����ֱ��
	
	public BadmintonScoring()
	{		
		/***********��ť����**********/
		//����尴ť
		Return.setBounds(30, 10, 101, 94);//����λ��	
		Return.setBorderPainted(false);//���ñ߿�
		Return.setBackground(Color.white);//���ñ���
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
				
		//����尴ť����ǩ���ı�������
		//��ǩ
		Player1.setBounds(0, 10, 101, 94);
		Player2.setBounds(420, 10, 101, 94);
		PK.setBounds(200, 10, 100, 100);
		
		//�ı���
		ShowName[0].setBounds(110, 20, 100, 20);
		ShowName[1].setBounds(110, 60, 100, 20);
		ShowName[2].setBounds(310, 20, 100, 20);
		ShowName[3].setBounds(310, 60, 100, 20);
		
		//��ť
		LeftWin.setBounds(80, 500, 110, 60);
		RightWin.setBounds(350, 500, 110, 60);
		LeftReset.setBounds(80, 590, 110, 60);
		RightReset.setBounds(350, 590, 110, 60);
		New.setBounds(215, 550, 110, 60);
		Help.setBounds(450, 120, 50, 30);
		Help.setToolTipText("�����ȡ����");
		
		//�ȷ�����
		panel.setBounds(70, 330, 400, 150);	//���ö�ͼλ��
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
			
		/**********�������**********/		
		//�����
		LeftPane.setLayout(null);		
		LeftPane.add(Return);		
		LeftPane.add(Addplayer);
		LeftPane.add(Start);
		LeftPane.add(CheckAll);
		LeftPane.add(Save);
		LeftPane.setOpaque(false);//����Ϊ͸��
		
		//�����
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
		
		//�ָ����
		SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, LeftPane, RightPane);
		SplitPane.setDividerLocation(200);
		SplitPane.setDividerSize(4);
		SplitPane.setEnabled(false);
		SplitPane.setOpaque(false);
				
		/**********�ȷֱ���ʼ��***********/
		//�ֱַ��1����
		Font font = new Font(" ",3,15);
		TableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        Table0.setDefaultRenderer(Object.class, TableRenderer);
        Table0.setFont(font);  	        
        Table0.setSelectionBackground(Color.pink);   
        Table0.setSelectionForeground(Color.black);   
        Table0.setRowHeight(40);  
        Table0.setCellSelectionEnabled(true);        
      	        
        //���ó�ʼֵ
        Model0.setValueAt("ѡ����1", 0, 0);
        Model0.setValueAt("ѡ����2", 1, 0);	
		Model0.setValueAt(Jufen1_1.get(0), 0, 1);
        Model0.setValueAt(Jufen1_2.get(0), 1, 1);
        
        //�ֱַ��2����
	    TableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        Table1.setDefaultRenderer(Object.class, TableRenderer);
        Table1.setFont(font);  	        
        Table1.setSelectionBackground(Color.pink);   
        Table1.setSelectionForeground(Color.black);   
        Table1.setRowHeight(40);  
        Table1.setCellSelectionEnabled(true);       
      	        
        //���ó�ʼֵ
        Model1.setValueAt("ѡ����1", 0, 0);
        Model1.setValueAt("ѡ����2", 1, 0);	
		Model1.setValueAt(Jufen2_1.get(0), 0, 1);
        Model1.setValueAt(Jufen2_2.get(0), 1, 1); 
  	  
        //�ֱַ��3����
        TableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        Table2.setDefaultRenderer(Object.class, TableRenderer);
        Table2.setFont(font);  	        
        Table2.setSelectionBackground(Color.pink);   
        Table2.setSelectionForeground(Color.black);   
        Table2.setRowHeight(40);  
        Table2.setCellSelectionEnabled(true);
          	        
        //���ó�ʼֵ
        Model2.setValueAt("ѡ����1", 0, 0);
        Model2.setValueAt("ѡ����2", 1, 0);	
        Model2.setValueAt(Jufen3_1.get(0), 0, 1);
        Model2.setValueAt(Jufen3_2.get(0), 1, 1);
        
		/*********��������*********/
		BadFrame.setSize(750, 700);
		BadFrame.setLayout(new BorderLayout());
		BadFrame.add(SplitPane, BorderLayout.CENTER);
		BadFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		BadFrame.setLocationRelativeTo(null);
		BadFrame.setVisible(true);
		BadFrame.setResizable(false);
		
		//���ñ���
		ImageIcon img = new ImageIcon("image/��ɫ����.jpg");
        JLabel imgLabel = new JLabel(img); 
        BadFrame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());  
        Container cp=BadFrame.getContentPane();  
        cp.setLayout(new BorderLayout());            
        ((JPanel)cp).setOpaque(false);   

		validate();
		
		/*********�����¼�����**********/
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
		
		//���ÿɼ�
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
			final JFrame Addframe = new JFrame("����˶�Ա");
			Addframe.setBounds(500,300,400,350);
			Addframe.setResizable(false);
			Addframe.setLayout(null);
			
			//��ǩ			
			JLabel[] Player = {new JLabel("ѡ��1-1"),new JLabel("ѡ��1-2"),
					new JLabel("ѡ��2-1"),new JLabel("ѡ��2-2")};
		
		    for(int i=0 ;i<4;i++)
		    {
		    	Player[i].setFont(new Font("ѡ��2",30,25));
		    }
			Player[0].setBounds(50, 70, 150, 30);	
			Player[1].setBounds(50, 120, 150, 30);	;
			Player[2].setBounds(50, 170, 150, 30);
			Player[3].setBounds(50, 220, 150, 30);
			
			JLabel Instruction = new JLabel("������ѡ�����֣�");
			Instruction.setBounds(70, 10, 400, 50);
			Instruction.setFont(new Font("ѡ��2",1,30));
			Instruction.setForeground(Color.red);
			
			//�ı���			
			AddName[0].setBounds(200, 70, 120, 30);
			AddName[1].setBounds(200, 120, 120, 30);
			AddName[2].setBounds(200, 170, 120, 30);
			AddName[3].setBounds(200, 220, 120, 30);
			
			//��ť
			JButton Yes = new JButton("ȷ��");
			Yes.setBounds(170, 270, 80, 40);
			JButton Cancel = new JButton("ȡ��");
			Cancel.setBounds(270, 270, 80, 40);
			
			//������
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
			
			//�����¼�
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
			final JFrame Tableframe = new JFrame("�ܱȷ� ");
			Tableframe.setBounds(500,300,400,210);
	        Tableframe.setResizable(false);
	        Tableframe.setLayout(new BorderLayout());
		
	        Font font = new Font(" ",3,20);
							          
	        for(int i=0 ; i<3 ; i++)
	        {
	        	Table.setValueAt(i+1, i, 0);
	        	Table.setValueAt("��ϸ", i, 3);
	        }
	        
	        //��ӱȷ�
	        Table.setValueAt(Zongfen[0], 0, 1);
	        Table.setValueAt(Zongfen[1], 0, 2);
	        Table.setValueAt(Zongfen[2], 1, 1);
	        Table.setValueAt(Zongfen[3], 1, 2);
	        Table.setValueAt(Zongfen[4], 2, 1);
	        Table.setValueAt(Zongfen[5], 2, 2);
	        	        
            // ����table���ݾ���      
	        TableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	        Table.setDefaultRenderer(Object.class, TableRenderer);
	        Table.setFont(font);
	        TableColumnModel columnModel = Table.getColumnModel();   	        
	         
	        //��ӹ�����     
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
			
			//��Ԫ������¼�
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
					new File("Scoring/").mkdir(); //mkdirֻ����һ���ļ���
			}
			catch(SecurityException e2)
			{
			      e2.printStackTrace();
			}
			
			JFileChooser file = new JFileChooser("Scoring/");
			file.setAcceptAllFileFilterUsed(false);//ȥ����ʾ�����ļ����������
			file.addChoosableFileFilter(new FileNameExtensionFilter("Excel���(.xls)", "xls"));
			int n = file.showSaveDialog(null);
			String FileName = file.getSelectedFile().getName();   
		     
		     if(FileName != null)
				{
					int na = 0;
					String p= FileName;
					while(new File("Scoring/"+p+".xls").exists())//.exists()���ж�һ���ļ��Ƿ����
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
			int n = JOptionPane.showConfirmDialog(null,"�ó�����������ͬѧ��д\n"+
		            "����鿴��ϸ������������ȷ����","����",JOptionPane.YES_NO_OPTION);
			
			if(n==0)
			{
				try 
				{
					Runtime.getRuntime().exec( "cmd /c start "
							+"Instruction_Of_Badminton/��ë��Ʒ���ʹ��˵��.doc");
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
		}
	}
	
	/*********����ܷ�*********/
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
	
	/********��Ӿַ�**********/
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
    
	/********�Ƴ��ַ��е�һ������**********/
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
	
	/********�������ϸ������ϸ�ȷֱ��**********/
	public void mouseClicked(MouseEvent e) 
	{ 		
		int RowIndex,ColumnIndex;
		final JFrame Frame0 = new JFrame();
		
		 if (e.getClickCount() == 2) 
		 {
		      RowIndex = Table.rowAtPoint(e.getPoint());
		      ColumnIndex = Table.columnAtPoint(e.getPoint());

		      //�鿴��ͬ�����ıȷ�
        	  if(ColumnIndex == 3&&RowIndex == 0)
        	  { 
        		  Model0.setColumnCount(Jufen1_1.size()+1);
        		  for(int i=1 ; i<Jufen1_1.size();i++)
        		  {
        			  Table0.getColumnModel().getColumn(i+1).setHeaderValue(i);
      				  Model0.setValueAt(Jufen1_1.get(i), 0, (i+1));
	        		  Model0.setValueAt(Jufen1_2.get(i), 1, (i+1));	        			   			  
  			      }	       		  
        		  setFixColumnWidth(Table0);//���ù̶��п�
		          Table0.getColumnModel().getColumn(0).setPreferredWidth(150);	
	  	          JScrollPane ScrollPane0 = new JScrollPane(Table0,
	  	        		 ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
		  	        	 ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	  	          Frame0.add(ScrollPane0);
	  	          Frame0.setTitle("��һ�ֱȷ�");
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
        		  setFixColumnWidth(Table1);//���ù̶��п�
		          Table1.getColumnModel().getColumn(0).setPreferredWidth(150);	
	  	          JScrollPane ScrollPane1 = new JScrollPane(Table1,
	  	        		 ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
		  	             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        		  Frame0.add(ScrollPane1);
        		  Frame0.setTitle("�ڶ��ֱȷ�");
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
        		  setFixColumnWidth(Table2);//���ù̶��п�
		          Table2.getColumnModel().getColumn(0).setPreferredWidth(150);	
	  	          JScrollPane ScrollPane2 = new JScrollPane(Table2,
	  	        		 ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
		  	             ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	  	          Frame0.add(ScrollPane2);
	  	          Frame0.setTitle("�����ֱȷ�");
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
	
	/********���ù̶�����п�**********/
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

	/********δʹ�ú���**********/
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) {	}
	
	//����
	public static void main(String[] args)
	{
		new BadmintonScoring();
	}	
}

