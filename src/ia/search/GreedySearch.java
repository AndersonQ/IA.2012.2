package ia.search;

import ia.City;
import ia.WeightCityLink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.jgrapht.UndirectedGraph;

/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class GreedySearch  implements SearchProblem
{
    private UndirectedGraph<City, WeightCityLink> g;
    private City destiny, source;
    private double h[][];
    private List<String> cities;

    public GreedySearch(UndirectedGraph<City, WeightCityLink> g, City source, City destiny, double h[][])
    {
        Set<City> vc;
        this.g = g;
        this.destiny = destiny;
        this.source = source;
        this.h = h;

        cities = new ArrayList<String>();
        vc = g.vertexSet();

        for(City c: vc)
            cities.add(c.getName());

        Collections.sort(cities);
    }

    public List<Object> expand(Object o)
    {
        List<Object> ret;
        List<City> sorted;
        Set<WeightCityLink> s;
        City node = (City) o;
        City sl, dl;

        ret = new LinkedList<Object>();
        sorted = new LinkedList<City>();

        s = g.edgesOf(node);
        for(WeightCityLink l: s)
        {
            sl = l.getSource();
            dl = l.getTarget();
            if(sl != node)
                if(!sorted.contains(sl))
                    sorted.add(sl);
            if(dl != node)
                if(!sorted.contains(dl))
                    sorted.add(dl);
        }

        Collections.sort(sorted, new Comparator<City>()
        {
            public int compare(City arg0, City arg1)
            {
                double sd, ds;
                sd = getHeuristic(arg0);
                ds = getHeuristic(arg1);

                if(sd > ds)
                    return 1;
                else if (ds > ds)
                    return -1;
                else
                    return 0;
            }
        });

//        System.out.println("Nodes sorted by heuristic:");
        for(City c: sorted)
        {
//            System.out.println(c);
            ret.add((Object) c);
        }

        return ret;
    }

    public SearchResult process(Object o)
    {
        return new SearchResult(destiny.equals(o));
    }

    private double getHeuristic(City src)
    {
        int s, d;

        s = cities.indexOf(src.getName());
        d = cities.indexOf(destiny.getName());

        return h[s][d];
    }

    public City getDestiny()
    {
        return destiny;
    }

    public City getSource()
    {
        return source;
    }

}
