package ia;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class TimeStationLink extends DefaultEdge 
{
	private static int count = 0;
	protected UndirectedGraph<Station, TimeStationLink> graph;
	public int my_number;
	protected double time;
	
	public TimeStationLink(UndirectedGraph<Station, TimeStationLink> graph, double time)
	{
		this.my_number = this.count++;
		this.graph = graph;
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
		return new String ("N:" + my_number + " " + this.getSource() + " <-- " + time + " min" + " --> " + this.getTarget());
	}

	public double getTime()
	{
		return time;
	}

	public void setTime(double time)
	{
		this.time = time;
	}
}
