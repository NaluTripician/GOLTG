public class GameOfLifeRules
{

	private int numnextto;
	private int redFriend = 0;
	private int blueFriend = 0;

	private boolean hasMoreRed, hasMoreBlue;

	private Cell [][] colony;
	private Cell [][] newcolony;
	private Cell dead = new Cell(-1);
	private Cell red = new Cell(1);
	private Cell blue = new Cell(0);

	String result;

//Constructor
	public GameOfLifeRules(Cell[][] StartBoard)
    {
          colony = StartBoard;
          newcolony = new Cell[colony.length][colony[0].length];
          for(int i = 0; i < colony.length; i++)
          {
                for (int j = 0; j < colony[i].length; j++)
                {
                      newcolony[i][j] = dead;
                }
          }

    }

//Update method- updates colony after time passes
	public Cell[][] update()
	{
		for(int j = 0; j < ((colony.length)-1); j++)
		{

			for(int f= 0; f < ((colony.length)-1); f++)
			{
				numnextto = 0;
				redFriend = 0;
				blueFriend = 0;

				//up left
				try
				{
					if((colony[j-1][f-1]).isAlive())
					{
						numnextto++;

						if((colony[j-1][f-1]).isRed())
						{
							redFriend++;
						}
						else if((colony[j-1][f-1]).isBlue())
						{
							blueFriend++;
						}
					}
				}
				catch(Exception e){}


				//up
				try
				{
					if((colony[j-1][f]).isAlive())//no work
					{
						numnextto++;

						if((colony[j-1][f]).isRed())
						{
							redFriend++;
						}
						else if((colony[j-1][f]).isBlue())
						{
							blueFriend++;
						}
					}
				}
				catch(Exception e){}

				//up right
				try
				{
					if((colony[j-1][f+1]).isAlive())//no work
					{

						numnextto++;
						if((colony[j-1][f+1]).isRed())
						{
							redFriend++;
						}
						else if((colony[j-1][f+1]).isBlue())
						{
							blueFriend++;
						}
					}
				}
				catch(Exception e){}

				//left
				try
				{
					if((colony[j][f-1]).isAlive())
					{
						numnextto++;

						if((colony[j][f-1]).isRed())
						{
							redFriend++;
						}
						else if((colony[j][f-1]).isBlue())
						{
							blueFriend++;
						}
					}
				}
				catch(Exception e){}

				//right
				try
				{
					if((colony[j][f+1]).isAlive())
					{
						numnextto++;

						if((colony[j][f+1]).isRed())
						{
							redFriend++;
						}
						else if((colony[j][f+1]).isBlue())
						{
							blueFriend++;
						}
					}
				}
				catch(Exception e){}

				//down left
				try
				{
					if((colony[j+1][f-1]).isAlive())
					{
						numnextto++;

						if((colony[j+1][f-1]).isRed())
						{
							redFriend++;
						}
						else if((colony[j+1][f-1]).isBlue())
						{
							blueFriend++;
						}
					}
				}
				catch(Exception e){}

				//down
				try
				{
					if((colony[j+1][f]).isAlive())
					{
						numnextto++;

						if((colony[j+1][f]).isRed())
						{
							redFriend++;
						}
						else if((colony[j+1][f]).isBlue())
						{
							blueFriend++;
						}
					}
				}
				catch(Exception e){}

				//down right
				try
				{
					if((colony[j+1][f+1]).isAlive())
					{
						numnextto++;

						if((colony[j+1][f+1]).isRed())
						{
							redFriend++;
						}
						else if((colony[j+1][f+1]).isBlue())
						{
							blueFriend++;
						}
					}
				}
				catch(Exception e){}

				//Check for new Cell
				try
				{
					if((colony[j][f]).isDead())
					{
						if(numnextto == 3)
						{

							if(redFriend > blueFriend)
							{
								newcolony[j][f] = red;
							}
							else if(blueFriend > redFriend)
							{
								newcolony[j][f] = blue;
							}
							else
							{
								if(Math.random() > .49)
								{
									newcolony[j][f] = red;
								}
								else
								{
									newcolony[j][f] = blue;
								}
							}
						}
						else
						{
							newcolony[j][f] = dead;
						}
					}
					else
					{
						if(numnextto == 2 || numnextto == 3)
						{
							newcolony[j][f] = colony[j][f];
						}
						else if(numnextto < 2)
						{
							newcolony[j][f] = dead;
						}

						else if(numnextto > 3)
						{
							newcolony[j][f] = dead;
						}

					}
				}
				catch(Exception e){}

			}
		}

		for(int j = 0; j<((colony.length)-1); j++)
		{
			for(int f=0; f<((colony.length)-1); f++)
			{
				colony[j][f] = newcolony[j][f];

			}
		}

		return colony;
	}

	public boolean hasMoreRed()
	{
		hasMoreRed = false;
		for(int j = 0; j<12; j++)
		{
			for(int f=0; f<12; f++)
			{
				if((colony[j][f].getTeam() == 0) && (colony[j][f].isAlive()))
				{
					hasMoreRed = true;
					break;
				}
			}
		}
		return hasMoreRed;
	}

	public boolean hasMoreBlue()
	{
		hasMoreBlue = false;
		for(int j = 0; j<12; j++)
		{
			for(int f=0; f<12; f++)
			{
				if((colony[j][f].getTeam() == 1) && (colony[j][f].isAlive()))
				{
					hasMoreBlue = true;
					break;
				}
			}
		}
		return hasMoreBlue;
	}
}
