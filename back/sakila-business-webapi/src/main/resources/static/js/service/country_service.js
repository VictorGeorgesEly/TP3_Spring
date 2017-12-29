'use strict';

App.factory('CountryService', ['$http', '$q', function($http, $q){

	return {

			fetchAllCountries: function() {
					return $http.get('http://localhost:8080/country/')
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while fetching countries');
										return $q.reject(errResponse);
									}
							);
			}

	};

}]);
