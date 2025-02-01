package com.example.p2.Service;

import com.example.p2.Entity.SignUpEntry;
import com.example.p2.Repository.SignUpRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SignUpService {

    @Autowired
    private SignUpRepository signUpRepository;

    public void saveDetails(SignUpEntry signUpEntry){
        signUpRepository.save(signUpEntry);
    }

    public SignUpEntry findByEmail(String Email) {
        return signUpRepository.findByEmail(Email);
    }

    public boolean validatePassword(String enteredPassword, String storedPassword) {
        return enteredPassword.equals(storedPassword);
    }
}




//    public void saveDetails(SignUpEntry signUpEntry){
//        if (signUpRepository.existsByEmail(signUpEntry.getEmail())) {
//            return "This email already exists";
//        }
//        signUpRepository.save(signUpEntry);
//        return null;
//    }


