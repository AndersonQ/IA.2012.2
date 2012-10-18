package ia;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.UndirectedGraph;

public class DeepSearch implements SearchProblem {

	/** The graph */
	private UndirectedGraph<City, WeightCityLink> graph;
	/** A stack to walk trough graph */ 
	private Stack<City> stack;
	
	/**
	 * Deep search to search problem
	 * @param graph
	 */
	public DeepSearch(UndirectedGraph<City, WeightCityLink> graph)
	{
		this.graph = graph;
		this.stack = new Stack<City>();
	}
	
	@Override
	public List<Object> expand(Object o) {
		//Cast to city
		City city = (City) o;
		//A Set to keep neighbour
		Set<WeightCityLink> neighbour;
		//Get neighbours
		neighbour = graph.edgesOf(city);
		
		List<Object> l = new LinkedList<Object>();
		
		for(WeightCityLink c : neighbour)
		{
			if(!l.contains(c.getTarget()))
			{
				l.add(c);
			}
		}
		
		return l;
	}

	@Override
	public SearchResult process(Object o) {
		
		return null;
	}

}