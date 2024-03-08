package com.wistron.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @Author：Chaojun_Lu
 * @Date：2024/2/28 13:53
 * @Function： 自定义类型处理
 */
public class ExampleTypeHandler extends BaseTypeHandler<Date> {
    private static Logger mLog = LogManager.getLogger(ExampleTypeHandler.class);
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        mLog.info("setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType)");
        ps.setString(i, String.valueOf(parameter.getTime()));
    }

    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        mLog.info("getNullableResult(ResultSet rs, String columnName), columnNamexxx="+columnName);
        String sqlTimestamp = rs.getString(columnName);
        mLog.info("sqlTimestamp="+sqlTimestamp);
        if(sqlTimestamp != null){
            return new Date(Long.valueOf(sqlTimestamp));
        }
        return null;
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        mLog.info("getNullableResult(ResultSet rs, int columnIndex)");
        String sqlTimestamp = rs.getString(columnIndex);
        if(sqlTimestamp != null){
            return new Date(Long.valueOf(sqlTimestamp));
        }
        return null;
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        mLog.info("getNullableResult(CallableStatement cs, int columnIndex)");
        String sqlTimestamp = cs.getString(columnIndex);
        if(sqlTimestamp != null){
            return new Date(Long.valueOf(sqlTimestamp));
        }
        return null;
    }
}
