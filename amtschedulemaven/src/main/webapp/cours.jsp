<%@page import="com.amt.schedule.entities.Cours"%>
<%@page import="com.amt.schedule.entities.Plage"%>
<%@page import="com.amt.schedule.entities.Matiere"%>
<%@page import="com.amt.schedule.entities.Utilisateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>cours:</p>
	<%
						@SuppressWarnings("unchecked")
                     	List<Cours> cours = (List<Cours>) request.getAttribute("cours");
                    	for(int i=0; i<cours.size(); i++){
                    		%>

	<div><%=cours.get(i).getMatiere()%>
		&nbsp;<%=cours.get(i).getUtilisateur().getNom()%>&nbsp;<%=cours.get(i).getPlage()%></div>
	<%
                    	}
                    %>
</body>
</html>