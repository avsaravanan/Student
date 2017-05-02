<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="http://getbootstrap.com/favicon.ico">

<title>Student List</title>

<!-- Bootstrap core CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>

<body>

<div class="page-header">
    <h3 class="text-center">Student Management System</h3>
</div>
<div class="container">
<div class="text-center text-muted"></div>
        <div class="table-responsive">
            <table class="table table-hover" id="metric">
                <thead>
                    <tr>
                        <th data-sort-initial="descending">Reference #</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${student}" var="stdnt">
                        <tr>
                            <spring:url value="/student/editstudent/" var="url" htmlEscape="true"/>
                            <td><a href="${url}<c:out value="${stdnt.id}"></c:out>" class="btn btn-link" target="_blank"><c:out value="${stdnt.id}"></c:out></a></td>
                            <td><c:out value="${stdnt.first_name}"></c:out></td>
                            <td><c:out value="${stdnt.last_name}"></c:out></td>
                            <td><c:out value="${stdnt.email}"></c:out></td>
                            
                            </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </div>
</body>
</html>    
