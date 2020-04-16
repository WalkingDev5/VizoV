package org.academiadecodigo.bootcamp40.controllers.rest;

import org.academiadecodigo.bootcamp40.converters.ChallengeDtoToChallenge;
import org.academiadecodigo.bootcamp40.converters.ChallengeToChallengeDto;
import org.academiadecodigo.bootcamp40.persistence.model.Challenge;
import org.academiadecodigo.bootcamp40.services.ChallengeServiceImp;
import org.academiadecodigo.bootcamp40.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/challenge")
public class RestChallengesController {

    private UserServiceImp userServiceImp;
    private ChallengeServiceImp challengeServiceImp;
    private ChallengeToChallengeDto challengeToChallengeDto;
    private ChallengeDtoToChallenge challengeDtoToChallenge;

    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Autowired
    public void setChallengeServiceImp(ChallengeServiceImp challengeServiceImp) {
        this.challengeServiceImp = challengeServiceImp;
    }

    @Autowired
    public void setChallengeDtoToChallenge(ChallengeDtoToChallenge challengeDtoToChallenge) {
        this.challengeDtoToChallenge = challengeDtoToChallenge;
    }

    @Autowired
    public void setChallengeToChallengeDto(ChallengeToChallengeDto challengeToChallengeDto) {
        this.challengeToChallengeDto = challengeToChallengeDto;
    }

    @GetMapping("/{id}")
    public String showChallenge(@PathVariable Integer id, Model model) {

        Challenge challenge = userServiceImp.getNewChallenge(userServiceImp.getById(id));
        model.addAttribute("challenge", challengeToChallengeDto.convert(challenge));
        return "description";
    }
}
