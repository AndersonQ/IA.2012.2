package ia;

import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.DefaultEdge;

public class StringLink extends DefaultEdge 
{
	private static int count = 0;
	public int my_number;

	public StringLink() 
	{
		my_number = count ++;
		// TODO Auto-generated constructor stub
	}

	public StringLink(Object arg0) 
	{
		super(arg0);
		my_number = count ++;
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
		return (String) super.getTarget();
	}
	
	public String getSource()
	{
		return (String) super.getSource();
	}
	
	public String toString()
	{
		return new String (super.toString() + " N:" + my_number);
	}
}
