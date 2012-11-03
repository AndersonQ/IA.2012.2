package ia.search;

import ia.City;
import ia.WeightCityLink;

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
	/** The goal */
	City goal;

	public UniformCostSearch(UndirectedGraph<City, WeightCityLink> graph, City goal)
	{
		this.graph = graph;
		this.goal = goal;
		this.orderedlist = new PriorityQueue<WeightCityLink>();
	}
	
	@Override
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
			list.add(edge);
		}
		
		return list;
	}

	@Override
	public SearchResult process(Object o) {
		City city = (City) o;
		
		//city is the goal!
		if(goal.getName().equals(city.getName()))
		{
			return new SearchResult(true);
		}
		//otherwise, fail
		return new SearchResult(false);
	}
}
