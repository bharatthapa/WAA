 
function makeAjaxCall(){
   	var send = JSON.stringify(serializeObject($('#employeeForm')));
	$.ajax({
		url: '/RestEmployee/employee/add',
		type: 'POST',
		dataType: "json",
 		data:send,
 		contentType: 'application/json',
		success: function(employee){
			$('#result').html("");
			$("#result").append( '<H3 align="center"> New Employee Information <H3>');                
			$('#result').append("<H4 align='center'>First Name:  " + employee.firstName + "</h4>"  );
			$('#result').append("<H4 align='center'>Last Name: " + employee.lastName  + "</h4>" );
			$('#result').append("<H4 align='center'>Email: " + employee.email  + "</h4>");
			$("#result").attr("style", "display: block");
			$("#result").append('<h4 align="center"> <a href="#" onclick="toggle_visibility(\'result\');"><b>EXIT</b> </a> </h4>');
		},
		error: function(){						
			alert('Error while request..');
		}
	});
}

toggle_visibility = function(id) {
    var e = document.getElementById(id);
    if(e.style.display == 'block')
       e.style.display = 'none';
    else
       e.style.display = 'block';
 }	   


 function serializeObject (form)
{
    var jsonObject = {};
    var a = form.serializeArray();
    $.each(a, function() {
        if (jsonObject[this.name] !== undefined) {
            if (!jsonObject[this.name].push) {
            	jsonObject[this.name] = [jsonObject[this.name]];
            }
            jsonObject[this.name].push(this.value || '');
        } else {
        	jsonObject[this.name] = this.value || '';
        }
    });
    return jsonObject;
};


/*
'{ firstName:\"' + $("#firstName").val() + "\"" +
 		', lastName:\"' + $("#lastName").val() + "\"" +
 		', email:\"' + $("#email").val() + "\"}"
  */