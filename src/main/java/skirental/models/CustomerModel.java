package skirental.models;

        import org.omg.CORBA.portable.ApplicationException;
        import skirental.database.dao.CustomerDao;
        import skirental.database.dbUtils.DatabaseManager;
        import skirental.database.model.Customer;

public class CustomerModel {

    public void saveCustomerToDB (String name, String surname, String addres, String external_id) throws ApplicationException {
        CustomerDao customerDao = new CustomerDao(DatabaseManager.getConnectionSource());
        Customer customer = new Customer();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setAddres(addres);
        customer.setExternal_id(external_id);
        customerDao.creatOrUpdate(customer);
        DatabaseManager.closeConnectionSource();
    }
}
