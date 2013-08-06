<script type="text/javascript">
var editor = new TINY.editor.edit('editor', {
	id: 'tinyeditor',
	width: 584,
	height: 175,
	cssclass: 'tinyeditor',
	controlclass: 'tinyeditor-control',
	rowclass: 'tinyeditor-header',
	dividerclass: 'tinyeditor-divider',
	controls: ['bold', 'italic', 'underline', 'strikethrough', '|', 'subscript', 'superscript', '|',
		'orderedlist', 'unorderedlist', '|', 'outdent', 'indent', '|', 'leftalign',
		'centeralign', 'rightalign', 'blockjustify', '|', 'unformat', '|', 'undo', 'redo', 'n',
		'font', 'size', 'style', '|', 'image', 'hr', 'link', 'unlink', '|', 'print'],
	footer: true,
	fonts: ['Verdana','Arial','Georgia','Trebuchet MS'],
	xhtml: true,
	cssfile: 'custom.css',
	bodyid: 'editor',
	footerclass: 'tinyeditor-footer',
	toggle: {text: 'source', activetext: 'wysiwyg', cssclass: 'toggle'},
	resize: {cssclass: 'resize'}
});

document.forms["IdeaForm"]["tinyeditor"].value = editor ;

<%-- <portlet:namespace />CancelIdeaForm = function()
{
	window.location.href = "<%=BackToIdeaViewURL.toString()%>";
} --%>
<portlet:namespace/>SubmitIdeaForm = function()
{
		var hiddenId = "addurl_";
		var inputEditortxt = $("#iframediv iframe").contents().find('body').html();
		document.forms["IdeaForm"]["tinyeditor"].value = inputEditortxt;
		alert(inputEditortxt);
		document.IdeaForm.action = document.forms["IdeaForm"][hiddenId + ""].value;
		document.IdeaForm.submit();
}
<portlet:namespace />ResetIdeaForm = function() {
	document.forms["IdeaForm"]["ideaTitle"].value = "";
	document.forms["IdeaForm"]["tinyeditor"].value = "";
}
</script>