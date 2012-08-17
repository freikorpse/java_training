<%@ page import="java.util.*" %>
<html>
<body>
<h1”>Beer Recommendations JSP</h1>
<p>
<%
Object obj = request.getAttribute("styles");
List<String> styles = List.class.cast(obj);
Iterator<String> it = styles.iterator();
while(it.hasNext()) {
	out.print("<br>try: " + it.next());
}
%>
</body>
</html>