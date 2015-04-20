package com.app.generator;

import com.kodemore.collection.KmList;
import com.kodemore.generator.KmgGenerator;
import com.kodemore.generator.KmgRoot;
import com.kodemore.generator.model.KmgCssBundle;
import com.kodemore.html.KmCssParser;
import com.kodemore.log.KmLog;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

import com.app.file.MyDevelopmentFiles;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyEnvironment;

public class MyGenerator
    implements KmConstantsIF
{
    //##################################################
    //# main
    //##################################################

    public static void main(String... args)
    {
        try
        {
            KmLog.installConsole();
            MyEnvironment.installDevelopment();

            MyGenerator e;
            e = new MyGenerator();
            e.setArgs(args);
            e.generate();
        }
        catch ( RuntimeException ex )
        {
            System.out.flush();
            System.err.flush();

            ex.printStackTrace(System.out);
        }
    }

    //##################################################
    //# constants
    //##################################################

    /**
     * This class prefix is used in front of most/all of the application
     * specific classes.  In particular this prefix is used during code
     * generation.
     */
    private static final String APPLICATION_PREFIX  = "my";

    /**
     * The root package that contains the application specific code.
     */
    private static final String APPLICATION_PACKAGE = "com.app";

    //##################################################
    //# variables
    //##################################################

    private KmgRoot             _root;
    private KmList<String>      _args;

    private boolean             _installedModels;
    private boolean             _installedProperties;
    private boolean             _installedCss;

    //##################################################
    //# constructor
    //##################################################

    public MyGenerator()
    {
        _args = new KmList<>();
    }

    //##################################################
    //# generate
    //##################################################

    public void generate()
    {
        if ( getArgs().isEmpty() )
        {
            generateAll();
            return;
        }

        if ( hasArg("all") )
        {
            generateAll();
            return;
        }

        if ( hasArg("models") )
            generateModels();

        if ( hasArg("properties") )
            generateProperties();

        if ( hasArg("css") )
            generateCss();
    }

    public void generateAll()
    {
        generateModels();
        generateProperties();
        generateCss();

        KmgGenerator.printCounts();
    }

    private void generateModels()
    {
        installModels();
        generate("model");
        generate("db");
        generate("doc");
    }

    private void generateProperties()
    {
        installProperties();
        generate("property");
    }

    private void generateCss()
    {
        installCss();
        generate("css");
    }

    private void generate(String setupPath)
    {
        String templatePath = Kmu.joinFilePath(getGeneratorPath(), "templates");
        String setupDir = Kmu.joinFilePath(templatePath, setupPath);
        String setupFile = "_setup.stf";

        KmgGenerator g;
        g = new KmgGenerator();
        g.setRootPath(getRootPath());
        g.setSetupDir(setupDir);
        g.setSetupFile(setupFile);
        g.setRoot(getRoot());
        g.run();
    }

    //##################################################
    //# accessing
    //##################################################

    public void setArgs(String... args)
    {
        _args.clear();
        _args.addAll(args);
    }

    public KmList<String> getArgs()
    {
        return _args;
    }

    public boolean hasArg(String e)
    {
        return getArgs().contains(e);
    }

    //##################################################
    //# models
    //##################################################

    public KmgRoot getRoot()
    {
        if ( _root == null )
        {
            _root = new KmgRoot();
            _root.setApplicationName(MyConstantsIF.APPLICATION_NAME);
            _root.setApplicationPrefix(APPLICATION_PREFIX);
            _root.setApplicationPackage(APPLICATION_PACKAGE);
            _root.setDefaultModelSuperClass("MyAbstractDomain");
        }
        return _root;
    }

    //##################################################
    //# models
    //##################################################

    public void installModels()
    {
        if ( _installedModels )
            return;

        String typesPath = getConfigPath("types.stf");
        String modelsDir = getConfigPath("model");

        KmgRoot e;
        e = getRoot();
        e.installTypes(typesPath);
        e.installModels(modelsDir);
        e.installExtensions();
        e.validateModels();

        _installedModels = true;
    }

    //##################################################
    //# css
    //##################################################

    public void installCss()
    {
        if ( _installedCss )
            return;

        String prefix = "web/static/version/app/theme/default/css/";

        String themePath = prefix + "theme.css";
        String spicePath = prefix + "spice.css";
        String toolsPath = prefix + "tools.css";
        String buttonPath = prefix + "button.css";

        KmgRoot root;
        root = getRoot();

        KmgCssBundle e;
        e = root.addCssBundle("default");
        e.addSelectors(getCssSelectors(themePath));
        e.addSelectors(getCssSelectors(spicePath));
        e.addSelectors(getCssSelectors(toolsPath));
        e.addSelectors(getCssSelectors(buttonPath));
        e.installComposites();

        e = root.addCssBundle("spice");
        e.addSelectors(getCssSelectors(spicePath));
        e.installComposites();

        _installedCss = true;
    }

    private KmList<String> getCssSelectors(String path)
    {
        System.out.println("parse css: " + path);

        path = getRootPath(path);

        KmCssParser parser;
        parser = new KmCssParser();
        parser.parseFile(path);

        KmList<String> v;
        v = parser.getClassSelectors();

        return v;
    }

    //##################################################
    //# properties
    //##################################################

    public void installProperties()
    {
        if ( _installedProperties )
            return;

        String path = getConfigPath("properties.stf");
        getRoot().installProperties(path);

        _installedProperties = true;
    }

    //##################################################
    //# support
    //##################################################

    private String getRootPath()
    {
        return MyDevelopmentFiles.getProjectRoot();
    }

    private String getRootPath(String... path)
    {
        return join(getRootPath(), join(path));
    }

    private String getGeneratorPath()
    {
        return join(getRootPath(), "web/WEB-INF/resource/generator");
    }

    private String getConfigPath(String... args)
    {
        return join(getGeneratorPath(), "config", join(args));
    }

    private String join(String... path)
    {
        return Kmu.joinFilePath(path);
    }
}
