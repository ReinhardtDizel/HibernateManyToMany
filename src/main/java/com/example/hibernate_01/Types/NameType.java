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
import java.sql.Types;
import java.util.Objects;

public class NameType implements UserType {
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
    public int hashCode(Object o) throws HibernateException {
        return 0;
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings,
                              SharedSessionContractImplementor sharedSessionContractImplementor, Object owner)
            throws HibernateException, SQLException {

        NameImpl nameImpl = new NameImpl();

        String fullName = resultSet.getString(strings[0]);
        if(fullName != null)
            nameImpl.setFullName(fullName);

        return nameImpl;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value,
                            int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (Objects.isNull(value)) {
            st.setNull(index, Types.VARCHAR);
            st.setNull(index + 1, Types.VARCHAR);
            st.setNull(index + 2, Types.VARCHAR);
            st.setNull(index + 3, Types.VARCHAR);
            st.setNull(index + 4, Types.VARCHAR);
        } else {
            final NameImpl nameImpl = (NameImpl) value;
            st.setString(index,nameImpl.getFullName());
            st.setString(index+1,nameImpl.getFirstName());
            st.setString(index+2,nameImpl.getMiddleName());
            st.setString(index+3,nameImpl.getLastName());
            st.setString(index+4,nameImpl.getShortName());
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
    public Serializable disassemble(Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return null;
    }
}
