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
		
		String Title = "欢迎使用球赛计分器";
		String Text = "       该球赛计分器包括篮球计分器和羽毛球记分器，"
				+ "刚进入程序是一个主界面，可选择篮球和羽毛球记分器，"
				+ "当选择其中一个计分器后，进入相应的计分器界面，进行相应的操作。 "
				+ "操作中，羽毛球计分器由梁青青编写，篮球计分器由吴雨潜同学编写，"
				+ "主界面有两位同学共同完成！"+'\n'
				+ "      感谢您使用该球赛计分器！";
		
		Instruction_Title.setText(Title+'\n');
		Instruction_Title.setFont(new Font("",3,30));
		Instruction_Title.setEditable(false);
		Instruction_Title.setBackground(Color.white);
		Instruction_Title.setHorizontalAlignment(JTextField.CENTER);
		
		Instruction_Text.setText(Text+'\n');
		Instruction_Text.setFont(new Font("",2,25));
		Instruction_Text.setEditable(false);
		Instruction_Text.setLineWrap(true);//自动换行
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
