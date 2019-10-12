<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="#" id="formId">
	<input type="file" name="img"><br>
	<input type="button" value="上传" onclick="doUpload();"><br>
	<input type="button" value="下载" onclick="downlo();">
	<input type="hidden" value="" id="hid">
</form>
<div>
	<img id="i1" alt="" width="700px" height="500px" src="">
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/Js/jquery-1.11.0.js"></script>
<script type="text/javascript">
function doUpload(){
	var formData = new FormData($("#formId")[0]);
	alert("xxx");
	$.ajax({
		url:"${pageContext.request.contextPath}/uploadFastDFS",
		type:"POST",
		data:formData,
		async:false,
		contentType:false,
		processData:false,
		success:function(data) {
			alert(data.obj);
			$("#i1").attr("src",data.obj.path);
			$("#hid").val(data.obj.fid);
			
		}
	});
	
	
}
	function downlo() {
		// 获得id
		var fid = $("#hid").val();
		window.open("http://localhost:8080/hospital/download?fid="+fid);
	}	
</script>
</html>