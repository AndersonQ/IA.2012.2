package ia;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 * Edge of the Graph, the nodes are city  
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class WeightCityLink extends DefaultEdge 
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

	@Override
	protected City getSource() 
	{
		return graph.getEdgeSource(this); 
	}

	@Override
	protected City getTarget() 
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
