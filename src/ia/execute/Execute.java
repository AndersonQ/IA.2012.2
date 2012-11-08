package ia.execute;

/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public interface Execute {

	/** 
	 * Execute a search and print the path 
	 */
	public void run(int src, int dest) throws Exception;
	
	/**
	 * Get the names of all cities
	 * @return a string array with all cities
	 */
	public String[] getCityNames();
}
