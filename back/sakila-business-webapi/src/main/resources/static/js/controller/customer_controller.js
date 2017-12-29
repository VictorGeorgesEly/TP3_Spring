'use strict';

App.controller('CustomerController', ['$scope', 'CustomerService', function($scope, CustomerService) {
          var self = this;
          self.customer={customerId:null,lastName:'',firstName:'',email:''};
          self.customers=[];
          self.countries=[];
          self.cities=[];


          self.fetchAllCountries = function(){
        	  CustomerService.fetchAllCountries()
                  .then(
      					       function(d) {
      						        self.countries = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };

          self.fetchAllCustomers = function(){
        	  CustomerService.fetchAllCustomers()
                  .then(
      					       function(d) {
      						        self.customers = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };

          self.createCustomer = function(customer){

        	  console.log(customer);
              CustomerService.createCustomer(customer)
		              .then(
                      self.fetchAllCustomers,
				              function(errResponse){
					               console.error('Error while creating Customer.');
				              }
                  );
          };

         self.updateCustomer = function(customer){
        	 CustomerService.updateCustomer(customer)
             .then(
                     self.fetchAllCustomers,
				              function(errResponse){
					               console.error('Error while updating Customer.');
				              }
                 );
         };

        self.deleteCustomer = function(customerId){
             CustomerService.deleteCustomer(customerId)
		              .then(
				              self.fetchAllCustomers,
				              function(errResponse){
					               console.error('Error while deleting Customer.');
				              }
                 );
         };

         self.fetchAllCustomers();
         self.fetchAllCountries();

         self.submit = function() {
             if(self.customer.customerId==null){
           	  	self.customer.address.cityId=$scope.selectedCity.cityId;
                 console.log('Saving New Customer', self.customer);
                 self.createCustomer(self.customer);
             }else{
                 console.log('Customer updating with id ', self.customer.customerId);
                 console.log('Customer: ', self.customer);
                 self.updateCustomer(self.customer);
             }
             self.reset();
         };

         self.edit = function(customerId){
             console.log('id to be edited', customerId);
             for(var i = 0; i < self.customers.length; i++){
                 if(self.customers[i].customerId == customerId) {
                    self.customer = angular.copy(self.customers[i]);

                    for(var k = 0; k<self.countries.length; k++) {
                    	if(self.countries[k].countryId == self.customers[i].address.city.country.countryId) {
                    		$scope.selectedCountry = self.countries[k]
                    		self.cities = $scope.selectedCountry.cities;

                    		for(var j = 0; j < self.cities.length; j++) {
                            	if(self.cities[j].cityId == self.customers[i].address.city.cityId) {
                            		$scope.selectedCity = self.cities[j]
                            		console.log($scope.selectedCity)
                            	}
                            }
                    	}
                    }

                    break;
                 }
             }
                      };

         self.fillCityList = function(){
             self.cities = $scope.selectedCountry.cities
         };


         self.reset = function(){
             self.customer={customerId:null,lastName:'',firstName:'',email:''};
             $scope.selectedCity = null;
             $scope.selectedCountry= null;
             $scope.myForm.$setPristine(); //reset Form
         };

     }]);
