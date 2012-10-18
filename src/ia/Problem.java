package ia;

import java.util.List;

/**
 * Description of the problem to be solved
 * @author fenix
 *
 */
public interface Problem 
{
	List<Object> expand(Object o);
	Result process(Object o);
}
