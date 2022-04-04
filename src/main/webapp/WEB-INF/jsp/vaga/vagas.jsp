<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css" />
  <title>Vagas</title>
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,500&amp;subset=latin-ext" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
  <link rel="stylesheet" href="/css/styleCardEmpresa.css">
</head>

<style>
  html {
    font-size: 14px;
  }

  .container {
    font-size: 14px;
    color: #666666;
    font-family: "Open Sans";
  }
</style>

<body>
  <c:import url="/WEB-INF/jsp/menu.jsp"/>
  <header class="bg-dark py-5">
      <div class="container px-5">
          <div class="row gx-5 justify-content-center">
              <div class="col-lg-6">
                  <div class="text-center my-5">
                      <c:if test="${not empty nomeEmpresa}">
                            <h1 class="display-5 fw-bolder text-white mb-2">Vagas da empresa ${nomeEmpresa} cadastradas</h1>
                      </c:if>
                      <c:if test="${empty nomeEmpresa}">
                          <h1 class="display-5 fw-bolder text-white mb-2">Vagas de Emprego Disponiveis</h1>
                      </c:if>
                      <div class="d-grid gap-3 d-sm-flex justify-content-sm-center">
                          <c:if test="${criadorEmpresa == usuarioId}">
                              <a class="btn btn-primary btn-lg px-4 me-sm-3" href="/empresa/${idEmpresa}/vaga/cadastro">Cadastre a Vaga para a sua Empresa</a>
                          </c:if>
                          <h5 class="mb-4" style="color: #FF2D00;">${mensagem}</h5>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </header>
  <div class="container">
      <c:if test="${not empty vagaLista}">
        <div class="row pt-5 m-auto">
            <c:forEach var="e" items="${vagaLista}">
              <div class="col-md-6 col-lg-4 pb-3">
                <!-- Add a style="height: XYZpx" to div.card to limit the card height and display scrollbar instead -->
                <div class="card card-custom bg-white border-white border-0" style="height: 450px">
                  <div class="card-custom-img" style="background-image: url(http://res.cloudinary.com/d3/image/upload/c_scale,q_auto:good,w_1110/trianglify-v1-cs85g_cc5d2i.jpg);"></div>
                  <div class="card-custom-avatar">
                    <img class="img-fluid" src="http://res.cloudinary.com/d3/image/upload/c_pad,g_center,h_200,q_auto:eco,w_200/bootstrap-logo_u3c8dx.jpg" alt="Avatar" />
                  </div>
                  <div class="card-body" style="overflow-y: auto">
                    <h4 class="card-title">${e.cargo}</h4>
                    <p class="card-text">Empresa: ${e.nomeEmpresa}</p>
                    <p class="card-text">Cidade: ${e.cidade}</p>
                    <p class="card-text">Salario: ${e.salario}</p>
                    <p class="card-text">Descricao: ${e.descricao}</p>
                    <p class="card-text">Forma de Contratacao: ${e.forma_contratacao}</p>
                  </div>
                  <div class="card-footer" style="background: inherit; border-color: inherit;">
                    <form action="/empresa/${idEmpresa}/vaga/${e.id}/candidato" method="post">
                        <button class="btn btn-primary" type="submit" method="post">Candidatar-se</button>
                    </form>
                    <c:if test="${e.idUsuarioCriador == usuarioId}">
                        <a href="/vaga/${e.id}/excluir" class="btn btn-outline-primary">Remover</a>
                        <a href="/empresa/${idEmpresa}/vaga/${e.id}/candidatos" class="btn btn-outline-primary">Candidatos</a>
                    </c:if>
                  </div>
                </div>
              </div>
            </c:forEach>
        </div>
      </c:if>
  </div>
</body>

</html>
