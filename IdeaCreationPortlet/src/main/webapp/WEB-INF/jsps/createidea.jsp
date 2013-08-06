<%@page import="java.util.Date"%>
<%@page import="com.ibm.icu.util.Calendar"%>
<%@include file="/WEB-INF/jsps/init.jsp"%>
<%@page isELIgnored="false"%>
<portlet:actionURL var="createIdeaURL">
	<portlet:param name="action" value="createIdea" />
</portlet:actionURL>
<portlet:renderURL var="saveFileURL">
	<portlet:param name="view" value="file" />
</portlet:renderURL>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/main-style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/jquery-ui.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/tinyeditor.css" />
</head>
<%
	Date nowDate = new Date();
	pageContext.setAttribute("submissionDate", nowDate);
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.MONTH, 1);
	Date VoteDate = cal.getTime();
	pageContext.setAttribute("VotedDate", VoteDate);
%>
<fmt:formatDate pattern="dd MMM, yyyy" value="${submissionDate}"
	var="formattedSubmissionDate" />
<fmt:formatDate pattern="dd MMM, yyyy" value="${VotedDate}"
	var="formattedVotedDate" />
<div>
	<!-- class="divformStyle" -->
	<form action="${createIdeaURL}" method="post" name="IdeaForm"
		enctype="multipart/form-data">
		<div>
			<div style="line-height: 1cm">
				Idea Submission -Full Form<br />
			</div>
			<div>
				<div>
					<span class="spanIdeaTitle">IdeaTitle:</span> <span
						class="spanIdeaInputTitle"><input type="text"
						name="ideaTitle" class="inputIdeaTitle" /></span>
				</div>
				<div class="clear"></div>
				<div>
					<span>SubmissionDate:</span> <span><label>${formattedSubmissionDate}</label></span>

				</div>
				<div>
					<span>Voting Begins:</span> <span><label>${formattedVotedDate}(in
							four Weeks)</label></span>
				</div>
				<div>
					<span>Idea ConTest:</span> <span><select name="ideaContest">
							<c:forEach var="contest" items="${IdeaContest}">
								<option value="${contest.contestId}">${contest.contestName}</option>
							</c:forEach>
					</select></span>
				</div>
				<div>
					<span>Category:</span> <span><select name="ideaCategory">
							<c:forEach var="category" items="${Categories}">
								<option value="${category.categoryId}">${category.categoryName}</option>
							</c:forEach>
					</select></span>
				</div>
				<div>
					<span>Sub Category:</span> <span><select
						name="ideasubCategory">
							<c:forEach var="subcategory" items="${SubCategories}">
								<option value="${subcategory.subcategoryId}">${subcategory.name}</option>
							</c:forEach>
					</select></span>
				</div>
				<div>
					<span>Stage:</span> <span><input type="radio"
						name="ideastage" value="Refinment" checked="checked"/>Refinment <input
						type="radio" name="ideastage" value="Analysis" />Analysis <input
						type="radio" name="ideastage" value="Developement" />Developement</span>
				</div>
				<div>
					<span>IdeaType:</span> <span><select name="ideaType">
							<c:forEach var="ideatype" items="${IdeaTypes}">
								<option value="${ideatype.ideaTypeId}">${ideatype.ideaTypeName}</option>
							</c:forEach>
					</select></span>
				</div>
				<div id="iframediv">
					<span>Description:</span><span><textarea id="tinyeditor" name="tinyeditor"
							style="width: 400px; height: 200px"></textarea></span>
				</div>
				<div>
				<input type="hidden" name="app-context" value="Personal" id="file-upload-context" />
      			<input type="hidden" name="app-space" value="Exo Space" id="file-upload-space" />
      			<input type="hidden" name="data-uuid" value="agile1" id="file-upload-input" />
      			<input type="hidden" name="app-filter" value="/sites/intranet/documents/Folksonomy/" id="file-upload-filter" />
      			<input type="file" name="ideafile" style="width:400px; margin: auto; padding-left: 30px;" />
				</div>
				<div>
					 <input type="hidden" name="addurl_" value="<%=createIdeaURL.toString()%>"> 
              &nbsp;&nbsp;&nbsp;
			<input type="button" onclick="<portlet:namespace/>SubmitIdeaForm()" value="Submit" style="width: 75px;margin-left: 50px;">
			&nbsp;&nbsp;&nbsp;
			<input type="button" value="Reset" style="width:75px;" onclick="<portlet:namespace />ResetIdeaForm()" />
				&nbsp;&nbsp;&nbsp;
			<input type="button" value="Cancel" style="width:75px;" onclick="<portlet:namespace />CancelIdeaForm()" />
				</div>
			</div>
		</div>
	</form>
</div>
<%-- <div><input type="button" name="fileUploadbutton" value="Attachfiles" onclick="<portlet:namespace/>OpenFileUploadDialog()"/></div>
<div id="fileUpload" style="display: none;">
<form name="uploadForm" id="uploadForm" class="fileUploadForm" method="post" enctype="multipart/form-data" action="<%=insertfileURL.toString()%>">
	<span>Idea File:</span> <span> 
	<input type="hidden" name="addurl_" value="<%=insertfileURL.toString()%>"> 
	<input type="hidden"
		name="app-context" value="Personal" id="file-upload-context" /> <input
		type="hidden" name="app-space" value="Exo Space"
		id="file-upload-space" /> <input type="hidden" name="data-uuid"
		value="agile1" id="file-upload-input" /> <input type="hidden"
		name="app-filter" value="/sites/intranet/documents/Folksonomy/"
		id="file-upload-filter" /> <input type="file" name="pic"
		style="width: 400px; margin: auto; padding-left: 30px;" />
	</span>
	<input type="Submit" value="File Upload"> 
	 <input type="button" onclick="<portlet:namespace/>SubmitFileUploadForm()" value="Submit" style="width: 75px;margin-left: 50px;">
</form>	
	<div id="progress">
		<div id="bar"></div>
		<div id="percent">0%</div>
		<div id="message"></div>
	</div>
	<div id="uploader"></div>
</div> --%>
<a href="<%=saveFileURL.toString()%>">Insert File</a>
<%@ include file="/WEB-INF/jsps/createidea_js.jsp"%>