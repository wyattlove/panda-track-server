//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.utility.*;

public abstract class MyUserBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaUser Meta = MyMetaUser.instance;
    public static final MyUserTools Tools = MyUserTools.instance;
    public static final MyUserValidator Validator = MyUserValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String name;
    private String email;
    private String phone;
    private Boolean verified;
    private String passwordSalt;
    private String passwordHash;
    private String timeZoneCode;
    private String roleCode;
    private Integer lockVersion;
    private MyProject lastProject;

    //##################################################
    //# constructor
    //##################################################

    public MyUserBase()
    {
        super();
        setUid(newUid());
        setVerified(false);
        setPasswordSalt(newUid());
        setRoleCode(MyUserRole.Other.getCode());
    }

    //##################################################
    //# field (uid)
    //##################################################

    public String getUid()
    {
        return uid;
    }

    public void setUid(String e)
    {
        checkReadOnly();
        e = Validator.getUidValidator().convertOnly(e);
        uid = e;
    }

    public void clearUid()
    {
        setUid(null);
    }

    public boolean hasUid()
    {
        return Kmu.hasValue(getUid());
    }

    public boolean hasUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getUid(), e);
    }

    public void truncateUid()
    {
        truncateUid(false);
    }

    public void truncateUid(boolean ellipses)
    {
        uid = Kmu.truncate(uid, 30, ellipses);
    }

    //##################################################
    //# field (name)
    //##################################################

    public String getName()
    {
        return name;
    }

    public void setName(String e)
    {
        checkReadOnly();
        e = Validator.getNameValidator().convertOnly(e);
        name = e;
    }

    public void clearName()
    {
        setName(null);
    }

    public boolean hasName()
    {
        return Kmu.hasValue(getName());
    }

    public boolean hasName(String e)
    {
        return Kmu.isEqualIgnoreCase(getName(), e);
    }

    public void truncateName()
    {
        truncateName(false);
    }

    public void truncateName(boolean ellipses)
    {
        name = Kmu.truncate(name, 50, ellipses);
    }

    //##################################################
    //# field (email)
    //##################################################

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String e)
    {
        checkReadOnly();
        e = Validator.getEmailValidator().convertOnly(e);
        email = e;
    }

    public void clearEmail()
    {
        setEmail(null);
    }

    public boolean hasEmail()
    {
        return Kmu.hasValue(getEmail());
    }

    public boolean hasEmail(String e)
    {
        return Kmu.isEqualIgnoreCase(getEmail(), e);
    }

    public void truncateEmail()
    {
        truncateEmail(false);
    }

    public void truncateEmail(boolean ellipses)
    {
        email = Kmu.truncate(email, 50, ellipses);
    }

    //##################################################
    //# field (phone)
    //##################################################

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String e)
    {
        checkReadOnly();
        e = Validator.getPhoneValidator().convertOnly(e);
        phone = e;
    }

    public void clearPhone()
    {
        setPhone(null);
    }

    public boolean hasPhone()
    {
        return Kmu.hasValue(getPhone());
    }

    public boolean hasPhone(String e)
    {
        return Kmu.isEqualIgnoreCase(getPhone(), e);
    }

    public void truncatePhone()
    {
        truncatePhone(false);
    }

    public void truncatePhone(boolean ellipses)
    {
        phone = Kmu.truncate(phone, 30, ellipses);
    }

    //##################################################
    //# field (verified)
    //##################################################

    public Boolean getVerified()
    {
        return verified;
    }

    public void setVerified(Boolean e)
    {
        checkReadOnly();
        e = Validator.getVerifiedValidator().convertOnly(e);
        verified = e;
    }

    public void clearVerified()
    {
        setVerified(null);
    }

    public boolean hasVerified()
    {
        return getVerified() != null;
    }

    public boolean hasVerified(Boolean e)
    {
        return Kmu.isEqual(getVerified(), e);
    }

    public boolean isVerified()
    {
        if ( getVerified() == null )
            return false;
        return getVerified();
    }

    public boolean isNotVerified()
    {
        return !isVerified();
    }

    public boolean isVerified(Boolean b)
    {
        return Kmu.isEqual(getVerified(), b);
    }

    public void toggleVerified()
    {
        setVerified(!getVerified());
    }

    //##################################################
    //# field (passwordSalt)
    //##################################################

    public String getPasswordSalt()
    {
        return passwordSalt;
    }

    public void setPasswordSalt(String e)
    {
        checkReadOnly();
        e = Validator.getPasswordSaltValidator().convertOnly(e);
        passwordSalt = e;
    }

    public void clearPasswordSalt()
    {
        setPasswordSalt(null);
    }

    public boolean hasPasswordSalt()
    {
        return Kmu.hasValue(getPasswordSalt());
    }

    public boolean hasPasswordSalt(String e)
    {
        return Kmu.isEqualIgnoreCase(getPasswordSalt(), e);
    }

    public void truncatePasswordSalt()
    {
        truncatePasswordSalt(false);
    }

    public void truncatePasswordSalt(boolean ellipses)
    {
        passwordSalt = Kmu.truncate(passwordSalt, 30, ellipses);
    }

    //##################################################
    //# field (passwordHash)
    //##################################################

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public void setPasswordHash(String e)
    {
        checkReadOnly();
        e = Validator.getPasswordHashValidator().convertOnly(e);
        passwordHash = e;
    }

    public void clearPasswordHash()
    {
        setPasswordHash(null);
    }

    public boolean hasPasswordHash()
    {
        return Kmu.hasValue(getPasswordHash());
    }

    public boolean hasPasswordHash(String e)
    {
        return Kmu.isEqualIgnoreCase(getPasswordHash(), e);
    }

    public void truncatePasswordHash()
    {
        truncatePasswordHash(false);
    }

    public void truncatePasswordHash(boolean ellipses)
    {
        passwordHash = Kmu.truncate(passwordHash, 40, ellipses);
    }

    //##################################################
    //# field (timeZoneCode)
    //##################################################

    public String getTimeZoneCode()
    {
        return timeZoneCode;
    }

    public void setTimeZoneCode(String e)
    {
        checkReadOnly();
        e = Validator.getTimeZoneCodeValidator().convertOnly(e);
        timeZoneCode = e;
    }

    public void clearTimeZoneCode()
    {
        setTimeZoneCode(null);
    }

    public boolean hasTimeZoneCode()
    {
        return Kmu.hasValue(getTimeZoneCode());
    }

    public boolean hasTimeZoneCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getTimeZoneCode(), e);
    }

    public void truncateTimeZoneCode()
    {
        truncateTimeZoneCode(false);
    }

    public void truncateTimeZoneCode(boolean ellipses)
    {
        timeZoneCode = Kmu.truncate(timeZoneCode, 5, ellipses);
    }

    //##################################################
    //# field (roleCode)
    //##################################################

    public String getRoleCode()
    {
        return roleCode;
    }

    public void setRoleCode(String e)
    {
        checkReadOnly();
        e = Validator.getRoleCodeValidator().convertOnly(e);
        roleCode = e;
    }

    public void clearRoleCode()
    {
        setRoleCode(null);
    }

    public boolean hasRoleCode()
    {
        return Kmu.hasValue(getRoleCode());
    }

    public boolean hasRoleCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getRoleCode(), e);
    }

    public void truncateRoleCode()
    {
        truncateRoleCode(false);
    }

    public void truncateRoleCode(boolean ellipses)
    {
        roleCode = Kmu.truncate(roleCode, 1, ellipses);
    }

    public MyUserRole getRole()
    {
        return MyUserRole.findCode(getRoleCode());
    }

    public void setRole(MyUserRole e)
    {
        if ( e == null )
            setRoleCode(null);
        else
            setRoleCode(e.getCode());
    }

    public boolean hasRole()
    {
        return getRole() != null;
    }

    public boolean hasRole(MyUserRole e)
    {
        return getRole() == e;
    }

    public void setRoleDeveloper()
    {
        setRole(MyUserRole.Developer);
    }

    public boolean isRoleDeveloper()
    {
        return hasRole(MyUserRole.Developer);
    }

    public boolean isNotRoleDeveloper()
    {
        return !isRoleDeveloper();
    }

    public void setRoleAdmin()
    {
        setRole(MyUserRole.Admin);
    }

    public boolean isRoleAdmin()
    {
        return hasRole(MyUserRole.Admin);
    }

    public boolean isNotRoleAdmin()
    {
        return !isRoleAdmin();
    }

    public void setRoleOther()
    {
        setRole(MyUserRole.Other);
    }

    public boolean isRoleOther()
    {
        return hasRole(MyUserRole.Other);
    }

    public boolean isNotRoleOther()
    {
        return !isRoleOther();
    }

    //##################################################
    //# field (lockVersion)
    //##################################################

    public Integer getLockVersion()
    {
        return lockVersion;
    }

    public void setLockVersion(Integer e)
    {
        checkReadOnly();
        e = Validator.getLockVersionValidator().convertOnly(e);
        lockVersion = e;
    }

    public void clearLockVersion()
    {
        setLockVersion(null);
    }

    public boolean hasLockVersion()
    {
        return getLockVersion() != null;
    }

    public boolean hasLockVersion(Integer e)
    {
        return Kmu.isEqual(getLockVersion(), e);
    }

    //##################################################
    //# field (roleName)
    //##################################################

    public final String getRoleName()
    {
        return Kmu.getName(getRole());
    }

    public boolean hasRoleName()
    {
        return Kmu.hasValue(getRoleName());
    }

    public boolean hasRoleName(String e)
    {
        return Kmu.isEqualIgnoreCase(getRoleName(), e);
    }

    //##################################################
    //# lastProject
    //##################################################

    public MyProject getLastProject()
    {
        return lastProject;
    }

    public void setLastProject(MyProject e)
    {
        checkReadOnly();
        lastProject = e;
    }

    public void _setLastProject(MyProject e)
    {
        checkReadOnly();
        lastProject = e;
    }

    public void clearLastProject()
    {
        setLastProject(null);
    }

    public boolean hasLastProject()
    {
        return getLastProject() != null;
    }

    public boolean hasLastProject(MyProject e)
    {
        return Kmu.isEqual(getLastProject(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyUser)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyUser)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyUser)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyUser getCopy()
    {
        return (MyUser)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyUserBase) )
            return false;

        MyUserBase e = (MyUserBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyUser e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyUser e)
    {
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getEmail(), e.getEmail()) ) return false;
        if ( !Kmu.isEqual(getPhone(), e.getPhone()) ) return false;
        if ( !Kmu.isEqual(getVerified(), e.getVerified()) ) return false;
        if ( !Kmu.isEqual(getPasswordSalt(), e.getPasswordSalt()) ) return false;
        if ( !Kmu.isEqual(getPasswordHash(), e.getPasswordHash()) ) return false;
        if ( !Kmu.isEqual(getTimeZoneCode(), e.getTimeZoneCode()) ) return false;
        if ( !Kmu.isEqual(getRoleCode(), e.getRoleCode()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getRoleName(), e.getRoleName()) ) return false;
        return true;
    }

    public boolean isDifferent(MyUser e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyUser e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# property
    //##################################################

    public void importPropertyMap(KmMap<String,String> map)
    {
        KmProperties p;
        p = new KmProperties();
        p.setMap(map);

        if ( p.hasKey("uid") )
            setUid(p.getString("uid"));

        if ( p.hasKey("name") )
            setName(p.getString("name"));

        if ( p.hasKey("email") )
            setEmail(p.getString("email"));

        if ( p.hasKey("phone") )
            setPhone(p.getString("phone"));

        if ( p.hasKey("verified") )
            setVerified(p.getBoolean("verified"));

        if ( p.hasKey("passwordSalt") )
            setPasswordSalt(p.getString("passwordSalt"));

        if ( p.hasKey("passwordHash") )
            setPasswordHash(p.getString("passwordHash"));

        if ( p.hasKey("timeZoneCode") )
            setTimeZoneCode(p.getString("timeZoneCode"));

        if ( p.hasKey("roleCode") )
            setRoleCode(p.getString("roleCode"));

        if ( p.hasKey("lockVersion") )
            setLockVersion(p.getInteger("lockVersion"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasUid() )
            p.setString("uid", getUid());

        if ( hasName() )
            p.setString("name", getName());

        if ( hasEmail() )
            p.setString("email", getEmail());

        if ( hasPhone() )
            p.setString("phone", getPhone());

        if ( hasVerified() )
            p.setBoolean("verified", getVerified());

        if ( hasPasswordSalt() )
            p.setString("passwordSalt", getPasswordSalt());

        if ( hasPasswordHash() )
            p.setString("passwordHash", getPasswordHash());

        if ( hasTimeZoneCode() )
            p.setString("timeZoneCode", getTimeZoneCode());

        if ( hasRoleCode() )
            p.setString("roleCode", getRoleCode());

        if ( hasLockVersion() )
            p.setInteger("lockVersion", getLockVersion());

        return p.getMap();
    }


    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyUser");
        sb.append("(");
        sb.append("Uid=");
        sb.append(uid);
        sb.append(")");
        return sb.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Uid = " + uid);
        System.out.println("    Name = " + name);
        System.out.println("    Email = " + email);
        System.out.println("    Phone = " + phone);
        System.out.println("    Verified = " + verified);
        System.out.println("    PasswordSalt = " + passwordSalt);
        System.out.println("    PasswordHash = " + passwordHash);
        System.out.println("    TimeZoneCode = " + timeZoneCode);
        System.out.println("    RoleCode = " + roleCode);
        System.out.println("    LockVersion = " + lockVersion);
    }
}
