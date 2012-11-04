package ia.tests;

import java.util.Set;

import ia.City;
import ia.WeightCityLink;
import ia.search.UniformCostSearch;

import org.jgrapht.UndirectedGraph;

public class UniformCostTest {

	UndirectedGraph<City, WeightCityLink> graph;
	Set<City> cities;
	UniformCostSearch uni;
	
	public UniformCostTest(UndirectedGraph<City, WeightCityLink> graph)
	{
		this.graph = graph;
		
		
		cities = graph.vertexSet();
		Object[] citiesarray = cities.toArray();
		
		System.out.println("\nTesting UniformCostSearch...");
		
		for(int i = 0; i < 5; i++)
		{
			City city = (City) citiesarray[i];
			
			uni = new UniformCostSearch(graph, city);
			
			System.out.println("\nCity " + city);
			Set<WeightCityLink> neighbour = graph.edgesOf(city);
			System.out.println("Edges: " + neighbour);
			System.out.println("Ordered by cost: " + uni.expand(city));
		}
	}
	
}
