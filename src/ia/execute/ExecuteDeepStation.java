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

import ia.Station;
import ia.Colour;
import ia.TimeStationLink;
import ia.search.DeepSearch;
import ia.search.SearchProblem;
import ia.search.SearchResult;
import ia.search.UniformCostSearch;
import ia.tests.DeepSearchStations;

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
public class ExecuteDeepStation
{
    public ExecuteDeepStation()
    {
    }

    public void run(int src)
    {

        UndirectedGraph<Station, TimeStationLink> g = new SimpleGraph<Station, TimeStationLink>(TimeStationLink.class);
        Station e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16;

        e1 = new Station("CPTM Santo André");
        e2 = new Station("EMTU Santo André");
        e3 = new Station("CPTM Bras");  
        e4 = new Station("Metro Jabaquara");
        e5 = new Station("CPTM Tamanduatei");
        e6 = new Station("Metro República");
        e7 = new Station("Metro Luz");
        e8 = new Station("Metro Consolação");
        e9 = new Station("Metro Barra Funda");
        e10 = new Station("Metro Butantã"); 
        e11 = new Station("Metro Pinheiros");
        e12 = new Station("CPTM Presidente Altino");    
        e13 = new Station("CPTM Osasco");   
        e14 = new Station("Onibus 8022-10");
        e15 = new Station("CPTM Cidade Universitária");
        e16 = new Station("USP");

        g.addVertex(e1);
        g.addVertex(e2);
        g.addVertex(e3);
        g.addVertex(e4);
        g.addVertex(e5);
        g.addVertex(e6);
        g.addVertex(e7);
        g.addVertex(e8);
        g.addVertex(e9);
        g.addVertex(e10);
        g.addVertex(e11);
        g.addVertex(e12);
        g.addVertex(e13);
        g.addVertex(e14);
        g.addVertex(e15);
        g.addVertex(e16);

        /*==================Dados das conexções de tempo - TimeStationLink=======*/
        g.addEdge(e1, e3, new TimeStationLink(g, 30) );
        g.addEdge(e1, e5, new TimeStationLink(g, 20) );

        g.addEdge(e2, e4, new TimeStationLink(g, 45) );

        g.addEdge(e3, e6, new TimeStationLink(g, 10) );
        g.addEdge(e3, e7, new TimeStationLink(g, 7) );
        g.addEdge(e3, e9, new TimeStationLink(g, 12) );

        g.addEdge(e4, e7, new TimeStationLink(g, 20) );

        g.addEdge(e5, e8, new TimeStationLink(g, 20) );

        g.addEdge(e6, e10, new TimeStationLink(g, 15) );
        g.addEdge(e6, e11, new TimeStationLink(g, 13) );

        g.addEdge(e7, e10, new TimeStationLink(g, 20) );
        g.addEdge(e7, e11, new TimeStationLink(g, 16) );

        g.addEdge(e8, e10, new TimeStationLink(g, 12) );

        g.addEdge(e9, e12, new TimeStationLink(g, 12) );
        g.addEdge(e9, e13, new TimeStationLink(g, 16) );

        g.addEdge(e10, e14, new TimeStationLink(g, 15) );

        g.addEdge(e11, e15, new TimeStationLink(g, 6) );

        g.addEdge(e12, e15, new TimeStationLink(g, 10) );

        g.addEdge(e13, e15, new TimeStationLink(g, 10) );

        g.addEdge(e14, e16, new TimeStationLink(g, 0) );

        g.addEdge(e15, e16, new TimeStationLink(g, 0) );

        /*
         * Loop to solve the problem
         */

        /* Auxiliar data structs */
        Stack<Station> stack = new Stack<Station>();
        Station c = null;
        List<Object> cl = null;
        SearchResult r = null;
        SearchProblem sp;
        
        if(src == 1)
        {
            System.out.printf("Indo de %s para %s\n", e1, e16);
            sp = new DeepSearchStations(g, e1, e16);
            stack.push(e1);
        }
        else
        {
            System.out.printf("Indo de %s para %s\n", e2, e16);
            sp = new DeepSearchStations(g, e2, e16);
            stack.push(e2);
        }

        while(!stack.isEmpty())
        {
            /* Expand */
            c = stack.pop();
            c.setColour(Colour.GRAY);
            cl = sp.expand(c);

            /* Put all non processed nodes in the queue */
            for(Object node: cl)
            {
                if( ((Station)node).getColour() == Colour.WHITE)
                    stack.push((Station)node);

                /* Set the father of the expanded node to c */
                if( (((Station)node).getFather() == null) )
                    ((Station)node).setFather(c);
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
            List<Station> rpath = new LinkedList<Station>();
            List<Station> path = new LinkedList<Station>();

            /*
             * Build the path form source to destiny
             */
            while(!((DeepSearchStations)sp).getSource().equals((Object)c))
            {
                rpath.add(c);
                c = c.getFather();
            }

            /* Reverse the path */
            path.add(((DeepSearchStations)sp).getSource());
            for(int i = rpath.size() - 1; i >=0; i--)
                path.add(rpath.get(i));

            /* Print the path */
            System.out.printf("\nPath from %s to %s is:\n", ((DeepSearchStations)sp).getSource(), ((DeepSearchStations)sp).getTarget());
            for(Station vc: path)
                System.out.println(vc);
        }
        else
            System.out.printf("Destiny not found!\n");
    }
}
