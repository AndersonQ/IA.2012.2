package ia;

public class City 
{
	protected String name;

	/**
	 * @param name
	 */
	public City(String name)
	{
		super();
		this.name = name;
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
	
	
}
