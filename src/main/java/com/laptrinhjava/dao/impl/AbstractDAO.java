package com.laptrinhjava.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.laptrinhjava.dao.GenericDAO;
import com.laptrinhjava.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {

    private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final static String url = "jdbc:mysql://localhost:3306/quanlyhoso";
    private final static String user = "root";
    private final static String password = "123456";

    public Connection getConnection() {
        Connection cnn = null;
        try {
            Class.forName(JDBC_DRIVER);
            cnn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            System.err.println("Khong tim thay Driver: " + ex.getMessage());
        } catch (SQLException ex) {
            System.err.println("Khong the ket noi voi CSDL MySQL. Chi tiet: " + ex.getMessage());
        }
        return cnn;
    }


    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection cnn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            cnn = getConnection();
            statement = cnn.prepareStatement(sql);
            setParameter(statement, parameters);
            rs = statement.executeQuery();
            while (rs.next()) {
                results.add(rowMapper.mapRow(rs));
            }
            return results;
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (cnn != null) {
                    cnn.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    private void setParameter(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                } else if (parameter instanceof Float) {
                    statement.setFloat(index, (Float) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Timestamp) {
                    statement.setTimestamp(index, (Timestamp) parameter);
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateordelete(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

    }

    @Override
    public Integer insert(String sql, Object... parameters) {
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Integer id = null;
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
            setParameter(statement, parameters);
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            connection.commit();
            return id;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        return null;
    }


	@Override
	public int count(String sql, Object... parameters) {
	        Connection cnn = null;
	        PreparedStatement statement = null;
	        ResultSet rs = null;
	        try {
	        	int count = 0;
	            cnn = getConnection();
	            statement = cnn.prepareStatement(sql);
	            setParameter(statement, parameters);
	            rs = statement.executeQuery();
	            while (rs.next()) {
	              count = rs.getInt(1);
	            }
	            return count;
	        } catch (SQLException e) {
	            return 0;
	        } finally {
	            try {
	                if (cnn != null) {
	                    cnn.close();
	                }
	                if (statement != null) {
	                    statement.close();
	                }
	                if (rs != null) {
	                    rs.close();
	                }
	            } catch (SQLException e) {
	                return 0;
	            }
	        }
	}

}
