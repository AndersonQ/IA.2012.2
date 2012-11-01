package ia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.jgrapht.UndirectedGraph;

public class GreedySearch  implements SearchProblem
{
    private UndirectedGraph<City, WeightCityLink> g;
    private City destiny;
    private double h[][];
    private List<String> cities;

    public GreedySearch(UndirectedGraph<City, WeightCityLink> g, City destiny, double h[][])
    {
        Set<City> vc;
        this.g = g;
        this.destiny = destiny;
        this.h = h;

        cities = new ArrayList<String>();
        vc = g.vertexSet();

        for(City c: vc)
            cities.add(c.getName());

        Collections.sort(cities);
    }

    public List<Object> expand(Object o)
    {
        return null;
    }

    public SearchResult process(Object o)
    {
        return null;
    }

    private double getHeuristic(City src, City dest)
    {
        int s, d;

        s = cities.indexOf(src.getName());
        d = cities.indexOf(dest.getName());

        return h[s][d];
    }

}
