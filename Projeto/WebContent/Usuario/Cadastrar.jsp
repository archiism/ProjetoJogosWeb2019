<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/Projeto/AtualizarUsuario" method="post">
	Nome: <input name="txtNome" type="text"><br>
	Senha: <input name="txtSenha" type="password"><br>
	Confirmar Senha: <input name="txtConfirmarSenha" type="password"><br>
	Apelido: <input name="txtApelido" type="text"><br>
	Telefone: <input name="txtTelefone" type="text"><br>
	email: <input name="txtEmail" type="text"><br>
	cpf: <input name="txtCpf" type="text"><br>
	<input type="date" name="calendar">
	
	</form>
</body>
</html>