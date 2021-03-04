package com.sip.gestibank.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Client {

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

    @SerializedName("status")
    @Expose
    private String statut;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("typeCompte")
    @Expose
    private String typeCompte;

    public Client() {
    }

    public Client(String name, String prenom, String email, String tel)
    {
        this.name = name;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.role = "CLIENT";
        this.statut = "ATTENTE";
        this.password = name + "." + prenom;
        this.typeCompte=typeCompte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getStatus() {
        return statut;
    }

    public void setStatus(String status) {
        this.statut = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getTypeCOmpte() {
        return typeCompte;
    }

    public void setTypeCompte(String tc) {
        this.typeCompte = tc;
    }
    @Override
    public String toString() {
        return "Client{" +
                "Nom='" + name + '\'' +
                ", Email='" + email + '\'' +
                ", Teléphone='" + tel + '\'' +
                ", Rôle='" + role + '\'' +
                ", Statut='" + statut + '\'' +
                ", Type de compte='" + typeCompte + '\'' +
                '}';
    }

}
