package lablaida.ikram.ebank_account_service.repositories;

import lablaida.ikram.ebank_account_service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
