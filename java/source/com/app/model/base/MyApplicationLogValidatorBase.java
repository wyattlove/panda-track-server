//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.model.base;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.exception.error.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

/**
 * Validation rules for applicationLog.
 */
public class MyApplicationLogValidatorBase
    extends MyDomainValidator<MyApplicationLog>
{
    //##################################################
    //# static
    //##################################################

    public static final MyApplicationLogValidator instance = new MyApplicationLogValidator();

    //##################################################
    //# variables
    //##################################################

    private KmIntegerValidator idValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator loggerNameValidator;
    private KmStringValidator contextValidator;
    private KmStringValidator messageValidator;
    private KmStringValidator levelNameValidator;
    private KmIntegerValidator levelCodeValidator;
    private KmStringValidator threadNameValidator;
    private KmStringValidator exceptionTextValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyApplicationLogValidatorBase()
    {
        super();
        idValidator = newIdValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        loggerNameValidator = newLoggerNameValidator();
        contextValidator = newContextValidator();
        messageValidator = newMessageValidator();
        levelNameValidator = newLevelNameValidator();
        levelCodeValidator = newLevelCodeValidator();
        threadNameValidator = newThreadNameValidator();
        exceptionTextValidator = newExceptionTextValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmIntegerValidator getIdValidator()
    {
        return idValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmStringValidator getLoggerNameValidator()
    {
        return loggerNameValidator;
    }

    public KmStringValidator getContextValidator()
    {
        return contextValidator;
    }

    public KmStringValidator getMessageValidator()
    {
        return messageValidator;
    }

    public KmStringValidator getLevelNameValidator()
    {
        return levelNameValidator;
    }

    public KmIntegerValidator getLevelCodeValidator()
    {
        return levelCodeValidator;
    }

    public KmStringValidator getThreadNameValidator()
    {
        return threadNameValidator;
    }

    public KmStringValidator getExceptionTextValidator()
    {
        return exceptionTextValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyApplicationLog value)
    {
        value.setId(idValidator.convertOnly(value.getId()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setLoggerName(loggerNameValidator.convertOnly(value.getLoggerName()));
        value.setContext(contextValidator.convertOnly(value.getContext()));
        value.setMessage(messageValidator.convertOnly(value.getMessage()));
        value.setLevelName(levelNameValidator.convertOnly(value.getLevelName()));
        value.setLevelCode(levelCodeValidator.convertOnly(value.getLevelCode()));
        value.setThreadName(threadNameValidator.convertOnly(value.getThreadName()));
        value.setExceptionText(exceptionTextValidator.convertOnly(value.getExceptionText()));
    }

    @Override
    public void validateOnly(MyApplicationLog value, KmList<KmErrorIF> errors)
    {
        idValidator.validateOnly(value.getId(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        loggerNameValidator.validateOnly(value.getLoggerName(), errors);
        contextValidator.validateOnly(value.getContext(), errors);
        messageValidator.validateOnly(value.getMessage(), errors);
        levelNameValidator.validateOnly(value.getLevelName(), errors);
        levelCodeValidator.validateOnly(value.getLevelCode(), errors);
        threadNameValidator.validateOnly(value.getThreadName(), errors);
        exceptionTextValidator.validateOnly(value.getExceptionText(), errors);
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmIntegerValidator newIdValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("applicationLog");
        e.setField("id");
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("applicationLog");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newLoggerNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("applicationLog");
        e.setField("loggerName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newContextValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("applicationLog");
        e.setField("context");
        return e;
    }

    public KmStringValidator newMessageValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModel("applicationLog");
        e.setField("message");
        return e;
    }

    public KmStringValidator newLevelNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(5);
        e.setAllowsPrintable(true);
        e.setModel("applicationLog");
        e.setField("levelName");
        return e;
    }

    public KmIntegerValidator newLevelCodeValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("applicationLog");
        e.setField("levelCode");
        return e;
    }

    public KmStringValidator newThreadNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("applicationLog");
        e.setField("threadName");
        return e;
    }

    public KmStringValidator newExceptionTextValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModel("applicationLog");
        e.setField("exceptionText");
        return e;
    }


}

