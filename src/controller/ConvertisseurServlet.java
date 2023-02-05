package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import model.Temperature;

@WebServlet("/convertisseur")
public class ConvertisseurServlet extends HttpServlet {

    /**
     * Méthode GET : on affiche le formulaire
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String maVue = "/convinput.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(maVue);
        dispatcher.forward(request,response);
    }

    /**
     * Méthode POST : on affiche la conversion
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // on devrait récuperer la valeur saisie par l'utilisateur
        String valCelsius = request.getParameter("celsius");

        if (valCelsius.isEmpty()) {
            // pas de valeur : il faudrait afficher un message d'erreur...
            valCelsius = "20";
        }

        // action : on applique le convertisseur
        // on suppose que valCelsius représente bien un nombre
        Temperature temp = new Temperature(Double.valueOf(valCelsius));
        // on enregistre l'objet dans la requête
        request.setAttribute("temperature", temp);

        // on passe la main à la vue
        String maVue = "/convoutput.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(maVue);
        dispatcher.forward(request,response);
    }

}
