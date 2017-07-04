package com.wisedu.emap.<%=com%>.po;

import com.wisedu.business.ws.AbstractResult;

public class <%=fileTitle%>Result extends AbstractResult {

	private static final long serialVersionUID = 1L;

	private <%=fileTitle%>[] result;

	public <%=fileTitle%>[] getResult() {
		return result;
	}

	public void setResult(<%=fileTitle%>[] result) {
		this.result = result;
	}
}