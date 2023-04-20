<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.dharun.thirukural.dto.Thirukural"
    import="com.dharun.thirukural.thirukuralbynumber.NumberSearchController"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Thirukural By Number</title>
<link href = "thirukuralview.css" rel ="stylesheet" />
</head>
<body>
<div class="left">
		<img src="Images/Thiruvalluvar.jpg" height=700px width =600px >
	</div>
<form action="NumberSearch.jsp" method="post" onSubmit ="return validate()">
<div class="right">
<div class ="inner1">
<h2>குறளை எண் வாரியாக தேடுதல்</h2>
<input type ="number" class  = "kuralno" placeholder="குறள் எண்ணை தேர்வு செய்க(1-1330)" name = "number" id= "number"><br>
<button class ="btn-adhigaram" type ="submit">தேடு</button>
</div>
</div>
</form>
<script>
function validate(){
	var number = document.getElementById("number").value;
	if(number < 1 || number > 1330) {
		alert("1 மற்றும் 1330 க்கு இடையில் உள்ள எண்ணை உள்ளிடவும்");
		return false;
	}
	return true;
}

</script>

	<div class="right">
		<br />

		<div class="inner">
			<%
			String numberParam = request.getParameter("number");
			int thirukkuralNumber = -1;
			int displayStatus = 0; // 0 - number kural, 1 - kural of the day

			//To show kural of the day
			if (numberParam != null && !numberParam.isEmpty()) {
				thirukkuralNumber = Integer.parseInt(numberParam);
			}

			Thirukural kural = null;
			if (thirukkuralNumber == -1) {
				kural = NumberSearchController.getInstance().getKuralOfTheDay();
				displayStatus = 1;
			} else {
				kural = NumberSearchController.getInstance().getKural(thirukkuralNumber);
				displayStatus = 0;
			}
			if (kural == null) {
				out.println("இணையத் துண்டிப்பு ஏற்பட்டுள்ளது");
			} else {
			if (displayStatus == 1) {
			%>
			<h2>இன்றைய குறள்</h2>
			<%
			} else {
			%>
			<h2>நீங்கள் கேட்ட திருக்குறள்</h2>
			<%
			}
			out.println("குறள் எண்:" + kural.getNumber());
			out.println("</br>");
			out.println("</br>");
			out.println("</br>");
			out.println("<h2>குறள்:</h2>" + kural.getLine1() + "<br/>" + kural.getLine2());
			out.println("</br>");
			out.println("</br>");
			out.println("<h2>தமிழ் விளக்கம்:</h2>" + kural.getTamilExplanation());

			out.println("</br>");
			out.println("</br>");
			out.println("</br>");
			out.println("\nTranslation :" + kural.getEnglishExplanation() );
			out.println();
			}
			%>
		</div>
	</div>

</body>
</html>