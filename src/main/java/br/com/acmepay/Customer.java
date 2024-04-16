package br.com.acmepay;

import java.io.File;
import java.util.List;

public class Customer {

    private File customerDocument;

    private List<Account> customerAccounts;

    private String customerName;

    private String customerEmail;

    private String customerPhone;


    public File getCustomerDocument() {
        return customerDocument;
    }

    public void setCustomerDocument(File customerDocument) {
        this.customerDocument = customerDocument;
    }

    public List<Account> getCustomerAccounts() {
        return customerAccounts;
    }

    public void setCustomerAccounts(List<Account> customerAccounts) {
        this.customerAccounts = customerAccounts;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
