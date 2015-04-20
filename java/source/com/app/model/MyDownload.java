package com.app.model;

import com.kodemore.file.KmFile;

import com.app.file.MySharedFiles;
import com.app.model.base.MyDownloadBase;

public class MyDownload
    extends MyDownloadBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyDownload()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    public KmFile getFile()
    {
        return MySharedFiles.getInstance().getDownload(this);
    }

}
