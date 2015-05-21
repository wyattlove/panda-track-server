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
 * Validation rules for action.
 */
public class MyActionValidatorBase
    extends MyDomainValidator<MyAction>
{
    //##################################################
    //# static
    //##################################################

    public static final MyActionValidator instance = new MyActionValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator titleValidator;
    private KmStringValidator descriptionValidator;
    private KmStringValidator typeCodeValidator;
    private KmIntegerValidator lockVersionValidator;
    private KmStringValidator sectionNameValidator;
    private KmStringValidator ownerUidValidator;
    private KmStringValidator ownerNameValidator;
    private KmStringValidator assigneeUidValidator;
    private KmStringValidator assigneeNameValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyActionValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        titleValidator = newTitleValidator();
        descriptionValidator = newDescriptionValidator();
        typeCodeValidator = newTypeCodeValidator();
        lockVersionValidator = newLockVersionValidator();
        sectionNameValidator = newSectionNameValidator();
        ownerUidValidator = newOwnerUidValidator();
        ownerNameValidator = newOwnerNameValidator();
        assigneeUidValidator = newAssigneeUidValidator();
        assigneeNameValidator = newAssigneeNameValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getTitleValidator()
    {
        return titleValidator;
    }

    public KmStringValidator getDescriptionValidator()
    {
        return descriptionValidator;
    }

    public KmStringValidator getTypeCodeValidator()
    {
        return typeCodeValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    public KmStringValidator getSectionNameValidator()
    {
        return sectionNameValidator;
    }

    public KmStringValidator getOwnerUidValidator()
    {
        return ownerUidValidator;
    }

    public KmStringValidator getOwnerNameValidator()
    {
        return ownerNameValidator;
    }

    public KmStringValidator getAssigneeUidValidator()
    {
        return assigneeUidValidator;
    }

    public KmStringValidator getAssigneeNameValidator()
    {
        return assigneeNameValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyAction value)
    {
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setTitle(titleValidator.convertOnly(value.getTitle()));
        value.setDescription(descriptionValidator.convertOnly(value.getDescription()));
        value.setTypeCode(typeCodeValidator.convertOnly(value.getTypeCode()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyAction value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
        titleValidator.validateOnly(value.getTitle(), errors);
        descriptionValidator.validateOnly(value.getDescription(), errors);
        typeCodeValidator.validateOnly(value.getTypeCode(), errors);
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
        e.setModel("action");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTitleValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("action");
        e.setField("title");
        return e;
    }

    public KmStringValidator newDescriptionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModel("action");
        e.setField("description");
        return e;
    }

    public KmStringValidator newTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1);
        e.setAllowsLetters(true);
        e.setForcesUpperCase(true);
        e.setStripsAllSpaces(true);
        e.setModel("action");
        e.setField("typeCode");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("action");
        e.setField("lockVersion");
        return e;
    }

    public KmStringValidator newSectionNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("action");
        e.setField("sectionName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newOwnerUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("action");
        e.setField("ownerUid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newOwnerNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("action");
        e.setField("ownerName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newAssigneeUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("action");
        e.setField("assigneeUid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newAssigneeNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("action");
        e.setField("assigneeName");
        e.setRequired();
        return e;
    }


}

