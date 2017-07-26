//	Generated using Unvired Modeller - Build R-4.000.0090
package com.unvired.sample.rest.gen.be;

import java.util.ArrayList;

import com.unvired.lib.utility.BusinessEntity;
import com.unvired.lib.utility.Structure;

public class WEATHER extends BusinessEntity {

	private static final long serialVersionUID = 1L;
	public static final String NAME = "WEATHER";
	public WEATHER()
	{
		setName(NAME);
		setHeader(new WEATHER_HEADER());
	}

	public WEATHER_HEADER getWEATHER_HEADER()
	{
		return (WEATHER_HEADER)super.getHeader();
	}

	public static class WEATHER_HEADER extends Structure
	{
		private static final long serialVersionUID = 1L;
		public static final String NAME = "WEATHER_HEADER";

		public static final String FLD_CITY = "CITY";
		public static final String FLD_WEATHER_DESC = "WEATHER_DESC";
		public static final String FLD_TEMPERATURE = "TEMPERATURE";
		public static final String FLD_HUMIDITY = "HUMIDITY";

		public static final ArrayList<String> FIELDS = new ArrayList<String>();

		static {
			FIELDS.add(FLD_CITY);
			FIELDS.add(FLD_WEATHER_DESC);
			FIELDS.add(FLD_TEMPERATURE);
			FIELDS.add(FLD_HUMIDITY);
		}

		public WEATHER_HEADER()
		{
			setName(NAME);
		}

		public String getCITY()
		{
			return getField(FLD_CITY);
		}

		public void setCITY(String value)
		{
			if(value != null)
				addField(FLD_CITY, value);
		}

		public String getWEATHER_DESC()
		{
			return getField(FLD_WEATHER_DESC);
		}

		public void setWEATHER_DESC(String value)
		{
			if(value != null)
				addField(FLD_WEATHER_DESC, value);
		}

		public String getTEMPERATURE()
		{
			return getField(FLD_TEMPERATURE);
		}

		public void setTEMPERATURE(String value)
		{
			if(value != null)
				addField(FLD_TEMPERATURE, value);
		}

		public String getHUMIDITY()
		{
			return getField(FLD_HUMIDITY);
		}

		public void setHUMIDITY(String value)
		{
			if(value != null)
				addField(FLD_HUMIDITY, value);
		}

	}
}