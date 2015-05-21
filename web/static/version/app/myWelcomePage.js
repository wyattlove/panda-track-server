var MyWelcomePage;
MyWelcomePage = {};
MyWelcomePage.name = 'welcome';

MyWelcomePage.show = function(options)
{
    showJadePage('myWelcome', MyWelcomePage.init)
}

MyWelcomePage.init = function(options)
{
    $('#browserButton').click(gotoDocBrowserPage);
    
    var req = 
    {
        action: 'getVendors',
        sessionUid: gSessionUid
    };
    
    api(req, MyWelcomePage.handleGetVendors);
}

MyWelcomePage.handleGetVendors = function(res)
{
    if ( !res.ok )
    {
        alert("Cannot load vendors.\n" + res.message);
        return;
    }

    Kmu.addSelectOptions('#vendorSelect', res.vendors, 'name', 'uid');
}
