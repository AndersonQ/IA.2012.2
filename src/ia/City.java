package ia;

/**
 * Class to represent node
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class City
{
	protected String name;
	public Colour c;

	/**
	 * @param name
	 */
	public City(String name)
	{
		super();
		this.name = name;
		this.c = Colour.WHITE;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	@Override
	public String toString() 
	{
		return new String(name);
	}

	@Override
	public boolean equals(Object obj) 
	{
		City c = (City) obj;
		
		return this.name.equalsIgnoreCase(c.getName());
	}
	
	public Colour getColour()
	{
		return c;
	}

	public void setColour(Colour c)
	{
		this.c = c;
	}
}
