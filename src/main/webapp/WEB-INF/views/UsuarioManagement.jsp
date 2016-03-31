<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS $http Example</title>  
    <style>
        .nome.ng-valid {
          background-color: lightgreen;
      }

        .nome.ng-dirty.ng-invalid-required {
          background-color: red;
      }

        .nome.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="UsuarioController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Cadastro de Usuário</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.usuario.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Nome</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.usuario.nome" name="nome"
                                         class="nome form-control input-sm" placeholder="Informe seu nome"/>
                                  <!-- required ng-minlength="3"-->
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.nome.$error.required">Campo obrigatório</span>
                                      <span ng-show="myForm.nome.$error.minlength">Deverá ter no mínimo 3 caracteres</span>
                                      <span ng-show="myForm.nome.$invalid">Valor inválido</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Login</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.usuario.login" class="form-control input-sm"
                                         placeholder="Informe seu endereço"/>
                                  <span ng-show="myForm.login.$error.required">Campo obrigatório</span>
                                  <span ng-show="myForm.login.$error.minlength">Deverá ter no mínimo 3 caracteres</span>
                                  <span ng-show="myForm.login.$invalid">Valor inválido</span>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Email</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="ctrl.usuario.email" name="email" class="email form-control input-sm" placeholder="Informe seu Email" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">Campo obrigatório</span>
                                      <span ng-show="myForm.email.$invalid">Valor inválido</span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.usuario.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm">Limpa Dados</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Lista de Usuários</span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>Cod.</th>
                              <th>Nome</th>
                              <th>Login</th>
                              <th>Email</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.usuarios">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.nome"></span></td>
                              <td><span ng-bind="u.login"></span></td>
                              <td><span ng-bind="u.email"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/usuario_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/usuario_controller.js' />"></script>
  </body>
</html>