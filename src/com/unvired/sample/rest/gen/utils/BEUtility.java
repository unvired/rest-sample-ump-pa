//	Generated using Unvired Modeller - Build R-4.000.0090
package com.unvired.sample.rest.gen.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.unvired.lib.utility.BusinessEntity;
import com.unvired.lib.utility.Structure;
import com.unvired.sample.rest.gen.be.WEATHER;

public class BEUtility
{
	public static List<WEATHER> getWEATHER(List<BusinessEntity> beList)
	{
		ArrayList<WEATHER> typedBEs = new ArrayList<WEATHER>();

		if(beList != null)
		{
			for (BusinessEntity be : beList)
			{
				if(be.getName().equals(WEATHER.NAME))
				{
					WEATHER typedBE = new WEATHER();
					typedBEs.add(typedBE);
					for (Entry<String, String> field : be.getHeader().getFieldsInOrder().entrySet())
					{
						typedBE.getHeader().addField(field.getKey(), field.getValue());
					}

					//	Process each item individually
					for (Structure item : be.getItems())
					{
					}
				}
			}
		}
		return typedBEs;
	}

}