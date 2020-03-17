package service;

import bl.Util;
import dao.EmployeeDAO;
import entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends Util implements EmployeeDAO {

    private Connection connection = getConnection();

    @Override
    public void add(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, AGE, ADDRESS_ID)" + "VALUES(?,?,?,?,?) ";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.setLong(5,employee.getAddressID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public List<Employee> getAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();

        String sql = "SELECT ID, FIRST_NAME, LAST_NAME, AGE FROM EMPLOYEE ";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("ID"));
                employee.setFirstName(resultSet.getString("FIRST_NAME"));
                employee.setLastName(resultSet.getString("LAST_NAME"));
                employee.setAge(resultSet.getInt("AGE"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return employeeList;
    }

    @Override
    public Employee getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, FIRST_NAME, LAST_NAME, AGE FROM EMPLOYEE WHERE ID=?";

        Employee employee = new Employee();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            employee.setId(resultSet.getLong("ID"));
            employee.setFirstName(resultSet.getString("FIRST_NAME"));
            employee.setLastName(resultSet.getString("LAST_NAME"));
            employee.setAge(resultSet.getInt("AGE"));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return employee;
    }

    @Override
    public void update(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE EMPLOYEE SET FIRST_NAME=?, LAST_NAME=?, AGE=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setLong(4, employee.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void delete(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM EMPLOYEE WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, employee.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
