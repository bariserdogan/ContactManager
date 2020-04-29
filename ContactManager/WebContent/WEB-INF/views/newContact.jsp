<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address Book</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<style>  
.errormsg{color:red}  
</style> 
</head>
<body>
	<div class="container my-5">
	    <h3> Create/Edit Contact</h3>
	    <div class="card">
	        <div class="card-body">
	            <div class="col-md-10">
	                <form:form action="save" modelAttribute="contact" method="post">
	                    <form:hidden path="id"/>
	                    <div class="row">
	                        <div class="form-group col-md-10">
	                            <form:label path="name" class="col-form-label">Name</form:label> 
	                            <form:input type="text" path="name" class="form-control"/><form:errors path="name" cssClass="errormsg"/> 
	                        </div>
	                        <div class="form-group col-md-10">
	                            <form:label path="email" class="col-form-label">Email</form:label> 
	                            <form:input type="text" path="email" class="form-control"/><form:errors path="email" cssClass="errormsg"/> 
	                        </div>
	                        <div class="form-group col-md-10">
	                            <form:label path="address" class="col-form-label">Address</form:label> 
	                            <form:input type="text" path="address" class="form-control"/><form:errors path="address" cssClass="errormsg"/> 
	                            
	                        </div>
	                        <div class="form-group col-md-10">
	                            <form:label path="phone" class="col-form-label">Phone</form:label> 
	                            <form:input type="text" path="phone" class="form-control"/><form:errors path="phone" cssClass="errormsg"/> 
	                        </div>
	                        <div class="col-md-6">
	                            <input type="submit" class="btn btn-primary" value="Save">
	                        </div>                      
	                    </div>
	                </form:form>
	            </div>
	        </div>
	    </div>
	</div>


<!-- 
	<div align="center">
		<h1>Create/Edit Contact</h1>
		<form:form action="save" method="post" modelAttribute="contact">
			<table cellpadding="5">
				<form:hidden path="id"/>
				<tbody>
					<tr>
						<td>Name:</td>
						<td>
							<form:input path="name"/><br/>
							<form:errors path="name" cssClass="errormsg"/> 
						</td>
					</tr>
					<tr>
						<td>Email:</td>
						<td>
							<form:input path="email"/><br/>
							<form:errors path="email" cssClass="errormsg"/>
						</td>
					</tr>
					<tr>
						<td>Address:</td>
						<td>
							<form:input path="address"/><br/>
							<form:errors path="address" cssClass="errormsg"/>
						</td>
					</tr>
					<td>Phone:</td>
						<td>
							<form:input path="phone"/><br/>
							<form:errors path="phone" cssClass="errormsg"/>
						</td>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="3"><input type="submit" value="Save"/></td>
					</tr>
				</tfoot>
			</table>
		</form:form>
	</div>
	 -->
</body>
</html>