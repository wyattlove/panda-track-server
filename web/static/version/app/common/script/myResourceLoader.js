var MyResourceLoader =
{
    //**********************************************************
    //** files
    //**********************************************************

    files: 
        [
            // Reset
            "static/{version}/app/theme/default/css/reset.css",

            // JQuery
            "static/{version}/jquery/core/jquery-1.10.2.min.js",
            "static/{version}/jquery/core/jquery-migrate-1.2.1.min.js",

            // JQuery UI
            "static/{version}/jquery/jquery-ui-1.11.1/jquery-ui.min.css",
            "static/{version}/jquery/jquery-ui-1.11.1/jquery-ui.min.js",

            // Simple Modal
            // "static/{version}/jquery/simplemodal-1.4.4/simplemodal.css",
            // "static/{version}/jquery/simplemodal-1.4.4/simplemodal.js",

            // Color Picker
            "static/{version}/jquery/colorpicker-09.05.23/css/colorpicker.css",
            "static/{version}/jquery/colorpicker-09.05.23/js/colorpicker.js",

            // Smooth Menu
            // "static/{version}/jquery/smoothmenu-1.5/ddsmoothmenu.css",
            // "static/{version}/jquery/smoothmenu-1.5/ddsmoothmenu-v.css",
            // "static/{version}/jquery/smoothmenu-1.5/ddsmoothmenu.js",

            // Flexigrid
            "static/{version}/jquery/flexigrid-1.1/css/flexigrid.pack.css",
            "static/{version}/jquery/flexigrid-1.1/js/flexigrid.js",
            
            // Akquinet Toasts
            "static/{version}/jquery/akquinet-0.2.0-13/resources/css/jquery.toastmessage.css",
            "static/{version}/jquery/akquinet-0.2.0-13/javascript/jquery.toastmessage.js",
            
            // CL Editor
            // "static/{version}/jquery/cleditor-1.4.3/jquery.cleditor.css",
            // "static/{version}/jquery/cleditor-1.4.3/jquery.cleditor.min.js",

            // Block UI
            "static/{version}/jquery/blockUi-2.64.0/jquery.blockUI.js",

            // Cookie
            "static/{version}/jquery/cookie-1.0.0/jquery.cookie.js",

            // Transit - smooth transitions
            "static/{version}/jquery/transit-0.9.9/jquery.transit-0.9.9.min.js",
            
            // Twitter Bootstrap
            // "static/{version}/bootstrap-2.3.2/css/bootstrap.min.css",
            // "static/{version}/bootstrap-2.3.2/js/bootstrap.min.js",
            
            // Bootstap-select
            "static/{version}/bootstrap-select-1.3.1/bootstrap-select.min.css",
            "static/{version}/bootstrap-select-1.3.1/bootstrap-select.min.js",
            
            // Dropzone
            "static/{version}/dropzone-3.6.1/dropzone.js",
            "static/{version}/dropzone-3.6.1/dropzone.css",
            
            // Json
            "static/{version}/json-2010.11.18/json2.js",
            
            // Code39 Azalea
            // "static/{version}/azaleaCode39/Code39Azalea.min.css", 
            
            // History
            "static/{version}/jquery/history-1.8.6/scripts/bundled-uncompressed/html5/jquery.history.js", 
            
            // ScrollTo
            "static/{version}/jquery/scrollto-1.4.3.1/jquery.scrollTo-1.4.3.1-min.js", 

            // Visible
            "static/{version}/jquery/jquery-visible-master/jquery.visible.js", 
            
            // Mindmup Editable Table
            // "static/{version}/jquery/mindmup-editable-table/mindmup-editabletable.js", 

            // Splitter
            "static/{version}/jquery/jcubic-splitter-0.14.0/css/jquery.splitter.css",
            "static/{version}/jquery/jcubic-splitter-0.14.0/js/jquery.splitter-0.14.0.js",
            
            // NVD3 Charts
            "static/{version}/nvd3-1.1.10/src/nv.d3.css", 
            "static/{version}/nvd3-1.1.10/lib/d3.v3.js", 
            "static/{version}/nvd3-1.1.10/nv.d3.js", 
            "static/{version}/nvd3-1.1.10/src/tooltip.js", 
            "static/{version}/nvd3-1.1.10/src/utils.js", 
            "static/{version}/nvd3-1.1.10/src/interactiveLayer.js", 
            "static/{version}/nvd3-1.1.10/src/models/legend.js", 
            "static/{version}/nvd3-1.1.10/src/models/axis.js", 
            "static/{version}/nvd3-1.1.10/src/models/line.js", 
            "static/{version}/nvd3-1.1.10/src/models/lineChart.js", 
            
            // Kodemore
            "static/{version}/app/common/script/kmExtensions.js",
            "static/{version}/app/common/script/kmUtility.js",
            "static/{version}/app/common/script/kmNavigator.js",
            "static/{version}/app/common/script/kmDropdownMenu.js",
            "static/{version}/app/common/script/kmTimeAgo.js",
            "static/{version}/app/common/script/kmDateAgo.js",
            
            // App
            "static/{version}/app/theme/default/css/button.css",
            "static/{version}/app/theme/default/css/dropdownMenu.css",
            "static/{version}/app/theme/default/css/theme.css",
            "static/{version}/app/theme/default/css/spice.css",
            "static/{version}/app/theme/default/css/tools.css"
        ],

    //**********************************************************
    //** public
    //**********************************************************
        
    /**
     * Load the files needed for local testing without a servlet container.
     */
    loadTestResources: function(userOptions, version)
    {
        var prefix = "../";
        return this._loadAppResources(userOptions, version, prefix);
    },

    /**
     * Load the files needed in production or when running inside a container.
     */
    loadAppResources: function(userOptions, version)
    {
        // Assumes ROOT (implied) context
        var prefix = "/";
        return this._loadAppResources(userOptions, version, prefix);
    },

    _loadAppResources: function(userOptions, version, prefix)
    {
        var localOptions = 
        {
            files: this.getFiles(prefix, version),
        }; 

        return this.run(localOptions, userOptions);
    },

    //**********************************************************
    //** private
    //**********************************************************

    run: function(localOptions, userOptions)
    {
        // jquery not loaded yet.
        // var options = $.extend({}, localOptions, userOptions);
        
        var options = {};
        
        if ( localOptions )
            for ( key in localOptions )
                options[key] = localOptions[key];
                
        if ( userOptions )
            for ( key in userOptions )
                options[key] = userOptions[key];
    
        KmResourceLoader.load(options);
    },
    
    getFiles: function(prefix, version)
    {
        var input = this.files;
        var output = new Array();
        
        for ( var i in input )
        {
            var s = this.getFile(input[i], prefix, version);
            output.push(s); 
        }
        
        return output;            
    },
    
    getFile: function(input, prefix, version)
    {
        if ( ! version )
            version = "version";
            
        var regex = new RegExp("{version}");
            
        var s;
        s = prefix + input;
        s = s.replace(regex, version);
        return s;
    }
    
}
