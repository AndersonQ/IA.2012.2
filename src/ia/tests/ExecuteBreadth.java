package ia.tests;

import ia.City;
import ia.Colour;
import ia.WeightCityLink;
import ia.search.DeepSearch;
import ia.search.SearchProblem;
import ia.search.SearchResult;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

public class ExecuteBreadth
{
    UndirectedGraph<City, WeightCityLink> g;
    City source, destiny;
    String[] cityNames;

    City cities[];
    public ExecuteBreadth()
    {
        /*
         * Build a vector with the cities names.
         */
        cityNames = new String[8];

        cityNames[0] = new String ("Barueri");
        cityNames[1] = new String ("Diadema");
        cityNames[2] = new String ("Guarulhos");
        cityNames[3] = new String ("Franco da Rocha");
        cityNames[4] = new String ("Mauá");
        cityNames[5] = new String ("Santo André");
        cityNames[6] = new String ("São Paulo");
        cityNames[7] = new String ("Taboão da Serra");

        /*
         * Build graph
         */
        g = new SimpleGraph<City, WeightCityLink>(WeightCityLink.class);

        cities = new City[8];

        cities[0] = new City("Barueri");
        cities[1] = new City("Diadema");
        cities[2] = new City("Guarulhos");
        cities[3] = new City("Franco da Rocha");
        cities[4] = new City("Mauá");
        cities[5] = new City("Santo André");
        cities[6] = new City("São Paulo");
        cities[7] = new City("Taboão da Serra");

        g.addVertex(cities[0]);
        g.addVertex(cities[1]);
        g.addVertex(cities[2]);
        g.addVertex(cities[3]);
        g.addVertex(cities[4]);
        g.addVertex(cities[5]);
        g.addVertex(cities[6]);
        g.addVertex(cities[7]);

        g.addEdge(cities[0], cities[3], new WeightCityLink(g, 1) );
        g.addEdge(cities[0], cities[7], new WeightCityLink(g, 1) );

        g.addEdge(cities[1], cities[5], new WeightCityLink(g, 1) );
        g.addEdge(cities[1], cities[6], new WeightCityLink(g, 1) );
        g.addEdge(cities[1], cities[7], new WeightCityLink(g, 1) );

        g.addEdge(cities[2], cities[3], new WeightCityLink(g, 1) );
        g.addEdge(cities[2], cities[6], new WeightCityLink(g, 1) );

        g.addEdge(cities[3], cities[0], new WeightCityLink(g, 1) );
        g.addEdge(cities[3], cities[2], new WeightCityLink(g, 1) );
        g.addEdge(cities[3], cities[6], new WeightCityLink(g, 1) );

        g.addEdge(cities[4], cities[5], new WeightCityLink(g, 1) );
        g.addEdge(cities[4], cities[6], new WeightCityLink(g, 1) );

        g.addEdge(cities[5], cities[1], new WeightCityLink(g, 1) );
        g.addEdge(cities[5], cities[4], new WeightCityLink(g, 1) );
        g.addEdge(cities[5], cities[6], new WeightCityLink(g, 1) );

        g.addEdge(cities[6], cities[1], new WeightCityLink(g, 1) );
        g.addEdge(cities[6], cities[2], new WeightCityLink(g, 1) );
        g.addEdge(cities[6], cities[4], new WeightCityLink(g, 1) );
        g.addEdge(cities[6], cities[5], new WeightCityLink(g, 1) );
        g.addEdge(cities[6], cities[7], new WeightCityLink(g, 1) );

        g.addEdge(cities[7], cities[0], new WeightCityLink(g, 1) );
        g.addEdge(cities[7], cities[1], new WeightCityLink(g, 1) );
        g.addEdge(cities[7], cities[6], new WeightCityLink(g, 1) );
    }

    public void run(int src, int dest) throws Exception
    {
        if((src < 0) || (src >= 8) || (dest < 0) || (dest >=8))
            throw new Exception("Source or destiny not found!");

        source = cities[src];
        destiny = cities[dest];

        System.out.print("\nSolving a problem: ");

        /*
         * Loop to solve the problem
         */

        /* Auxiliar data structs */
        Queue<City> stack = new LinkedList<City>();
        City c = null;
        List<Object> cl = null;
        SearchResult r = null;

        System.out.printf("Buscando caminho de %s para %s\n", source, destiny);
        SearchProblem sp = new DeepSearch(g, cities[src], cities[dest]);

        stack.add(cities[src]);
        while(!stack.isEmpty())
        {
            /* Expand */
            //c = list.pop();
            c = stack.remove();
            c.setColour(Colour.GRAY);
            cl = sp.expand(c);

            /* Put all non processed nodes in the queue */
            for(Object node: cl)
            {
                if( ((City)node).getColour() == Colour.WHITE)
                    stack.add((City)node);

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
            while(!((DeepSearch)sp).getSource().equals((Object)c))
            {
                rpath.add(c);
                c = c.getFather();
            }

            /* Reverse the path */
            path.add(((DeepSearch)sp).getSource());
            for(int i = rpath.size() - 1; i >=0; i--)
                path.add(rpath.get(i));

            /* Print the path */
            System.out.printf("\nPath from %s to %s is:\n", ((DeepSearch)sp).getSource(), ((DeepSearch)sp).getTarget());
            for(City vc: path)
                System.out.println(vc);
        }
        else
            System.out.printf("Destiny not found!\n");
    }

    public String[] getCityNames()
    {
        return cityNames;
    }
}
