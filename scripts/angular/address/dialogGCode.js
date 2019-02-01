// *
// * Amendments
// * ----------	 									
// * 
// * EH 01sept2017 ITT-201707-0001C Add dialog gCode to QS Address / Location	    
// *


'use strict';



angular
  .module('dialogGCODE', ['ngMaterial'])
  .controller('dialogGCODEMainController', ['$scope', '$http', '$mdDialog', function ($scope, $http, $mdDialog) {

  $scope.searchParams={};

  $scope.requireG3 = true;

  $scope.showDialogGCODE = function(event) {	
			  
	  //default fields - will not change
	  $scope.searchParams.searchString1='';	
	  $scope.searchParams.searchString2='';
	  $scope.searchParams.searchString3='';
	  $scope.searchParams.searchString4='';
	  $scope.searchParams.maxResults='9999';
	  $scope.searchParams.orderBy='G1codekey';
	  $scope.searchParams.orderByDesc='';
	  
	  $scope.g1codes = {};
	  $scope.g2codes = {};
	  $scope.g3codes = {};
	  $scope.g4codes = {};
	  
	  $http.post('http://ttreport.intermodaltank.com:8081/webservice/rest/G1codeResource/list', $scope.searchParams).then(function(response) {
		  $scope.g1codes = response.data;
	  }, function(errResponse) {
		  console.error('Error while fetching G1c0deResource/list');
	  });

	  $mdDialog.show({
		clickOutsideToClose: false,
		scope: $scope,        
		preserveScope: true,   
		
	  templateUrl: "pages/standard/dialogGCode.html",
 
	  controller: function dialogGCODESubController() {

	  $scope.refreshG2codes = function() {
			//default fields - will not change
			$scope.searchParams.searchString2='';
			$scope.searchParams.searchString3='';
			$scope.searchParams.searchString4='';	
			$scope.searchParams.maxResults='9999';
			$scope.searchParams.orderBy='G2codekey';
			$scope.searchParams.orderByDesc='';

			$scope.g2codes = {};
			
  		    $scope.requireG3 = true;

			$http.post('http://ttreport.intermodaltank.com:8081/webservice/rest/G2codeResource/list', $scope.searchParams).then(function(response) {
				$scope.g2codes = response.data;
			}, function(errResponse) {
				console.error('Error while fetching G2codeResource/list');
			});
		   }
		   
	   $scope.clearG3 = function() {
			  $scope.g3codes = {};
			  $scope.g4codes = {};
	   }
	   
	   $scope.refreshG3codes = function() {
			  //default fields - will not change
			  $scope.searchParams.searchString3='';
			  $scope.searchParams.searchString4='';		
			  $scope.searchParams.maxResults='9999';
			  $scope.searchParams.orderBy='G3codekey';
			  $scope.searchParams.orderByDesc='';

			  $scope.g3codes = {};

			  $http.post('http://ttreport.intermodaltank.com:8081/webservice/rest/G3codeResource/list', $scope.searchParams).then(function(response) {
				  $scope.g3codes = response.data;
			  }, function(errResponse) {
				  console.error('Error while fetching G3codeResource/list');
			  });
	   }
	   
	   $scope.clearG4 = function() {
			  $scope.g4codes = {};
	   }
		   
	   $scope.refreshG4codes = function() {
			  //default fields - will not change
			  $scope.searchParams.searchString4='';		
			  $scope.searchParams.maxResults='9999';
			  $scope.searchParams.orderBy='G3codekey';
			  $scope.searchParams.orderByDesc='';

			  $scope.g4codes = {};
			  
  			  $scope.requireG3 = false;

			  $http.post('http://ttreport.intermodaltank.com:8081/webservice/rest/G4codeResource/list', $scope.searchParams).then(function(response) {
				  $scope.g4codes = response.data;
				  $scope.showg4 = true;
			  }, function(errResponse) {
				  console.error('Error while fetching G4codeResource/list');
			  });
		   }
		   
	   $scope.selectDialogGCODE = function() {
			  document.getElementById('geo1pull').value = document.getElementById('geo1id').value;
			  document.getElementById('geo2pull').value = document.getElementById('geo2id').value;
			  document.getElementById('geo3pull').value = document.getElementById('geo3id').value;
			  document.getElementById('geo4pull').value = document.getElementById('geo4id').value;
			  $mdDialog.hide();
		   }
		   
	   $scope.closeDialogGCODE = function() {
			  $scope.g2codes = {};
			  $scope.g3codes = {};
			  $scope.g4codes = {};
			  $mdDialog.hide();
		   }

		}
	 });
  };

}]);		 
