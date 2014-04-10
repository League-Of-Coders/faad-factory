<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String id = request.getSession().getId(); %>
<s:form action="register_4">
<img src="jcaptcha.jpg;jsessionid='<%=id%>'"/><br>
<s:textfield name="jcaptcha"/>
<s:checkbox name="termsAgreed" label="I agree to all Terms and Conditions of FAAD Factory and I am the official Representative of the user whose account is being created."></s:checkbox>
<s:submit label="Next"/>
</s:form>
</body>
</html>