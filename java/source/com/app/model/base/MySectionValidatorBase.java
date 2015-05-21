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
 * Validation rules for section.
 */
public class MySectionValidatorBase
    extends MyDomainValidator<MySection>
{
    //##################################################
    //# static
    //##################################################

    public static final MySectionValidator instance = new MySectionValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator nameValidator;
    private KmIntegerValidator sequenceValidator;
    private KmIntegerValidator lockVersionValidator;
    private KmStringValidator topicNameValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MySectionValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        nameValidator = newNameValidator();
        sequenceValidator = newSequenceValidator();
        lockVersionValidator = newLockVersionValidator();
        topicNameValidator = newTopicNameValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmIntegerValidator getSequenceValidator()
    {
        return sequenceValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    public KmStringValidator getTopicNameValidator()
    {
        return topicNameValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MySection value)
    {
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setSequence(sequenceValidator.convertOnly(value.getSequence()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MySection value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        sequenceValidator.validateOnly(value.getSequence(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("section");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("section");
        e.setField("name");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newSequenceValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("section");
        e.setField("sequence");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("section");
        e.setField("lockVersion");
        return e;
    }

    public KmStringValidator newTopicNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("section");
        e.setField("topicName");
        e.setRequired();
        return e;
    }


}

