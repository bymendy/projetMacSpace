//package com.macsecurite.macsecurite.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.macsecurite.macsecurite.model.Users;
import com.macsecurite.macsecurite.model.Role;
import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
//public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * Gère les actions à effectuer après une authentification réussie.
     *
     * @param request l'objet HttpServletRequest qui contient la requête envoyée par le client au servlet
     * @param response l'objet HttpServletResponse qui contient la réponse envoyée par le servlet au client
     * @param authentication l'objet Authentication qui contient les informations d'authentification
     * @throws IOException si une exception d'entrée/sortie survient
     */
    //@Override
//public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
//  Users user = (Users) authentication.getPrincipal();

//String redirectURL;

        // Boucle sur les rôles de l'utilisateur pour déterminer l'URL de redirection appropriée
// for (Role role : user.getRoles()) {
//  switch (role.getName()) {
//    case "ADMIN":
//        redirectURL = "/dashboard";
//        break;
//      case "CLIENT":
//           redirectURL = "/client";
//          break;
//      default:
//          redirectURL = "/login";
                            //           break;
//     }
//     response.sendRedirect(redirectURL);
// //      return;  // Sort de la boucle et de la méthode après avoir trouvé le premier rôle correspondant
//  }
//  }
//}
