import java.util.List;


public interface Problem 
{
	List<Object> expand(Object o);
	Result process(Object o);
}
