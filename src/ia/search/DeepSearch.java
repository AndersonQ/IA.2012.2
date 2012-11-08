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
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class DeepSearch implements SearchProblem {
	
	/** The graph */
	private UndirectedGraph<City, WeightCityLink> graph;
	/** A stack to walk trough graph */ 
	private Stack<City> stack;
	/** The source city */
	City source;
	/** The target city */
	City target;
	
	/**
	 * Deep search to search problem
	 * @param graph
	 */
	public DeepSearch(UndirectedGraph<City, WeightCityLink> graph, City source, City target)
	{
		this.graph = graph;
		this.source = source;
		this.target = target;
		this.stack = new Stack<City>();
	}

	public void paint_white(UndirectedGraph<City,WeightCityLink> graph){

		Set<City>vertices = graph.vertexSet();

		for(City c:vertices){
			c.setColour(Colour.WHITE);
		}
	}

	public Stack run(City inicio, City fim){

		City temp, filho; 
		Set<WeightCityLink> vert_col ; //Collections de vértice
		stack.add(inicio); 
		paint_white(graph);

		while(!stack.empty()){ 
			temp = stack.pop();
			temp.setColour(Colour.GRAY);

			if(temp == fim){
				return stack;
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
		City node = (City) o;
		//A Set to keep neighbour
		Set<WeightCityLink> neighbour;
		//Get neighbours
		neighbour = graph.edgesOf(node);

		List<Object> l = new LinkedList<Object>();

		for(WeightCityLink edge : neighbour)
		{
			City source = edge.getSource();
			City target = edge.getTarget();
			
			if(source != node)
			{
				l.add(source);
			}
			if(target != node)
			{
				l.add(target);
			}
		}
		return l;
	}

	@Override
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
