package ia.search;

import ia.City;
import ia.Colour;
import ia.WeightCityLink;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

public class ExecuteGreedy
{
    UndirectedGraph<City, WeightCityLink> g;
    City source, destiny;
    String[] cityNames;

    City cities[];

    double h [][] = {{0.0, 41.7, 43.2, 41.3, 59.7, 51.1, 37.7, 28.8},
            {41.7, 00.0, 38.8, 61.8, 32.5, 12.3, 22.1, 18.3},
            {43.2, 38.8, 00.0, 45.2, 35.0, 36.0, 19.2, 44.2},
            {41.3, 61.8, 45.2, 00.0, 71.1, 70.4, 45.2, 52.2},
            {59.7, 32.5, 35.0, 71.1, 00.0, 09.3, 28.7, 44.9},
            {51.1, 12.3, 36.0, 70.4, 09.3, 00.0, 20.2, 34.8},
            {37.7, 22.1, 19.2, 45.2, 28.7, 20.2, 00.0, 18.2},
            {28.8, 18.3, 44.2, 52.2, 44.9, 34.8, 18.2, 00.0}};

    public ExecuteGreedy()
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
        /*
         * Loop to solve the problem
         */

        /* Auxiliary data structs */
        Stack<City> s = new Stack<City>();
        City c = null;
        List<Object> cl = null;
        SearchResult r = null;
        //Diadema -> Guarulhos
        System.out.printf("Trying to go to: %s from %s\n", destiny, source);
        SearchProblem sp = new GreedySearch(g, source, destiny, h);
        s.push(source);
        while(!s.empty())
        {
            /* Expand */
            c = s.pop();
            c.setColour(Colour.GRAY);
            cl = sp.expand(c);

            /* Put all non processed nodes in the stack */
            for(Object node: cl)
            {
                if( ((City)node).getColour() == Colour.WHITE)
                    s.push((City)node);

                /* Set the father of the expanded node to c */
                if( (((City)node).getFather() == null) )
                    ((City)node).setFather(c);
            }

            /* If c is not BLACK process it and make it BLACK */
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
            while(!((GreedySearch)sp).getSource().equals(c))
            {
                rpath.add(c);
                c = c.getFather();
            }

            /* Reverse the path */
            path.add(((GreedySearch)sp).getSource());
            for(int i = rpath.size() - 1; i >=0; i--)
                path.add(rpath.get(i));

            /* Print the path */
            System.out.printf("\nPath from %s to %s is:\n", ((GreedySearch)sp).getSource(), ((GreedySearch)sp).getDestiny());
            for(City vc: path)
                System.out.println(vc);
        }
        else
            System.out.printf("Destiny not found!\n");
    }
}
