package ia;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.jgraph.*;
import org.jgraph.graph.*;
import org.jgrapht.*;
import org.jgrapht.graph.DefaultDirectedGraph;

public class Tests 
{
	
	public static void main(String args[])
	{		
		DirectedGraph<String, StringLink> g;

		g = new DefaultDirectedGraph<String, StringLink>(StringLink.class);
		
		String s1, s2, s3;
		
		s1 = new String("Cidade1");
		s2 = new String("Cidade2");
		s3 = new String("Cidade3");
		
		g.addVertex(s1);
		g.addVertex(s2);
		g.addVertex(s3);
		
//		g.addEdge(s1, s2, new StringLink(s1, s2));
//		g.addEdge(s2, s3, new StringLink(s2, s3));
//		g.addEdge(s3, s1, new StringLink(s3, s1));
		g.addEdge(s1, s2, new StringLink(g));
		g.addEdge(s2, s3, new StringLink(g));
		g.addEdge(s3, s1, new StringLink(g));
		
		Set<StringLink> s;
		s = g.edgesOf(s1);
		
		for(StringLink d: s)
		{
			System.out.println("\nEdge: " + d);
			System.out.println(" to: " + d.getSource() + " from: " + d.getTarget());
			//System.out.println(" to: " + g.getEdgeSource(d) + " from: " + g.getEdgeTarget(d));
		}		
		System.out.println(g);
	}
}
