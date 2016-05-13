package cput.za.ac.ecommerce_clothingapp.domain;

import java.io.Serializable;

/**
 * Created by Admin on 2016-05-02.
 */
public class UserAccount implements Serializable{

    private Long id;
    private Long roleId;
    private String userName;
    private String password;
    private String hintQuestion;
    private String answer;
    private String description;
    private User user;

    private UserAccount() {

    }

    public UserAccount(Builder build){
        this.id=build.id;
        this.roleId=build.roleId;
        this.userName=build.userName;
        this.password=build.password;
        this.hintQuestion=build.hintQuestion;
        this.answer=build.answer;
        this.description=build.description;
        this.user=build.user;


    }

    public static class Builder{
        private Long id;
        private Long roleId;
        private String userName;
        private String password;
        private String hintQuestion;
        private String answer;
        private String description;
        private User user;



        public Builder(){

        }

        public Builder user(User user){
            this.user=user;
            return this;
        }

        public Builder id(Long id){
            this.id=id;
            return this;
        }
        public Builder roleId(Long roleId){
            this.roleId=roleId;
            return this;
        }
        public Builder userName(String userName){
            this.userName=userName;
            return this;
        }
        public Builder password(String password){
            this.password=password;
            return this;
        }
        public Builder hintQuestion(String hintQuestion){
            this.hintQuestion=hintQuestion;
            return this;
        }
        public Builder answer(String answer){
            this.answer=answer;
            return this;
        }
        public Builder description(String description){
            this.description=description;
            return  this;
        }

        public Builder copy(UserAccount account){
            this.id=account.getId();
            this.roleId=account.getRoleId();
            this.userName=account.getUserName();
            this.password=account.getPassword();
            this.answer=account.getAnswer();
            this.hintQuestion=account.getHintQuestion();
            this.description=account.getDescription();
            this.user=account.getUser();
            return this;
        }

        public UserAccount build(){return new UserAccount(this);}
    }


    public Long getId() {
        return id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getHintQuestion() {
        return hintQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public String getDescription() {
        return description;
    }
    public User getUser() {
        return user;
    }
}
