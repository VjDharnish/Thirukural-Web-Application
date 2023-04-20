

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import = "java.util.Scanner" import = "com.dharun.thirukural.file.FileController"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thirukural Application</title>
<link href="thirukuralview.css" rel="stylesheet" />
</head>
<body>


<div class="left">
		<img src="Images/Thiruvalluvar.jpg" height=700px width =600px >
	</div>
	<div class="right">
		<br />

	<div class="inner">
	<h1>திருக்குறள் செயலிக்கு உங்களை வரவேற்கிறோம்</h1>
	<form action="NumberSearch.jsp" method="get">
		<button type="submit" class="homeoption">திருக்குறளை எண்
			வாரியாக தேட</button>
	</form>
	<br>
	<form action = "Adhigaram.jsp" method = "get">
	<button type="submit" class="homeoption" onclick="">
		திருக்குறளை அதிகாரம் வாரியாக தேட</button>
	<br>
	</form>
	<form  action ="ThirukuralView.jsp" method  ="get">
	<button type="submit" class="homeoption" name  = "speciality">
		திருக்குறளின் சிறப்புகளை பற்றி அரிய</button>
	</form >
	<br>
	<form  action ="ThirukuralView.jsp" method  ="get">
	<button type="submit" class="homeoption" name  = "history">
		திருக்குறளின் வரலாற்றை பற்றி அரிய</button>
	</form>
	<%
	String speciality = request.getParameter("speciality");
	String history  = request.getParameter("history");
	if(speciality!=null){
		history=null;
		%>
		<h2>திருக்குறள் சிறப்புகள்</h2>
		<%		Scanner special = FileController.getInstance().getSpecality();
		while(special.hasNextLine()) {
			out.println("<p>" + special.nextLine()+ "</p>");
		}
		//out.println("----------------------------------------------------------------------------------------");
		//out.println("----------------------------------------------------------------------------------------");
	}
	if(history!=null){
		speciality=null;
		%>
		<h2>திருக்குறள் வரலாறு</h2>
		<%
		Scanner hist = FileController.getInstance().getHistory();
		while(hist.hasNextLine()) {
			out.println("<p>" + hist.nextLine()+ "</p>");
		}
		//out.println("----------------------------------------------------------------------------------------");
		//out.println("----------------------------------------------------------------------------------------");
	}
	
	%>
	</div>
	</div>
	
	


</body>
</html>