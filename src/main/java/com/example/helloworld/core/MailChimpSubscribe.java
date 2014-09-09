package com.example.helloworld.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by protocol on 8/27/14.
 */
public class MailChimpSubscribe {

    @NotNull
    /*The API Key for the Mandrill account*/
    private String apikey;


    private String id;

    @NotNull
    private MailChimpEmail email;

    private String emailType;

    private boolean double_optin;

    private boolean update_existing;

    private boolean replace_interests;

    private boolean send_welcome;

    /*Getters to enable JSON serialization*/

    @JsonProperty
    public String getApikey() {
        return apikey;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    //set the email for to add

    public void setEmail(MailChimpEmail email){
        this.email = email;
    }

    @JsonProperty
    public MailChimpEmail getEmail() {
        return email;
    }

    @JsonProperty
    public String getEmailType() {
        return emailType;
    }

    @JsonProperty
    public boolean isDouble_optin() {
        return double_optin;
    }

    @JsonProperty
    public boolean isUpdate_existing() {
        return update_existing;
    }

    @JsonProperty
    public boolean isReplace_interests() {
        return replace_interests;
    }

    @JsonProperty
    public boolean isSend_welcome() {
        return send_welcome;
    }

    /*public constructor*/
    public MailChimpSubscribe( ){

        //this is the API Key for the mandrill account
        this.apikey = "enter your mail chimp api key here";

        //this is the id for the list we are adding the user to, in this case 'Beta'
        this.id = "enter your mail chimp list id here";

    }


    public class MailChimpEmail {

        private String email;

        private String euid;

        private String leid;

        /*Getters to enable JSON serialization*/

        @JsonProperty
        public String getEmail() {
            return email;
        }

        @JsonProperty
        public String getEuid() {
            return euid;
        }

        @JsonProperty
        public String getLeid() {
            return leid;
        }

        /*public constructor*/
        public MailChimpEmail(String email){

            this.email = email;
        }


    }
}
