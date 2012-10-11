package ia;

import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.graph.DefaultDirectedGraph;

public class StringLink extends DefaultEdge 
{
	private static int count = 0;
	public int my_number;
	protected Object graph;

	public StringLink() 
	{
		my_number = count ++;
		// TODO Auto-generated constructor stub
	}

	public StringLink(Object graph) 
	{
		super(graph);
		my_number = count ++;
		this.graph = graph;
		// TODO Auto-generated constructor stub
	}
	
	public StringLink(String source, String target)
	{
		my_number = count ++;
		this.source = source;
		this.target = target;
	}

	public StringLink(Object arg0, AttributeMap arg1) 
	{
		super(arg0, arg1);
		my_number = count ++;
		// TODO Auto-generated constructor stub
	}
	
	public String getTarget()
	{
		DefaultDirectedGraph<String, StringLink> g = (DefaultDirectedGraph<String, StringLink>) graph;
		return (String) g.getEdgeTarget(this);
	}
	
	public String getSource()
	{
		DefaultDirectedGraph<String, StringLink> g = (DefaultDirectedGraph<String, StringLink>) graph;
		return (String) g.getEdgeSource(this);
	}
	
	public String toString()
	{
		return new String (" N:" + my_number);
	}
}
