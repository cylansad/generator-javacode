package com.wisedu.emap.<%=com%>.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisedu.business.bean.BeanImpl;
import com.wisedu.business.exception.BusinessException;
import com.wisedu.business.ws.OperateResult;
import com.wisedu.business.ws.QueryConfig;
import com.wisedu.business.ws.UserInfo;
import com.wisedu.emap.gglgl.constants.GglglConstants;
import com.wisedu.emap.gglgl.service.CommonService;
import com.wisedu.emap.gglgl.service.DataPermissionService;
import com.wisedu.emap.<%=com%>.dao.<%=fileTitle%>Dao;
import com.wisedu.emap.<%=com%>.po.<%=fileTitle%>;
import com.wisedu.emap.<%=com%>.po.<%=fileTitle%>Result;
import com.wisedu.emap.<%=com%>.service.<%=fileTitle%>Service;

/**
 * <%=beanTitle%>服务实现类
 */
@Service("<%=com%>.<%=beanTitle%>Service")
public class <%=fileTitle%>ServiceImpl implements <%=fileTitle%>Service {

	@Autowired
	private DataPermissionService dataPermissionService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private <%=fileTitle%>Dao <%=beanTitle%>Dao;

	/**
	 * <%=beanTitle%>查询
	 */
	public <%=fileTitle%>Result <%=beanTitle%>Query(<%=fileTitle%> param, QueryConfig config, String setting, String logKey, UserInfo userInfo) {
		<%=fileTitle%>Result result = new <%=fileTitle%>Result();

		if (StringUtils.equals(config.getOrder(), GglglConstants.QUERY_CONFIG_DEFAULT_ORDER)) {
			//config.setOrder("-XNXQDM,-WHJSRQ");	// 默认排序
		}

		try {
			String filterSub = dataPermissionService.getPermissionCondition("", userInfo);
			result = (<%=fileTitle%>Result) <%=beanTitle%>Dao.actionQueryPage("", param, config, setting, <%=fileTitle%>.class, <%=fileTitle%>Result.class, userInfo, filterSub);
			result.setCode(GglglConstants.SUCCESS);
		} catch (Exception ex) {
			commonService.endTrans(false);
			result.setCode(GglglConstants.FAILURE);
			result.setMsg(ex.getMessage());
			commonService.wrapAndThrowException(ex);
		}
		return result;
	}
}