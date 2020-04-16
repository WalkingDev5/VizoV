package org.academiadecodigo.bootcamp40.controllers.rest;

import org.academiadecodigo.bootcamp40.converters.UserDtoToUser;
import org.academiadecodigo.bootcamp40.converters.UserToUserDto;
import org.academiadecodigo.bootcamp40.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/profile")
public class RestProfileController {

    private UserServiceImp userServiceImp;
    private UserDtoToUser userDtoToUser;
    private UserToUserDto userToUserDto;

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Autowired
    public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    @Autowired
    public UserDtoToUser getUserDtoToUser() {
        return userDtoToUser;
    }


}
