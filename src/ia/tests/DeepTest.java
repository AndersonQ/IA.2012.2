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
package ia.tests;

import ia.City;
import ia.Colour;
import ia.WeightCityLink;
import ia.search.DeepSearch;
import ia.search.SearchProblem;
import ia.search.SearchResult;
import ia.search.UniformCostSearch;

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
public class DeepTest {

	public DeepTest(){
	}
	
	public static void main(String[] args){

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
		Stack<City> stack = new Stack<City>();
		City c = null;
		List<Object> cl = null;
		SearchResult r = null;

		System.out.printf("Trying to go to: %s from %s\n", ct3, ct2);
		SearchProblem sp = new DeepSearch(g, ct3, ct2);

		stack.push(ct3);
		while(!stack.isEmpty())
		{
			/* Expand */
			//c = list.pop();
			c = stack.pop();
			c.setColour(Colour.GRAY);
			cl = sp.expand(c);

			/* Put all non processed nodes in the queue */
			for(Object node: cl)
			{
				if( ((City)node).getColour() == Colour.WHITE)
					stack.push((City)node);

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
}
