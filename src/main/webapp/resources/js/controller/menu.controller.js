angular.module('menu')
.controller('menuCtrl', [
	'$scope',
	'$location',
	function($scope, $location) {
		
		$scope.menu = [
           {titulo: 'Produto', link: '/produto'},
           {titulo: 'Categoria', link: '/categoria'}
        ];
		
		$scope.redirect = function(link) {
			$location.path(link);
		}
		
	}
]);
