package com.project.tokoonline.service;


import com.project.tokoonline.contoller.UserController;
import com.project.tokoonline.exception.InternalErrorException;
import com.project.tokoonline.exception.NotFoundException;
import com.project.tokoonline.model.User;
import com.project.tokoonline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Object getAllUser() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            return "Data ada yg bernilai Null";
        }
    }

    @Override
    public User addUser(User user) {
        String email = user.getEmail();
        var validasi = userRepository.findByEmail(email);
        if (validasi.isPresent()){
            throw new InternalErrorException("Email Already Axist");
        } else {
            return userRepository.save(user);
        }

    }

    @Override
    public Object getUser(Long id) {
//        var ini dipakai ketika sudah mengimplementasi kan global exception handler
        var user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
        try {
//            Var di bawah ini sebelum menggunakan package exception not found
//            var user = userRepository.findById(id).get();
            return userRepository.save(user);
        } catch (Exception e) {
//            digunakan saat sudah memakai exception
            throw new InternalErrorException("Data ada yang bernilai null");

//            return dibawah ini sebelum menggunakan throw new
//            return "Kesalahan Memunculkan Data";
        }
    }

    @Override
    public Object editUser(Long id, String username, String email, int age, String address, int phone_number) {
        User user = userRepository.findById(id).get();
        user.setUsername(username);
        user.setEmail(email);
        user.setAge(age);
        user.setAddress(address);
        user.setHp(phone_number);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
