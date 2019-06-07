<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Demo</title>
    <style>
      html, body {
        padding: 0;
        margin: 0;
      }
      .app {
        width: 80%;
        min-height: 100vh;
        margin: auto;

        background: #ddd;
        padding: 20px;
      }
      h1 {
        color: cornflowerblue;
        font-size: 45px;
        font-family: "Droid Sans Mono";
        text-align: center;
      }
      img {
        margin: auto;
        display: block;
      }
      footer {
        margin-top: 30px;
      }
      label {
        display: block;
      }

      form  div {
        margin-bottom: 15px;
      }

    </style>
  </head>
  <body>
    <section class="app">
      <h1>Counterthings</h1>     

        <form method="POST" action="./utilisateur" >
          <div>
            <label>Username</label>
            <input type="text" name="username" />
          </div>
          <div>
            <label>Password</label>
            <input type="password" name="password" />
          </div>
          <div>
            <input type="submit" value="Login" />
          </div>
        </form>