package br.com.nomadit.order.repository;

import br.com.nomadit.order.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>  {

    Optional<Customer> findByClientCode(Integer clientCode);
}
