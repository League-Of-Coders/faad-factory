<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.app.core.models.User,com.app.core.AppEngine,com.app.core.widgets.Portfolio,com.app.frameworks.widget.Widget" %>
<!-- Imports -->
<script type="text/javascript" src="../profiles/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="../profiles/js/jquery.editinplace.js"></script>
<script type="text/javascript" src="../profiles/js/jquery.ui.js"></script>

<script type="text/javascript">var editable= false;</script>

<!-- Check for refresh -->
<%
	try{
	if(request.getAttribute("refresh").toString().trim().equals("true"))
	{
		request.setAttribute("refresh", false);
		System.out.println("Portfolio.jsp : refreshing.......");
		//response.sendRedirect(AppEngine.getInstance().getText("app.contextRoot")+ "/core/widgets/Portfolio.jsp");
%>
<script type="text/javascript">
	alert("refreshing...");
</script>
        <jsp:forward page='<%=AppEngine.getInstance().getText("app.contextRoot")+ "/core/profiles/view" %>'></jsp:forward>
<%
	}
	}catch(Exception ex)
	{
		System.out.println("Portfolio.jsp : no refresh value found ");
		ex.printStackTrace();
	}
%>

<!-- Identify User -->
<%
 	boolean editable=false;
	User requestedUser = (User)session.getAttribute("requestedUser");
	User user = (User)session.getAttribute("user");
	if (user.getEMail().equals(requestedUser.getEMail()))
	{
		editable=true;
		
%>
		<script type="text/javascript"> editable = true;</script>
<%
	}
%>

<!-- Get portfolio object for user -->
<%
	Portfolio portfolio = Portfolio.getUserPortfolio(requestedUser);
%>

<!-- Main Content -->

<br>
<%if(editable)  {%>
<!-- Edit in place -->
<script type="text/javascript">
	$(document).ready(function() {
        $("#aboutMe").editInPlace({
        //	callback: function(unused, enteredText) { return enteredText;}, 
        	url: "<%= AppEngine.getInstance().getText("app.contextRoot") + "/core/widgets/portfolio-action"%>",
		params: "element_id=aboutMe",
		bg_over: "#cff",
		field_type: "textarea",
		textarea_rows: "15",
		textarea_cols: "35",
		element_id: "aboutMe",
		saving_image: "./images/ajax-loader.gif"	
		});
    });
</script>
<!-- portfolio data -->
About Me : <div id="aboutMe"><%=portfolio.getAboutMe() %></div>
<%} %>
