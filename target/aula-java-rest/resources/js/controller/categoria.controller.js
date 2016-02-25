$wangular.module('categoria')
.controller('CategoriaCtrl',
	function($scope, CategoriaService) {
		
		$scope.categoria = {};
		$scope.categorias = [];
		
		var error = function() {
			console.log("Status = " + CategoriaService.status);
			console.log("Error = " + CategoriaService.error);
		};
		
		$scope.updateValue = false;
		$scope.mudaUpdate = function() {
			$scope.updateValue = !$scope.updateValue;	
			$scope.categoria.id = undefined;
		};		

		$scope.categoria.id = '';
		$scope.find = function() {
			CategoriaService.find($scope.categoria).then(
				function() {
					$scope.categorias = CategoriaService.data;
					CategoriaService.data = {};
				},
				error
			);
		};
		
		$scope.findAll = function() {
			CategoriaService.findAll().then(
				function() {
					$scope.categorias = CategoriaService.data;
					CategoriaService.data = {};
				},
				error
			);
		};

		var updateMsg = function() {
			alert('Categoria ' + $scope.categoria.descricao + 'salva com sucesso!');
		};

		$scope.create = function() {
			CategoriaService.create($scope.categoria).then(updateMsg, error);
		};

		$scope.update = function() {
			CategoriaService.update($scope.categoria).then(updateMsg, error);
		};

		$scope.remove = function() {
			CategoriaService.remove($scope.categoria).then(
				function() {
					alert('Categoria' + $scope.categoria.descricao + 'excluida com sucesso!');
				}
			);
		};

	}
);