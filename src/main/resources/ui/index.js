var app = angular.module('ServiceApp', [ 'ngResource' ]);

app.factory("Services", function($resource) {
	return $resource("http://localhost:8080/services/");
});

app.controller("ServiceController", function($scope, Services) {
	Services.query(function(data) {
		$scope.services = data;
	});
});