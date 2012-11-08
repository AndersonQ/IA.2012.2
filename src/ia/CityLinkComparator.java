package ia;

import java.util.Comparator;

/**
 * 
 * @author Anderson Queiroz, Fernando Zucatelli, João Coutinho, Tiago Queiroz
 *
 */
public class CityLinkComparator implements Comparator<WeightCityLink> 
{

	public CityLinkComparator() 
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(WeightCityLink arg0, WeightCityLink arg1) 
	{
		if(arg0.getWeight() < arg1.getWeight())
		{
			return -1;
		}
		if(arg0.getWeight() > arg1.getWeight())
		{
			return 1;
		}
		return 0;
	}
}
