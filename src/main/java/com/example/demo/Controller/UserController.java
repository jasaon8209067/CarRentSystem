package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //註冊
    @PostMapping("/register")
    public String register(@RequestBody User user){
        return userService.register(user);
    }

    //登入
    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session){
        String result = userService.login(user.getUsername(), user.getPassword());
        if(result.equals("登入成功")){
            session.setAttribute("loginUser", user.getUsername());
        }
        return result;
    }

    //登出
    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "已登出";
    }

    //查看目前登入者
    @GetMapping("/me")
    public Object getLoginUser(HttpSession session){
        return session.getAttribute("loginUser");
    }

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
//        if(id == 1){
//            return new User(1L, "James", "jamesHuang@yahoo.com");
//        }else if (id == 2){
//            return new User(2L, "Peter", "peterLee@gmail.com");
//        }else{
//            return new User(0L, "無此使用者", "none");
//        }
    }

    @GetMapping("/search")
    public String searchUser(@RequestParam String username) {
        return "搜尋的名字是:" + username;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/update/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUserById(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public  void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @GetMapping("/username/{username}")
    public User findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }

}
