package ia.tests;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import ia.City;
import ia.Colour;
import ia.WeightCityLink;
import ia.search.SearchProblem;
import ia.search.SearchResult;
import ia.search.UniformCostSearch;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class UniformCostTest {

	UndirectedGraph<City, WeightCityLink> graph;
	Set<City> cities;
	UniformCostSearch uni;
	
	public UniformCostTest(UndirectedGraph<City, WeightCityLink> graph)
	{
		this.graph = graph;
		
		cities = graph.vertexSet();
		Object[] citiesarray = cities.toArray();
		
		System.out.println("\nTesting UniformCostSearch nodes expansion...");
		
		for(int i = 0; i < 5; i++)
		{
			City city = (City) citiesarray[i];
			
			uni = new UniformCostSearch(graph, city, city);
			
			System.out.println("\nCity " + city);
			Set<WeightCityLink> neighbour = graph.edgesOf(city);
			System.out.println("Edges: " + neighbour);
			System.out.println("Ordered by cost: " + uni.expand(city));			
		}
		
		UndirectedGraph<City, WeightCityLink> g = new SimpleGraph<City, WeightCityLink>(WeightCityLink.class);
        City ct1,ct2,ct3,ct4,ct5,ct6,ct7,ct8;
                
        ct1 = new City("Barueri");
        ct2 = new City("Diadema");
        ct3 = new City("Guarulhos");
        ct4 = new City("Franco da Rocha");
        ct5 = new City("Mauá");
        ct6 = new City("Santo André");
        ct7 = new City("São Paulo");
        ct8 = new City("Taboão da Serra");

        g.addVertex(ct1);
        g.addVertex(ct2);
        g.addVertex(ct3);
        g.addVertex(ct4);
        g.addVertex(ct5);
        g.addVertex(ct6);
        g.addVertex(ct7);
        g.addVertex(ct8);

        g.addEdge(ct1, ct4, new WeightCityLink(g, 1) );
        g.addEdge(ct1, ct8, new WeightCityLink(g, 1) );

        g.addEdge(ct2, ct6, new WeightCityLink(g, 1) );
        g.addEdge(ct2, ct7, new WeightCityLink(g, 1) );
        g.addEdge(ct2, ct8, new WeightCityLink(g, 1) );

        g.addEdge(ct3, ct4, new WeightCityLink(g, 1) );
        g.addEdge(ct3, ct7, new WeightCityLink(g, 1) );

        g.addEdge(ct4, ct1, new WeightCityLink(g, 1) );
        g.addEdge(ct4, ct3, new WeightCityLink(g, 1) );
        g.addEdge(ct4, ct7, new WeightCityLink(g, 1) );

        g.addEdge(ct5, ct6, new WeightCityLink(g, 1) );
        g.addEdge(ct5, ct7, new WeightCityLink(g, 1) );

        g.addEdge(ct6, ct2, new WeightCityLink(g, 1) );
        g.addEdge(ct6, ct5, new WeightCityLink(g, 1) );
        g.addEdge(ct6, ct7, new WeightCityLink(g, 1) );

        g.addEdge(ct7, ct2, new WeightCityLink(g, 1) );
        g.addEdge(ct7, ct3, new WeightCityLink(g, 1) );
        g.addEdge(ct7, ct5, new WeightCityLink(g, 1) );
        g.addEdge(ct7, ct6, new WeightCityLink(g, 1) );
        g.addEdge(ct7, ct8, new WeightCityLink(g, 1) );

        g.addEdge(ct8, ct1, new WeightCityLink(g, 1) );
        g.addEdge(ct8, ct2, new WeightCityLink(g, 1) );
        g.addEdge(ct8, ct7, new WeightCityLink(g, 1) );

		System.out.print("\nSolving a problem: ");
        
		/*
         * Loop to solve the problem
         */

        /* Auxiliar data structs */
		Queue<City> list = new LinkedList<City>();
        City c = null;
        List<Object> cl = null;
        SearchResult r = null;
        ct3 = (City) citiesarray[0];
        ct2 = (City) citiesarray[2];
        g = graph;

        System.out.printf("Trying to go to: %s from %s\n", ct3, ct2);
        SearchProblem sp = new UniformCostSearch(g, ct3, ct2);
        
        list.add(ct2);
        while(!list.isEmpty())
        {
            /* Expand */
            //c = list.pop();
        	c = list.remove();
            c.setColour(Colour.GRAY);
            cl = sp.expand(c);

            /* Put all non processed nodes in the queue */
            for(Object node: cl)
            {
                if( ((City)node).getColour() == Colour.WHITE)
                    list.add((City)node);

                /* Set the father of the expanded node to c */
                if( (((City)node).getFather() == null) )
                    ((City)node).setFather(c);
            }

            /* If c is NOT BLACK process it and make it BLACK */
            if( c.getColour() != Colour.BLACK)
            {
                r = sp.process(c);
                c.setColour(Colour.BLACK);
            }

            /* If success break */
            if(r.isSuccess())
                break;
        }

        /* If the loop ended in success, build the path */
        if(r.isSuccess())
        {
            System.out.println("Destiny: \"" + c + "\" found!");
            List<City> rpath = new LinkedList<City>();
            List<City> path = new LinkedList<City>();

            /*
             * Build the path form source to destiny
             */
            while(!((UniformCostSearch)sp).getSource().equals(c))
            {
                rpath.add(c);
                c = c.getFather();
            }

            /* Reverse the path */
            path.add(((UniformCostSearch)sp).getSource());
            for(int i = rpath.size() - 1; i >=0; i--)
                path.add(rpath.get(i));

            /* Print the path */
            System.out.printf("\nPath from %s to %s is:\n", ((UniformCostSearch)sp).getSource(), ((UniformCostSearch)sp).getTarget());
            for(City vc: path)
                System.out.println(vc);
        }
        else
            System.out.printf("Destiny not found!\n");
    }
	
}
