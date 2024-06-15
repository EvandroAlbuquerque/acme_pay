package br.com.acmepay.adapters.output;

import br.com.acmepay.adapters.output.database.repository.CustomerRepository;
import br.com.acmepay.application.domain.model.CustomerDomain;
import br.com.acmepay.application.ports.out.ICreateCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CreateCustomerService implements ICreateCustomer {

    private final CustomerRepository repository;

    @Override
    public String execute(CustomerDomain customerDomain) {
        return customerDomain.getName();
    }
}