package com.sip.gestibank.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Agent {

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

    @SerializedName("matricule")
    @Expose
    private String matricule;

    public Agent() {
    }

    public Agent(String name, String prenom, String email, String tel, String matricule)
    {
        this.name = name;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.role = "AGENT";
        this.matricule = matricule;
        this.password = "123";

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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    @Override

    public String toString() {
        return "Agent{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", password='" + matricule + '\'' +
                '}';
    }

}
