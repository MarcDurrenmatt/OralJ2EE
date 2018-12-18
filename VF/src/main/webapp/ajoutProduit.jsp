<%-- 
    Document   : ajoutProduit
    Created on : 18 déc. 2018, 03:47:31
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                        <style>
                    h1{
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
    <center><h1>Ajout Panier</h1></center>
                            <form action="AjoutProduit">
                            <center> <label> Id Produit : <input name="Product_ID" class=form-control" required="required" value=""></label> <br></center>
                            <center><label> Numero produit : <input name="id" class=form-control" required="required" value=""></label></center>
                            <center><a href='AjoutProduit' > Ajout </a></center>

        </form>  
    </body>
</html>
