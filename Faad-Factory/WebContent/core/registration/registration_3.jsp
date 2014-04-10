<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags"  prefix="s"%>
<%@page import="com.app.core.models.User" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Widgets</title>
<%-- ---------------------- jsp variable declaration ------------ --%>
<%
	// recieve widget list from session scope
	String[] widgets = (String[])session.getAttribute("widgets");
	int count=0;
	for(String temp:widgets)
	{
		System.out.println(temp);
		count++;		
	}
%>
<%-- ----------------------- link to external js file ---------------- --%>
<script type="text/javascript" src="js/r3.js"></script>
<%-- ------------------- js variable declaration ----------------------- --%>
<script type="text/javascript">
var jsCount = parseInt('<%=count%>'); 
var widget = new Array(); // widget list
var i=0; //counter
/* alert("fromo the document");
alert(jsCount);
checker();*/
</script>
<%-- ----------------------js widget initialization from jsp variables ------- --%>
<%for(int i=0;i<count;i++) { %>
<script type="text/javascript">widget[i]='<%=widgets[i]%>';alert(widget[i]);i++;</script>
<%} %>

</head>
<body>
check body 12
<form id="form" action="/Faad-Factory/core/registration/register_3">
<input type="button" onClick="createFormAndHiddenFields(jsCount,widget)" value="Next"/>
</form>

</body>
</html>