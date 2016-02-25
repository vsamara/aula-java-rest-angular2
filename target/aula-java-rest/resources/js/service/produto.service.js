angular.module('produto')
.service(
	'ProdutoService',
	[	
	 	'$http',
	 	'CategoriaService',
	 	function ProdutoService($http, CategoriaService) {
	 		
	 		var url = "http://localhost:8080/aula-java-rest/rest/produto/";
	 		
	 		ProdutoService.data = {};
	 		ProdutoService.status = {};
	 		ProdutoService.error = {};
	 		
	 		var callbackSuccess = function(data, status) {
	 			ProdutoService.data = data;
	 			ProdutoService.status = status;
	 		};
	 		
	 		var callbackError = function(error, status) {
	 			ProdutoService.error = error;
	 			ProdutoService.status = status;
	 		};
	 		
	 		ProdutoService.getCategorias = function() {
	 			return CategoriaService.findAll();
	 		};
	 		
	 		ProdutoService.findAll = function() {
	 			return $http.get(url + 'find-all')
	 			.success(callbackSuccess)
	 			.error(callbackError);
	 		};
	 		
	 		ProdutoService.find = function(id) {
	 			return $http.get(url + 'find-' + id)
	 			.success(callbackSuccess)
	 			.error(callbackError);
	 		};
	 		
	 		ProdutoService.create = function(produto) {
	 			return $http({
					url: url + 'create',
	 				data: produto,
	 				method: 'POST'
				}).success(callbackSuccess)
	 			.error(callbackError);
	 		}
	 		
	 		ProdutoService.update = function(produto) {
	 			return $http.put(url + 'update', produto)
				.success(callbackSuccess)
	 			.error(callbackError);
	 		}
	 		
	 		ProdutoService.remove = function(produto) {
	 			return $http({
	 				url: url + 'delete',
	 				data: produto,
	 				method: 'DELETE'
	 			})
				.success(callbackSuccess)
				.error(callbackError);
	 		}
	 
	]	
);
