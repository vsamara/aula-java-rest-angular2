angular.module('produto')
.controller('ProdutoCtrl', 
	function($scope, ProdutoService) {
		
		$scope.produto = {};
		$scope.produtos = [];
		
		var error = function() {
			console.log('Status = ' + ProdutoService.status + '\n');
			console.log('Erro = ' + ProdutoService.error + '\n');
		}

		$scope.updateValue = false;
		$scope.mudaUpdate = function() {
			$scope.updateValue = !$scope.updateValue;	
			$scope.produto.id = undefined;
		};		
		
		$scope.findAll = function() {
			ProdutoService.findAll().then(
				function() {
					$scope.produtos = ProdutoService.data;
					ProdutoService.data = {};
				},
				error
			);
		}
		
		$scope.id = '';
		$scope.find = function() {
			ProdutoService.find($scope.id).then(
				function() {
					$scope.produto = ProdutoService.data;
					ProdutoService.data = {};
				},
				error
			);
		}
		
		var updateMsg = function() {
			alert($scope.produto.descricao + ' Salvo com sucesso!');
			ProdutoService.data = {};
		}
		
		$scope.create = function() {
			ProdutoService.create($scope.produto).then(updateMsg, error);
		}
		
		$scope.update = function() {
			ProdutoService.update($scope.produto).then(updateMsg, error);
		}
		
		$scope.remove = function() {
			ProdutoService.remove($scope.produto).then(
				function() {
					alert($scope.produto.descricao + ' Deletado com sucesso!');
					ProdutoService.data = {};
				}, 
				error
			);
		}
		
	}
);
