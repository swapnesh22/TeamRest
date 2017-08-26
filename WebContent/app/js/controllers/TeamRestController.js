'use strict';

eventsApp.controller('TeamController',
	function TeamController($scope, $http, teamData, teamRestService) {
    
        
    /*$http.get("http://localhost:8080/TeamRest/rest/TeamService/11338")
    .then(function(response) {
        $scope.team = response.data;
    });*/
    
	/*$scope.team = function() {
		$http.get("http://localhost:8080/TeamRest/rest/TeamService/11338")
	    .then(function(response) {
	        return = response.data;
	    });
	};*/
	
    //$scope.team = teamData.getTeamRest;
    $scope.team = teamData.teamValue;
    $scope.employeeDetails = teamData.employeeDetails;
});