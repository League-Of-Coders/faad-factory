<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
    <%@page import="com.app.core.models.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Faad Factory : Profile</title>
</head>
<body>
<div class="container">
<div id = "headerToolbar">
<tiles:insertAttribute name="header_toolbar" /><br>
</div>
<div id = "basicInfo">
 <tiles:insertAttribute name="basic_info" /><br/>
</div>
<div id = "widget_container">
 <tiles:insertAttribute name="widgets" /><br/>
</div>
<div id = "footer">
 <tiles:insertAttribute name="footer" /><br/>
</div>
</div>
</body>
</html>