'use strict';

App.factory('CustomerService', ['$http', '$q', function($http, $q){

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
			},

			fetchAllCustomers: function() {
					return $http.get('http://localhost:8080/customer/')
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while fetching customers');
										return $q.reject(errResponse);
									}
							);
			},

		    createCustomer: function(customer){
		    		var rental = {
		    				customerId: 1,
		    				filmId: 1
		    		}
					return $http.post('http://localhost:8080/customer/', customer)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while creating customer');
										return $q.reject(errResponse);
									}
							);
		    },

		    updateCustomer: function(customer, customerId){
     	    	    console.log("XXX", customer);
					return $http.post('http://localhost:8080/customerUpdate/', customer)
							.then(
									function(response){
										return response.data;
									},
									function(errResponse){
										console.error('Error while updating customer');
										console.log(errResponse)
										return $q.reject(errResponse);
									}
							);
			}

	};

}]);
