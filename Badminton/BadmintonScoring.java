package Badminton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class BadmintonScoring extends JFrame implements ActionListener, MouseListener 
{
	/**********��������**************/	
	//����
	JFrame BadFrame = new JFrame("��ë��Ʒ���");	
	JPanel LeftPane = new JPanel();
	JPanel RightPane = new JPanel();
	JSplitPane SplitPane;
	JPanel panel = new ImagePanel ();
	
	//��ť
	JButton Return = new JButton(new ImageIcon("image/����.png"));
	JButton Addplayer = new JButton(new ImageIcon("image/���ѡ��.png")); 
	JButton NewGame = new JButton(new ImageIcon("image/��ʼ.png"));
	JButton CheckAll = new JButton(new ImageIcon("image/�鿴.png"));
	JButton Save = new JButton(new ImageIcon("image/����.png"));
	JButton LeftWin = new JButton(new ImageIcon("image/�÷�.jpg") );
	JButton RightWin = new JButton(new ImageIcon("image/�÷�.jpg"));
	JButton Reset = new JButton(new ImageIcon("image/����.jpg"));
	JButton New = new JButton(new ImageIcon("image/�¾�.jpg"));
	
	//��ǩ
	JLabel Player1 = new JLabel(new ImageIcon("image/ѡ��1.png"));
	JLabel Player2 = new JLabel(new ImageIcon("image/ѡ��2.png"));
	JLabel PK = new JLabel(new ImageIcon("image/pk.png"));
	JLabel[] ScoreLeft = 
		{
			new JLabel(new ImageIcon("image/0.png")),
			new JLabel(new ImageIcon("image/1.png")),new JLabel(new ImageIcon("image/2.png")),
			new JLabel(new ImageIcon("image/3.png")),new JLabel(new ImageIcon("image/4.png")),
			new JLabel(new ImageIcon("image/5.png")),new JLabel(new ImageIcon("image/6.png")),
			new JLabel(new ImageIcon("image/7.png")),new JLabel(new ImageIcon("image/8.png")),
			new JLabel(new ImageIcon("image/9.png")),new JLabel(new ImageIcon("image/10.png")),
			new JLabel(new ImageIcon("image/11.png")),new JLabel(new ImageIcon("image/12.png")),
			new JLabel(new ImageIcon("image/13.png")),new JLabel(new ImageIcon("image/14.png")),
			new JLabel(new ImageIcon("image/15.png")),new JLabel(new ImageIcon("image/16.png")),
			new JLabel(new ImageIcon("image/17.png")),new JLabel(new ImageIcon("image/18.png")),
			new JLabel(new ImageIcon("image/19.png")),new JLabel(new ImageIcon("image/20.png")),
			new JLabel(new ImageIcon("image/21.png")),new JLabel(new ImageIcon("image/22.png")),
			new JLabel(new ImageIcon("image/23.png")),new JLabel(new ImageIcon("image/24.png")),
			new JLabel(new ImageIcon("image/25.png")),new JLabel(new ImageIcon("image/26.png")),
			new JLabel(new ImageIcon("image/27.png")),new JLabel(new ImageIcon("image/28.png")),
			new JLabel(new ImageIcon("image/29.png")),new JLabel(new ImageIcon("image/30.png")),
	   };
	JLabel[] ScoreRight = 
		{
			new JLabel(new ImageIcon("image/0.png")),
			new JLabel(new ImageIcon("image/1.png")),new JLabel(new ImageIcon("image/2.png")),
			new JLabel(new ImageIcon("image/3.png")),new JLabel(new ImageIcon("image/4.png")),
			new JLabel(new ImageIcon("image/5.png")),new JLabel(new ImageIcon("image/6.png")),
			new JLabel(new ImageIcon("image/7.png")),new JLabel(new ImageIcon("image/8.png")),
			new JLabel(new ImageIcon("image/9.png")),new JLabel(new ImageIcon("image/10.png")),
			new JLabel(new ImageIcon("image/11.png")),new JLabel(new ImageIcon("image/12.png")),
			new JLabel(new ImageIcon("image/13.png")),new JLabel(new ImageIcon("image/14.png")),
			new JLabel(new ImageIcon("image/15.png")),new JLabel(new ImageIcon("image/16.png")),
			new JLabel(new ImageIcon("image/17.png")),new JLabel(new ImageIcon("image/18.png")),
			new JLabel(new ImageIcon("image/19.png")),new JLabel(new ImageIcon("image/20.png")),
			new JLabel(new ImageIcon("image/21.png")),new JLabel(new ImageIcon("image/22.png")),
			new JLabel(new ImageIcon("image/23.png")),new JLabel(new ImageIcon("image/24.png")),
			new JLabel(new ImageIcon("image/25.png")),new JLabel(new ImageIcon("image/26.png")),
			new JLabel(new ImageIcon("image/27.png")),new JLabel(new ImageIcon("image/28.png")),
			new JLabel(new ImageIcon("image/29.png")),new JLabel(new ImageIcon("image/30.png")),
	   };
	
	
	//�ı���
	JTextField Name1 = new JTextField(10);
	JTextField Name2 = new JTextField(10);
	JTextField Name3 = new JTextField(10);
	JTextField Name4 = new JTextField(10);
	JTextField Name5 = new JTextField(10);
	JTextField Name6 = new JTextField(10);
	JTextField Name7 = new JTextField(10);
	JTextField Name8 = new JTextField(10);
	
	//�ȷ�����
	
	int[] Zongfen = {0,0,0,0,0,0};
	Vector<Integer> Jufen1 = new Vector<Integer>();
	Vector<Integer> Jufen2 = new Vector<Integer>();
	Vector<Integer> Jufen3 = new Vector<Integer>();
	
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
	
	public BadmintonScoring()
	{		
		/***********��ť����**********/
		//����尴ť
		Return.setBounds(30, 10, 101, 94);	
		Return.setBorderPainted(false);
		Return.setBackground(Color.white);
		Addplayer.setBounds(30, 140, 97, 102);
		Addplayer.setBorderPainted(false);
		Addplayer.setBackground(Color.white);
		NewGame.setBounds(30, 270, 92, 93);
		NewGame.setBorderPainted(false);
		NewGame.setBackground(Color.white);
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
		Name1.setBounds(110, 20, 100, 20);
		Name2.setBounds(110, 60, 100, 20);
		Name3.setBounds(310, 20, 100, 20);
		Name4.setBounds(310, 60, 100, 20);
		
		//��ť
		LeftWin.setBounds(80, 500, 90, 60);
		RightWin.setBounds(350, 500, 90, 60);
		Reset.setBounds(80, 590, 90, 60);
		New.setBounds(350, 590, 90, 60);
		
		//�ȷ�����
		panel.setBounds(70, 330, 400, 150);
		for(int i=0 ; i<31 ; i++)
		{
			ScoreLeft[i].setBounds(50, 170, 200, 150);
			ScoreRight[i].setBounds(320, 170, 200, 150);
		}		
		Jufen1.add(0);Jufen1.add(0);
		Jufen2.add(0);Jufen2.add(0);
		Jufen3.add(0);Jufen3.add(0);
				
		/**********�������**********/		
		//�����
		LeftPane.setLayout(null);		
		LeftPane.add(Return);		
		LeftPane.add(Addplayer);
		LeftPane.add(NewGame);
		LeftPane.add(CheckAll);
		LeftPane.add(Save);
		LeftPane.setOpaque(false);
		
		//�����
		RightPane.setLayout(null);
		RightPane.add(Player1);
		RightPane.add(Name1);
		RightPane.add(Name2);
		RightPane.add(PK);
		RightPane.add(Player2);
		RightPane.add(Name3);
		RightPane.add(Name4);
		RightPane.add(LeftWin);
		RightPane.add(RightWin);
		RightPane.add(Reset);
		RightPane.add(New);
		RightPane.add(panel);
		RightPane.setOpaque(false);		
		RightPane.add(ScoreRight[0]);		
		RightPane.add(ScoreLeft[0]);
		
		//�ָ����
		SplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, LeftPane, RightPane);
		SplitPane.setDividerLocation(200);
		SplitPane.setDividerSize(4);
		SplitPane.setEnabled(false);
		SplitPane.setOpaque(false);
				
		/*********��������*********/
		BadFrame.setSize(750, 700);
		BadFrame.setVisible(true);
		BadFrame.setLayout(new BorderLayout());
		BadFrame.add(SplitPane, BorderLayout.CENTER);
		BadFrame.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		BadFrame.setLocationRelativeTo(this);
		BadFrame.setVisible(true);
		
		//���ñ���
		ImageIcon img = new ImageIcon("image/��ɫ����.jpg");
        JLabel imgLabel = new JLabel(img); 
        BadFrame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());  
        Container cp=BadFrame.getContentPane();  
        cp.setLayout(new BorderLayout());            
        ((JPanel)cp).setOpaque(false);   

		validate();
		
		/*********ʱ�����**********/
		Return.addActionListener(this);
		Addplayer.addActionListener(this);
		NewGame.addActionListener(this);
		CheckAll.addActionListener(this);
		Save.addActionListener(this);
		LeftWin.addActionListener(this);
		RightWin.addActionListener(this);
		Reset.addActionListener(this);
		New.addActionListener(this);
	}
	

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == Return) {}	
		if(e.getSource() == Addplayer) 
		{		
			JFrame Addframe = new JFrame("����˶�Ա");
			Addframe.setBounds(500,300,400,350);
			Addframe.setResizable(false);
			Addframe.setLayout(null);
			
			//��ǩ
			Font font = new Font("ѡ��2",30,30);
			Font font1 = new Font("ѡ��2",30,25);
			
			JLabel Player3 = new JLabel("ѡ��1-1");
			Player3.setFont(font1);
			Player3.setBounds(50, 70, 150, 30);	
			
			JLabel Player4 = new JLabel("ѡ��1-2");
			Player4.setFont(font1);
			Player4.setBounds(50, 120, 150, 30);	
			
			JLabel Player5 = new JLabel("ѡ��2-1");
			Player5.setFont(font1);
			Player5.setBounds(50, 170, 150, 30);
			
			JLabel Player6 = new JLabel("ѡ��2-2");
			Player6.setFont(font1);
			Player6.setBounds(50, 220, 150, 30);
			
			JLabel Instruction = new JLabel("������ѡ�����֣�");
			Instruction.setBounds(50, 10, 400, 50);
			Instruction.setFont(font);
			
			//�ı���			
			Name5.setBounds(200, 70, 100, 30);
			Name5.setBackground(Color.LIGHT_GRAY);
			Name6.setBounds(200, 120, 100, 30);
			Name6.setBackground(Color.BLUE);
			Name7.setBounds(200, 170, 100, 30);
			Name7.setBackground(Color.GREEN);
			Name8.setBounds(200, 220, 100, 30);
			Name8.setBackground(Color.pink);
			
			//��ť
			JButton Yes = new JButton("ȷ��");
			Yes.setBounds(170, 270, 80, 40);
			JButton Cancel = new JButton("ȡ��");
			Cancel.setBounds(270, 270, 80, 40);
			
			//������
			Addframe.add(Instruction);
			Addframe.add(Player3);
			Addframe.add(Player4);
			Addframe.add(Player5);
			Addframe.add(Player6);
			Addframe.add(Name5);
			Addframe.add(Name6);
			Addframe.add(Name7);
			Addframe.add(Name8);
			Addframe.add(Cancel);
			Addframe.add(Yes);	
			Addframe.setVisible(true);
		}
		if(e.getSource()==CheckAll)
		{						
			JFrame Tableframe = new JFrame("�ܱȷ� ");
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
	        Table.setFillsViewportHeight(true);      
	        JScrollPane ScrollPane = new JScrollPane(Table);
	        Tableframe.add(ScrollPane);
	        
	        Table.setSelectionBackground(Color.pink);   
	        Table.setSelectionForeground(Color.black);   
	        Table.setRowHeight(50);  
	        Table.setCellSelectionEnabled(true);
	        
	        Tableframe.setVisible(true);
			Tableframe.validate();
			
			//��Ԫ������¼�
			Table.addMouseListener(this);
		}
	}

	public void mouseClicked(MouseEvent e) 
	{ 
		int RowIndex,ColumnIndex;
		 if (e.getClickCount() == 2) 
		 {
		      RowIndex = Table.rowAtPoint(e.getPoint());
		      ColumnIndex = Table.columnAtPoint(e.getPoint());
		      
		      String[] Colnames0 = {"������Ա","0"};
		      DefaultTableModel Model0 = new DefaultTableModel(Colnames0,2)
  			  {
		    	   private static final long serialVersionUID = 1L;
	  		        
	  		        public boolean isCellEditable(int row, int column)
	  		        {
	  		                return false;
	  		        };		
  			  };
  			  
		      if(ColumnIndex == 3)
		      {
		    	  JFrame Frame0 = new JFrame();	  		 
	    		  JTable Table0 = new JTable(Model0);
	    		  	    		      		    		  
	    		  //�������
	    		  Font font = new Font(" ",3,15);
	    		  TableRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	  	          Table0.setDefaultRenderer(Object.class, TableRenderer);
	  	          Table0.setFont(font);
	  	          TableColumnModel columnModel = Table0.getColumnModel();   	        
	  	          Table0.setSelectionBackground(Color.pink);   
		          Table0.setSelectionForeground(Color.black);   
		          Table0.setRowHeight(40);  
		          Table0.setCellSelectionEnabled(true);
		        	        
		          //���ó�ʼֵ
		          Table0.setValueAt("ѡ����1", 0, 0);
	    		  Table0.setValueAt("ѡ����2", 1, 0);	
		          Table0.setValueAt(Jufen1.get(0), 0, 1);
	        	  Table0.setValueAt(Jufen1.get(1), 1, 1);        	  
		      
	  	          //���ˮƽ�������Ϳ��	        	  
		          Table0.getColumnModel().getColumn(0).setPreferredWidth(150);		               
	  	          JScrollPane ScrollPane = new JScrollPane(Table0,
	  	        		  ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
	  	        		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	  	          
	  	          Frame0.add(ScrollPane);    		  
	    		  Frame0.setBounds(300, 300, 500, 150);
	    		  Frame0.setVisible(true);
		    	 
		      }
		 }
	}
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

