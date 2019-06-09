<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="./Contents/css/style.css">
</head>
<body>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Indie Retr0 GameFlix</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
       <button class="btn btn-primary navbar-btn glyphicon glyphicon-home"> Inicio</button>
       
     
       <c:if test="${sessionScope.usuarioLogado.getNivelAcesso()!=0 }">
        <button class="btn btn-primary navbar-btn ">Lista de usuarios</button>
      <button class="btn btn-primary navbar-btn " data-toggle="modal" data-target="#myModal">Cadastrar Jogo </button>
       </c:if>
      
    
      
      
    <button class="btn btn-danger navbar-btn glyphicon glyphicon-user"> Sair</button>
    
    </ul>
  </div>
</nav>

	<div class="container">
<div class="row">
  <div class="col-sm-2">
    <div class="sidebar-nav">
      <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <span class="visible-xs navbar-brand">Sidebar menu</span>
        </div>
        <div class="navbar-collapse collapse sidebar-navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="#">Ação</a></li>
            <li><a href="#">Aventura</a></li>
            <li><a href="#">Corrida</a></li>
            <li><a href="#">Meus Favoritos</a></li>
            <!--<li><a href="#">Reviews <span class="badge">1,118</span></a></li> -->
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
  </div>
  <div class="col-sm-10" style="background-color: lightgray; height: 100%">

    <div class="form-group">
  <label for="comment">Noticias</label>
  <textarea class="form-control" rows="10" id="comment"></textarea>
</div>

    <div class="text-center">
      <H1 style="text-align: center;">LISTA DE JOGOS</H1>
    </div>

    <div class="card">
      <img src="./Contents/imagens/joinha.png" alt="John" style="width:100%">
      <p class="title">JOGO</p>
      <p>GENERO</p>
      <p><button class="btn btn-success">Jogar</button>
      <button class="btn btn-warning">Favorito</button></p>
    </div>
<!--------------------------->
   
    <div class="clear">
      <h1>LISTA DOS MAIS JOGADOS</h1>
    </div>

    <div class="card">
      <img src="./Contents/imagens/joinha.png" alt="John" style="width:100%">
      <p class="title">JOGO</p>
      <p>GENERO</p>
      <p><button class="btn btn-success">Jogar</button>
        <button class="btn btn-warning">Favorito</button></p>
    </div>
<!--------------------------->
    

<form method="Post" action="/Projeto/Login">
<!-- The Modal -->
<div class="modal fade" id="myModal">
  <div class="modal-dialog modal-md">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Cadastrar Jogo</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->

<div class="form-group">
    <label for="nome">Nome do Jogo:</label>
    <input type="text" class="form-control" id="nome">
  </div>
  <div class="form-group">
    <label for="pwd">Dificuldade:</label>
    <select class="form-control" id="pwd">
      <option value="1">Facil</option>
      <option value="2">Médio</option>
      <option value="3">Dificil</option>
    </select>
  </div>
  <div class="form-group">
    <label for="caminho">Selecionar Jogo:</label>
    <input type="file" class="form-control" id="caminho">
  </div>

      <!--Fim Modal body -->
      <div class="modal-body">
        
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <input type="submit" class="btn btn-primary" value="Salvar">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
      </div>

    </div>
  </div>
</div>
</form>

  </div>
</div>
</div>
</body>
</html>