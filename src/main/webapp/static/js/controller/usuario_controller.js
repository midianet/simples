'use strict';

App.controller('UsuarioController', ['$scope', 'UsuarioService', function($scope, UsuarioService) {
    var self = this;
    self.usuario = {id: null, nome: '', login: '', senha: '', email: '', ativo: true};
    self.usuarios=[];

    self.list = function(){
        UsuarioService.list().then(
            function(d) {
      		    self.usuarios = d;
            },
            function(err){
                console.error('Error ao listar Usuarios');
            }
        );
    };
           
    self.create = function(usuario){
        UsuarioService.create(usuario).then(
            self.list,
            function(err){
			    console.error('Error ao criar Usuario.');
            }
        );
    };

    self.update = function(usuario, id){
        UsuarioService.update(usuario, id).then(
            self.list,
			function(err){
			    console.error('Erro ao atualizarUsuario.');
            }
        );
    };

    self.delete = function(id){
        UsuarioService.delete(id).then(
            self.list,
			function(err){
			    console.error('Erro ao deletar Usuario.');
            }
        );
    };

    self.list();

    self.submit = function() {
        if(self.usuario.id==null){
            console.log('Salvando novo usuario', self.usuario);
            self.create(self.usuario);
        }else{
            self.update(self.usuario, self.usuario.id);
            console.log('Usuario atualizado com o id ', self.usuario.id);
        }
        self.reset();
    };
              
    self.edit = function(id){
        console.log('Id a ser editado', id);
        for(var i = 0; i < self.usuarios.length; i++){
            if(self.usuarios[i].id == id) {
                self.usuario = angular.copy(self.usuarios[i]);
                break;
            }
        }
    };
              
    self.remove = function(id){
        console.log('Id a ser deletado', id);
        if(self.usuario.id === id) {
         self.reset();
        }
        self.delete(id);
    };

    self.reset = function(){
        self.usuario={id:null,username:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    };
    
}]);