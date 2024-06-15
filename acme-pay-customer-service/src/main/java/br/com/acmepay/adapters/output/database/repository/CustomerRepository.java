package br.com.acmepay.adapters.output.database.repository;

import br.com.acmepay.adapters.output.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAll();
}
