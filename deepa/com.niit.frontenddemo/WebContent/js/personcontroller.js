app.controller('PersonController',function($scope,PersonService,$location){
	function getAllPersons(){
	PersonService.getAllPersons().then(function(response){
		$scope.persons=response.data
		console.log(response.status)
	},function(response){
		console.log(response.status)
	})
	}
	getAllPersons()
	$scope.savePerson =function(){
		PersonService.savePerson($scope.person).then(function(response){
			console.log(response.data)
			console.log(response.status)
			$location.path('/getallpersons')
		},function(response){
			console.log(response.status)
		})
	}	
	$scope.deletePerson=function(id){
		PersonService.deletePerson(id).then(function(response){
			getAllPersons()
			$location.path('/getallpersons')
		},function(response){
			console.log(response.status)
		})
	}
})
