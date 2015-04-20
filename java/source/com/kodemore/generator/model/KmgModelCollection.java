package com.kodemore.generator.model;

import com.kodemore.generator.KmgElement;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.KmNamedEnumIF;
import com.kodemore.utility.Kmu;

/**
 * I represent a collection of other models.
 * This type of collection is always the "other side" of an association.
 * The association is the real mandatory side of the relationship; the
 * collection is the optional convenience side of the relationship.
 */
public class KmgModelCollection
    extends KmgModelAttribute
{
    //##################################################
    //# enum
    //##################################################

    private enum Relation
        implements KmNamedEnumIF
    {
        Children("children"),
        WeakChildren("weakChildren");

        public static Relation findName(String s)
        {
            for ( Relation e : values() )
                if ( e.getName().equals(s) )
                    return e;
            return null;
        }

        private String _name;

        private Relation(String name)
        {
            _name = name;
        }

        @Override
        public String getName()
        {
            return _name;
        }
    }

    private enum OnCopy
        implements KmNamedEnumIF
    {
        Clear("clear"),
        Copy("copy");

        private String _name;

        private OnCopy(String name)
        {
            _name = name;
        }

        @Override
        public String getName()
        {
            return _name;
        }
    }

    //##################################################
    //# variables
    //##################################################

    private String                       _name;
    private String                       _comment;
    private String                       _type;
    private KmgModelAssociationReference _associationReference;
    private Relation                     _relation;
    private String                       _sequence;

    //##################################################
    //# constructor
    //##################################################

    public KmgModelCollection(KmgElement parent)
    {
        super(parent);
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return _name;
    }

    public String getComment()
    {
        return _comment;
    }

    public String getType()
    {
        return _type;
    }

    public KmgModelAssociationReference getAssociationReference()
    {
        return _associationReference;
    }

    public boolean hasAssociationReference(KmgModelAssociation e)
    {
        return Kmu.isEqual(getAssociation(), e);
    }

    public KmgModelAssociation getAssociation()
    {
        return getAssociationReference().getAssociation();
    }

    public KmgModel getAssociationReferenceModel()
    {
        return getAssociationReference().getReferenceModel();
    }

    private KmgModelHibernateCollectionType getHibernateCollectionType()
    {
        return KmgModelHibernateCollectionType.getType();
    }

    public String getSequence()
    {
        return _sequence;
    }

    public Relation getRelation()
    {
        return _relation;
    }

    public boolean isRelationWeak()
    {
        return _relation == Relation.WeakChildren;
    }

    public boolean isRelationStrong()
    {
        return !isRelationWeak();
    }

    //##################################################
    //# onCopy
    //##################################################

    public OnCopy getOnCopy()
    {
        switch ( _relation )
        {
            case Children:
                return OnCopy.Copy;

            case WeakChildren:
                return OnCopy.Clear;
        }
        return null;
    }

    public boolean isOnCopyClear()
    {
        return getOnCopy() == OnCopy.Clear;
    }

    public boolean isOnCopyCopy()
    {
        return getOnCopy() == OnCopy.Copy;
    }

    //##################################################
    //# cascade
    //##################################################

    public String getCascade()
    {
        switch ( _relation )
        {
            case Children:
                return "all-delete-orphan";

            case WeakChildren:
                return "save-update,evict,lock,replicate,merge,persist";
        }
        return null;

    }

    //##################################################
    //# public
    //##################################################

    @Override
    public void parse(KmStfElement e)
    {
        checkAttributeKeys(
            e,
            "name",
            "comment",
            "relation",
            "sequence",
            "elementModel",
            "elementField");

        _name = parseRequiredNameAttribute(e);
        _comment = parseRequiredString(e, "comment");

        _type = "bag";
        _sequence = parseString(e, "sequence", null);

        String s = parseRequiredString(e, "relation");
        _relation = Relation.findName(s);
        if ( _relation == null )
            throw newFatal("Unknown relation: " + s);

        String elementModel = parseRequiredString(e, "elementModel");
        String elementField = parseRequiredString(e, "elementField");

        _associationReference = new KmgModelAssociationReference(this);
        _associationReference.setModelName(elementModel);
        _associationReference.setAssociationName(elementField);
    }

    @Override
    public void validate()
    {
        _associationReference.validate();

        KmgModelHibernateCollectionType ctype = getHibernateCollectionType();

        if ( ctype.getUsesSequence() )
        {
            if ( Kmu.isEmpty(_sequence) )
                throw newFatal("Sequence is required for collection type(%s)", getType());

            KmgModelField f = getSequenceField();
            if ( f == null )
                throw newFatal(
                    "Sequence field(%s) not found in (%s).",
                    _sequence,
                    getAssociation().getModel().getName());
        }

        if ( !ctype.getUsesSequence() )
            if ( _sequence != null )
                throw newFatal("Sequence not allowed for collection type(%s)", getType());

        if ( !getAssociation().isRelationParent() )
            throw newFatal("The child association must have a Parent relation.");
    }

    @Override
    public void postValidate()
    {
        // none
    }

    public KmgModelField getSequenceField()
    {
        return getAssociation().getModel().getField(_sequence);
    }

    public boolean hasSequenceField()
    {
        return getSequenceField() != null;
    }

    public KmgModel getElementModel()
    {
        return getAssociation().getModel();
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public String getf_name()
    {
        return Kmu.pluralize(getName());
    }

    public String getf_singleName()
    {
        return getName();
    }

    public String getf_SingleName()
    {
        return Kmu.capitalizeFirstLetter(getf_singleName());
    }

    @Override
    public String getf_Type()
    {
        return formatList(getHibernateCollectionType().getJavaType(), getf_ElementType());
    }

    @Override
    public String getf_ImplType()
    {
        return formatList(getHibernateCollectionType().getJavaImpl(), getf_ElementType());
    }

    public String getf_ImplType_NoGeneric()
    {
        return formatList(getHibernateCollectionType().getJavaImpl(), "");
    }

    public String getf_WrapperType()
    {
        return Kmu.format(
            "%s<%s>",
            getHibernateCollectionType().getJavaWrapper(),
            getf_ElementType());
    }

    public String getf_WrapperImplType()
    {
        return Kmu.format(
            "%s<%s,%s>",
            getHibernateCollectionType().getJavaImplWrapper(),
            getf_ElementType(),
            getModel().getf_Class());
    }

    public String getf_WrapperImplType_NoGeneric()
    {
        return Kmu.format("%s<>", getHibernateCollectionType().getJavaImplWrapper());
    }

    public String getf_implGetMethod()
    {
        return "getBase" + getf_Name();
    }

    public String getf_ElementType()
    {
        return getElementModel().getf_Type();
    }

    public String getf_ElementName()
    {
        return getAssociation().getf_Name();
    }

    public String getf_hibernateName()
    {
        return getHibernateCollectionType().getName();
    }

    public String getf_cascade()
    {
        return getCascade();
    }

    public String getf_inverse()
    {
        return getHibernateCollectionType().getInverse() + "";
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("collection(%s)", _name);
    }

}
