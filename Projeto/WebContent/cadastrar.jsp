<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
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
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Indie Retr0 GameFlix</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      
    
    </ul>
  </div>
</nav>

	<div class="container">
<div class="row">
  <div class="col-sm-2">
    
  </div>
  <div class="col-sm-8" style="background-color: lightgray; height: 100%">

    
  
    <div class="text-center">
      <H1 style="text-align: center;">Cadastrar Usuario</H1>
    </div>

    <!-- -->

<form method="post" action="/Projeto/Cadastrar">
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="validationDefault01">Nome</label>
      <input type="text" class="form-control" id="validationDefault01" placeholder="First name" name="txtNome" required>
    </div>

    <div class="col-md-3 mb-3">
      <label for="validationDefault02">Cpf</label>
      <input type="text" class="form-control" id="validationDefault02" placeholder="Cpf" name="txtCpf" required>
    </div>

    <div class="col-md-3 mb-3">
      <label for="validationDefaultUsername">Data de Nascimento</label>
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"></span>
        </div>
        <input type="date" class="form-control" id="validationDefaultUsername" aria-describedby="inputGroupPrepend2" name="txtData" required>
      </div>
    </div>

  </div>

  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationDefault03">Login</label>
      <input type="text" class="form-control" id="validationDefault03" placeholder="Login" name="txtLogin" required>
    </div>

    <div class="col-md-4 mb-3">
      <label for="validationDefault04">Senha</label>
      <input type="password" class="form-control" id="validationDefault04" placeholder="Senha" name="txtSenha" required>
    </div>

    <div class="col-md-4 mb-3">
      <label for="validationDefault04">Email</label>
      <input type="email" class="form-control" id="validationDefault04" placeholder="Email" name="txtEmail" required>
    </div>
    
  </div>
  <hr/>
  <div class="row">
    <div class="col-md-12">
      <br><button class="btn btn-primary" type="submit">Confirmar</button><br>
    </div>
  </div>
  
</form>

    <!--  -->

    </div>
  </div>
</div>
</form>

  </div>
</div>
</div>
</body>
</html>