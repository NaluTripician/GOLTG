import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TurnControler extends JFrame implements ActionListener
{
	private JButton next;
	private Container cp = getContentPane();
	private GameOfLifeTheGame gol;
	private int count = 1;

	public TurnControler (GameOfLifeTheGame g)
	{
		gol = g;

		setTitle("RED's Turn");
		setSize(500,100);
		setLocation(300,500);

		next = new JButton("Next Player's Turn");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		next.addActionListener(this);
		next.setBackground(new Color(255,105,97));
		next.setOpaque(true);

		cp.add(next,BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e)
	{
		gol.updateBoard();
		count++;

		if(count%2 == 0)
		{
			cp.removeAll();
			setTitle("BLUE's Turn");
			next.setBackground(new Color(174,198,255));
			next.setOpaque(true);
			cp.add(next,BorderLayout.CENTER);
		}
		else
		{
			cp.removeAll();
			setTitle("RED's Turn");
			next.setBackground(new Color(255,105,97));
			next.setOpaque(true);
			cp.add(next,BorderLayout.CENTER);
		}
	}


}
