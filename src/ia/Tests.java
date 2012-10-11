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

//		DirectedGraph<URL, DefaultEdge> g =
//				new DefaultDirectedGraph<URL, DefaultEdge>(DefaultEdge.class);
//
//		try {
//			URL amazon = new URL("http://www.amazon.com");
//			URL yahoo = new URL("http://www.yahoo.com");
//			URL ebay = new URL("http://www.ebay.com");
//
//			// add the vertices
//			g.addVertex(amazon);
//			g.addVertex(yahoo);
//			g.addVertex(ebay);
//
//			// add edges to create linking structure
//			g.addEdge(yahoo, amazon);
//			g.addEdge(yahoo, ebay);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//		
////		Set<DefaultEdge> s = g.edgeSet();
////		for(DefaultEdge d: s)
////		{
////			System.out.println(d);
////		}
//		System.out.println(g);
		
		
		DirectedGraph<String, StringLink> g;

		g = new DefaultDirectedGraph<String, StringLink>(StringLink.class);
		
		String s1, s2, s3;
		
		s1 = new String("Cidade1");
		s2 = new String("Cidade2");
		s3 = new String("Cidade3");
		
		g.addVertex(s1);
		g.addVertex(s2);
		g.addVertex(s3);
		
		g.addEdge(s1, s2, new StringLink(s1, s2));
		g.addEdge(s2, s3, new StringLink(s2, s3));
		g.addEdge(s3, s1, new StringLink(s3, s1));
		
		Set<StringLink> s;
		s = g.edgesOf(s1);
		
		for(StringLink d: s)
		{
			System.out.println("\nEdge: " + d);
			System.out.println(" to: " + d.getSource() + " from: " + d.getTarget());
			System.out.println(" to: " + g.getEdgeSource(d) + " from: " + g.getEdgeTarget(d));
		}
		
		System.out.println(g);
	}
	

}
