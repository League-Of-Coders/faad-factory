<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix = "s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Faad-Factory</title>
<link href="core/registration/styles/registration_layout.css" rel="stylesheet" type="text/css">
</head>
<body>
<s:if test="hasActionMessages()">
   <div class="notify">
      <s:actionmessage/>
   </div>
</s:if>
<div id="formWrapper">
<div class="form">
<s:form action="/core/registration/register_1" method="post">
<s:textfield name="firstName" label="First Name "/>
<s:textfield name="lastName" label="Last Name "/>
<s:textfield name="eMail" label="E-Mail "/>
<s:submit value="Next"/>
</s:form>
</div>
</div>
</body>
</html>