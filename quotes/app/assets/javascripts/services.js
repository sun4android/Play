var quoteServices = angular.module('quoteServices', ['ngResource']);

quoteServices.factory('Quote', ['$resource', function($resource) {
	return $resource('/rest/quotes', {keyword: '@keyword'});
}]);

var weatherServices = angular.module('weatherServices', ['ngResource']);

weatherServices.factory('Weather',['$resource', function($resource) {
	return $resource('/rest/weather', {city: '@city'});
}]);