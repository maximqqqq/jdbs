package dao;

import entity.Address;
import entity.Pets;

import java.sql.SQLException;
import java.util.List;

public interface PetsDAO {
    //create
    void add(Pets pets) throws SQLException;

    //read
    List<Pets> getAll() throws SQLException;

    Pets getById(Long id) throws SQLException;

    //update
    void update(Pets pets) throws SQLException;

    //delete
    void delete(Pets pets) throws SQLException;
}
