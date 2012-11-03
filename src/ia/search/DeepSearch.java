package ia.search;

import ia.City;
import ia.Colour;
import ia.WeightCityLink;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.UndirectedGraph;

/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, Jo��o Coutinho, Tiago Queiroz
 *
 */





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
	
	public City run(City inicio, City fim){
		City temp, filho; 
		Set<WeightCityLink> vert_col ; //Collections de vértice
		stack.add(inicio); 
		
		while(!stack.empty()){ 
			temp = stack.pop();
			temp.setColour(Colour.GRAY);
			
			if(temp == fim){
				return temp;
			}
			
			vert_col = graph.edgesOf(temp);
			
			for(WeightCityLink e: vert_col){
				filho = e.getTarget();
				
				if(filho.c.equals("WHITE")){
					stack.add(filho);
				}
				
				temp.setColour(Colour.BLACK);;
				
			}			
			
			
			
		}
		
		return null;
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