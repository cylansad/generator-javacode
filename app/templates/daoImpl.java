package com.wisedu.emap.<%=com%>.dao.impl;

import org.springframework.stereotype.Service;

import com.wisedu.emap.gglgl.dao.impl.CommonDaoImpl;
import com.wisedu.emap.<%=com%>.dao.<%=fileTitle%>Dao;
import com.wisedu.emap.<%=com%>.po.<%=fileTitle%>;

@Service("<%=beanTitle%>Dao")
public class <%=fileTitle%>DaoImpl extends CommonDaoImpl<<%=fileTitle%>> implements <%=fileTitle%>Dao {

}