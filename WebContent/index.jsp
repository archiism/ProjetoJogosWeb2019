<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<meta charset="utf-8">
<head>
    <link rel="stylesheet" type="text/css" href="./Contents/css/reset.css">
    <link rel='stylesheet' type="text/css" href="./Contents/css/login.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Login</title>
 
   
</head>
</head>
<body class="text-center">
      <!-- Bootstrap core CSS -->
      <link href="./Contents/bootstrap/css/bootstrap.min.css" rel="stylesheet">

      <!-- Custom styles for this template -->
      <link href="signin.css" rel="stylesheet">
    
    
        <form class="form-signin" method="Post" action="/Projeto/Login">
          <img class="mb-4" src="./Contents/imagens/user5.png" alt="" width="150" height="150">
          <h1 class="h3 mb-3 font-weight-normal">Indie Retr0 GameFlix</h1>
          <label for="inputEmail" class="sr-only">Email address</label>
          <input type="text" name="txtLogin" id="inputEmail" class="form-control" placeholder="Login" required="Preencha os dados" autofocus=""><br>
          <label for="inputPassword" class="sr-only">Password</label>
          <input type="password" name="txtSenha" id="inputPassword" class="form-control" placeholder="Senha" required=""><br>
          
          <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
          <div id="lb">
          <a href="#">Esqueci minha senha</a> 
          
        </div>
        <a href="/Projeto/cadastrar.jsp">        Cadastrar</a>
        <p class="mt-5 mb-3 text-muted">©2019-2020</p>
        </form>
      
    
</body>
