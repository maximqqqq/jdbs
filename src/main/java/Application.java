import bl.Util;
import entity.Address;
import entity.Employee;
import entity.Pets;
import service.AddressService;
import service.EmployeeService;
import service.PetsService;

import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        PetsService petsService = new PetsService();

        Address address = new Address();
        address.setId(1L);
        address.setCountry("Belarus");
        address.setCity("Minsk");

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("Maxim");
        employee.setLastName("Steponenko");
        employee.setAge(30);
        employee.setAddressID(address.getId());

        Pets pets = new Pets();
        pets.setId(1L);
        pets.setName("Bobik");
        pets.setAge(5);
        pets.setEmployeeID(employee.getId());

        try {
//            addressService.add(address);
//            employeeService.add(employee);
//            petsService.add(pets);
            List<Pets> petsList = petsService.getAll();
            for (Pets e: petsList) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
