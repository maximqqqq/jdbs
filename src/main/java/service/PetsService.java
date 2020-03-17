package service;

import bl.Util;
import dao.PetsDAO;
import entity.Pets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PetsService extends Util implements PetsDAO {

    Connection connection = getConnection();

    @Override
    public void add(Pets pets) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO PETS (ID, NAME, AGE, EMPLOYEE_ID)" + "VALUES(?,?,?,?) ";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, pets.getId());
            preparedStatement.setString(2, pets.getName());
            preparedStatement.setInt(3, pets.getAge());
            preparedStatement.setLong(4,pets.getEmployeeID());

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
    public List<Pets> getAll() throws SQLException {
        List<Pets> petsList = new ArrayList<>();

        String sql = "SELECT ID, NAME, AGE FROM PETS ";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Pets pets = new Pets();
                pets.setId(resultSet.getLong("ID"));
                pets.setName(resultSet.getString("NAME"));
                pets.setAge(resultSet.getInt("AGE"));

                petsList.add(pets);
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
        return petsList;
    }

    @Override
    public Pets getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, NAME, AGE FROM PETS WHERE ID=?";

        Pets pets = new Pets();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            pets.setId(resultSet.getLong("ID"));
            pets.setName(resultSet.getString("NAME"));
            pets.setAge(resultSet.getInt("AGE"));

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
        return pets;
    }

    @Override
    public void update(Pets pets) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE PETS SET NAME=?, AGE=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, pets.getName());
            preparedStatement.setInt(2, pets.getAge());
            preparedStatement.setLong(3, pets.getId());

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
    public void delete(Pets pets) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM PETS WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, pets.getId());

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

