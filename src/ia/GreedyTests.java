package ia;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

public class GreedyTests
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        UndirectedGraph<City, WeightCityLink> g = new SimpleGraph<City, WeightCityLink>(WeightCityLink.class);
        City ct1,ct2,ct3,ct4,ct5,ct6,ct7,ct8;
        
        double h [][] = {{0.0, 41.7, 43.2, 41.3, 59.7, 51.1, 37.7, 28.8},
                {41.7, 00.0, 38.8, 61.8, 32.5, 12.3, 22.1, 18.3},
                {43.2, 38.8, 00.0, 45.2, 35.0, 36.0, 19.2, 44.2},
                {41.3, 61.8, 45.2, 00.0, 71.1, 70.4, 45.2, 52.2},
                {59.7, 32.5, 35.0, 71.1, 00.0, 09.3, 28.7, 44.9},
                {51.1, 12.3, 36.0, 70.4, 09.3, 00.0, 20.2, 34.8},
                {37.7, 22.1, 19.2, 45.2, 28.7, 20.2, 00.0, 18.2},
                {28.8, 18.3, 44.2, 52.2, 44.9, 34.8, 18.2, 00.0}};
        
        ct1 = new City("Barueri");
        ct2 = new City("Diadema");
        ct3 = new City("Guarulhos");
        ct4 = new City("Franco da Rocha");
        ct5 = new City("Mauá");
        ct6 = new City("Santo André");
        ct7 = new City("São Paulo");
        ct8 = new City("Taboão da Serra");

        g.addVertex(ct1);
        g.addVertex(ct2);
        g.addVertex(ct3);
        g.addVertex(ct4);
        g.addVertex(ct5);
        g.addVertex(ct6);
        g.addVertex(ct7);
        g.addVertex(ct8);

        g.addEdge(ct1, ct4, new WeightCityLink(g, 1) );
        g.addEdge(ct1, ct8, new WeightCityLink(g, 1) );

        g.addEdge(ct2, ct6, new WeightCityLink(g, 1) );
        g.addEdge(ct2, ct7, new WeightCityLink(g, 1) );
        g.addEdge(ct2, ct8, new WeightCityLink(g, 1) );

        g.addEdge(ct3, ct4, new WeightCityLink(g, 1) );
        g.addEdge(ct3, ct7, new WeightCityLink(g, 1) );

        g.addEdge(ct4, ct1, new WeightCityLink(g, 1) );
        g.addEdge(ct4, ct3, new WeightCityLink(g, 1) );
        g.addEdge(ct4, ct7, new WeightCityLink(g, 1) );

        g.addEdge(ct5, ct6, new WeightCityLink(g, 1) );
        g.addEdge(ct5, ct7, new WeightCityLink(g, 1) );

        g.addEdge(ct6, ct2, new WeightCityLink(g, 1) );
        g.addEdge(ct6, ct5, new WeightCityLink(g, 1) );
        g.addEdge(ct6, ct7, new WeightCityLink(g, 1) );

        g.addEdge(ct7, ct2, new WeightCityLink(g, 1) );
        g.addEdge(ct7, ct3, new WeightCityLink(g, 1) );
        g.addEdge(ct7, ct5, new WeightCityLink(g, 1) );
        g.addEdge(ct7, ct6, new WeightCityLink(g, 1) );
        g.addEdge(ct7, ct8, new WeightCityLink(g, 1) );

        g.addEdge(ct8, ct1, new WeightCityLink(g, 1) );
        g.addEdge(ct8, ct2, new WeightCityLink(g, 1) );
        g.addEdge(ct8, ct7, new WeightCityLink(g, 1) );

        //Franco da Rocha -> Santo André
        GreedySearch search = new GreedySearch(g, ct4, ct6, h);
        search.expand(ct4);
        
        System.out.printf("\n\n");
        //Diadema -> Santo André
        search = new GreedySearch(g, ct2, ct6, h);
        search.expand(ct2);
    }

}
