
function validateForm(){	
	
	isValid = true;
	
	$('form input[type="text"]').each(function()
	{
		if(this.value == "")
		{	
			alert("Value required for " +  this.name);
			isValid = false;
			return false;
			
		}		
	});	
	
	return isValid;
}
