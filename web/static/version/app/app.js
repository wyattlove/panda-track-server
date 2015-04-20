//*********************************************************
//** globals
//*********************************************************

var gServerSessionUid;

//*********************************************************
//** test
//*********************************************************

function handleTest()
{
    var req = 
    {
        action: 'getVendors',
        sessionUid: gServerSessionUid
    };

    var handler = function(res)
    {
        var v = res.vendors;
        var n = v.length;
        for ( var i=0; i<n; i++ )
        {
            var e = v[i];
            console.log(e.uid + ", " + e.name);
        }
    };
    
    api(req, handler);
}

//*********************************************************
//** utility
//*********************************************************

function showPage(name)
{
	var url = "/jade/" + name + ".jade";
	
	var result = $.ajax(
	{
		url: url,
		method: 'POST',
        dataType: 'html',
		async: true,
		cache: true
	});
	
	result.done(function(data, statusText, jqXHR)
	{
		$("#page").html(data);
	})
	
	result.fail(function(jqXHR, textStatus, errorThrown)
	{
		console.log("show page failed: " + name)
	});
}

function loadJade(name, thenFn)
{
	var url = "/jade/" + name + ".jade";
	
	var result = $.ajax(
	{
		url: url,
		method: 'POST',
        dataType: 'html',
		async: true,
		cache: false
	});
	
	result.done(function(data, statusText, jqXHR)
	{
		thenFn(data);
	})
	
	result.fail(function(jqXHR, textStatus, errorThrown)
	{
		console.log("load jade failed: " + name)
	});
}

function api(req, handler)
{
	var data = 
	{
	    request: JSON.stringify(req)
	};
	
	var result = $.ajax(
	{
		url: "/api",
		method: 'POST',
        dataType: 'json',
		async: true,
		cache: false,
		data: data
	});
	
	result.done(function(data, statusText, jqXHR)
	{
		if ( handler )
			handler(data);
	})
	
	result.fail(function(jqXHR, textStatus, errorThrown)
	{
		console.log("Api Failed.");
	});
}


//*********************************************************
//** login page
//*********************************************************

function showLoginPage()
{
	loadJade('login', showLoginPageWith)
}

function showLoginPageWith(html)
{
	$('#page').html(html);
	$('#page').promise().done(function()
    {
	    $('#email').val('root');
	    $('#email').focus();
    });
}

function handleLogin()
{
	var email = $('#email').val();
	var password = $('#password').val();

	var req = 
	{
		action: "login",
		email: email,
		password: password
	};
	
	api(req, handleLoginResponse);
}

function handleLoginResponse(res)
{
	if ( ! res )
	{
		alert("Login Failed.\nNo Response.");
		return;
	}
	
	if ( !res.ok )
    {
		alert("Login Failed.\n" + res.message);
		return;
    }
	
	gServerSessionUid = res.sessionUid;
	
	showWelcomePage();
}

//*********************************************************
//** welcome page
//*********************************************************

function showWelcomePage()
{
	loadJade('welcome', showWelcomePageWith)
}

function showWelcomePageWith(html)
{
	$('#page').html(html);
	
	var req = 
	{
		action: 'getVendors',
		sessionUid: gServerSessionUid
	};
	
	api(req, handleGetVendors);
}

function handleGetVendors(res)
{
    console.log("handleGetVendors");
    
	if ( !res.ok )
	{
		alert("Cannot get vendors.");
		return;
	}
	
	$.each(res.vendors, function(index, e) 
	{
	    $('#vendorSelect')
    	    .append($("<option>")
    	    .attr("value", e.uid)
    	    .text(e.name)); 
	});
}


//*********************************************************
//** application start
//*********************************************************

$(document).ready(function()
{
	showLoginPage();
});
