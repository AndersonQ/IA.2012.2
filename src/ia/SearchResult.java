package ia;

/**
 * A class to keep the result
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class SearchResult 
{
	private boolean success;
	
	public SearchResult(boolean result)
	{
		success = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
