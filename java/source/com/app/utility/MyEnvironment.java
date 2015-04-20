package com.app.utility;

import javax.servlet.ServletContextEvent;

import com.kodemore.utility.Kmu;

public class MyEnvironment
{
    //##################################################
    //# variables
    //##################################################

    private static String _webRoot;
    private static String _projectPath;

    //##################################################
    //# install
    //##################################################

    public static void installDevelopment()
    {
        String working = Kmu.getWorkingFolder();
        String web = Kmu.joinFilePath(working, "web");
        setWebRoot(web);

        _projectPath = working;
    }

    public static void installServlet(ServletContextEvent ev)
    {
        String root = ev.getServletContext().getRealPath("");
        setWebRoot(root);
    }

    private static void setWebRoot(String webRoot)
    {
        String path = Kmu.getCanonicalPath(webRoot);
        String webInf = Kmu.joinFilePath(path, "WEB-INF");

        if ( !Kmu.fileExists(webInf) )
            throw Kmu.newFatal(
                "Attempt to install web path failed (%s).  Cannot find (%s).",
                webRoot,
                webInf);

        _webRoot = path;
    }

    //##################################################
    //# accessing
    //##################################################

    public static String getWebRoot()
    {
        return _webRoot;
    }

    public static String getProjectRoot()
    {
        return _projectPath;
    }

    //##################################################
    //# testing
    //##################################################

    public static boolean isInstalled()
    {
        return _webRoot != null;
    }
}
