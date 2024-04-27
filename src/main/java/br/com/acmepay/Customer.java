package br.com.acmepay;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String document;

    private List<Account> accounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Customer> customers = new ArrayList<>();

    public void create(Customer customer) throws Exception {
        this.checkIfDocumentExists(customer.getDocument());
        this.checkIfEmailExists(customer.getEmail());

        this.setId(customer.getId());;
        this.setName(customer.getName());
        this.setEmail(customer.getEmail());
        this.setPhone(customer.getPhone());
        this.setDocument(customer.getDocument());
        this.setAccounts(null);
        customers.add(customer);
    }

    public void update(Customer customerUpdated) {

        for (Customer c: customers) {
            if (c.getId().equals(customerUpdated.getId())) {

                if (customerUpdated.getName() != null) {
                    c.setName(customerUpdated.getName());
                }

                if (customerUpdated.getEmail() != null) {
                    c.setEmail(customerUpdated.getEmail());
                }

                if (customerUpdated.getPhone() != null) {
                    c.setPhone(customerUpdated.getPhone());
                }

                if (customerUpdated.getDocument() != null) {
                    c.setDocument(customerUpdated.getDocument());
                }

                c.setAccounts(customerUpdated.getAccounts());
            }
        }
    }

    public List<Customer> listAll() {
        return customers;
    }

    public Customer getByDocument(String document) throws DocumentNotFoundException {
        for (Customer c: customers) {
            if (c.getDocument().equals(document)) {
                return c;
            }
        }
        throw new DocumentNotFoundException("Document not found");
    }

    public void delete(Long id) {
        for (Customer c: customers) {
            if (c.getId().equals(id)) {
                customers.remove(c);
            }
        }
    }

    public void checkIfDocumentExists(String document) throws DocumentAlreadyExistsException {
        for (Customer c: customers) {
            if (c.getDocument().equals(document)) {
                throw new DocumentAlreadyExistsException("Document already exists.");
            }
        }
    }


    public void checkIfEmailExists(String email) throws EmailAlreadyExistsException {
        for (Customer c: customers) {
            if (c.getEmail().equals(email)) {
                throw new EmailAlreadyExistsException("Email already exists.");
            }
        }
    }
}
