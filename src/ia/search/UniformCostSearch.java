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

package ia.search;

import ia.City;
import ia.WeightCityLink;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import org.jgrapht.UndirectedGraph;


/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class UniformCostSearch implements SearchProblem{
	
	/** The graph */
	private UndirectedGraph<City, WeightCityLink> graph;
	/** A ordered list to choose the low cost edge */
	PriorityQueue<WeightCityLink> orderedlist;
	//List<City> orderedlist;
	/** The source city */
	City source;
	/** The target city */
	City target;

	public UniformCostSearch(UndirectedGraph<City, WeightCityLink> graph, City source, City target)
	{
		this.graph = graph;
		this.target = target;
		this.source = source;
		this.orderedlist = new PriorityQueue<WeightCityLink>();
	}
	
	public List<Object> expand(Object o) {
		//Cast to city
		City node = (City) o;
		//A Set to keep neighbour
		Set<WeightCityLink> neighbour;
		//The list to be returned
		List<Object> list = new LinkedList<Object>();
		
		//Get neighbours
		neighbour = graph.edgesOf(node);
		
		for(WeightCityLink c : neighbour)
		{
			if(!orderedlist.contains(c))
			{
				orderedlist.add(c);
			}
		}
		
		//Copy all elements in ordered list to list
		for(WeightCityLink edge: orderedlist)
		{
			City source = edge.getSource();
			City target = edge.getTarget();
			
			if(source != node)
			{
				list.add(source);
			}
			if(target != node)
			{
				list.add(target);
			}
		}
		
		return list;
	}

	public SearchResult process(Object o) {
		City city = (City) o;
		//city is the goal true, otherwise, fail
		return new SearchResult(this.target.getName().equals(city.getName()));
	}

	public City getSource() {
		return source;
	}

	public City getTarget() {
		return target;
	}
	
	
}
