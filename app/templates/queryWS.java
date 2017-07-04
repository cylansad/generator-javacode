package com.wisedu.emap.<%=com%>.ws;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisedu.business.ws.AbstractResult;
import com.wisedu.business.ws.BaseBean;
import com.wisedu.business.ws.BaseServiceTemplate;
import com.wisedu.business.ws.CheckEnum;
import com.wisedu.business.ws.QueryConfig;
import com.wisedu.business.ws.UserInfo;
import com.wisedu.emap.emapcommon.constants.ProductCodeConsts;
import com.wisedu.emap.gglgl.util.LogUtil;
import com.wisedu.emap.<%=com%>.po.<%=fileTitle%>;
import com.wisedu.emap.<%=com%>.po.<%=fileTitle%>Result;
import com.wisedu.emap.<%=com%>.service.<%=fileTitle%>Service;
import com.wisedu.emap.ws.Documentation;

/**
 * 查询服务类
 * 
 * @author 
 * 
 */
@Service
@WebService(name = "<%=beanTitle%>QueryWebService")
public class <%=fileTitle%>QueryWebService {

	@Autowired
	private <%=fileTitle%>Service <%=beanTitle%>Service;

	private static final Logger LOGGER = LoggerFactory.getLogger(<%=fileTitle%>QueryWebService.class);

	@Documentation(value = "<%=beanTitle%>查询")
	public <%=fileTitle%>Result <%=beanTitle%>Query(<%=fileTitle%> param, QueryConfig config, String setting, UserInfo userInfo) {
		LOGGER.info("<%=beanTitle%>Query查询入参：{}", LogUtil.getStringFromObject(param, config, setting, userInfo));
		BaseServiceTemplate bs = new BaseServiceTemplate(param, config, setting, userInfo, CheckEnum.NOCHECK, CheckEnum.CHECK, ProductCodeConsts.GS);
		<%=fileTitle%>Result result = (<%=fileTitle%>Result) bs.executeQuery(new BaseServiceTemplate.ICallBackQuery() {
			public AbstractResult call(BaseBean param, QueryConfig config, String setting, String logKey, UserInfo userInfo) {
				return <%=beanTitle%>Service.<%=beanTitle%>Query((<%=fileTitle%>) param, config, setting, logKey, userInfo);
			}
		});
		LOGGER.info("<%=beanTitle%>Query查询出参：{}", LogUtil.getStringFromResult(result));
		return result;
	}
}