package cput.za.ac.ecommerce_clothingapp.restapi.resources;

import java.io.Serializable;

/**
 * Created by Admin on 2016-05-03.
 */
public class FAQResource implements Serializable {
    private Long id;
    private String question;
    private String answer;

    private FAQResource(){}

    public FAQResource(Builder build){
        this.id=build.id;
        this.question=build.question;
        this.answer=build.answer;
    }

    public static class Builder{
        private Long id;
        private String question;
        private String answer;

        public Builder(){}
        public Builder id(Long id){
            this.id=id;
            return this;
        }

        public Builder question(String question){
            this.question=question;
            return this;
        }

        public Builder answer(String answer){
            this.answer=answer;
            return this;
        }

        public Builder copy(FAQResource value){
            this.id=value.getId();
            this.question=value.getQuestion();
            this.answer=value.getAnswer();
            return  this;
        }

        public FAQResource build(){return new FAQResource(this);}

    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
