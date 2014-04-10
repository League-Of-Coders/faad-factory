alert("im here");
var jsCount = parseInt('<%=count%>');
alert(jsCount);
function checker()
{
	alert("check chekc");
}
function createFormAndHiddenFields(jspCount,list)
{
	var form = document.getElementById("form");
	var y = document.createElement("INPUT");
	y.type="hidden";
	y.name="count";
	y.value=jspCount;
	form.appendChild(y);
	
	for(var i=0;i<jspCount;i++)
	{
		var x = document.createElement("INPUT");
		x.name="widget" + i;
		alert("name: " + x.name);
		x.type="hidden";
		x.value=list[i];
		form.appendChild(x);
	}
	
	form.submit();
}