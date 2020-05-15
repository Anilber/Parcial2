<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<%
String nombre= request.getParameter("nombreCl");
String apellido= request.getParameter("apellidoCl");
String idBus= request.getParameter("idBus");




if(idBus==null){
	idBus="";
	nombre="";
	apellido="";
	
}
%>

<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>


<body>		  	
<form action="ServeletController">
<table align="center">
	<thead>
	
	</thead>	
				<tbody>
					
						<tr>
							<td>
								<p>Nombre usuario</p> <input type="text" name="Nusuario" value="<%=nombre%>">
								<p>Apellido usuario</p> <input type="text" name="Ausuario" value="<%=apellido%>">
								<p>id</p> <input type="text" name="Id" value="<%=idBus%>">
										
										
								<br>
								<br>		
										
									
								</td>
						</tr>
				</tbody>
			</table>
			
				
				<input type="submit" class="btn btn-info" value="ACTUALIZAR" name="btn">
</form>
</body>
</html>