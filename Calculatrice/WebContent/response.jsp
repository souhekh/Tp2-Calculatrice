<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response</title>
</head>
<body>
    <h1>R�sultat</h1>
    
    <% String operande1 = request.getParameter("operand1");
       String operande2 = request.getParameter("operand2");
       String operation = request.getParameter("operation");
    %>
  
    <% if (operande1 == null || operande2 == null || operation == null) { %>
        <p>Erreur : les valeurs des op�randes et/ou de l'op�ration n'ont pas �t� correctement r�cup�r�es.</p>
    <% } else { %>
       
        <% int op1 = Integer.parseInt(operande1);
           int op2 = Integer.parseInt(operande2);
        %>
      
        <% int resultat = 0;
           if (operation.equals("addition")) {
               resultat = op1 + op2;
           } else if (operation.equals("soustraction")) {
               resultat = op1 - op2;
           } else if (operation.equals("multiplication")) {
               resultat = op1 * op2;
           } else if (operation.equals("division")) {
               if (op2 == 0) {
                   out.println("Erreur : division par z�ro.");
               } else {
                   resultat = op1 / op2;
               }
           } else {
               out.println("Erreur : op�ration non valide.");
           }
        %>
      
        <p>R�sultat : <%= resultat %></p>
    <% } %>
 
</body>
</html>