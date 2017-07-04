package com.wisedu.emap.<%=com%>.service;

import com.wisedu.business.ws.OperateResult;
import com.wisedu.business.ws.QueryConfig;
import com.wisedu.business.ws.UserInfo;
import com.wisedu.emap.<%=com%>.po.<%=fileTitle%>;
import com.wisedu.emap.<%=com%>.po.<%=fileTitle%>Result;

public interface <%=fileTitle%>Service {

	/**
	 * 查询
	 */
	<%=fileTitle%>Result <%=beanTitle%>Query(<%=fileTitle%> param, QueryConfig config, String setting, String logKey, UserInfo userInfo);

}