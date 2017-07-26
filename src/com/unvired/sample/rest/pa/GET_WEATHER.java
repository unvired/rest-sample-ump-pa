//	Generated using Unvired Modeller - Build R-4.000.0002
package com.unvired.sample.rest.pa;  

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.unvired.lib.utility.InfoMessage;
import com.unvired.lib.utility.InfoMessage.InfoMessageCategory;
import com.unvired.lib.utility.InfoMessage.InfoMessageType;
import com.unvired.sample.rest.gen.be.WEATHER;
import com.unvired.sample.rest.gen.pa.ABSTRACT_GET_WEATHER;
import com.unvired.ump.agent.IHTTPResponse;
 
public class GET_WEATHER extends ABSTRACT_GET_WEATHER {
	
    public void execute() {
    	
        try {        	
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
        	infoMessages.add(new InfoMessage(e.getMessage(), InfoMessageType.APPLICATION, InfoMessageCategory.FAILURE));    
        }
	}   
}