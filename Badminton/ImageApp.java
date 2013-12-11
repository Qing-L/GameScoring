package Badminton;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

	

class ImagePanel extends JPanel 
{
	public void paint(Graphics g) 
	{
		super.paint(g);
		ImageIcon icon = new ImageIcon("image/╪ссм.gif");
		g.drawImage(icon.getImage(), 0, 0, 400, 150, this);
	}
}
