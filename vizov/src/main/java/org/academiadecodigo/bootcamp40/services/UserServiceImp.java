package org.academiadecodigo.bootcamp40.services;

import org.academiadecodigo.bootcamp40.persistence.dao.ChallengeDao;
import org.academiadecodigo.bootcamp40.persistence.dao.UserDao;
import org.academiadecodigo.bootcamp40.persistence.model.Challenge;
import org.academiadecodigo.bootcamp40.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp {

    private UserDao userDao;
    private ChallengeServiceImp challengeServiceImp;
    private ChallengeDao challengeDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setChallengeServiceImp(ChallengeServiceImp challengeServiceImp) {
        this.challengeServiceImp = challengeServiceImp;
    }

    public User getById(Integer id){

        return userDao.findById(id);

    }

    public Challenge getNewChallenge(User user){

        int challengeId = challengeServiceImp.getRandomChallenge(user.getLevel());
        return challengeServiceImp.getById(challengeId);
    }

    public void completedChallenge(Integer id, Challenge challenge) {

        User user = userDao.findById(id);
        user.addChallenge(challenge);
    }

    public List<Challenge> getMyChallenges(Integer id) {

        User user = userDao.findById(id);
        return user.getChallenges();
    }

}
