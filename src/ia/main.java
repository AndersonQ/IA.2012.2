package ia;

import java.util.Scanner;

import ia.search.ExecuteBreadth;
import ia.search.ExecuteDeep;
import ia.search.ExecuteGreedy;
import ia.search.ExecuteUniformCost;

/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class main
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ExecuteGreedy gs;
        ExecuteBreadth bs;
        ExecuteUniformCost ufc;
        ExecuteDeep ds;
        
        int op = 100, i, src, dst;
        Scanner sc = new Scanner(System.in);
        String cities[];

        while(op > 0)
        {
            System.out.printf("\nEscolha o tipo de busca:\n") ;
            System.out.printf("1 - Busca em largura\n");
            System.out.printf("2 - Busca em profundidade\n");
            System.out.printf("3 - Busca de custo uniforme\n");
            System.out.printf("4 - Busca gulosa\n");
            System.out.printf("0 - Sair\n");
            System.out.printf("> ");
            op = sc.nextInt();            

            switch(op)
            {
            case 1:
                //Busca em largura
                bs = new ExecuteBreadth();
                cities = bs.getCityNames();

                System.out.printf("\nEscolha a cidade da partida:\n");
                for(i = 0; i < cities.length; i++)
                    System.out.printf("%d - %s\n", i, cities[i]);
                System.out.printf(">");
                src = sc.nextInt();

                System.out.printf("\nEscolha a cidade de destino:\n");
                for(i = 0; i < cities.length; i++)
                    if(i != src)
                        System.out.printf("%d - %s\n", i, cities[i]);
                System.out.printf(">");
                dst = sc.nextInt();

                try
                {
                    bs.run(src, dst);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
                break;

            case 2:
                //Busca em profundidade
                ds = new ExecuteDeep();
                cities = ds.getCityNames();

                System.out.printf("\nEscolha a cidade da partida:\n");
                for(i = 0; i < cities.length; i++)
                    System.out.printf("%d - %s\n", i, cities[i]);
                System.out.printf(">");
                src = sc.nextInt();

                System.out.printf("\nEscolha a cidade de destino:\n");
                for(i = 0; i < cities.length; i++)
                    if(i != src)
                        System.out.printf("%d - %s\n", i, cities[i]);
                System.out.printf(">");
                dst = sc.nextInt();

                try
                {
                	ds.run(src, dst);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
                break;

            case 3:
                //Busca de custo uniforme
                ufc = new ExecuteUniformCost();
                cities = ufc.getCityNames();

                System.out.printf("\nEscolha a cidade da partida:\n");
                for(i = 0; i < cities.length; i++)
                    System.out.printf("%d - %s\n", i, cities[i]);
                System.out.printf(">");
                src = sc.nextInt();

                System.out.printf("\nEscolha a cidade de destino:\n");
                for(i = 0; i < cities.length; i++)
                    if(i != src)
                        System.out.printf("%d - %s\n", i, cities[i]);
                System.out.printf(">");
                dst = sc.nextInt();

                try
                {
                	ufc.run(src, dst);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
                break;

            case 4:
                //Busca Gulosa
                gs = new ExecuteGreedy();
                cities = gs.getCityNames();

                System.out.printf("\nEscolha a cidade da partida:\n");
                for(i = 0; i < cities.length; i++)
                    System.out.printf("%d - %s\n", i, cities[i]);
                System.out.printf(">");
                src = sc.nextInt();

                System.out.printf("\nEscolha a cidade de destino:\n");
                for(i = 0; i < cities.length; i++)
                    if(i != src)
                        System.out.printf("%d - %s\n", i, cities[i]);
                System.out.printf(">");
                dst = sc.nextInt();

                try
                {
                    gs.run(src, dst);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    System.exit(1);
                }
                break;

            default:
                break;
            }
        }
    }
}
