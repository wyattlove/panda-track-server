//*********************************************************
//** globals
//*********************************************************

var gAppName       = 'Panda Track';
var gSessionUid    = undefined;

var SESSION_COOKIE = 'session';
var EMAIL_COOKIE   = 'email';

//*********************************************************
//** goto page
//*********************************************************

function gotoLoginPage()
{
    gotoPage('login');
}

function replaceWithLoginPage()
{
    gotoPage('login', true);
}

function gotoWelcomePage()
{
    gotoPage('welcome');
}

function gotoDocBrowserPage()
{
    gotoPage('docBrowser');
}

function gotoPage(name, replace)
{
    KmNavigator.pushPage(
    {
       url: '?page=' + name,
       replace: !!replace
    });
}

//*********************************************************
//** handle nav
//*********************************************************

function handleNav(dir)
{
    var page = Kmu.getQueryValue('page');
    if ( !page )
    {
        replaceWithLoginPage();
        return;
    }

    if ( page == 'login' )
    {
        MyLoginPage.show();
        return;
    }    
    
    if ( page == 'welcome' )
    {
        MyWelcomePage.show();
        return;
    }    
    
    if ( page == 'docBrowser' )
    {
        MyDocBrowserPage.show();
        return;
    }    
    
    console.log('Unknown page: ' + page);
    replaceWithLoginPage();
}

//*********************************************************
//** handle
//*********************************************************

function handleTest()
{
    var req = 
    {
        action: 'getVendors',
        sessionUid: gSessionUid
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

function handleRefresh()
{
    location.reload();
}

function handleLogout()
{
    gSessionUid = null;
    Cookies.remove(SESSION_COOKIE);   
    gotoLoginPage();
}

//*********************************************************
//** support
//*********************************************************

function showJadePage(name, thenFn)
{
    var url = sprintf("/jade/%s.jade", name);
    
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
        setPageHtml(data);
        thenFn();
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
//** utility
//*********************************************************

function page()
{
    return $('#page');
}

function setPageHtml(e)
{
    page().html(e);
}

//*********************************************************
//** application start
//*********************************************************

$(document).ready(function()
{
    KmNavigator.defaultTitle = gAppName;
    KmNavigator.handler = handleNav;
    KmNavigator.init();

    gSessionUid = Cookies.get(SESSION_COOKIE);   
    
    handleNav();
});
