package com.example.usermanagement.service;
import com.example.usermanagement.repository.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

        public User createUser(User user){
            if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email id is alredy exist");
        }
            return userRepository.save(user);
        }
        public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("wrong email or password!"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("wrong email or password!");
        }
        return user;
    }

    public List<User> getAllUsers(){
            return userRepository.findAll();
        }
        public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    public User updateUser(Long id,User userDetails){
            User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
            user.setName(user.getName());
            user.setMobile(user.getMobile());
            user.setEmail(user.getEmail());
            user.setApp(user.getApp());
            user.setSum(user.getSum());

            user.setPerStreet(userDetails.getPerStreet());
            user.setPerVillageOrCity(userDetails.getPerVillageOrCity());
            user.setPerState(userDetails.getPerState());
            user.setPerCountry(userDetails.getPerCountry());
            user.setCurStreet(userDetails.getCurStreet());
            user.setCurVillageOrCity(userDetails.getCurVillageOrCity());
            user.setCurState(userDetails.getCurState());
            user.setCurCountry(userDetails.getCurCountry());

        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    public List<User> createMultipleUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

}

