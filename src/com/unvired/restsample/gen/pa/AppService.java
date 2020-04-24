package com.unvired.restsample.gen.pa;

import java.util.Hashtable;
import java.util.Vector;

import com.unvired.lib.utility.BusinessEntity;
import com.unvired.lib.utility.InfoMessage;
import com.unvired.lib.utility.InfoMessage.InfoMessageCategory;
import com.unvired.ump.agent.IBusinessProcess;
import com.unvired.ump.agent.IBusinessProcess.RequestType;
import com.unvired.ump.agent.IHTTPRequest;
import com.unvired.ump.agent.IHTTPResponse;
import com.unvired.ump.agent.IProcessAgent;
import com.unvired.ump.agent.InvalidOutput;

public abstract class AppService implements IProcessAgent {
	protected Vector<InfoMessage> infoMessages;
	protected Vector<String> bizEntMeta;
	protected Vector<BusinessEntity> beList;

	public IBusinessProcess process;

	public void init(IBusinessProcess process) {
		this.process = process;
		infoMessages = new Vector<InfoMessage>();
		bizEntMeta = new Vector<String>();
		beList = new Vector<BusinessEntity>();
	}

	public void finish() {
		try {
			process.setOutput(beList, null);
			process.getInfoMessageList().addAll(infoMessages);
		} catch (InvalidOutput e) {
			process.getInfoMessageList().add(new InfoMessage(e.getMessage(), InfoMessageCategory.FAILURE));
		}
	}

	protected void addParameter(Hashtable<String, String> parameters, String name, String value, String defaultValue) {
		if (!isEmpty(name)) {
			if (!isEmpty(value))
				parameters.put(name, value);
			else if (!isEmpty(defaultValue))
				parameters.put(name, defaultValue);
		}
	}

	protected boolean isEmpty(String value) {
		return (value == null || value.trim().isEmpty());
	}

	/*
	* This generated utility function enables the REST function modelled in the Bots Builder to be executed against the target system 
	*
	* @return Handle to {@link IHTTPResponse} containing the result of the execution.
	*/
	public IHTTPResponse GET_WEATHER(String q, String APPID) {
		Hashtable<String, String> postParameters = new Hashtable<String, String>();
		addParameter(postParameters, "q", q, "VALUE");
		addParameter(postParameters, "APPID", APPID, "8a1af5734b536e738f32c75e78db730e");

		String resource = "/data/2.5/weather";

		IHTTPRequest httpRequest = (IHTTPRequest) process.createRequest(RequestType.HTTP);
		httpRequest.setPath(resource);
		httpRequest.setVerb(IHTTPRequest.HTTPVerb.GET);

		httpRequest.setParameters(postParameters);

		IHTTPResponse httpResponse = (IHTTPResponse) process.getService().submitRequest(httpRequest,
				Constant.UNVIRED_REST_SAMPLE_REST_SERVER_REST_EXECUTE);
		return httpResponse;
	}

}
