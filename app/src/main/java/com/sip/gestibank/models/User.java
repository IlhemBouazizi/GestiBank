package com.sip.gestibank.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("prenom")
        @Expose
        private String prenom;

        @SerializedName("email")
        @Expose
        private String email;

        @SerializedName("tel")
        @Expose
        private String tel;

        @SerializedName("role")
        @Expose
        private String role;

        @SerializedName("password")
        @Expose
        private String password;


        public User() {
        }

        public User(String name, String prenom, String email, String tel, String role, String password)
        {
            this.name = name;
            this.prenom = prenom;
            this.email = email;
            this.tel = tel;
            this.role = role;
            this.password = "";

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        @Override

        public String toString() {
            return "Agent{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", tel='" + tel + '\'' +
                    ", role='" + role + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

    }


