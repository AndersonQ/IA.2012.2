/*
 * Copyright 2012 Anderson Queiroz <contato(at)andersonq(dot)eti(dot)br>
 * 					Fernando Zucatelli, João Coutinho, Tiago Queiroz <contato(at)tiago(dot)eti(dot)br>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
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
	City father;

	/**
	 * @param name
	 */
	public City(String name)
	{
		super();
		this.name = name;
		this.c = Colour.WHITE;
		father = null;
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
		City ct = (City) obj;
		
		return this.name.equalsIgnoreCase(ct.getName());
	}
	
	public Colour getColour()
	{
		return c;
	}

	public void setColour(Colour c)
	{
		this.c = c;
	}

    public City getFather()
    {
        return father;
    }

    public void setFather(City father)
    {
        this.father = father;
    }
}
