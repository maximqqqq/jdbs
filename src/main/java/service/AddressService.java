package service;

import bl.Util;
import dao.AddressDAO;
import entity.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressService extends Util implements AddressDAO {

    Connection connection = getConnection();

    @Override
    public void add(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO ADDRESS (ID, COUNTRY, CITY) VALUES(?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());

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
    public List<Address> getAll() throws SQLException {
        List<Address> addressList = new ArrayList<>();

        String sql = "SELECT ID, COUNTRY, CITY FROM ADDRESS";

        Statement statement = null;

        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getLong("ID"));
                address.setCountry(resultSet.getString("COUNTRY"));
                address.setCountry(resultSet.getString("CITY"));

                addressList.add(address);
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
        return addressList;
    }

    @Override
    public Address getById(Long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, COUNTRY, CITY FROM ADDRESS WHERE ID=?";

        Address address = new Address();

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            address.setId(resultSet.getLong("ID"));
            address.setCountry(resultSet.getString("COUNTRY"));
            address.setCity(resultSet.getString("CITY"));

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
        return address;
    }

    @Override
    public void update(Address address) throws SQLException {
        PreparedStatement preparedStatement=null;

        String sql ="UPDATE ADDRESS SET COUNTRY=?, CITY=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,address.getCountry());
            preparedStatement.setString(2,address.getCity());
            preparedStatement.setLong(3,address.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
    }

    @Override
    public void delete(Address address) throws SQLException {
        PreparedStatement preparedStatement=null;

        String sql = "DELETE FROM ADDRESS WHERE ID=?";

        try {
            preparedStatement= connection.prepareStatement(sql);

            preparedStatement.setLong(1,address.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
    }
}
