package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //註冊
    public String register(User user){
        //檢查帳號是否存在
        if(userRepository.findByUsername(user.getUsername()) != null){
            return "帳號已存在";
        }
        //加密密碼
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "註冊成功";
    }

    //登入
    public User login(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user == null){
            return null;
        }
        if(!passwordEncoder.matches(password, user.getPassword())){
            return null;
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {

        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public User updateUserById(Long id, User user){
        User nowUser = userRepository.findById(id).orElse(null);
        if(nowUser!= null){
            nowUser.setUsername(user.getUsername());
            nowUser.setPassword(passwordEncoder.encode(user.getPassword()));
            nowUser.setEmail(user.getEmail());
            return userRepository.save(nowUser);
        }
        System.out.println("查無此使用者");
        return null;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
