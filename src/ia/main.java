package ia;

import java.util.Scanner;

import ia.search.ExecuteGreedy;

public class main
{
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ExecuteGreedy gs = new ExecuteGreedy();
        int op = 100;
        Scanner sc = new Scanner(System.in);

        while(op > 0)
        {
            System.out.printf("\nEscolha o tipo de busca:\n") ;
            System.out.printf("1 - Busca em largura\n");
            System.out.printf("2 - Busca em profundidade\n");
            System.out.printf("3 - Busca de custo uniforme\n");
            System.out.printf("4 - Busca gulosa\n");
            System.out.printf("0 - Sair\n");
            System.out.printf(">\n");
            op = sc.nextInt();            

            switch(op)
            {
            case 1:
                //Busca em largura
                break;

            case 2:
                //Busca em profundidade
                break;

            case 3:
                //Busca de custo uniforme
                break;

            case 4:
                //Busca Gulosa
                try
                {
                    gs.run(7, 4);
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
