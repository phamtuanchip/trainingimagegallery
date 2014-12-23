<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Image</title>
</head>
<body>
		<div align="center">
	<!--  <div id="wrapper" >-->
		<h3>Form Edit Image</h3>
		<s:form action="updateImage" method="POST" enctype="multipart/form-data">
		<table border="0" align="center">
			<tr>
				<td><s:text name="Image Name" ></s:text></td>
				<td><s:textfield name="image.img_name"  value="%{image.img_name}" ></s:textfield>
				<s:label style="color: red; font-style: italic;" name="error"></s:label>
				</td>
				<s:hidden name="image.id" value="%{image.id}" ></s:hidden>
			</tr>
			<tr>
				<td><s:text name="Description" ></s:text></td>
				<td><s:textarea name="image.img_description" value="%{image.img_description}" rows="2" cols="15"></s:textarea>
				<s:label style="color: red; font-style: italic;" name="error2"></s:label>
				</td>
			</tr>
			<tr>
				<td><s:text name="User Upload" ></s:text></td>
				<td><s:textfield name="image.img_userUpLoad" value="%{image.img_userUpLoad}"  ></s:textfield></td>
			</tr>
			<tr>
				<td><s:text name="Category" ></s:text></td>
				<td><s:select list="listCategory" name="image.category_id" listValue="name" listKey="id" value="%{name}" headerKey="%{image.category.id}"  headerValue="%{image.category.name}" ></s:select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><img height="60" width="60" src=" <s:url action='imageAction?imageId=%{image.id}'/>"/><td>
			</tr>
			<tr>
				<td><s:text name="upload Image" ></s:text></td>
				<td><s:file name="image.file" label="fileImage"></s:file></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
		<tr>
				<td></td>
				<td><s:submit name="submit"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;				
				<button onclick="window.location.href='listImage'" >Back</button>
				</td>
		</tr>
		</table>
		</s:form>
		</div>			
</html>