package com.stage.chu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
  
  //fait atention l'url dans GetMapping ne signifie pas le nom du fichier html
  // lorsque l'utilisateur visite localhost:8080/loginForm , Spring va appeler cette méthode pour traiter la requête Get effectue a l'url .

  @GetMapping("/loginForm")
  public String getForm(){
    return "loginForm";
  }

 

}
