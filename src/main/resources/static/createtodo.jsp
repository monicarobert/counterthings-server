<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todos</title>
    <style>
        body {background-color: lightblue;}
        h2 {
            text-align: center;
        }
        div.centre{
            position:absolute;
            left: 50%;
            top: 50%;
            width: 200px;
            height: 200px;
            margin-left: -100px; /* Cette valeur doit être la moitié négative de la valeur du width */
            margin-top: -100px; /* Cette valeur doit être la moitié négative de la valeur du height */
        }

    .submitButton {
    background-color: #009900;
    color: #0F4987;
    background: #11A3EA;
    border: 1px solid #cccccc;
    text-align: center;
    width: auto;
    padding: 2px 3px 2px 3px;
    }
    .inputbox {
        background-color:#FFFFFF;
        color: #333333;
        width:150px;
        border-width:1px;
        border-style:solid;
        border-color:#808080;

    }

    </style>

</head>
<body>
<h2>Enter a to do:</h2>
<div class="centre" align="center">
<form method="POST" action="./todo/web" >
      <div>
          <label>Name</label>
          <input type="text" name="todo" />
      </div>

      <div>
          <input type="submit" value="Enter" />
      </div>
  </form> 
  </div>

</body>

</html>