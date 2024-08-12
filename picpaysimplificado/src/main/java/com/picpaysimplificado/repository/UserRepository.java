package com.picpaysimplificado.repository;

import com.picpaysimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// no <table, id_type> a gente passa a tabela que vai ultiliar e tambem o tipo do id
public interface UserRepository extends JpaRepository<User, Long> {

    // pode retornar um cadastro ou nao, por isso o optional
    Optional<User>findUserByDocument(String document);


    Optional<User>findUserById(Long id);

};


