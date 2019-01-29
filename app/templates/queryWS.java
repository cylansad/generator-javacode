package com.wisedu.emap.<%=com%>.ws;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisedu.business.ws.AbstractResult;
import com.wisedu.business.ws.BaseBean;
import com.wisedu.business.ws.CheckEnum;
import com.wisedu.business.ws.QueryConfig;
import com.wisedu.business.ws.UserInfo;
import com.wisedu.emap.<%=com%>.po.<%=fileTitle%>;
import com.wisedu.emap.<%=com%>.po.<%=fileTitle%>Result;
import com.wisedu.emap.<%=com%>.service.<%=fileTitle%>Service;
import com.wisedu.emap.gglgl.service.ws.template.YjsServiceTemplate;
import com.wisedu.emap.ws.Documentation;

/**
 * <%=beanTitle%>查询服务类
 */
@Service
@WebService(name = "<%=com%>.<%=beanTitle%>QueryWebService")
public class <%=fileTitle%>QueryWebService {

	@Autowired
	private <%=fileTitle%>Service <%=beanTitle%>Service;

	private static final Logger LOGGER = LoggerFactory.getLogger(<%=fileTitle%>QueryWebService.class);

	@Documentation(value = "<%=beanTitle%>查询")
	public <%=fileTitle%>Result <%=beanTitle%>Query(<%=fileTitle%> param, QueryConfig config, String setting, UserInfo userInfo) {
		YjsServiceTemplate ys = new YjsServiceTemplate(LOGGER, "<%=beanTitle%>管理", "<%=beanTitle%>Query查询", param, config, setting, userInfo, CheckEnum.NOCHECK, CheckEnum.CHECK);
		KsbResult result = (KsbResult) ys.executeQuery(new YjsServiceTemplate.ICallBackQuery() {
			public AbstractResult call(BaseBean param, QueryConfig config, String setting, String logKey, UserInfo userInfo) {
				return <%=beanTitle%>Service.<%=beanTitle%>Query((<%=fileTitle%>) param, config, setting, logKey, userInfo);
			}
		});
		return result;
	}
}