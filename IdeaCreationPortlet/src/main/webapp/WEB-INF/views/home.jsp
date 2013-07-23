<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>

<portlet:actionURL var="createIdeaURL">
	<portlet:param name="action" value="createIdeaAction" />
</portlet:actionURL>

<h1>Idea Creation</h1>

<p>The time on the server is ${serverTime}.</p>


<form action="${createIdeaURL}" method="post" name="newIdeaCreationForm">
	<table>
		<tr>
			<td>Title :</td>
			<td><input name="ideaTitle" /></td>
		</tr>
		<tr>
			<td>Description :</td>
			<td><textarea name="description"></textarea></td>
		</tr>
		<tr>
			<td>Co Inventor</td>
			<td><select>
					<c:forEach var="coInventor" items="coInventors">
						<option>${coInventor.name}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Contest</td>
			<td></td>
		</tr>
		<tr>
			<td>Category</td>
			<td></td>
		</tr>
		<tr>
			<td>Sub Category</td>
			<td></td>
		</tr>
		<tr>
			<td>Type</td>
			<td></td>
		</tr>
		<tr>
			<td>Stage</td>
			<td></td>
		</tr>
		<tr align="center">
			<td colspan="2"><input type="submit" value="Create" /></td>
		</tr>
	</table>
</form>