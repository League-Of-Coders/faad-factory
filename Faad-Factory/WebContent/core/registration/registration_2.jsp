<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<script type="text/javascript">
function handleChange(value){
	var element = document.getElementById("otherAccountType");
	if (value!="Others")
		{
		
			element.style.display="none";
			element.setAttribute("label","change");
		}
	else
		{
			element.style.display="block";
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="handleChange('hide')">
<s:set name="myVar" value="test"/>    
<s:form action="/core/registration/register_2">
<s:textfield name="userName" label="User Name"></s:textfield>
<s:password name="password" label="Password"/>
<s:password name="cPassword" label="Re-enter Password"/>
<s:select name="accountType" label = "Account Type" list="accountTypes" headerKey="-1" headerValue="--Select One--" onchange="handleChange(this.value)"/>
<s:textfield name="otherAccountType" id="otherAccountType" value="Please Specify"></s:textfield>
<s:submit label="Next"/>
</s:form>
</body>
</html>