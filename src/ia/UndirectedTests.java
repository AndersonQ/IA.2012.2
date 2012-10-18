package ia;

import java.util.Set;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class UndirectedTests 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		UndirectedGraph<City, WeightCityLink> g = new SimpleGraph<City, WeightCityLink>(WeightCityLink.class);
		City c1, c2, c3, c4, c5, c6, c7, c8, 	
		c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43;
		
		c1 = new City("Recife");
		c2 = new City("Natal");
		c3 = new City("Florianópolis");
		c4 = new City("Olinda");
		c5 = new City("Arujá");
		c6 = new City("Barueri");
		c7 = new City("Biritiba Mirim");
		c8 = new City("Caieiras");
		c9 = new City("Cajamar");
		c10 = new City("Carapicuíba");
		c11 = new City("Cotia");
		c12 = new City("Diadema");
		c13 = new City("Embu das Artes");
		c14 = new City("Embu-Guaçu");
		c15 = new City("Ferraz de Vasconcelos");
		c16 = new City("Francisco Morato");
		c17 = new City("Franco da Rocha");
		c18 = new City("Guararema");
		c19 = new City("Guarulhos");
		c20 = new City("Itapecerica da Serra");
		c21 = new City("Itapevi");
		c22 = new City("Itaquaquecetuba");
		c23 = new City("Jandira");
		c24 = new City("Juquitiba");
		c25 = new City("Mairiporã");
		c26 = new City("Mauá");
		c27 = new City("Mogi das Cruzes");
		c28 = new City("Osasco");
		c29 = new City("Pirapora do Bom Jesus");
		c30 = new City("Poá");
		c31 = new City("Ribeirão Pires");
		c32 = new City("Rio Grande da Serra");
		c33 = new City("Salesópolis");
		c34 = new City("Santa Isabel");
		c35 = new City("Santana de Parnaíba");
		c36 = new City("Santo André");
		c37 = new City("São Bernardo do Campo");
		c38 = new City("São Caetano do Sul");
		c39 = new City("São Lourenço da Serra");
		c40 = new City("São Paulo");
		c41 = new City("Suzano");
		c42 = new City("Taboão da Serra");
		c43 = new City("Vargem Grande Paulista");

		g.addVertex(c1);
		g.addVertex(c2);
		g.addVertex(c3);
		g.addVertex(c4);
		g.addVertex(c5);
		g.addVertex(c6);
		g.addVertex(c7);
		g.addVertex(c8);
		g.addVertex(c9);
		g.addVertex(c10);
		g.addVertex(c11);
		g.addVertex(c12);
		g.addVertex(c13);
		g.addVertex(c14);
		g.addVertex(c15);
		g.addVertex(c16);
		g.addVertex(c17);
		g.addVertex(c18);
		g.addVertex(c19);
		g.addVertex(c20);
		g.addVertex(c21);
		g.addVertex(c22);
		g.addVertex(c23);
		g.addVertex(c24);
		g.addVertex(c25);
		g.addVertex(c26);
		g.addVertex(c27);
		g.addVertex(c28);
		g.addVertex(c29);
		g.addVertex(c30);
		g.addVertex(c31);
		g.addVertex(c32);
		g.addVertex(c33);
		g.addVertex(c34);
		g.addVertex(c35);
		g.addVertex(c36);
		g.addVertex(c37);
		g.addVertex(c38);
		g.addVertex(c39);
		g.addVertex(c40);
		g.addVertex(c41);
		g.addVertex(c42);
		g.addVertex(c43);

		g.addEdge(c1, c4, new WeightCityLink(g, 7));
		g.addEdge(c1, c3, new WeightCityLink(g, 3300));
		g.addEdge(c3, c4, new WeightCityLink(g, 3320));
		g.addEdge(c4, c2, new WeightCityLink(g, 281));
		g.addEdge(c5, c19, new WeightCityLink(g, 26.8) );
		g.addEdge(c5, c22, new WeightCityLink(g, 12.5) );
		g.addEdge(c5, c27, new WeightCityLink(g, 23.5) );
		g.addEdge(c5, c34, new WeightCityLink(g, 17.0) );
		g.addEdge(c6, c10, new WeightCityLink(g, 5.1) );
		g.addEdge(c6, c28, new WeightCityLink(g, 11.5) );
		g.addEdge(c6, c21, new WeightCityLink(g, 12.5) );
		g.addEdge(c6, c23, new WeightCityLink(g, 5.5) );
		g.addEdge(c6, c35, new WeightCityLink(g, 12.6) );
		g.addEdge(c7, c27, new WeightCityLink(g, 19.9) );
		g.addEdge(c7, c18, new WeightCityLink(g, 43.5) );
		g.addEdge(c7, c33, new WeightCityLink(g, 23.6) );
		g.addEdge(c8, c9, new WeightCityLink(g, 28.6) );
		g.addEdge(c8, c17, new WeightCityLink(g, 7.0) );
		g.addEdge(c8, c25, new WeightCityLink(g, 22.4) );
		g.addEdge(c8, c40, new WeightCityLink(g, 37.8) );
		g.addEdge(c9, c29, new WeightCityLink(g, 30.6) );
		g.addEdge(c9, c35, new WeightCityLink(g, 17.1) );
		g.addEdge(c9, c8, new WeightCityLink(g, 28.6) );
		g.addEdge(c9, c17, new WeightCityLink(g, 26.9) );
		g.addEdge(c9, c40, new WeightCityLink(g, 46.3) );
		g.addEdge(c10, c6, new WeightCityLink(g, 5.1) );
		g.addEdge(c10, c28, new WeightCityLink(g, 5.5) );
		g.addEdge(c10, c23, new WeightCityLink(g, 9.1) );
		g.addEdge(c10, c11, new WeightCityLink(g, 20.1) );
		g.addEdge(c11, c10, new WeightCityLink(g, 20.1) );
		g.addEdge(c11, c23, new WeightCityLink(g, 21.5) );
		g.addEdge(c11, c21, new WeightCityLink(g, 7.5) );
		g.addEdge(c11, c43, new WeightCityLink(g, 11.9) );
		g.addEdge(c11, c39, new WeightCityLink(g, 46.8) );
		g.addEdge(c11, c20, new WeightCityLink(g, 29.2) );
		g.addEdge(c11, c13, new WeightCityLink(g, 14.1) );
		g.addEdge(c11, c42, new WeightCityLink(g, 24) );
		g.addEdge(c12, c40, new WeightCityLink(g, 19.2) );
		g.addEdge(c12, c37, new WeightCityLink(g, 7.9) );
		g.addEdge(c13, c11, new WeightCityLink(g, 14.1) );
		g.addEdge(c13, c20, new WeightCityLink(g, 8.7) );
		g.addEdge(c13, c40, new WeightCityLink(g, 37.7) );
		g.addEdge(c13, c42, new WeightCityLink(g, 16.1) );
		g.addEdge(c14, c39, new WeightCityLink(g, 19.8) );
		g.addEdge(c14, c24, new WeightCityLink(g, 38.7) );
		g.addEdge(c14, c40, new WeightCityLink(g, 49.4) );
		g.addEdge(c14, c20, new WeightCityLink(g, 17.3) );
		g.addEdge(c15, c40, new WeightCityLink(g, 35.5) );
		g.addEdge(c15, c26, new WeightCityLink(g, 28.8) );
		g.addEdge(c15, c41, new WeightCityLink(g, 8.4) );
		g.addEdge(c15, c30, new WeightCityLink(g, 3.3) );
		g.addEdge(c16, c17, new WeightCityLink(g, 6.6) );
		g.addEdge(c17, c16, new WeightCityLink(g, 6.6) );
		g.addEdge(c17, c9, new WeightCityLink(g, 26.9) );
		g.addEdge(c17, c25, new WeightCityLink(g, 18.7) );
		g.addEdge(c17, c8, new WeightCityLink(g, 7) );
		g.addEdge(c18, c34, new WeightCityLink(g, 32.4) );
		g.addEdge(c18, c27, new WeightCityLink(g, 24.4) );
		g.addEdge(c18, c7, new WeightCityLink(g, 43.5) );
		g.addEdge(c18, c33, new WeightCityLink(g, 34.8) );
		g.addEdge(c19, c25, new WeightCityLink(g, 26) );
		g.addEdge(c19, c40, new WeightCityLink(g, 21.2) );
		g.addEdge(c19, c22, new WeightCityLink(g, 29.2) );
		g.addEdge(c19, c5, new WeightCityLink(g, 26.8) );
		g.addEdge(c19, c34, new WeightCityLink(g, 42.4) );
		g.addEdge(c20, c13, new WeightCityLink(g, 8.7) );
		g.addEdge(c20, c11, new WeightCityLink(g, 29.2) );
		g.addEdge(c20, c39, new WeightCityLink(g, 22.4) );
		g.addEdge(c20, c14, new WeightCityLink(g, 17.3) );
		g.addEdge(c20, c40, new WeightCityLink(g, 36.5) );
		g.addEdge(c21, c6, new WeightCityLink(g, 12.8) );
		g.addEdge(c21, c43, new WeightCityLink(g, 17.5) );
		g.addEdge(c21, c11, new WeightCityLink(g, 7.5) );
		g.addEdge(c21, c23, new WeightCityLink(g, 5.7) );
		g.addEdge(c22, c5, new WeightCityLink(g, 12.5) );
		g.addEdge(c22, c19, new WeightCityLink(g, 29.2) );
		g.addEdge(c22, c40, new WeightCityLink(g, 40.2) );
		g.addEdge(c22, c30, new WeightCityLink(g, 6.2) );
		g.addEdge(c22, c41, new WeightCityLink(g, 8.6) );
		g.addEdge(c22, c27, new WeightCityLink(g, 20.7) );
		g.addEdge(c23, c6, new WeightCityLink(g, 5.5) );
		g.addEdge(c23, c21, new WeightCityLink(g, 5.7) );
		g.addEdge(c23, c11, new WeightCityLink(g, 21.5) );
		g.addEdge(c23, c9, new WeightCityLink(g, 9.1) );
		g.addEdge(c24, c39, new WeightCityLink(g, 18.8) );
		g.addEdge(c24, c14, new WeightCityLink(g, 38.7) );
		g.addEdge(c24, c40, new WeightCityLink(g,78.5) );
		g.addEdge(c25, c17, new WeightCityLink(g, 18.7) );
		g.addEdge(c25, c8, new WeightCityLink(g, 22.4) );
		g.addEdge(c25, c40, new WeightCityLink(g, 34.1) );
		g.addEdge(c25, c19, new WeightCityLink(g, 26) );
		g.addEdge(c26, c40, new WeightCityLink(g, 36.4) );
		g.addEdge(c26, c36, new WeightCityLink(g, 9.3) );
		g.addEdge(c26, c31, new WeightCityLink(g, 8.3) );
		g.addEdge(c26, c15, new WeightCityLink(g, 28.8) );
		g.addEdge(c27, c34, new WeightCityLink(g, 48.7) );
		g.addEdge(c27, c5, new WeightCityLink(g, 23.5) );
		g.addEdge(c27, c22, new WeightCityLink(g, 20.7) );
		g.addEdge(c27, c41, new WeightCityLink(g, 14.6) );
		g.addEdge(c27, c36, new WeightCityLink(g, 64.7) );
		g.addEdge(c27, c7, new WeightCityLink(g, 19.9) );
		g.addEdge(c27, c18, new WeightCityLink(g, 24.4) );
		g.addEdge(c28, c40, new WeightCityLink(g, 29) );
		g.addEdge(c28, c6, new WeightCityLink(g, 11.5) );
		g.addEdge(c28, c10, new WeightCityLink(g, 5.5) );
		g.addEdge(c28, c11, new WeightCityLink(g, 26.9) );
		g.addEdge(c29, c9, new WeightCityLink(g, 30.6) );
		g.addEdge(c29, c35, new WeightCityLink(g, 14.6) );
		g.addEdge(c30, c22, new WeightCityLink(g, 6.2) );
		g.addEdge(c30, c15, new WeightCityLink(g, 3.3) );
		g.addEdge(c30, c41, new WeightCityLink(g, 5.1) );
		g.addEdge(c31, c26, new WeightCityLink(g, 8.3) );
		g.addEdge(c31, c36, new WeightCityLink(g, 7.2) );
		g.addEdge(c31, c32, new WeightCityLink(g, 5.5) );
		g.addEdge(c31, c41, new WeightCityLink(g, 28) );
		g.addEdge(c32, c31, new WeightCityLink(g, 5.5) );
		g.addEdge(c32, c36, new WeightCityLink(g, 20.8) );
		g.addEdge(c32, c41, new WeightCityLink(g, 30.3) );
		g.addEdge(c33, c18, new WeightCityLink(g, 34.8) );
		g.addEdge(c33, c7, new WeightCityLink(g, 23.6) );
		g.addEdge(c34, c19, new WeightCityLink(g, 42.4) );
		g.addEdge(c34, c5, new WeightCityLink(g, 17) );
		g.addEdge(c34, c27, new WeightCityLink(g, 48.7) );
		g.addEdge(c34, c18, new WeightCityLink(g, 32.4) );
		g.addEdge(c35, c9, new WeightCityLink(g, 17.1) );
		g.addEdge(c35, c29, new WeightCityLink(g, 14.6) );
		g.addEdge(c35, c6, new WeightCityLink(g, 12.6) );
		g.addEdge(c35, c40, new WeightCityLink(g, 44.5) );
		g.addEdge(c36, c40, new WeightCityLink(g, 23.3) );
		g.addEdge(c36, c38, new WeightCityLink(g, 6.7) );
		g.addEdge(c36, c37, new WeightCityLink(g, 6.9) );
		g.addEdge(c36, c27, new WeightCityLink(g, 647) );
		g.addEdge(c36, c41, new WeightCityLink(g, 33.8) );
		g.addEdge(c36, c32, new WeightCityLink(g, 20.8) );
		g.addEdge(c36, c31, new WeightCityLink(g, 17.2) );
		g.addEdge(c36, c26, new WeightCityLink(g, 9.3) );
		g.addEdge(c37, c40, new WeightCityLink(g, 25.2) );
		g.addEdge(c37, c38, new WeightCityLink(g, 9.8) );
		g.addEdge(c37, c12, new WeightCityLink(g, 7.9) );
		g.addEdge(c37, c36, new WeightCityLink(g, 6.9) );
		g.addEdge(c38, c40, new WeightCityLink(g, 13.5) );
		g.addEdge(c38, c36, new WeightCityLink(g, 6.7) );
		g.addEdge(c38, c37, new WeightCityLink(g, 9.8) );
		g.addEdge(c39, c11, new WeightCityLink(g, 46.8) );
		g.addEdge(c39, c24, new WeightCityLink(g, 18.8) );
		g.addEdge(c39, c14, new WeightCityLink(g, 20.7) );
		g.addEdge(c39, c20, new WeightCityLink(g, 22.4) );
		g.addEdge(c40, c19, new WeightCityLink(g, 21.2) );
		g.addEdge(c40, c25, new WeightCityLink(g, 34.1) );
		g.addEdge(c40, c8, new WeightCityLink(g, 37.8) );
		g.addEdge(c40, c9, new WeightCityLink(g, 46.3) );
		g.addEdge(c40, c35, new WeightCityLink(g, 44.5) );
		g.addEdge(c40, c28, new WeightCityLink(g, 29) );
		g.addEdge(c40, c42, new WeightCityLink(g, 16.2) );
		g.addEdge(c40, c13, new WeightCityLink(g, 37.7) );
		g.addEdge(c40, c20, new WeightCityLink(g, 36.5) );
		g.addEdge(c40, c14, new WeightCityLink(g, 49.4) );
		g.addEdge(c40, c24, new WeightCityLink(g, 78.5) );
		g.addEdge(c40, c37, new WeightCityLink(g, 25.2) );
		g.addEdge(c40, c12, new WeightCityLink(g, 19.2) );
		g.addEdge(c40, c38, new WeightCityLink(g, 13.5) );
		g.addEdge(c40, c36, new WeightCityLink(g, 23.3) );
		g.addEdge(c40, c26, new WeightCityLink(g, 36.4) );
		g.addEdge(c40, c15, new WeightCityLink(g, 35.5) );
		g.addEdge(c40, c22, new WeightCityLink(g, 40.2) );
		g.addEdge(c41, c30, new WeightCityLink(g, 5.1) );
		g.addEdge(c41, c15, new WeightCityLink(g, 8.4) );
		g.addEdge(c41, c31, new WeightCityLink(g, 28) );
		g.addEdge(c41, c32, new WeightCityLink(g, 30.3) );
		g.addEdge(c41, c27, new WeightCityLink(g, 14.6) );
		g.addEdge(c41, c36, new WeightCityLink(g, 33.8) );
		g.addEdge(c42, c40, new WeightCityLink(g, 16.2) );
		g.addEdge(c42, c11, new WeightCityLink(g, 24) );
		g.addEdge(c42, c13, new WeightCityLink(g, 16.1) );
		g.addEdge(c43, c21, new WeightCityLink(g, 17.5) );
		g.addEdge(c43, c11, new WeightCityLink(g, 11.9) );
	
		Set<WeightCityLink> s;
		
		s = g.edgeSet();
		
		System.out.printf("Printing Edges:\n");
		for(WeightCityLink l: s)
			System.out.println(l);
		
		System.out.printf("\n\nPrining Sources and Targets:\n");
		for(WeightCityLink l: s)
		{
			System.out.print("From: " + l.getSource() + " to: " + l.getTarget());
			System.out.println(" weight: " + l.getWeight());
		}
		
		System.out.println("\n\nEdges of " + c4);
		s = g.edgesOf(c4);
		for(WeightCityLink l: s)
			System.out.println(l);
	}
}