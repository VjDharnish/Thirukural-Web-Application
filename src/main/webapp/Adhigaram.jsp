<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.dharun.thirukural.dto.*"
	import="com.dharun.thirukural.thirukuralbyadhigaram.AdhigaramController"
	import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adhigarm Search</title>
<link href="thirukuralview.css" rel="stylesheet" />
</head>
<body>
	<div class="left">
		<img src="Images/Thiruvalluvar.jpg" height=700px width =600px >
	</div>

	<form action="Adhigaram.jsp" class="kuralbox" method="get"
		onSubmit="return validate()">
		<div class="right">
		<h2>அதிகாரம் வாரியான தேடலை தேர்ந்தெடுத்துள்ளீர்கள்</h2>
			
				

				<div class="form">
					<input type="number" class="kuralno"
						placeholder="அதிகாரம் எண்ணை உள்ளிடவும்(1-133)" id="number"
						name="number" value="number" />
					<button class="btn-adhigaram" type="submit">தேடு</button>
				</div>


			</div>
		
	</form>

	<script type="text/javascript">
function validate(){
	var number  = +
	document.getElementById("number").value;
	if(number<1 || number> 133){
		alert("1 மற்றும் 133 க்கு இடையில் உள்ள எண்ணை உள்ளிடவும்");
		return false;
	}
	return true;
}
</script>

	<div class="right">
		<br>

		<div class="inner">
			<%
			String option = request.getParameter("number");
			if (option != null) {
				List<Thirukural> kurals = AdhigaramController.getInstance().findAdhigaram(option);
				if (kurals == null) {
					out.println("இணையத் துண்டிப்பு ஏற்பட்டுள்ளது");
				} else {
					out.println("<div class = \"kuralinner\">");
					for (int i = 0; i < 10; i++) {
				Thirukural kural = kurals.get(i);

				//out.println("குறள் எண்:" + kural.getNumber());
				//out.println("</br>");
				//out.println("</br>");
				//out.println("</br>");
				out.println("<p class ='kuralline'>" + kural.getLine1() + "<br/>" + kural.getLine2() + "<br/> </p>");
				//out.println("</br>");
				//out.println("</br>");
				//out.println("<h2>தமிழ் விளக்கம்:</h2>" + kural.getTamilExplanation());

				//out.println("</br>");
				//out.println("</br>");
				//out.println("</br>");
				//out.println("\nTranslation :" + kural.getEnglishExplanation() );
				out.println();
					}
					out.println("</div>");
				}
			}
			%>
		</div>
	</div>




</body>
</html>