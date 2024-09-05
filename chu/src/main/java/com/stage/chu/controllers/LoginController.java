package com.stage.chu.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.stage.chu.entities.Utilisateur;
import com.stage.chu.repo.UserRepository;



@Controller
public class LoginController {
  
  //fait atention l'url dans GetMapping ne signifie pas le nom du fichier html
  // lorsque l'utilisateur visite localhost:8080/loginForm , Spring va appeler cette méthode pour traiter la requête Get effectue a l'url .

  // @GetMapping("/loginForm")
  // public String getForm(){
  //   return "loginForm";
  // }
  @Autowired
    private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  // Affiche le formulaire d'inscription
  @GetMapping("/loginForm")
  public String showSignUpForm(Model model) {
      model.addAttribute("user", new Utilisateur());
      return "loginForm";
  }

  // Enregistre l'utilisateur après la soumission du formulaire
  @PostMapping("/signup")
  public String signUp(@RequestParam String nom, @RequestParam String prenom, @RequestParam String email,
                        @RequestParam String password) {
      // Créer un nouvel utilisateur
      Utilisateur newUser = new Utilisateur();
      newUser.setNom(nom);
      newUser.setPrenom(prenom);
      newUser.setEmail(email);
      newUser.setPassword(passwordEncoder.encode(password));  // Crypter le mot de passe

      // Sauvegarder l'utilisateur dans la base de données
      userRepository.save(newUser);

      return "redirect:/loginForm";  // Redirection après l'inscription
  }

 

}
