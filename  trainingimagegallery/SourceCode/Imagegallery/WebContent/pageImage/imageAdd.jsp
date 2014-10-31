<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Image Add</title>
</head>
<style type="text/css">
	#wrapper {
		border: 1px solid #000;
		float: left;
	}
</style>
<body>
	<div align="center">
	<!--  <div id="wrapper" >-->
		<h3>Form Add Image</h3>
		<s:form action="SaveImageInfo" method="POST" enctype="multipart/form-data">
		<table border="0" align="center">
			<tr>
				<td><s:text name="Image Name" ></s:text></td>
				<td><s:textfield name="imageForm.img_name"  ></s:textfield></td>
			</tr>
			<tr>
				<td><s:text name="Description" ></s:text></td>
				<td><s:textarea name="imageForm.img_description" ></s:textarea></td>
			</tr>
			<tr>
				<td><s:text name="User Upload" ></s:text></td>
				<td><s:textfield name="imageForm.img_user_upload" ></s:textfield></td>
			</tr>
			<tr>
				<td><s:text name="Category" ></s:text></td>
				<td><s:select list="listCategory" name="category_name" listValue="name" listKey="name" value="%{name}" headerKey="-1" headerValue="--select item--" ></s:select></td>
			</tr>
			<tr>
				<td><s:text name="upload Image" ></s:text></td>
				<td><s:file name="imageForm.file" label="fileImage"></s:file></td>
			</tr>
		</table>
		<p align="center"><s:submit name="submit"></s:submit></p>
		</s:form>
		</div>
		<!--  </div> -->
</body>
</html>