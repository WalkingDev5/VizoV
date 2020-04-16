package org.academiadecodigo.bootcamp40.persistence.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends AbstractModel {

    private String userName;
    private String email;
    private LevelType level;

    @ManyToMany(

            fetch = FetchType.EAGER
    )

    private List<Challenge> challenges = new ArrayList<Challenge>();

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public LevelType getLevel() {
        return level;
    }

    public void setLevel(LevelType level) {
        this.level = level;
    }

    public void addChallenge(Challenge challenge){
        challenges.add(challenge);
        challenge.addUser(this);
    }
}
