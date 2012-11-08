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
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class PriceStationLink extends DefaultEdge 
{
	private static int count = 0;
	protected UndirectedGraph<Station, PriceStationLink> graph;
	public int my_number;
	protected double price;

	/**
	 * @param graph
	 * @param price
	 */
	public PriceStationLink(UndirectedGraph<Station, PriceStationLink> graph,
			double price)
	{
		super();
		this.graph = graph;
		this.price = price;
		this.my_number = this.count++;
	}
	
	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}
	
	@Override
	protected Station getSource()
	{
		return graph.getEdgeSource(this);
	}

	@Override
	protected Station getTarget()
	{
		return graph.getEdgeTarget(this);
	}

	@Override
	public String toString()
	{
		return new String ("N:" + my_number + " " + this.getSource() + " <-- " + "R$ " + price + " --> " + this.getTarget());
	}
}
