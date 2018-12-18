<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Bienvenue</title>
                <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
                <style>
                    td{
                        padding: 10px;
                    }
                    label{
                        width:50%;
                        border: 1px solid black;
                        border-radius:5px;
                        background-color: lightblue;
                    }
                </style>
        </head>
	<body>
        <center><h1><u> Bienvenue </u></h1></center>

                        <form method="POST">
                            <center> <label> Nom d'utilisateur : <input name="log" class=form-control" required="required" value=""></label> <br></center>
                            <center><label> Mot de passe : <input name="mdp" class=form-control" required="required" value=""></label></center>
            <center><input name="action" class="btn btn-success" value="Log" type="SUBMIT"></center>
           <center><input name="action" class="btn btn-succes" value="Commande" type="SUBMIT"></center>
        </form>  

        <c:if  test="${not correct}">
            <div style="color:red;"> Mot de passe ou login incorrect </div>
        </c:if>
	</body>        
</html>
