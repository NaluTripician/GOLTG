import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainBoard extends JFrame
{

	private Cell[][] colony;

	private GameOfLifeTheGame gol;

	private int count = 0;

	private JButton a1 = new JButton(),a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	private JButton c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
	private JButton d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12;
	private JButton e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12;
	private JButton f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12;
	private JButton g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12;
	private JButton h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12;
	private JButton i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12;
	private JButton j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12;
	private JButton k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12;
	private JButton l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;

	private JButton[][] buttonArray = {	{a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12},
										{b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12},
										{c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12},
										{d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12},
										{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12},
										{f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12},
										{g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12},
										{h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12},
										{i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12},
										{j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12},
										{k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12},
										{l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12}};


	Container cp = getContentPane();

	public MainBoard(Cell[][] cells, GameOfLifeTheGame r)
	{
		colony = cells;
		gol = r;

		setTitle("Game of Life: The Game");
		setSize(500,500);
		setLocation(300,0);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		cp.setLayout(new GridLayout(12,12,5,5));

		for(int i = 0; i <12; i++)
		{
			for(int j = 0; j <12; j++)
			{
				buttonArray[i][j] = new JButton();
				(buttonArray[i][j]).setBackground((colony[i][j]).getColor());
				(buttonArray[i][j]).setOpaque(true);
				(buttonArray[i][j]).setBorderPainted(false);
				cp.add(buttonArray[i][j]);
				buttonArray[i][j].addActionListener(new stateCycle(i,j));
			}
		}
	}

	public void moveChanger(Cell[][] c)
	{
		colony = c;
		for(int i = 0; i <12; i++)
		{
			for(int j = 0; j <12; j++)
			{
				(buttonArray[i][j]).setBackground((colony[i][j]).getColor());
				cp.add(buttonArray[i][j]);
			}
		}
		this.show();
	}

	public void Update(Cell[][] cells)
	{
		colony = cells;

		cp.removeAll();

		cp.setLayout(new GridLayout(12,12,5,5));

		for(int i = 0; i <12; i++)
		{
			for(int j = 0; j <12; j++)
			{
				buttonArray[i][j] = new JButton();
				(buttonArray[i][j]).setBackground((colony[i][j]).getColor());
				(buttonArray[i][j]).setOpaque(true);
				(buttonArray[i][j]).setBorderPainted(false);
				cp.add(buttonArray[i][j]);
				buttonArray[i][j].addActionListener(new stateCycle(i,j));
			}
		}

	}


	class stateCycle implements ActionListener
	{
		private int x;
		private int y;

		public stateCycle(int a,int b)
		{
			super();
			x=a;
			y=b;
		}

		public void actionPerformed(ActionEvent e)
		{
			count = gol.getCellState(x, y);
			
			if(count == 0)
			{
				gol.killCell(x,y);
			}
			else if(count == 1)
			{
				gol.BirthRed(x,y);
			}
			else if(count == -1)
			{

				gol.BirthBlue(x, y);
			}
		}
	}


}
