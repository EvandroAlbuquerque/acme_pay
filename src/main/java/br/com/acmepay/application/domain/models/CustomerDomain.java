package br.com.acmepay.application.domain.models;

import br.com.acmepay.application.domain.exception.DocumentAlreadyExistsException;
import br.com.acmepay.application.domain.exception.DocumentNotFoundException;
import br.com.acmepay.application.domain.exception.EmailAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;

public class CustomerDomain {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String document;

    private List<AccountDomain> accountDomains;

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

    public List<AccountDomain> getAccounts() {
        return accountDomains;
    }

    public void setAccounts(List<AccountDomain> accountDomains) {
        this.accountDomains = accountDomains;
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

    public List<CustomerDomain> customerDomains = new ArrayList<>();

    public void create(CustomerDomain customerDomain) throws Exception {
        this.checkIfDocumentExists(customerDomain.getDocument());
        this.checkIfEmailExists(customerDomain.getEmail());

        this.setId(customerDomain.getId());;
        this.setName(customerDomain.getName());
        this.setEmail(customerDomain.getEmail());
        this.setPhone(customerDomain.getPhone());
        this.setDocument(customerDomain.getDocument());
        this.setAccounts(null);
        customerDomains.add(customerDomain);
    }

    public void update(CustomerDomain customerDomainUpdated) {

        for (CustomerDomain c: customerDomains) {
            if (c.getId().equals(customerDomainUpdated.getId())) {

                if (customerDomainUpdated.getName() != null) {
                    c.setName(customerDomainUpdated.getName());
                }

                if (customerDomainUpdated.getEmail() != null) {
                    c.setEmail(customerDomainUpdated.getEmail());
                }

                if (customerDomainUpdated.getPhone() != null) {
                    c.setPhone(customerDomainUpdated.getPhone());
                }

                if (customerDomainUpdated.getDocument() != null) {
                    c.setDocument(customerDomainUpdated.getDocument());
                }

                c.setAccounts(customerDomainUpdated.getAccounts());
            }
        }
    }

    public List<CustomerDomain> listAll() {
        return customerDomains;
    }

    public CustomerDomain getByDocument(String document) throws DocumentNotFoundException {
        for (CustomerDomain c: customerDomains) {
            if (c.getDocument().equals(document)) {
                return c;
            }
        }
        throw new DocumentNotFoundException("Document not found");
    }

    public void delete(Long id) {
        for (CustomerDomain c: customerDomains) {
            if (c.getId().equals(id)) {
                customerDomains.remove(c);
            }
        }
    }

    public void checkIfDocumentExists(String document) throws DocumentAlreadyExistsException {
        for (CustomerDomain c: customerDomains) {
            if (c.getDocument().equals(document)) {
                throw new DocumentAlreadyExistsException("Document already exists.");
            }
        }
    }


    public void checkIfEmailExists(String email) throws EmailAlreadyExistsException {
        for (CustomerDomain c: customerDomains) {
            if (c.getEmail().equals(email)) {
                throw new EmailAlreadyExistsException("Email already exists.");
            }
        }
    }
}
