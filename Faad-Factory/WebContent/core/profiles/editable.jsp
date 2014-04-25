<%@page import="com.app.core.models.User,com.app.frameworks.widget.Widget" %>
<%@taglib uri="/struts-tags" prefix="s"%>
 <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%
	User user = (User)session.getAttribute("user");
%>
<link href="styles/tabbed.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script>
$(document).ready(function(){
  
    $(".tab_content:not(:first)").hide();
	
	$("#tabs li").click(function(event){
			
		var id = $(event.target).index();
		$(".tab_content").hide().eq(id).show();
	});
  
});
</script>
<div id="wrapper">
<div id="tabs">
<ul>
<%
	
	for(Widget widget:user.getWidgets())
	{ // Start tabbed panel
%>
		<li><%=widget.getWrapper().getName() %></li>
<%  } 
%>
</ul><br><br>
</div>
<div id="widget_content">
<%
	int i=1;
	for(Widget widget:user.getWidgets())
	{ // Start content
		String renderer = "/core/widgets/" + widget.getWrapper().getName()+".jsp";
%>
		<div class="tab_content"id="<%="tab_content_"+i%>"><%=widget.getWrapper().getName() %> content
		<jsp:include page="<%=renderer%>"/>
		</div>
<%  
	i++;
	} 
%>
</div>
</div>