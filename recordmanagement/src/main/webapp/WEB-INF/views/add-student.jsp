<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>


</head>

<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">FILL STUDENT'S DETAILS</h1>

				<form action="savestudent" modelAttribute="newStudent"
					method="POST">

					
					<div class="form-group">
						<label for="name">Student Name</label> <input type="text"
							class="form-control" name="studentName" 
							id="studentName" rows="1"
							placeholder="Enter the student name here">
							
					</div>


					<div class="form-group">
						<label for="department">Department</label> <input type="text"
							class="form-control" name="departmentName"
							id="departmentName" rows="1"
							placeholder="Enter the department name here">
							
					</div>

					<div class="form-group">
						<label for="country">Country</label> <input type="text"
							class="form-control" name="countryName" 
							id="countryName"rows="1" 
							placeholder="Enter the country name here">
							
					</div>

					<div class="container text-center">

						<a href="/list"
							class="btn btn-outline-danger"> Back</a>
						<button type="submit" class="btn btn-primary">Add</button>
					</div>

				</form>
			</div>
		</div>
	</div>

</body>
</html>