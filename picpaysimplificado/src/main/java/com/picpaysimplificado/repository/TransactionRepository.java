package com.picpaysimplificado.repository;

import com.picpaysimplificado.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

// no <table, id_type> a gente passa a tabela que vai ultiliar e tambem o tipo do id
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
