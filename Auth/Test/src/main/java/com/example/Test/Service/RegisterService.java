package com.example.Test.Service;

import com.example.Test.Dto.UserDto;
import com.example.Test.Entity.User;

public interface RegisterService {
    User registration(UserDto userdto);
}
