package com.app.ui.servlet;

import com.kodemore.json.KmJsonMap;
import com.kodemore.json.KmJsonReader;
import com.kodemore.utility.Kmu;

import com.app.ui.servlet.action.MyAction;
import com.app.ui.servlet.action.MyActionRegistry;

public class MyApiServlet
    extends MyServlet
    implements MyServletConstantsIF
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet()
    {
        handle();
    }

    @Override
    protected void doPost()
    {
        handle();
    }

    //##################################################
    //# handle
    //##################################################

    private void handle()
    {
        String json = getData().getParameter("request");
        if ( Kmu.isEmpty(json) )
        {
            handleError("No request parameter.");
            return;
        }

        KmJsonMap req = null;
        try
        {
            req = KmJsonReader.parseJsonMap(json);
        }
        catch ( Exception ex )
        {
            handleError("Malformed action json.");
            return;
        }

        handleRequest(req);
    }

    private void handleRequest(KmJsonMap req)
    {
        String key = req.getString("action");
        if ( Kmu.isEmpty(key) )
        {
            handleError("No action key.");
            return;
        }

        MyAction action = MyActionRegistry.getAction(key);
        if ( action == null )
        {
            handleError("Action not registered: %s.", key);
            return;
        }

        action.run(req);

        if ( !getData().hasResult() )
            handleError("No result for action: %s.", key);
    }

    private void handleError(String msg, Object... args)
    {
        KmJsonMap res = MyApiUtility.newErrorResponse(msg, args);
        getData().setJsonResult(res);
    }
}
