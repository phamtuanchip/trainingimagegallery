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
<link type="text/css" rel="stylesheet" href="css/stylePaging.css"/>
<script src="script/jquery-1.11.1.min.js"></script>

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
		$("#db_table").children().remove();
		$("#db_table").append('<thead><tr><td>ID</td><td>Name</td><td>Description</td><td>Date Create</td><td>size</td><td>User Update</td><td>Category</td><td>image</td><td>Manage</td>s</tr></thead><tbody>');
		$.each(data, function(index, value) {
			console.log(value.id);
			$("#db_table").append('<tr><td> ' 
		+(index +1) + '</td><td>'+ value.img_name 
		+'</td><td>'+ value.img_description +'</td><td>'+ value.dateCreate 
		+'</td><td>'+ value.img_size +'</td><td>'+ value.img_userUpLoad 
		+'</td><td> '+  value.category_name + '</td><td><img width="60" height="60" src=" /Imagegallery/imageAction.action?imageId='
		+ value.id +'"></td><td><a href="redirectToImageUpdateForm?imageId='
		+ value.id +'">Edit</a>||<a href="deleteImage?imageId='+ value.id +'">Delete</a></td></tr>');
		});
		$("#db_table").append('</tbody>');
	}	
	
	$('table.paginated').each(function() {
	    var currentPage = 0;
	    var numPerPage = 5;
	    var $table = $(this);
	    $table.bind('repaginate', function() {
	        $table.find('tbody tr').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();
	    });
	    $table.trigger('repaginate');
	    var numRows = $table.find('tbody tr').length;
	    var numPages = Math.ceil(numRows / numPerPage);
	    var $pager = $('<div class="pager"></div>');
	    for (var page = 0; page < numPages; page++) {
	        $('<span class="page-number"></span>').text(page + 1 ).bind('click', {
	            newPage: page
	        }, function(event) {
	            currentPage = event.data['newPage'];
	            $table.trigger('repaginate');
	            $(this).addClass('active').siblings().removeClass('active');
	        }).appendTo($pager).addClass('clickable');
	    }
	    $pager.insertBefore($table).find('span.page-number:first').addClass('active');
	});
	 
	

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
		<table class="paginated" border="1" cellpadding="2" cellspacing="2" id="db_table">
		<thead>
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
			<td><img height="60" width="60" src=" <s:url action='imageAction?imageId=%{#image.id}'/>"/></td>
			<td><a href="redirectToImageUpdateForm?imageId=<s:property value="id"/>" >Edit</a>||<a href="deleteImage?imageId=<s:property value="id"/>" >Delete</a></td>
		</tr>
		</s:iterator>
		</tbody>
		</table>
		<br>
		<br>
	</div>
</body>
</html>