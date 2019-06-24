<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Usuários</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="./Contents/css/style.css">
</head>
<body>
<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
	%>
	<c:if test="${sessionScope.logado != 'verdade'}">
	<c:redirect url="/index.jsp">/</c:redirect>
</c:if>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="./menu.jsp"><b>Indie Retr0 GameFlix</b></a>
    </div>
    <ul class="nav navbar-nav navbar-right">
       <button class="btn btn-primary navbar-btn glyphicon glyphicon-home" onclick="window.location.href='/Projeto/Menu'"> Inicio</button>
       
     
       <c:if test="${sessionScope.usuarioLogado.getNivelAcesso()!=0 }">
        <button class="btn btn-primary navbar-btn ">Lista de usuarios</button>
        <button class="btn btn-primary navbar-btn " data-toggle="modal" data-target="#noticia">Inserir Noticia </button>
      <button class="btn btn-primary navbar-btn " data-toggle="modal" data-target="#myModal">Cadastrar Jogo </button>
       </c:if>
      
    
      
      
    <button class="btn btn-danger navbar-btn glyphicon glyphicon-user" onclick="window.location.href='./Logoff.jsp'"> Sair</button>
    
    </ul>
  </div>
</nav>

	<div class="container-fluid">
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
            <li><a href="/Projeto/Acao">Ação</a></li>
            <li><a href="/Projeto/Aventura">Aventura</a></li>
            <li><a href="/Projeto/Corrida">Corrida</a></li>
        
            <!--<li><a href="#">Reviews <span class="badge">1,118</span></a></li> -->
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
  </div>
  <div class="col-sm-9" style="background-color: lightgray; height: 100%">

    <div class="form-group">
  <label for="comment"><h2>Noticias</h2></label>
  <textarea class="form-control" rows="10" id="comment" readonly>${noti.assunto} ( ${noti.data } )
  
  
  ${ noti.texto}</textarea>
</div>

    <div class="text-center">
      <H1 style="text-align: center;">LISTA DE USUARIOS</H1>
    </div>

    
<!--------------------------->
   <table class="table">
  <thead class="table table-striped table-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome</th>
      <th scope="col">Login</th>
      <th scope="col">Email</th>
      <th scope="col">CPF</th>
      <th scope="col">Nascimento</th>
      <th scope="col">Nivel de Acesso</th>
      <th scope="col">Editar usuário</th>
    </tr>
  </thead>
  
  <tbody>
  <c:forEach var="listas" items="${listaUsuario}">
  <tr>
      <th scope="row"><input type="text" name="id" size="2" readonly value="${listas.idUsuario }"></th>
      <td>${listas.nome}</td>
      <td>${listas.login }</td>
      <td>${listas.email}</td>
      <td>${listas.cpf }</td>
      <td>${listas.dataNascimento }</td>
      <td>${listas.nivelAcesso }</td>
      <td>
 			<a href="/Projeto/AtualizarUsuario?id=${listas.idUsuario}&nivel=${listas.nivelAcesso}" class="btn btn-primary">Troca Nivel Acesso</a>     
      </td>
   </tr>
  
  </c:forEach>
      
    </tbody>
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
    <label for="genero">Gênero:</label>
    <select class="form-control" id="genero">
      <option value="1">Ação</option>
      <option value="2">Aventura</option>
      <option value="3">Corrida</option>
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

<!-- Outro Modal -->
<form method="Post" action="/Projeto/CadNoticia">
<!-- The Modal -->
<div class="modal fade" id="noticia">
  <div class="modal-dialog modal-md">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Inserir Noticia</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->

<div class="form-group">
    <label for="nome">Titulo:</label>
    <input type="text" class="form-control" id="nome" name="txtTitulo">
  </div>
  <div class="form-group">
    <label for="pwd">Assunto:</label>
    <textarea class="form-control" rows="10" name="txtAssunto">
  </textarea>
  

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
<!--  fim -->
  </div>
</div>
</div>
</body>
</html>