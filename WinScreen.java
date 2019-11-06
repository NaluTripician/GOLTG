import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class WinScreen extends JFrame
{
	private JTextField win;
	Container cp = getContentPane();

	public WinScreen(boolean winner)
	{
		setSize(500,600);
		setLocation(300,0);

		if(winner)
		{
			setTitle("RED WINS!");
			win = new JTextField("RED WINS");
			win.setBackground(new Color(255,0,0));
			win.setOpaque(true);
			cp.add(win,BorderLayout.CENTER);

		}
		else
		{
			setTitle("BLUE WINS!");
			win = new JTextField("BLUE WINS");
			win.setBackground(new Color(0,0,255));
			win.setOpaque(true);
			cp.add(win,BorderLayout.CENTER);
		}
	}
}
