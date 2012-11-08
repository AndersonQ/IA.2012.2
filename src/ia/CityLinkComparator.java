/*
 * Copyright 2012 Anderson Queiroz <contato(at)andersonq(dot)eti(dot)br>
 * 					Fernando Zucatelli, João Coutinho, Tiago Queiroz
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

import java.util.Comparator;

/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class CityLinkComparator implements Comparator<WeightCityLink> 
{

	public CityLinkComparator() 
	{
		// TODO Auto-generated constructor stub
	}

	public int compare(WeightCityLink arg0, WeightCityLink arg1) 
	{
		if(arg0.getWeight() < arg1.getWeight())
		{
			return -1;
		}
		if(arg0.getWeight() > arg1.getWeight())
		{
			return 1;
		}
		return 0;
	}
}
