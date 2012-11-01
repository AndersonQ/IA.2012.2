package ia;

import ia.search.SearchProblem;
import ia.search.SearchResult;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class CitiesShortestPathWay implements SearchProblem 
{
	UndirectedGraph<City, WeightCityLink> g;
	
	public CitiesShortestPathWay()
	{
		super();
		g = new SimpleGraph<City, WeightCityLink>(WeightCityLink.class);
	}

	@Override
	public List<Object> expand(Object o) 
	{
		Set<WeightCityLink> s;
		List<Object> l = new LinkedList<Object>();
		City c = (City) o;
		
		s = g.edgesOf(c);
		
		for(WeightCityLink link: s)
		{
			if(!l.contains(link.getSource()))
				l.add(link.getSource());
			if(!l.contains(link.getTarget()))
				l.add(link.getTarget());
		}
		return l;
	}
	
	
	@Override
	public SearchResult process(Object o) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
