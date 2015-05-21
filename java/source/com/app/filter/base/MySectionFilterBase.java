//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.filter.base;

import com.kodemore.collection.*;
import com.kodemore.hibernate.criteria.*;

import com.app.command.base.*;
import com.app.criteria.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.filter.*;
import com.app.filter.core.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MySectionFilterBase
    extends MyBasicFilter<MySection>
    implements MySectionDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MySection> c)
    {
        applyConditionsTo((MySectionCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MySection> c)
    {
        applySortsTo((MySectionCriteria)c);
    }

    protected abstract void applyConditionsTo(MySectionCriteria c);

    protected abstract void applySortsTo(MySectionCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaSection getMeta()
    {
        return MySection.Meta;
    }

    @Override
    protected MySectionDao getDao()
    {
        return getAccess().getSectionDao();
    }

    @Override
    protected MySectionCriteria createCriteria()
    {
        return new MySectionCriteria(createGenericCriteria());
    }
}
