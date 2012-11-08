/*
 * Copyright 2012 Anderson Queiroz <contato(at)andersonq(dot)eti(dot)br>
 * 					Fernando Zucatelli, João Coutinho, Tiago Queiroz
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package ia.execute;

import ia.City;
import ia.Colour;
import ia.WeightCityLink;
import ia.search.DeepSearch;
import ia.search.SearchProblem;
import ia.search.SearchResult;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class ExecuteDeep implements Execute{
    UndirectedGraph<City, WeightCityLink> g;
    City source, destiny;
    String[] cityNames;

    City cities[];

	public ExecuteDeep()
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
        System.out.printf("Buscando caminho de %s para %s\n", source, destiny);
        SearchProblem sp = new DeepSearch(g, source, destiny);
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
            System.out.println("Destino: \"" + c + "\" encontrado!");
            List<City> rpath = new LinkedList<City>();
            List<City> path = new LinkedList<City>();

            /*
             * Build the path form source to destiny
             */
            while(!((DeepSearch)sp).getSource().equals(c))
            {
                rpath.add(c);
                c = c.getFather();
            }

            /* Reverse the path */
            path.add(((DeepSearch)sp).getSource());
            for(int i = rpath.size() - 1; i >=0; i--)
                path.add(rpath.get(i));

            /* Print the path */
            System.out.printf("\nCaminho de %s para %s is:\n", ((DeepSearch)sp).getSource(), ((DeepSearch)sp).getTarget());
            for(City vc: path)
                System.out.println(vc);
        }
        else
            System.out.printf("Destino não encontrado!\n");
    }

    public String[] getCityNames()
    {
        return cityNames;
    }
}
