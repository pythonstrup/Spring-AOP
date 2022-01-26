<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
	<title>Welcome</title>
</head>
<body>
	<p>Welcome! This is coming from a view</p>
	
	<form:form method="post" modelAttribute="user">
	<form:hidden path="guid"/>
		<fieldset>
			<form:label path="name">Name</form:label>
			<form:input path="name" type="text" required="required"/>
		</fieldset>
		<fieldset>
			<form:label path="userId">User ID</form:label>
			<form:input path="userId" type="text" required="required"/>
		</fieldset>
		<fieldset>
			<form:label path="pass">password</form:label>
			<form:input path="pass" type="text" required="required"/>
		</fieldset>
		<fieldset>
			<form:label path="pass2">Confirm password</form:label>
			<form:input path="pass2" type="text" required="required"/>
		</fieldset>
		<input class="btn btn-success" type="submit" value="Submit"/>
	</form:form>
</body>
</html>