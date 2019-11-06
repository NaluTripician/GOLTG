import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameOfLifeTheGame
{
	private GameOfLifeRules gol;
	private MainBoard mainBoard;
	private TurnControler turn;

	public Cell a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12;
	public Cell b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	public Cell c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
	public Cell d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12;
	public Cell e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12;
	public Cell f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12;
	public Cell g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12;
	public Cell h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11,h12;
	public Cell i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12;
	public Cell j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12;
	public Cell k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12;
	public Cell l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;

	private Cell dead = new Cell(-1);
	private Cell red = new Cell(1);
	private Cell blue = new Cell(0);

	public Cell[][] colony = {	{a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12},
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

	public GameOfLifeTheGame()
	{
		turn = new TurnControler(this);

		for(int i = 0; i < 12; i++)
		{
			for(int j = 0; j < 12; j++)
			{
				colony[i][j] = dead;
			}
		}

		colony[1][2] = blue;
		colony[1][3] = blue;
		colony[2][1] = blue;
		colony[2][4] = blue;
		colony[3][2] = blue;
		colony[3][4] = blue;
		colony[4][3] = blue;

		colony[1][9] = blue;
		colony[2][7] = blue;
		colony[2][10] = blue;
		colony[3][7] = blue;
		colony[3][10] = blue;
		colony[4][8] = blue;

		colony[7][8] = red;
		colony[7][9] = red;
		colony[8][7] = red;
		colony[8][10] = red;
		colony[9][7] = red;
		colony[9][9] = red;
		colony[10][8] = red;

		colony[7][3] = red;
		colony[8][1] = red;
		colony[8][4] = red;
		colony[9][1] = red;
		colony[9][4] = red;
		colony[10][2] = red;

		gol = new GameOfLifeRules(colony);
		mainBoard = new MainBoard(colony, this);

	}

	public void showB()
	{
		mainBoard.show();
		turn.show();
	}
	
	public int getCellState(int x, int y)
	{
		return colony[x][y].getTeam();
	}
	
	public void killCell(int x,int y)
	{
		colony[x][y] = dead;
		mainBoard.moveChanger(colony);
	}

	public void BirthRed(int x, int y)
	{
		colony[x][y] = red;
		mainBoard.moveChanger(colony);
	}

	public void BirthBlue(int x, int y)
	{
		colony[x][y] = blue;
		mainBoard.moveChanger(colony);
	}

	public void updateBoard()
	{
		colony = gol.update();

		mainBoard.Update(colony);
		mainBoard.show();

		this.checkWin();
	}

	public void checkWin()
	{
		if( (gol.hasMoreRed()) && !(gol.hasMoreBlue()) )
		{
			WinScreen r = new WinScreen(true);
			r.show();
			mainBoard.hide();
			turn.hide();
		}
		else if(!(gol.hasMoreRed()) && gol.hasMoreBlue())
		{
			WinScreen b = new WinScreen(false);
			b.show();
			mainBoard.hide();
			turn.hide();
		}
	}

	public static void main(String[] args) throws InterruptedException
	{

		GameOfLifeTheGame g = new GameOfLifeTheGame();
		g.showB();
	}
}
