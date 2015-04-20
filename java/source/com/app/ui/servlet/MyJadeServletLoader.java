package com.app.ui.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.servlet.ServletContext;

import com.kodemore.utility.Kmu;

import de.neuland.jade4j.template.TemplateLoader;

/**
 * Load jade templates from the servlet context.
 */
public class MyJadeServletLoader
    implements TemplateLoader
{
    //##################################################
    //# variables
    //##################################################

    private ServletContext _context;

    //##################################################
    //# constructor
    //##################################################

    public MyJadeServletLoader(ServletContext context)
    {
        _context = context;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public long getLastModified(String name) throws IOException
    {
        return 0;
    }

    @Override
    public Reader getReader(String name) throws IOException
    {
        InputStream stream = _context.getResourceAsStream(name);
        if ( stream == null )
            throw Kmu.newFatal("Servlet resource not found (%s).", name);

        InputStreamReader reader = new InputStreamReader(stream);
        return new BufferedReader(reader);
    }
}
