<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>

<portlet:actionURL var="createIdeaURL">
	<portlet:param name="action" value="createIdeaAction" />
</portlet:actionURL>

<form action="${createIdeaURL}" method="post" name="IdeaForm">

	<table>
		<tr>
			<th colspan="2">Idea Submission Form</th>
		</tr>
		<tr>
			<td>IdeaTitle:</td>
			<td><input name="ideaTitle" /></td>
		</tr>
		<tr>
			<td>SubmissionDate:</td>
			<td><input name="sumissionDate" value="<%=new Date() %>" /></td>
		</tr>
		<tr>
			<td>Idea ConTest:</td>
			<td>
				<select>
					<c:forEach var="contest" items="${IdeaContest}">
						<option>${contest.contestName}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		 <tr>
			<td>Category:</td>
			<td>
				<select>
					<c:forEach var="category" items="${Categories}">
						<option>${category.categoryName}</option>
					</c:forEach>
				</select>
			</td>
		</tr> 
		 <tr>
			<td>Sub Category:</td>
			<td>
				<select>
					<c:forEach var="subcategory" items="${SubCategories}">
						<option>${subcategory.name}</option>
					</c:forEach>
				</select>
			</td>
		</tr> 
		<tr>
			<td>Stage:</td>
			<td><input type="radio" name="ideastage" />Refinment <input
				type="radio" name="ideastage" />Analysis <input type="radio"
				name="ideastage" />Developement</td>
		</tr>
		<tr>
		<td>IdeaType:</td>
		<td>
				<select>
					<c:forEach var="ideatype" items="${IdeaTypes}">
						<option>${ideatype.ideaTypeName}</option>
					</c:forEach>
				</select>
			</td>
		</tr> 
		<tr>
			<td>Description:</td>
			<td><textarea name="description"></textarea></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="Create" /></td>
		</tr>
	</table>
</form>