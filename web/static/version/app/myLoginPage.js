var MyLoginPage;
MyLoginPage = {};
MyLoginPage.name = 'login';

MyLoginPage.show = function(options)
{
    showJadePage('myLogin', MyLoginPage.init)
}

MyLoginPage.init = function(options)
{
    page().promise().done(function()
    {
        var email = Cookies.get(EMAIL_COOKIE);
        var field = $('#email');
        
        if ( Kmu.hasValue(email) )
            field.val(email);
            
        field.focus();
    });
}

/**
 * Handle the action when the user presses the login button.
 */
MyLoginPage.handleLogin = function()
{
    var email = $('#email').val();
    var password = $('#password').val();

    Cookies.set(EMAIL_COOKIE, email);

    var req = 
    {
        action: "login",
        email: email,
        password: password
    };
    
    api(req, MyLoginPage.handleLoginResponse);
}

MyLoginPage.handleLoginResponse = function(res)
{
    if ( ! res )
    {
        alert("Login Failed.\nNo Response.");
        $('#email').focus();
        return;
    }
    
    if ( !res.ok )
    {
        alert("Login Failed.\n" + res.message);
        $('#email').focus();
        return;
    }
    
    gSessionUid = res.sessionUid;
    Cookies.set(SESSION_COOKIE, gSessionUid);   
    gotoWelcomePage();  
}
