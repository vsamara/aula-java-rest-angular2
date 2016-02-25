angular.module('menuModule')
.controller('menuCtrl', [
	'$scope',
	'$location',
	function($scope, $location) {
		
		$scope.menu = [
           {titulo: 'Produto', link: '/produto'},
           {titulo: 'Categoria', link: '/cliente'}
        ];
		
		$scope.redirect = function(link) {
			$location.path(link);
		}
		
	}
]);
