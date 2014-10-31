<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>list Image</title>
</head>
<script>
function myFunction() {
    var x;
    if (confirm("Press a button!") == true) {
        x = "You pressed OK!";
    } else {
        x = "You pressed Cancel!";
    }
    document.getElementById("demo").innerHTML = x;
}
</script>

<body>
	<div align="center">
		<table border="1" cellpadding="2" cellspacing="2" >
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Description</td>
			<td>Date Create</td>
			<td>size</td>
			<td>User Update</td>
			<td>Category</td>
			<td>image</td>
			<td>Manage</td>
		</tr>
		<s:iterator value="listImage" var="image">
		<tr>
			<td><s:property value="id" /></td>
			<td><s:property value="img_name" /></td>
			<td><s:property value="img_description" /></td>
			<td><s:property value="dateCreate" /></td>
			<td><s:property value="img_size" /></td>
			<td><s:property value="img_userUpLoad" /></td>
		 	<s:iterator value="listCategory" var="category" >
			<s:if test="%{#image.category_id == #category.id}">
			<td><s:property value="name" /></td>
			</s:if>
			</s:iterator>
			<!--  <td><s:url action="imageAction"><s:param name="imageId" ><s:property value="id"/></s:param></s:url></td>-->
			<s:hidden ></s:hidden>
			<td><img height="60" width="60" src=" <s:url action='imageAction?imageId=%{#image.id}'/>"/></td>
			<td><a href="redirectToImageUpdateForm?imageId=<s:property value="id"/>" >Edit</a>||<a href="deleteImage?imageId=<s:property value="id"/>" >Delete</a></td>
		</tr>
		</s:iterator>
		</table>
	</div>
</body>
</html>