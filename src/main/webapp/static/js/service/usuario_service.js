'use strict';

App.factory('UsuarioService', ['$http', '$q', function($http, $q){
	return {
		list: function() {
			return $http.get('http://localhost:8080/simples/api/usuario/')
				.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Erro enquanto lista usuarios');
						return $q.reject(errResponse);
					});
		},
		
		create: function(usuario){
			return $http.post('http://localhost:8080/simples/api/usuario/', usuario)
				.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Erro enquanto cria usuario');
						return $q.reject(errResponse);
					});
		},
		
		update: function(usuario, id){
			return $http.put('http://localhost:8080/simples/api/usuario/' + id, usuario)
				.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Erro enquanto atualiza usuario');
						return $q.reject(errResponse);
					});
		},
		    
		delete: function(id){
			return $http.delete('http://localhost:8080/simples/api/usuario/' + id)
				.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Erro enquanto deleta usuario');
						return $q.reject(errResponse);
					});
		}};
}]);