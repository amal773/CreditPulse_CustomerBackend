package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.CustomerCardAccount;

@Repository
public interface CustomerCardAccountRepository extends JpaRepository<CustomerCardAccount, Long> {
	@Query(value = "SELECT * FROM customer_card_account where customer_id = ?1", nativeQuery = true)
	List<CustomerCardAccount> findAllByCustomerId(Long id);

	@Query(value = "SELECT account_number FROM customer_card_account WHERE customer_id = ?1 AND activation_status = 'ACTIVE'", nativeQuery = true)
	List<Long> findAllActiveCustomerId(Long customerId);

	boolean existsByCardNumber(Long cardNumber);
}
