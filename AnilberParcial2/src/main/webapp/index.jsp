<html>


<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">

	$(document).ready(function(){
		$('#carga').click(function(){
			var bnt =$('#carga').val();
			$.post('ServeletController',{
				
			},function(response){
				let datos = JSON.parse(response)
				var tabladatos = document.getElementById('tablaDatos')
				for(let item of datos){
					
				tabladatos.innerHTML += `

		 <tr>
 		 <td>${item.apellido}</td>
		<td>${item.nombre}</td>
		 <td>${item.id}</td>
	
 		<td> <a href="ServeletController?btn=ELIMINAR&Id=${item.id}" class="btn btn-warning"> Eliminar<a/> 
 			 <a href="botones.jsp?idBus=${item.id}&nombreCl=${item.nombre}&apellidoCl=${item.apellido}"class="btn btn-danger"> Actualizar<a/>	
		</td>
		 </tr>

		 `
		 }

		});
	
	});
		
	});

</script>



<body>
<form action="ServeletController" method="post">
<input type="submit" class="btn btn-info" name="btncerrar"  value="cerrar seesion" >
</form>






<input type="submit" class="btn btn-info" name="btn" value="Cargar" id="carga">

  <a type="submit" class="btn btn-info" name="btn"href="login.jsp">Iniciar sesion</a> 



<table class="table table-dark" id="tablaDatos">
			 	<thead>
			 		<th>Apellido</th>
			 		<th>Nombre</th>
			 		<th>Id</th>
					<th>Opciones</th>

			 	</thead>

			 	<tbody>
			 		

			 	</tbody>

			 </table>



</body>
</html>
