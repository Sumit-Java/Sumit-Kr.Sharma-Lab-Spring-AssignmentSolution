<!DOCTYPE html>

<html>

<head>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<title>Students List</title>
</head>

<body
	background="C:\Users\mmjob\eclipse-workspace\recordmanagement\recordmanagement\src\main\resources\static\bg.jpg">

	<!-- put new button: Logout -->

	<div class="container mt-3">
	
			<div class="col-md-12"></div>

			<div class="text-right mb-3">
				<input type="button" value="Log out"
					onclick="window.location.href='http://localhost:8080/logout'; return false;"
					class="btn btn-outline-success" />
			</div>
		</div>
	

	<div class="container mt-5">

		<div class="row">

			<div class="col-md-12"></div>

			<h3 class="text-centre mb-3">
				<b>STUDENT REGISTERATION APPLICATION</b>
			</h3>

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">STUDENT NAME</th>
						<th scope="col">DEPARTMENT</th>
						<th scope="col">COUNTRY</th>
						<th scope="col">ACTION</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${list}" var="students">

						<!-- construct an "update" link with student id -->
						<c:url var="updateLink" value="/update">
							<c:param name="studentId" value="${students.id}" />
						</c:url>

						<!-- construct an "delete" link with student id -->
						<c:url var="deleteLink" value="/delete">
							<c:param name="studentId" value="${students.id}" />
						</c:url>


						<tr>
							<th scope="row">${students.id}</th>
							<td>${students.studentName}</td>
							<td>${students.departmentName}</td>
							<td>${students.countryName}</td>



							<td><a href="${updateLink}"><i
									class="fas fa-pen-nib text-primary" style=""font-size: 35px;"></i></a>
								<a href="${deleteLink}"
								onclick="if(!(confirm('Are you Sure you want to delete this Student?'))) return false">
									<i class="fas fa-trash text-danger" style=""font-size: 35px;"></i>

							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="container text-centre">

				<!-- put new button: Add Student -->

				<input type="button" value="New Student"
					onclick="window.location.href='addStudent'; return false;"
					class="btn btn-outline-success" />


			</div>
		</div>
	</div>
</body>
</html>