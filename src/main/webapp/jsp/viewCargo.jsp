<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Cargo</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<!-- //cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css
 -->
<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">


<script type="text/javascript">
	$(document).ready(function() {
		$('#cargotab').DataTable({
			pagingType : 'full_numbers',
		});
	});
</script>





</head>
<body>
	<br>
	<h3>All cargo details</h3>
	<br>
	<h5><a style="color:black" href="/cargo">AddCargo</a></h5>
	<br>
	<table id="cargotab" class="table">
		<thead class="thead-dark">
			<tr>
				<th>Cargo Id</th>
				<th>Truck Information</th>
				<th>Cargo Type</th>
				<th>Cargo Issuer</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allCargo}" var="cargo">
				<tr>
					<td>${cargo.cargoId}</td>
					<td>${cargo.truck}</td>
					<td>${cargo.cargoType}</td>
					<td>${cargo.cargoIssuer}</td>
					<td><a href="editCargo?cargoId=${cargo.cargoId}">Edit</a></td>
					<td><a href="deleteCargo?cargoId=${cargo.cargoId}">Delete</a>
				</tr>
			</c:forEach>

		</tbody>

	</table>
</body>
</html>