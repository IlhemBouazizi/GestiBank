package com.sip.gestibank.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Client extends User {

    @SerializedName("statut")
    @Expose
    private String statut;

    @SerializedName("typeCompte")
    @Expose
    private String typeCompte;

    public Client() {
    }

    public Client(String name, String prenom, String email, String tel, String typeCompte)
    {
        super(name,prenom,email,tel,"CLIENT",name + "." + prenom);
        this.statut = "ATTENTE";
        this.setPassword("123");
        this.typeCompte=typeCompte;
    }

    public String getStatus() {
        return statut;
    }

    public void setStatus(String status) {
        this.statut = status;
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
                "Nom='" + super.getName() + '\'' +
                ", Email='" + super.getEmail() + '\'' +
                ", Teléphone='" + super.getTel() + '\'' +
                ", Rôle='" + super.getRole() + '\'' +
                ", Statut='" + statut + '\'' +
                ", Type de compte='" + typeCompte + '\'' +
                '}';
    }

}
