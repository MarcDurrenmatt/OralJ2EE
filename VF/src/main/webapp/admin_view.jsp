

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script>
              google.charts.load('current', {'packages':['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {

              var data = google.visualization.arrayToDataTable([
                ['Task', 'Hours per Day'],
                ['Work',     11],
                ['Eat',      2],
                ['Commute',  2],
                ['Watch TV', 2],
                ['Sleep',    7]
              ]);

              var options = {
                title: 'My Daily Activities'
              };

              var chart = new google.visualization.PieChart(document.getElementById('piechart'));

              chart.draw(data, options);
            }
        </script>       
        <script type="text/javascript">
          google.charts.load('current', {'packages':['corechart']});
          google.charts.setOnLoadCallback(drawChart);

          function drawChart() {
            var data = google.visualization.arrayToDataTable([
              ['Year', 'Sales', 'Expenses'],
              ['2004',  1000,      400],
              ['2005',  1170,      460],
              ['2006',  660,       1120],
              ['2007',  1030,      540]
            ]);

            var options = {
              title: 'Company Performance',
              curveType: 'function',
              legend: { position: 'bottom' }
            };

            var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

            chart.draw(data, options);
          }
        </script>
        
        <script>
            google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawAnnotations);

function drawAnnotations() {
      var data = new google.visualization.DataTable();
      data.addColumn('timeofday', 'Time of Day');
      data.addColumn('number', 'Motivation Level');
      data.addColumn({type: 'string', role: 'annotation'});
      data.addColumn('number', 'Energy Level');
      data.addColumn({type: 'string', role: 'annotation'});

      data.addRows([
        [{v: [8, 0, 0], f: '8 am'},   1, '1',  .25, '.2'],
        [{v: [9, 0, 0], f: '9 am'},   2, '2',   .5, '.5'],
        [{v: [10, 0, 0], f:'10 am'},  3, '3',    1,  '1'],
        [{v: [11, 0, 0], f: '11 am'}, 4, '4', 2.25,  '2'],
        [{v: [12, 0, 0], f: '12 pm'}, 5, '5', 2.25,  '2'],
        [{v: [13, 0, 0], f: '1 pm'},  6, '6',    3,  '3'],
        [{v: [14, 0, 0], f: '2 pm'},  7, '7', 3.25,  '3'],
        [{v: [15, 0, 0], f: '3 pm'},  8, '8',    5,  '5'],
        [{v: [16, 0, 0], f: '4 pm'},  9, '9',  6.5,  '6'],
        [{v: [17, 0, 0], f: '5 pm'}, 10, '10',  10, '10'],
      ]);

      var options = {
        title: 'Motivation and Energy Level Throughout the Day',
        annotations: {
          alwaysOutside: true,
          textStyle: {
            fontSize: 14,
            color: '#000',
            auraColor: 'none'
          }
        },
        hAxis: {
          title: 'Time of Day',
          format: 'h:mm a',
          viewWindow: {
            min: [7, 30, 0],
            max: [17, 30, 0]
          }
        },
        vAxis: {
          title: 'Rating (scale of 1-10)'
        }
      };

      var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }
        </script>
        
    
    </head>
    <style>

        .container{
            
        padding: 5px;
        width: 700px;
        height: auto;

        margin : 50px auto auto;
        }
        
        form button{
        width:100%;
        }

        #titre{
            text-align: center;
            margin-top: 60px;
        }       
        
        .header {  
            position:fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 50px;		
            background: black;   
            z-index: 4;
          }
          
       .name {			 
            font-size : 30px;
            font-style: italic;
            font-weight: bold;
        }
        .cont{
            padding: 5px;
            width: 900px;
            height: auto;

            margin : 50px auto auto;
        }
        tr{
            text-align: center;
        }
        #result{
            width: 30px;
        }
    </style>
    <body>
        <header class="header">	
            <div class="name">	
                <a style="text-decoration:none; color:white;">Nom Site</a>					
            </div>				
	</header>
        <!--<h1 id="titre">Hello World!</h1>-->
        
        <!--<div id="piechart" style="width: 400px; height: 200px;"></div>-->
        <table class="table">
            <thead>
              <tr>
                <th scope="col">g1</th>
                <th scope="col">g2</th>
                <th scope="col">g3</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td scope="col">g1</td>
                <td scope="col">g2</td>
                <td scope="col">g3</td>
              </tr>
              <tr>
                   
                  <td><div id="piechart" style="width: 400px; height: 200px;"></div></td>
                  <td><div id="curve_chart" style="width: 400px; height: 200px"></div></td>
                  <td><div id="chart_div" style="width: 400px; height: 200px"></div></td>
              </tr>
              
            </tbody>
          </table>
        
       
   
    </body>
    
</html>
