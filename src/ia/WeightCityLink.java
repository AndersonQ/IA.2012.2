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
package ia;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 * Edge of the Graph, the nodes are city  
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class WeightCityLink extends DefaultEdge implements Comparable
{
	private static int count = 0;
	protected UndirectedGraph<City, WeightCityLink> graph;
	public int my_number;
	protected double weight;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public WeightCityLink(UndirectedGraph<City, WeightCityLink> graph, double weight) 
	{
		super();
		my_number = count ++;
		// TODO Auto-generated constructor stub
		this.graph = graph;
		this.weight = weight;
	}

	/**
	 * A compare method to be used with a PriorityQueue
	 * @param o a WeightCityLink object 
	 * @return 0 if the weight of both are equal, -1 if 'o' weight is bigger, and 1 otherwise
	 */
	public int compareTo(Object o) {
		if(this.weight < ((WeightCityLink)o).getWeight())
		{
			return -1;
		}
		if(this.weight > ((WeightCityLink)o).getWeight())
		{
			return 1;
		}
		return 0;
	}
	
	@Override
	public City getSource() 
	{
		return graph.getEdgeSource(this); 
	}

	@Override
	public City getTarget() 
	{
		return graph.getEdgeTarget(this);
	}

	public double getWeight() 
	{
		return weight;
	}

	public void setWeight(int weight) 
	{
		this.weight = weight;
	}

	@Override
	public String toString() 
	{
		return new String ("N:" + my_number + " " + this.getSource() + " <-- " + weight + " --> " + this.getTarget());
	}	
}
