package MainFrame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ScoreIndicator implements ActionListener
{
	public JFrame MainFrame;
	JTextField Instruction_Title;
	JTextArea Instruction_Text;
	JPanel ButtonPanel;
	JButton Basketball,Badminton;
	
	ScoreIndicator()
	{
		MainFrame = new JFrame();
		Instruction_Title = new JTextField(50);
		Instruction_Text = new JTextArea();
		
		ButtonPanel = new JPanel();
		Basketball = new JButton("Basketball");
		Badminton = new JButton("Badminton");
		
		String Title = "��ӭʹ�������Ʒ���";
		String Text = "       �������Ʒ�����������Ʒ�������ë��Ƿ�����"
				+ "�ս��������һ�������棬��ѡ���������ë��Ƿ�����"
				+ "��ѡ������һ���Ʒ����󣬽�����Ӧ�ļƷ������棬������Ӧ�Ĳ����� "
				+ "�����У���ë��Ʒ������������д������Ʒ���������Ǳͬѧ��д��"
				+ "����������λͬѧ��ͬ��ɣ�"+'\n'
				+ "      ��л��ʹ�ø������Ʒ�����";
		
		Instruction_Title.setText(Title+'\n');
		Instruction_Title.setFont(new Font("",3,30));
		Instruction_Title.setEditable(false);
		Instruction_Title.setBackground(Color.white);
		Instruction_Title.setHorizontalAlignment(JTextField.CENTER);
		
		Instruction_Text.setText(Text+'\n');
		Instruction_Text.setFont(new Font("",2,25));
		Instruction_Text.setEditable(false);
		Instruction_Text.setLineWrap(true);//�Զ�����
		Instruction_Text.setRows(2);
		
		ButtonPanel.add(Badminton);
		ButtonPanel.add(Basketball);
		
		Badminton.addActionListener(this);
		Basketball.addActionListener(this);
		
		MainFrame.setLayout(new BorderLayout());
		MainFrame.add("North",Instruction_Title);
		MainFrame.add("Center",Instruction_Text);
		MainFrame.add("South",ButtonPanel);
		MainFrame.setBounds(400, 160, 500, 400);
		MainFrame.setVisible(true);
		MainFrame.setResizable(false);
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == Badminton )
		{
			new Badminton.BadmintonScoring();
		}
		if(e.getSource() == Basketball )
		{
			new Score.Basketball();
		}
		
	}
	public static void main(String[] args)
	{
		new ScoreIndicator();
	}
}
