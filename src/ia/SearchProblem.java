package ia;

import java.util.List;

/**
 * Description of the problem to be solved
 * @author fenix
 *
 */
public interface SearchProblem 
{
	/**
	 * Expand neighbours of a city
	 * @param o A city to expand
	 * @return a list with neighbour
	 */
	List<Object> expand(Object o);
	
	/**
	 * 
	 * @param o
	 * @return
	 */
	SearchResult process(Object o);
}
