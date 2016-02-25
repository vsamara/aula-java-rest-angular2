angular.module('app', [
	'produto',
	'menu',
	'ngRoute'
]).config(function($routeProvider) {

	$routeProvider
	.when('/produto', {
		templateUrl: '../../aula-java-rest/produtotemplate.html',
		controller: 'ProdutoCtrl'
    })
    .when('/categoria', {
        templateUrl: '../../aula-java-rest/categoria.html',
        controller: 'CategoriaCtrl'
    });

});