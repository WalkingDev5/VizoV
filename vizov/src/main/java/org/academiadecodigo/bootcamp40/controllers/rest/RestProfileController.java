package org.academiadecodigo.bootcamp40.controllers.rest;

import org.academiadecodigo.bootcamp40.converters.ChallengeToChallengeDto;
import org.academiadecodigo.bootcamp40.converters.UserDtoToUser;
import org.academiadecodigo.bootcamp40.converters.UserToUserDto;
import org.academiadecodigo.bootcamp40.persistence.model.User;
import org.academiadecodigo.bootcamp40.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/profile")
public class RestProfileController {

    private UserServiceImp userServiceImp;
    private UserDtoToUser userDtoToUser;
    private UserToUserDto userToUserDto;
    private ChallengeToChallengeDto challengeToChallengeDto;

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

    @Autowired
    public void setChallengeToChallengeDto(ChallengeToChallengeDto challengeToChallengeDto) {
        this.challengeToChallengeDto = challengeToChallengeDto;
    }

    @GetMapping("/{id}")
    public String showProfile(@PathVariable Integer id, Model model) {

        User user = userServiceImp.getById(id);

        model.addAttribute("user", userToUserDto.convert(user));
        model.addAttribute("challenges", challengeToChallengeDto.convert(userServiceImp.getMyChallenges(id)));

        return "details";
    }

}
