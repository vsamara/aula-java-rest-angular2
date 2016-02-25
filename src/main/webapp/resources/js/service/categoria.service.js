angular.module('categoria')
.service('CategoriaService' , 
	[
	 	'$http',
	 	function CategoriaService($http) {
	 		
	 		var url = 'http://localhost:8080/aula-java-rest/rest/categoria/';
	 		
	 		CategoriaService.error = {};
	 		CategoriaService.data = {};
 			CategoriaService.status = {};

	 		var callbackError = function(data, status) {
	 			CategoriaService.error = data;
	 			CategoriaService.status = status;
	 		}	 			
	 		
	 		var callBackSuccess = function(data, status) {
	 			CategoriaService.data = data;
	 			CategoriaService.status = status;
	 		}
	 		
	 		CategoriaService.findAll = function() {
	 			return $http.get(url + 'find-all')
	 			.success(callBackSuccess)
	 			.error(callbackError);
	 		}
	 		
	 		CategoriaService.find = function(id) {
	 			return $http.get(url + 'find-' + id)
	 			.success(callBackSuccess)
	 			.error(callbackError);
	 		}

	 		CategoriaService.create = function(categoria) {
	 			return $http.post(url + 'create', categoria)
	 			.success(callBackSuccess)
	 			.error(callbackError);
	 		}
	 		
	 		CategoriaService.update = function(categoria) {
	 			return $http.put(url + 'update', categoria)
	 			.success(callBackSuccess)
	 			.error(callbackError);
	 		}

	 		CategoriaService.remove = function(categoria) {
	 			return $http({
	 				url: url + 'delete',
	 				data: categoria,
	 				method: 'DELETE'
	 			})
	 			.success(callBackSuccess)
	 			.error(callbackError);
	 		}
	 		
	 		return CategoriaService;
	 	}
	]
) 