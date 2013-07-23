<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>

<portlet:actionURL var="createIdeaURL">
	<portlet:param name="action" value="createIdeaAction" />
</portlet:actionURL>

<h1>Idea Creation</h1>

<p>The time on the server is ${serverTime}.</p>

<form:form action="${createIdeaURL}" method="post"  modelAttribute="newIdea" commandName="newIdea" name="newIdeaCreationForm" htmlEscape="false">
	Name : <form:input path="name" name="name" />
	<br />
	innovation Arena : <form:input path="innoArena" name="innoArena" />
	<br />
	Description : <form:textarea path="description" name="description" />
	<br />
	<input type="submit" value="Create"/>
</form:form>