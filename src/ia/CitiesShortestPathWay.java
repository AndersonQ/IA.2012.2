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

import ia.search.SearchProblem;
import ia.search.SearchResult;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class CitiesShortestPathWay implements SearchProblem 
{
	UndirectedGraph<City, WeightCityLink> g;
	
	public CitiesShortestPathWay()
	{
		super();
		g = new SimpleGraph<City, WeightCityLink>(WeightCityLink.class);
	}

	public List<Object> expand(Object o) 
	{
		Set<WeightCityLink> s;
		List<Object> l = new LinkedList<Object>();
		City c = (City) o;
		
		s = g.edgesOf(c);
		
		for(WeightCityLink link: s)
		{
			if(!l.contains(link.getSource()))
				l.add(link.getSource());
			if(!l.contains(link.getTarget()))
				l.add(link.getTarget());
		}
		return l;
	}
	
	
	public SearchResult process(Object o) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
