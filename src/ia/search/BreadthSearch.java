package ia.search;

import ia.City;
import ia.Colour;
import ia.WeightCityLink;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.UndirectedGraph;

public class BreadthSearch implements SearchProblem {

	/** The graph */
	private UndirectedGraph<City, WeightCityLink> graph;
	/** A stack to walk trough graph */ 
	private List<City> list;
	
	/**
	 * Deep search to search problem
	 * @param graph
	 */
	public BreadthSearch(UndirectedGraph<City, WeightCityLink> graph)
	{
		this.graph = graph;
		this.list = new LinkedList<City>();
	}
	
	public void paint_white(UndirectedGraph<City,WeightCityLink> graph){
		
		 Set<City>vertices = graph.vertexSet();
		 
		 for(City c:vertices){
			 c.setColour(Colour.WHITE);		 
		 }
		}
	
	public List run(City inicio, City fim){
		City temp, filho; 
		Set<WeightCityLink> vert_col ; //Collections de v������rtice
		paint_white(graph);
		list.add(inicio); 
		
		inicio.setColour(Colour.GRAY);
		
		while(!list.isEmpty()){
			temp = list.remove(0);//Retira da fila
			vert_col = graph.edgesOf(temp); //
			
			if(temp == fim){
				return list;
			}
			
			for(WeightCityLink e:vert_col){
				filho = e.getTarget();
				
				if(filho.getColour() == Colour.WHITE){
					filho.setColour(Colour.GRAY);
					list.add(filho);	
				}
				temp.setColour(Colour.BLACK);
			}
		}
		return null;
	}
	
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

	public SearchResult process(Object o) {
		
		
		
		return null;
	}


}
