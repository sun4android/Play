var quoteControllers = angular.module('quoteControllers', []);

quoteControllers.controller('QuoteController', ['$scope', 'Quote', function($scope, Quote) {
	$scope.fetchQuotes = function() {
		$scope.quotes = Quote.query({keyword: $scope.keyword});
	};
}]);

var weatherControllers = angular.module('weatherControllers', []);

weatherControllers.controller('WeatherController', ['$scope', 'Weather', function($scope, Weather) {
	$scope.fetchWeather = function() {
		$scope.weather = Weather.query({city: $scope.city});
	};
}]);