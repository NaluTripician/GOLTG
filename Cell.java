import java.awt.Color;

public class Cell
{
	private Color team;
	private Color red = new Color(255,0,0);
	private Color blue = new Color(0,0,255);
	private Color dead = new Color(143,143,143);
	private boolean state;

	public Cell(int c)
	{
		if(c == 1)
		{
			team = red;
			state = true;
		}
		else if(c == 0)
		{
			team = blue;
			state = true;
		}
		else if(c == -1)
		{
			team = dead;
			state = false;
		}
	}

	public void kill()
	{
		if(this.isAlive())
		{
			state = false;
			team = dead;
		}
		else{}
	}

	public void birth(int t)
	{
		state = true;
		if(t == 1)
		{
			team = red;
		}
		else if(t == 0)
		{
			team = blue;
		}
		else
		{
			state = false;
			team = dead;
		}
	}

	private void changeTeamRed()
	{
		team = red;
	}

	private void changeTeamBlue()
	{
		team = blue;
	}

	public void changeTeam(char t)
	{
		switch(t)
		{
			case 'r':
			{
				this.changeTeamRed();
			}
			case 'b':
			{
				this.changeTeamBlue();
			}
			case 'd':
			{
				team = dead;
			}
		}
	}

	public int getTeam()
	{
		if(team == red)
		{
			return 0;
		}
		else if(team == blue)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}

	public Color getColor()
	{
		return team;
	}

	public boolean isAlive()
	{
		return state;
	}

	public boolean isDead()
	{
		return !state;
	}

	public boolean isBlue()
	{
		if(team.equals(blue))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean isRed()
	{
		if(team.equals(red))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
