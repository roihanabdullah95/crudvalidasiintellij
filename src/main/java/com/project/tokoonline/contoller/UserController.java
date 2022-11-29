package com.project.tokoonline.contoller;


import com.project.tokoonline.model.User;
import com.project.tokoonline.response.ResponHelper;
import com.project.tokoonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public Object getAllUser() {
        return ResponHelper.ok(userService.getAllUser()) ;
    }

    @GetMapping("/{id}")
    public Object getUser(@PathVariable("id") Long id) {
//        sebelum menggunakan responUserHandler menampilkan data seperti dibawah ini
//        return userService.getUser(id);
//        menggunakan reponUserHandler
        return ResponHelper.ok(userService.getUser(id));
    }

    @PostMapping
    public Object addUser(@RequestBody User user) {
        return ResponHelper.ok(userService.addUser(user));
    }

    @PutMapping("/{id}")
    public Object editUserById(@PathVariable("id") Long id, @RequestBody User user) {
        return ResponHelper.ok(userService.editUser(id, user.getUsername(), user.getEmail(), user.getAge(), user.getAddress(), user.getHp()));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }
}
