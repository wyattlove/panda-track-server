package com.app.ui.servlet;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.kodemore.utility.Kmu;

import com.app.utility.MyConstantsIF;

import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.model.JadeModel;
import de.neuland.jade4j.template.JadeTemplate;
import de.neuland.jade4j.template.TemplateLoader;

/**
 * Handle entry into the application, typically initiated
 * from an HTTP GET.
 *
 * -- Redirect to a standard url.
 * -- Redirect the GET with a POST (to avoid caching).
 * -- Begin the server session and register the cookie.
 * -- Generate the minimal html page, just enough to bootstrap the first ajax request.
 */
public class MyJadeServlet
    extends MyServlet
    implements MyServletConstantsIF
{
    //##################################################
    //# static
    //##################################################

    private static JadeConfiguration   _config;
    private static MyJadeServletLoader _loader;

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
        try
        {
            StringWriter writer = new StringWriter();

            String uri = getData().getRequestUri();
            JadeTemplate template;
            template = getConfig().getTemplate(uri);
            template.process(getModel(), writer);

            String html = writer.toString();
            getData().setHtmlResult(html);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private synchronized JadeConfiguration getConfig()
    {
        if ( _config == null )
        {
            _config = new JadeConfiguration();
            _config.setCaching(false);
            _config.setPrettyPrint(true);
            _config.setMode(Jade4J.Mode.HTML);
            _config.setTemplateLoader(getLoader());
            _config.setSharedVariables(getSharedVariables());
        }

        return _config;
    }

    private Map<String,Object> getSharedVariables()
    {
        Map<String,Object> m;
        m = new HashMap<>();
        m.put("appName", MyConstantsIF.APPLICATION_NAME);
        m.put("appVersion", MyConstantsIF.APPLICATION_VERSION);
        return m;
    }

    private synchronized TemplateLoader getLoader()
    {
        if ( _loader == null )
            _loader = new MyJadeServletLoader(getServletContext());

        return _loader;
    }

    private JadeModel getModel()
    {
        return new JadeModel(getContext());
    }

    private Map<String,Object> getContext()
    {
        Map<String,Object> m;
        m = new HashMap<>();
        m.put("hello", "world");
        return m;
    }
}
