package ia.tests;

import ia.Station;
import ia.Colour;
import ia.TimeStationLink;
import ia.search.SearchProblem;
import ia.search.SearchResult;

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
public class DeepSearchStations implements SearchProblem {
	
	/** The graph */
	private UndirectedGraph<Station, TimeStationLink> graph;
	/** A stack to walk trough graph */ 
	private Stack<Station> stack;
	/** The source Station */
	Station source;
	/** The target Station */
	Station target;
	
	/**
	 * Deep search to search problem
	 * @param graph
	 */
	public DeepSearchStations(UndirectedGraph<Station, TimeStationLink> graph, Station source, Station target)
	{
		this.graph = graph;
		this.source = source;
		this.target = target;
		this.stack = new Stack<Station>();
	}

	public void paint_white(UndirectedGraph<Station,TimeStationLink> graph){

		Set<Station>vertices = graph.vertexSet();

		for(Station c:vertices){
			c.setColour(Colour.WHITE);
		}
	}

//	public Stack run(Station inicio, Station fim){
//
//		Station temp, filho; 
//		Set<TimeStationLink> vert_col ; //Collections de vértice
//		stack.add(inicio); 
//		paint_white(graph);
//
//		while(!stack.empty()){ 
//			temp = stack.pop();
//			temp.setColour(Colour.GRAY);
//
//			if(temp == fim){
//				return stack;
//			}
//
//			vert_col = graph.edgesOf(temp);
//
//			for(TimeStationLink e: vert_col){
//				filho = e.getTarget();
//
//				if(filho.getColour().equals("WHITE")){
//					stack.add(filho);
//				}
//
//				temp.setColour(Colour.BLACK);;
//			}			
//		}
//		return null;
//	}

	public List<Object> expand(Object o)
	{
		//Cast to Station
		Station node = (Station) o;
		//A Set to keep neighbour
		Set<TimeStationLink> neighbour;
		//Get neighbours
		neighbour = graph.edgesOf(node);

		List<Object> l = new LinkedList<Object>();

		for(TimeStationLink edge : neighbour)
		{
			Station source = edge.getSource();
			Station target = edge.getTarget();
			
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

	public SearchResult process(Object o)
	{
		Station Station = (Station) o;
		//Station is the goal true, otherwise, fail
		return new SearchResult(this.target.getName().equals(Station.getName()));
	}

	public Station getSource() {
		return source;
	}

	public Station getTarget() {
		return target;
	}
	
}
