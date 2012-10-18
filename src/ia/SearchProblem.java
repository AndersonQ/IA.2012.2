package ia;

import java.util.List;

/**
 * Description of the problem to be solved
 * @author fenix
 *
 */
public interface SearchProblem 
{
	List<Object> expand(Object o);
	SearchResult process(Object o);
}
