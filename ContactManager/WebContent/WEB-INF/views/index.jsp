<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address Book</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>
<body>
	<div class="container my-2">
	    <div class="card">
		    <div class="card-body">
		        <div class="container my-5">
		            <p class="my-5">
		                <a href="/ContactManager/new" class="btn btn-primary">
		                <i class="fas fa-user-plus ml-2"> Add Contact </i></a>
		            </p>
		            <div class="col-md-10">
	                    <table class="table table-striped table-responsive-md">
	                        <thead>
	                            <tr>
	                                <th>Name</th>
	                                <th>Email</th>
	                                <th>Address</th>
	                                <th>Phone</th>
	                                <th>Edit</th>
                                	<th>Delete</th>
	                            </tr>
	                        </thead>
	                        <tbody>
								<c:forEach items="${listContact}" var="contact">
									<tr>
										<td>${contact.name}</td>
										<td>${contact.email}</td>
										<td>${contact.address}</td>
										<td>${contact.phone}</td>
										<td>
											<a href="/ContactManager/edit?id=${contact.id}" class="btn btn-primary">
												<i class="fas fa-user-edit ml-2"></i>
											</a> 
										</td>
										<td>
											<a href="/ContactManager/delete?id=${contact.id}" class="btn btn-primary">
												<i class="fas fa-user-times ml-2"></i>
											</a> 
										</td>
									</tr>
								</c:forEach>
							</tbody> 
	                    </table>
		            </div>
		        </div>
		    </div>
	    </div>
    </div>
</body>
</html>