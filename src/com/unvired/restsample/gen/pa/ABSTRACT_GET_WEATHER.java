//	Generated using Unvired Modeller - Build R-4.000.0120
package com.unvired.restsample.gen.pa;

import com.unvired.restsample.gen.utils.BEUtility;
import com.unvired.ump.agent.IBusinessProcess;

public abstract class ABSTRACT_GET_WEATHER extends AppService {
	protected com.unvired.restsample.gen.be.WEATHER inputWEATHER;

	public void init(IBusinessProcess process) {
		super.init(process);

		inputWEATHER = BEUtility.getWEATHER(process.getBusinessEntityInput()).get(0);

	}

}
