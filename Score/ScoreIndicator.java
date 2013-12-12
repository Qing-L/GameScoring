package Score;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ScoreIndicator implements ActionListener
{
	JFrame MainFrame;
	JTextArea Instruction;
	JPanel ButtonPanel;
	JButton Basketball,Badminton;
	
	ScoreIndicator()
	{
		MainFrame = new JFrame();
		Instruction = new JTextArea();
		
		ButtonPanel = new JPanel();
		Basketball = new JButton("Basketball");
		Badminton = new JButton("Badminton");
		
		ButtonPanel.add(Badminton);
		ButtonPanel.add(Basketball);
		
		Badminton.addActionListener(this);
		Basketball.addActionListener(this);
		
		MainFrame.setLayout(new BorderLayout());
		MainFrame.add("Center",Instruction);
		MainFrame.add("South",ButtonPanel);
		MainFrame.setBounds(400, 160, 500, 400);
		MainFrame.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == Badminton )
		{
			
		}
		if(e.getSource() == Basketball )
		{
			//new Basketball();
		}
		
	}
	public static void main(String[] args)
	{
		new ScoreIndicator();
	}
}
