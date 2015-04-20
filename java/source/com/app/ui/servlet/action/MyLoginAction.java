package com.app.ui.servlet.action;

import com.kodemore.json.KmJsonMap;

import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.utility.MyConstantsIF;

public class MyLoginAction
    extends MyAction
{
    //##################################################
    //# constants
    //##################################################

    private static final String LOGIN_ERROR = "Invalid email or password.";

    //##################################################
    //# key
    //##################################################

    @Override
    public String getKey()
    {
        return "login";
    }

    //##################################################
    //# handle
    //##################################################

    @Override
    public KmJsonMap handle(KmJsonMap req)
    {
        String email = req.getString("email");
        String password = req.getString("password");

        MyUser user = getAccess().getUserDao().findEmail(email);
        if ( user == null )
            throw newError(LOGIN_ERROR);

        if ( !user.hasPassword(password) )
            throw newError(LOGIN_ERROR);

        MyServerSession ss;
        ss = new MyServerSession();
        ss.setUser(user);
        ss.setVersion(MyConstantsIF.APPLICATION_VERSION);
        ss.attachDao();

        KmJsonMap res;
        res = newOkResponse();
        res.setString("sessionUid", ss.getUid());
        return res;
    }
}
