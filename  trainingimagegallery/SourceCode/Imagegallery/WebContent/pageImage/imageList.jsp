<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>list Image</title>
</head>
<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"/>
<!-- <link type="text/css" rel="stylesheet" href="css/stylePaging.css"/> -->
<script src="script/jquery-1.11.1.min.js"></script>
 <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	
	$('#button_search').off("click").on("click",function(){
		var text_search = $("#text_search").val();
		var url = "rest/image/search/" + text_search;
		$.ajax({
			type : 'GET',
			url: url,
			contentType: 'application/json',
			success: callback,
			error: function(reg, status, ex){},
			timeout: 60000
			});
		
	});
	
	function callback(data){
		console.log("back");
		$("#db_table").DataTable().fnClearTable();
		$.each(data, function(index, value) {
	/*	$("#db_table").append('<tr><td> ' 
		+(index +1) + '</td><td>'+ value.img_name 
		+'</td><td>'+ value.img_description +'</td><td>'+ value.dateCreate 
		+'</td><td>'+ value.img_size +'</td><td>'+ value.img_userUpLoad 
		+'</td><td> '+  value.category_name + '</td><td><img width="60" height="60" src=" /Imagegallery/imageAction.action?imageId='
		+ value.id +'"></td><td><a href="redirectToImageUpdateForm?imageId='
		+ value.id +'">Edit</a>||<a href="deleteImage?imageId='+ value.id +'">Delete</a></td></tr>');
	*/	
		$("#db_table").DataTable().fnAddData([
				index + 1,
				value.img_name,
				value.img_description,
				value.dateCreate,
				value.img_size,
				value.img_userUpLoad,
				value.category_name,
				'<img width="100" height="100" src="/Imagegallery/imageAction.action?imageId=' + value.id  + '">',
				'<a href="redirectToImageUpdateForm?imageId='
					+ value.id +'">Edit</a>||<a href="deleteImage?imageId='+ value.id +'">Delete</a>'
				                		
		]);	
		});
	//	$("#db_table").append('</tbody>');
		}
		/*$("#db_table").DataTable({
			"aaData": data,
			"aocolumns":[
				{"mData": "img_name"},
				{"mData": "img_description"},
				{"mData": "dateCreate"},
				{"mData": "img_size"},
				{"mData": "img_userUpLoad"},
			],
			"aoColumnDefs": [{
					"aTargets":[7],
					"bSortable" : false,
					"mRender": function( img_no, type, full){
								return '<img width="60" height="60" src=" /Imagegallery/imageAction.action?imageId=' + img_no;
						}
					
				}
				
			  ]
		"bDestroy": true
		});*/
		
		
	
	
	 
	

});	
</script>

<body>
	<div align="center">
		<table border="0" >
			<tr>
				<td> Enter Text </td>
				<td> <input type="text" id="text_search" name="text_search" /></td>
				<td><input id="button_search"  type="button" name="button_Search" value="Search" /></td>
				<td><button onclick="window.location.href='redirectToSlideShow'" >SlideShow</button></td>
				<td><button onclick="window.location.href='redirectImageCreateForm'" >Add Image</button></td>
			</tr>
		</table>
		<br><br>
	<!-- 	<display:table id="studentTable" name="listImage" pagesize="5"
				cellpadding="5px;" cellspacing="5px;"
				style="margin-left:50px;margin-top:20px;" requestURI="">
				<display:column property="id" title="ID" />
				<display:column property="img_name" title="Name" />
				<display:column property="img_description" title="Department" />
				<display:column property="dateCreate" title="Cate Create" />
				<display:column property="img_size" title="Size" />
				<display:column  property="img_userUpLoad" title="User Upload" />
			</display:table>
		 -->
		 <div id="table">
		<table  id="db_table">
		<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Date Create</th>
			<th>Size</th>
			<th>User Update</th>
			<th>Category</th>
			<th>Image</th>
			<th>Manage</th>
		</tr>
		</thead>
		<tbody>
		<s:iterator value="listImage" var="image" status="status">
		<tr>
			<td><s:property value="%{#status.count}" /></td>
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
			<s:hidden ></s:hidden>
			<td><img height="100" width="100" src=" <s:url action='imageAction?imageId=%{#image.id}'/>"/></td>
			<td><a href="redirectToImageUpdateForm?imageId=<s:property value="id"/>" >Edit</a>||<a href="deleteImage?imageId=<s:property value="id"/>" >Delete</a></td>
		</tr>
		</s:iterator>
		</tbody>
		</table>
		</div>
		 <script>
 			 $(function(){
  				  $("#db_table").dataTable();	
  	 		})
  		</script>
	</div>
</body>
</html>