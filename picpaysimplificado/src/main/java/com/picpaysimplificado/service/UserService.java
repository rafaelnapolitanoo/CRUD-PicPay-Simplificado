package com.picpaysimplificado.service;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.dtos.UserDTO;
import com.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutionException;

//criar logica de negocio e metodos de validação
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        // validação de autorizacao para efetuar transacao, só os COMMUN podem
        if(sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuarios do tipo Logista, não estam autorizados a efetuar transações");
        }

        // validação para ver se o User tem o saldo (amount) em seu saldo
        if(sender.getBalance().compareTo(amount)< 0) {
            throw new Exception("Saldo Insuficiente");
        };
    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Ususario não encontrado"));
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
}
