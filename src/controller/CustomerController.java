package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import model.*;

public class CustomerController {
    private ArrayList customers;

    public CustomerController(ArrayList listOfCustomers) {
        this.customers = (listOfCustomers != null) ? listOfCustomers : new ArrayList();
    }

    public void registerCustomer(String name, LocalDate birthDate, Objective objective) {
        Customer c = new Customer(customers, name, birthDate, objective);
        customers.add(c);
    }

    public boolean removeCustomer(int id) {
        return customers.removeIf(c -> ((Customer) c).getId() == id);
    }

    public ArrayList getAllCustomers() {
        return customers;
    }

    public Customer findCustomerById(int id) {
        for (Object c : customers) {
            if (((Customer) c).getId() == id) 
            return (Customer) c;
        }
        return null;
    }

    public void addTraining(int customerId, Training training) {
        Customer c = findCustomerById(customerId);
        if (c != null) c.addTraining(training);
    }

    public boolean removeTraining(int customerId, int trainingId) {
        Customer c = findCustomerById(customerId);
        return (c != null) && c.removeTrainingById(trainingId);
    }

    public boolean isEnrolled(int customerId) {
        Customer c = findCustomerById(customerId);
        return c != null && c.isEnrolled();
    }
}