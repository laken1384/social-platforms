package com.backend.backend.domin;

import org.springframework.stereotype.Component;

import java.sql.Blob;

@Component
public class Users {
        private String UserID;
        private String UserName;
        private String Email;
        private String Password;
        private Blob Coverlmage;
        private String Biography;

        public String getUserID() {
            return UserID;
        }

        public void setUserID(String userID)
        {
            UserID = userID;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }

        public Blob getCoverlmage() {
            return Coverlmage;
        }

        public void setCoverlmage(Blob coverlmage) {
            Coverlmage = coverlmage;
        }

        public String getBiography() {
            return Biography;
        }

        public void setBiography(String biography) {
            Biography = biography;
        }
}
