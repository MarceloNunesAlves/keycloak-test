<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Itens</h1>
	<ul>
	<#list itens as item>
	    <li>${item}</li>
	</#list>
	</ul>
	<br>
	<a href="/">Pagina principal</a>
	<br/>
	<a href="/sair">Logout</a>
</body>
</html>