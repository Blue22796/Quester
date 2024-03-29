package com.example.demo.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	public Account findByMail(@Param("mail") String mail);
}
