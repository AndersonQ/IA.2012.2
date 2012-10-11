package ia;

import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

public class UndirectedTests 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		UndirectedGraph<City, WeightCityLink> g = new SimpleGraph<City, WeightCityLink>(WeightCityLink.class);
		City c1, c2, c3, c4;
		
		c1 = new City("Recife");
		c2 = new City("Natal");
		c3 = new City("Florianópolis");
		c4 = new City("Olinda");
		
		g.addVertex(c1);
		g.addVertex(c2);
		g.addVertex(c3);
		g.addVertex(c4);
		
		g.addEdge(c1, c4, new WeightCityLink(g, 7));
		g.addEdge(c1, c3, new WeightCityLink(g, 3300));
		g.addEdge(c4, c2, new WeightCityLink(g, 281));
		g.addEdge(c3, c4, new WeightCityLink(g, 3320));
		
		Set<WeightCityLink> s;
		
		s = g.edgeSet();
		
		System.out.printf("Printing Edges:\n");
		for(WeightCityLink l: s)
			System.out.println(l);
		
		System.out.printf("\n\nPrining Sources and Targets:\n");
		for(WeightCityLink l: s)
		{
			System.out.print("From: " + l.getSource() + " to: " + l.getTarget());
			System.out.println(" weight: " + l.getWeight());
		}
	}

}
