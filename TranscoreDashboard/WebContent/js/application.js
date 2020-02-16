
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
	queryObject = {};
		
	if(category !== ''){
		queryObject["categoryen"] = category;
		
		//querystring = querystring + 'categoryen=' + category; 
	}
	if(displayorder !== ''){
		
		queryObject["displayorder"] = displayOrder;
		
		//querystring = querystring + '&displayorder=' + displayOrder;
	}
	
	
	for(var i = 0; i < queryarray.length; i++)
	{
			var querypart = queryarray[i];
			
			if(querypart.includes('page'))
			{
				var partArray = querypart.split('=');
				queryObject[partArray[0]] = partArray[1]
			}
			
			if(querypart.includes('pagesize'))
			{
				var partArray = querypart.split('=');
				queryObject[partArray[0]] = partArray[1]
			}
	}	
	
	console.log(queryObject);
	var query = $.param(queryObject);
	
	window.location.href = querystring + query;
}


