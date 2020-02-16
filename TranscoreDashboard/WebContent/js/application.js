
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


function searchCategory()
{
		
	var category = '';
	var displayorder = '';	
	var queryParams = '';	
	var querystring = 'plate-category?';	
	var queryarray = window.location.search.substring(1).split('&');
	
	category = document.getElementById('idcategorydesc').value;
	displayorder = document.getElementById('iddisplayorder').value;
		
	if(category !== ''){
		querystring = querystring + 'categoryen=' + category; 
	}
	if(displayOrder !== ''){
		querystring = querystring + '&displayorder=' + displayOrder;
	}
	
	
	for(var i = 0; queryarray.length; i++)
	{
			var querypart = queryarray[i];
			
			if(querypart.includes('page')){
				
			}
			
			if(querypart.includes('pagesize')){
				
			}
	}	
}


