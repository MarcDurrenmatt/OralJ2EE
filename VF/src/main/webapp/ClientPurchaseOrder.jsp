<!DOCTYPE html>

<html>
    
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projet</title>
        
        <script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/0.8.1/mustache.min.js"></script>
        
                    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
                <style>
                    td{
                        padding: 10px;
                    }
                    a{
                        width:50%;
                        border: 1px solid black;
                        border-radius:5px;
                        background-color: lightblue;
                    }
                </style>
  
        
    </head>
    
    <body>
        
        <h1>Voici vos commandes, ${sessionScope.name}</h1>
        <h2>-</h2>
        <h3>-</h3>
        <div id="affPO"></div>
    <center><a href='ajoutProduit.jsp'>Passer une nouvelle commande</a></center>
        <div id="affP"></div>
        

     
            
  

    </body>
    
</html>

