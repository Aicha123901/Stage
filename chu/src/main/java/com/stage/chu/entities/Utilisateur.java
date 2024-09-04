package com.stage.chu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Utilisateur {

  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nom est requis")
    private String nom;

    @NotBlank(message = "Prénom est requis")
    private String prenom;

    @Email(message = "Adresse e-mail invalide")
    @NotBlank(message = "L'Adresse e-mail est obligatoir")
    private String email;
    
    @NotBlank(message = "Mot de passe est requis")
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
    private String password;

    public Long getId() {
      return this.id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getNom() {
      return this.nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }

    public String getPrenom() {
      return this.prenom;
    }

    public void setPrenom(String prenom) {
      this.prenom = prenom;
    }

    public String getEmail() {
      return this.email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getPassword() {
      return this.password;
    }

    public void setPassword(String password) {
      this.password = password;
    }


  
}
