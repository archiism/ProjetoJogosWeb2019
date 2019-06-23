<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type/javascript>
function usuarios(){
document.forms[0].action="ListarUsuarios";
document.forms[0].submit();
}
</script>
<meta charset="UTF-8">
<title>Jogando</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel='stylesheet' href='./Contents/css/comentario.css'>  
  <link rel="stylesheet" type="text/css" href="./Contents/css/style.css">
  <link rel="stylesheet" type="text/css" href="./Contents/css/post.css">
  <script src="http://code.jquery.com/jquery-latest.js"></script>
 
  <c:if test="${sessionScope.logado != 'verdade'}">
	<c:redirect url="/index.jsp">/</c:redirect>
</c:if>
</head>
<body >

<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
	%>
	
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><b>Indie Retr0 GameFlix</b></a>
    </div>
    <ul class="nav navbar-nav navbar-right">
       <button class="btn btn-primary navbar-btn glyphicon glyphicon-home" onclick="window.location.href='./menu.jsp'"> Inicio</button>
       
     
       <c:if test="${sessionScope.usuarioLogado.getNivelAcesso()!=0 }">
        <button class="btn btn-primary navbar-btn " onclick="usuarios()">Lista de usuarios</button>
       <!--   <button class="btn btn-primary navbar-btn " data-toggle="modal" data-target="#noticia">Inserir Noticia </button>
      <button class="btn btn-primary navbar-btn " data-toggle="modal" data-target="#myModal">Cadastrar Jogo </button> -->
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
  <div class="col-sm-9" style="background-color: lightgray" height:100%>

    <div class="form-group">
  <!-- <label calss="text-danger" for="comment"><h2>Noticias</h2></label>
    <textarea class="form-control" rows="10" id="comment" >${noti.assunto} ( ${noti.data } ) 
  
  
  ${ noti.texto}</textarea> -->
</div>

    <div class="text-center">
      <H1 style="text-align: center;">${nomeJogo}</H1>
    </div>
<!--------------------------->

			<div id="JogoView">
                <style type="text/css">
                    .modal{display:none;position:fixed;z-index:1;padding-top:100px;left:0;top:0;width:100%;height:100%;overflow:auto;background-color:#000;background-color:rgba(0,0,0,.4)}.modal-content{position:relative;background-color:#fefefe;margin:auto;padding:2px 16px;border:1px solid #888;width:500px;box-shadow:0 4px 8px 0 rgba(0,0,0,.2),0 6px 20px 0 rgba(0,0,0,.19);-webkit-animation-name:animatetop;-webkit-animation-duration:.4s;animation-name:animatetop;animation-duration:.4s}@keyframes animatetop{from{top:-300px;opacity:0}to{top:0;opacity:1}}.close{color:#000;float:right;font-size:28px;font-weight:700}.close:focus,.close:hover{color:#000;text-decoration:none;cursor:pointer}
                </style>

                   <div  style="margin:0; padding:0;">

                        <div>
                            <canvas style="margin: 0 auto; display: block;" id="canvas" oncontextmenu="event.preventDefault()" onmousedown="window.focus()"></canvas>
                        </div>
                    	<div id="add-modal" class="modal">
                            <div class="modal-content">
                                <span class="close">&times</span>
                                <p>Select a file to add to the computer</p>
                                <p><input type="file" id="upload-input"></input></p>
                            </div>
                        </div>
                        
                    
                        
                     
                   
                    
                    <h2 class='comentarios'>Comentários</h2>
                    <!------------------------------------------------------>
                   
                 <div class="corpo">
                    <div class="caixa">
  						<span><strong>Nome</strong></span>
 						 <p>Hello. How are you today?</p>
 						 <span class="time-right">11:00</span>
					</div>
                    
                    <div class="caixa escuro">
 						 <span class="direita"><strong>Nome</strong></span>
 						 <p>Hey! I'm fine. Thanks for asking!</p>
  						 <span class="time-right">11:01</span>
					</div>
                 </div>
                    
                    
                    <!-- ---------------------------------------------------->
                    
                    <div class="form-group shadow-textarea" id='comentarioDiv'>
 						 <label for="exampleFormControlTextarea6">Novo Comentario</label>
 						 <textarea class="form-control z-depth-1" id="exampleFormControlTextarea6" rows="3" placeholder="Escreva Aqui">2121</textarea>
 						
 						 		<button class="btn btn-primary navbar-btn " >Enviar</button>
 						 		<button class="btn btn-danger navbar-btn" id='escrever'> Escrever</button>
 						
					</div>
                   
                      <script type="text/javascript">
                        var Module = {canvas: document.getElementById('canvas')};
                        var jogo = document.querySelector('#jogo');
                        var text = document.querySelector('#comentarioDiv');
                        var jogo2 = document.querySelector('#jogo2');
                        console.log(text);
                        text.addEventListener('click',function(){
                        	  Module= {canvas:document.getElementById('') };
                        	})
                    	</script>

                   <script id='jogo' src='${game}'></script>
                    
<!--------------------------->
   
   

    

<form method="Post" action="/Projeto/CadastrarJogo">
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
    <input type="text" class="form-control" id="nome" name="txtNome">
  </div>
  <div class="form-group">
    <label for="pwd">Dificuldade:</label>
    <select class="form-control" id="pwd" name="txtDificuldade">
      <option value="1">Facil</option>
      <option value="2">Médio</option>
      <option value="3">Dificil</option>
    </select>
  </div>
  
  <div class="form-group">
    <label for="genero">Gênero:</label>
    <select class="form-control" id="genero" name="txtGenero">
      <option value="1">Ação</option>
      <option value="2">Aventura</option>
      <option value="3">Corrida</option>
    </select>
  </div>
  
  <div class="form-group">
    <label for="caminho">Selecionar Jogo:</label>
    <input type="file" class="form-control" id="caminho" name="txtCaminho">
  </div>
  
   <div class="form-group">
    <label for="imagem">Selecionar Imagem:</label>
    <input type="file" class="form-control" id="imagem" name="txtCaminhoImagem">
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