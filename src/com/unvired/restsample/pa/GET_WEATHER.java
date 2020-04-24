//	Generated using Unvired Modeller - Build R-4.000.0115
package com.unvired.restsample.pa;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.unvired.lib.utility.InfoMessage;
import com.unvired.lib.utility.InfoMessage.InfoMessageCategory;
import com.unvired.lib.utility.InfoMessage.InfoMessageType;
import com.unvired.restsample.gen.be.WEATHER;
import com.unvired.restsample.gen.pa.ABSTRACT_GET_WEATHER;
import com.unvired.ump.agent.IHTTPResponse;

public class GET_WEATHER extends ABSTRACT_GET_WEATHER {
	public void execute() {
		try {
			System.out.println("Test");
			 String city = inputWEATHER.getWEATHER_HEADER().getCITY();
	            
	            String responseText = "";
	            
	            //  Call the REST API
	            IHTTPResponse response = GET_WEATHER(city, "");
	            if(response.isSuccess()){
	            	
	                JsonObject weatherJson = (JsonObject)new JsonParser().parse(response.getMessage());  
	                
	                String description = weatherJson.get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString();
	                int temperature = weatherJson.get("main").getAsJsonObject().get("temp").getAsBigDecimal().intValue() - 273;       
	                int humidity = weatherJson.get("main").getAsJsonObject().get("humidity").getAsInt(); 
	                
	                WEATHER weatherBE = new WEATHER();
	                weatherBE.getWEATHER_HEADER().setCITY(city);
	                weatherBE.getWEATHER_HEADER().setWEATHER_DESC(description);
	                weatherBE.getWEATHER_HEADER().setTEMPERATURE(temperature + " degree Celsius");
	                weatherBE.getWEATHER_HEADER().setHUMIDITY(humidity + "%");
	                beList.add(weatherBE);
	            }
	            else {
	                responseText = "Something went wrong. Please try again";              
	                infoMessages.add(new InfoMessage(responseText, InfoMessageType.APPLICATION, InfoMessageCategory.FAILURE));
	            }

		} catch (Exception e) {
			e.printStackTrace();
			infoMessages.add(new InfoMessage(
					"Error in UMP App function(" + this.getClass().getSimpleName() + "). Error Details: "
							+ e.getMessage() == null ? e.getClass().getName() : e.getMessage(),
					InfoMessageType.APPLICATION, InfoMessageCategory.FAILURE));

		}
	}
}