/**
 * 
 */
app.controller('PersonDetailController',
		function($scope,PersonService,$routeParams,$location){
	var id=$routeParams.id
	
	/**
	 * Statement is to assign person detail for the given id
	 */
	PersonService.getPersonById(id).then(function(response){
		$scope.person=response.data
		console.log(response.data)
	},function(response){
	  console.log(response.status)	
	})
	
	$scope.updatePerson=function(){
		PersonService.updatePerson($scope.person).then(function(response){
			$location.path('/getallpersons')
		},function(response){
			console.log(response.status)
		})
	}
	
})