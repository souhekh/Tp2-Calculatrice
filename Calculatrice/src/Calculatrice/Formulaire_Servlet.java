package Calculatrice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Formulaire_Servlet
 */
@WebServlet("/Formulaire_Servlet")
public class Formulaire_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formulaire_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String operand1 = request.getParameter("operand1");
	        String operand2 = request.getParameter("operand2");
	        String operation = request.getParameter("operation");
	        if(operand1 == null || operand1.trim().isEmpty()) {
	            request.setAttribute("error", "Le champ opérande 1 est vide.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("erreur.html");
	            dispatcher.forward(request, response);
	            return;
	        }
	        if(operand2 == null || operand2.trim().isEmpty()) {
	            request.setAttribute("error", "Le champ opérande 2 est vide.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("ereur.html");
	            dispatcher.forward(request, response);
	            return;
	        }
	        if(operation == null || operation.trim().isEmpty()) {
	            request.setAttribute("error", "Aucune opération n'est sélectionnée.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("erreur.html");
	            dispatcher.forward(request, response);
	            return;
	        }
	        int operand1Int;
	        int operand2Int;
	        try {
	            operand1Int = Integer.parseInt(operand1);
	            operand2Int = Integer.parseInt(operand2);
	        } catch(NumberFormatException ex) {
	            request.setAttribute("error", "Les opérandes doivent être des nombres entiers.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("erreur.html");
	            dispatcher.forward(request, response);
	            return;
	        }
	        int result = 0;
	        if(operation.equals("addition")) {
	            result = operand1Int + operand2Int;
	        } else if(operation.equals("soustraction")) {
	            result = operand1Int - operand2Int;
	        } else if(operation.equals("multiplication")) {
	            result = operand1Int * operand2Int;
	        } else if(operation.equals("division")) {
	            result = operand1Int / operand2Int;
	        }
	        request.setAttribute("result", result);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("response.jsp");
	        dispatcher.forward(request, response);	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
