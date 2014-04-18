<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags"  prefix="s"%>
<%@page import="com.app.core.models.User,com.app.frameworks.widget.WidgetWrapper,java.util.ArrayList" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Widgets</title>
<%-- ---------------------- jsp variable declaration ------------ --%>
<%
	// recieve widget list from session scope
	ArrayList<WidgetWrapper> widgetWrappers = (ArrayList<WidgetWrapper>)session.getAttribute("widgetWrappers");
	System.out.println("hello");
%>
<%-- ----------------------- link to external js file ---------------- --%>
<script type="text/javascript" src="js/r3.js"></script>
<%-- ------------------- js variable declaration ----------------------- --%>
<script type="text/javascript">

var jsCount = parseInt('<%//=count%>'); 
//var widget = new Array(); // widget list
//var i=0; //counter
/* alert("fromo the document");
alert(jsCount);
checker();*/
</script>
<%-- ----------------------js widget initialization from jsp variables ------- --%>
<% //for(int i=0;i<count;i++) { %>
<!-- <script type="text/javascript">widget[i]='<%//=widgets[i]%>';alert(widget[i]);i++;</script> -->
<%//} %>

</head>
<body>
<s:if test="hasActionErrors()">
   <div class="errors">
      <s:actionerror/>
   </div>
</s:if>

<form id="form" action="/Faad-Factory/core/registration/register_3">
<table>
<tr><th>Select</th><th>Widget Name</th><th>Description</th><th>Developer</th><th>Version</th></tr>
<caption>Available Widgets</caption>
<%for(WidgetWrapper widgetWrapper:widgetWrappers) {%>
<tr>
<td><input type="checkbox" name="chosenWidgetWrappers" value="<%=widgetWrapper.getWidgetId()%>"/></td>
<td><%=widgetWrapper.getName() %></td>
<td><%=widgetWrapper.getDescription() %></td>
<td><%=widgetWrapper.getDeveloper() %></td>
<td><%=widgetWrapper.getVersion() %></td>
</tr>
<%} %>
<tr><td><td><td><td><td><input type="submit" onClick="createFormAndHiddenFields(jsCount,widget)" value="Next"/></td></tr>
</table>
</form>

</body>
</html>