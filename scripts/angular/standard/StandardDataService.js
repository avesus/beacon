// JavaScript Document
var StandardDataService = angular.module('StandardDataService', []);
StandardDataService.factory('LocationData', ['$http', function ($http) {

    var urlBase = 'http://localhost:8080/webservice/rest/LocationResource';	
    var LocationData = {};

    LocationData.getPlants = function () {		
        return $http.get(urlBase+'/searchbytype/PLANT');
    };

    LocationData.getPlantcitys = function () {		
        return $http.get(urlBase+'/searchbytype/PLANTCITY');
    };
	
    LocationData.getDepots = function () {		
        return $http.get(urlBase+'/searchbytype/DEPOT');
    };
	
    LocationData.getPorts = function () {		
        return $http.get(urlBase+'/searchbytype/PORT');
    };
	
    return LocationData;

}]);
StandardDataService.factory('AddressData', ['$http', function ($http) {

    var urlBase = 'http://localhost:8080/webservice/rest/AddressResource';	
    var AddressData = {};

    AddressData.getCustomers = function () {		
        return $http.get(urlBase+'/searchbytype/CUSTOMER');
    };

    AddressData.getVendors = function () {		
        return $http.get(urlBase+'/searchbytype/VENDOR');
    };
	

    return AddressData;

}]);
