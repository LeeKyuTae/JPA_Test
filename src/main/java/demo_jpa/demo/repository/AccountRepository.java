package demo_jpa.demo.repository;

import demo_jpa.demo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long > {
}
