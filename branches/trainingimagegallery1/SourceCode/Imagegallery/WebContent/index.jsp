<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center" >
	<s:form action="ListImage" >
		<s:submit name="Wellcome Page Image" value="wellcom Image gallery"></s:submit>
	</s:form>
	<s:form action="ListImageJSF" >
		<s:submit name="Wellcome Page Image" value="wellcom Image gallery with JSF "></s:submit>
	</s:form>
	
	</div>
</body>
</html>