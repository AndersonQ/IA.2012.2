package ia;

import ia.search.ExecuteGreedy;

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
        ExecuteGreedy gs = new ExecuteGreedy();

        try
        {
            gs.run(1, 2);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
