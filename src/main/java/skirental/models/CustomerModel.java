package skirental.models;

        import javafx.beans.property.ObjectProperty;
        import javafx.beans.property.SimpleObjectProperty;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import org.omg.CORBA.portable.ApplicationException;
        import skirental.database.dao.CustomerDao;
        import skirental.database.dbUtils.DatabaseManager;
        import skirental.database.model.Customer;
        import skirental.utils.Converters;

        import java.util.Date;
        import java.util.List;

public class CustomerModel {

    private ObservableList<CustomerFX> customerFXObservableList = FXCollections.observableArrayList();
    private ObjectProperty<CustomerFX> customer = new SimpleObjectProperty<>();
    private ObjectProperty<CustomerFX> customerStr = new SimpleObjectProperty<>();

    public void saveCustomerToDB (String name, String surname, String addres, String external_id) throws ApplicationException {
        CustomerDao customerDao = new CustomerDao(DatabaseManager.getConnectionSource());
        Customer customer = new Customer();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setAddres(addres);
        customer.setAddedDate(new Date());
        customer.setExternal_id(external_id);
        customerDao.creatOrUpdate(customer);
        DatabaseManager.closeConnectionSource();
        takeCustomerFromDB();// to refresh ObservableList
    }
    public void deleteCustomerFromDB() throws ApplicationException {
        CustomerDao customerDao = new CustomerDao(DatabaseManager.getConnectionSource());
        customerDao.deleteByID(Customer.class, customer.getValue().getId());
        DatabaseManager.closeConnectionSource();
        takeCustomerFromDB();// to refresh ObservableList
    };

    public void takeCustomerFromDB() throws ApplicationException {
        CustomerDao customerDao = new CustomerDao(DatabaseManager.getConnectionSource());
        List<Customer> customers = customerDao.queryForAll(Customer.class);
        this.customerFXObservableList.clear();
        customers.forEach(e->{
           CustomerFX customerFX = Converters.convertToCustomerFX(e);
            this.customerFXObservableList.add(customerFX);
        });
        DatabaseManager.closeConnectionSource();
}
    public void takeCustomerByID(int id) throws ApplicationException {
        CustomerDao customerDao = new CustomerDao(DatabaseManager.getConnectionSource());
        Customer customer = customerDao.findById(Customer.class, id);
        CustomerFX customerFX = Converters.convertToCustomerFX(customer);
        this.customerStr.set(customerFX);
        DatabaseManager.closeConnectionSource();
    }

    public void takeCustomerByRFIDFromDB(String rfid) throws ApplicationException {
        this.customerFXObservableList.clear();
        CustomerDao customerDao = new CustomerDao(DatabaseManager.getConnectionSource());
        List<Customer> customerList = customerDao.queryForEq(Customer.class,"external_id", rfid);
        //this.itemsFXObservableList.clear();
        customerList.forEach(customer -> {
            CustomerFX customerFX = Converters.convertToCustomerFX(customer);
            this.customerFXObservableList.add(customerFX);
        });
        DatabaseManager.closeConnectionSource();
    }


    public ObservableList<CustomerFX> getCustomerFXObservableList() {
        return customerFXObservableList;
    }

    public void setCustomerFXObservableList(ObservableList<CustomerFX> customerFXObservableList) {
        this.customerFXObservableList = customerFXObservableList;
    }

    public CustomerFX getCustomer() {
        return customer.get();
    }

    public ObjectProperty<CustomerFX> customerProperty() {
        return customer;
    }

    public void setCustomer(CustomerFX customer) {
        this.customer.set(customer);
    }
    public CustomerFX getCustomerStr() {
        return customerStr.get();
    }

    public ObjectProperty<CustomerFX> customerStrProperty() {
        return customerStr;
    }

    public void setCustomerStr(CustomerFX customerStr) {
        this.customerStr.set(customerStr);
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "customerFXObservableList=" + customerFXObservableList +
                ", customer=" + customer +
                '}';
    }
}
