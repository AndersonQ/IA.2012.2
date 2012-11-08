/*
 * Copyright 2012 Anderson Queiroz <contato(at)andersonq(dot)eti(dot)br>
 * 					Fernando Zucatelli, João Coutinho, Tiago Queiroz <contato(at)tiago(dot)eti(dot)br>
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
public class BreadthSearchStations implements SearchProblem {
	
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
	public BreadthSearchStations(UndirectedGraph<Station, TimeStationLink> graph, Station source, Station target)
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
