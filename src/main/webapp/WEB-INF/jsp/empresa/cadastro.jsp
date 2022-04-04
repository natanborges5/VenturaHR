<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>VenturaHR</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/styleCadastro.css">
</head>
<body>
    <!-- Responsive navbar-->
    <c:import url="/WEB-INF/jsp/menu.jsp"/>
    <div class="registration-form">
        <form action="/empresa/cadastro" method="post">
            <div class="form-icon">
                <span><i class="icon icon-user"></i></span>
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" id="nome" name="nome" placeholder="Nome">
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" id="endereco" name="endereco" placeholder="Endereco">
            </div>
            <div class="form-group">
                <input type="email" class="form-control item" id="email" name="email" placeholder="Email">
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" id="telefone" name="telefone"  placeholder="Telefone">
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" id="cnpj" name="cnpj"  placeholder="CNPJ">
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" id="razaoSocial" name="razaoSocial"  placeholder="Razao Social">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-block create-account">Cadastrar Empresa</button>
            </div>
        </form>
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    <script src="/js/scriptCadastro.js"></script>
</body>
</html>
