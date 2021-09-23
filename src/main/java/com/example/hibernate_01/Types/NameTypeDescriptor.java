package com.example.hibernate_01.Types;

import com.example.hibernate_01.Model.Interfaces.NameImpl;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NameTypeDescriptor implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] {
                StandardBasicTypes.STRING.sqlType(),
                StandardBasicTypes.STRING.sqlType(),
                StandardBasicTypes.STRING.sqlType(),
                StandardBasicTypes.STRING.sqlType(),
                StandardBasicTypes.STRING.sqlType()
        };
    }

    @Override
    public Class<NameImpl> returnedClass() {
        return NameImpl.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (null == x || null == y)
        {
            return false;
        }
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        if (x == null) return 0;
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings,
                              SharedSessionContractImplementor sharedSessionContractImplementor, Object owner)
            throws HibernateException, SQLException {
        NameImpl nameImpl = new NameImpl();
        nameImpl.setFullName(resultSet.getString(strings[0]));
        nameImpl.setFirstName(resultSet.getString(strings[1]));
        nameImpl.setMiddleName(resultSet.getString(strings[2]));
        nameImpl.setLastName(resultSet.getString(strings[3]));
        nameImpl.setShortName(resultSet.getString(strings[4]));
        return nameImpl;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value,
                            int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        NameImpl NameImpl = (NameImpl) value;
        if (NameImpl != null) {
            st.setString(index, NameImpl.getFullName());
            st.setString(index+1, NameImpl.getFirstName());
            st.setString(index+2, NameImpl.getMiddleName());
            st.setString(index+3, NameImpl.getLastName());
            st.setString(index+4, NameImpl.getShortName());
        }
        else{
            st.setNull(index+0, sqlTypes()[0]);
            st.setNull(index+1, sqlTypes()[1]);
            st.setNull(index+2, sqlTypes()[2]);
            st.setNull(index+3, sqlTypes()[3]);
            st.setNull(index+4, sqlTypes()[4]);
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return serializable;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return deepCopy(o);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
