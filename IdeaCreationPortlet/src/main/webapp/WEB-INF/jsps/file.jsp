<%@include file="/WEB-INF/jsps/init.jsp"%>
<portlet:actionURL var="insertfileURL">
<portlet:param name="action" value="saveFile" />
</portlet:actionURL>
<div>
<form action="<%=insertfileURL.toString()%>" id="file-form" method="post" enctype="multipart/form-data">
      <input type="hidden" name="app-context" value="Personal" id="file-upload-context" />
      <input type="hidden" name="app-space" value="Exo Space" id="file-upload-space" />
      <input type="hidden" name="data-uuid" value="agile1" id="file-upload-input" />
      <input type="hidden" name="app-filter" value="/sites/intranet/documents/Folksonomy/" id="file-upload-filter" />
      <input type="file" name="pic" style="width:400px; margin: auto; padding-left: 30px;" />
      <input type="submit" value="Upload"/>
</form>
</div>

