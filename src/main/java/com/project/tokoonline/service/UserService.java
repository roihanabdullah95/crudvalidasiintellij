package com.project.tokoonline.service;

import com.project.tokoonline.model.User;
import java.util.List;

public interface UserService {
Object getAllUser();
Object addUser(User user);
Object getUser(Long id);
Object editUser(Long id, String username, String email, int age, String address, int phone_number);
void deleteUserById(Long id);
}
