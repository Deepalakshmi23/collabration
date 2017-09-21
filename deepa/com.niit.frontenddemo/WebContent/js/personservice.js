/**
 * 
 */


app.factory('PersonService',function($http){
	var personService={};
	
	personService.getAllPersons=function(){
	return	$http.get("http://localhost:8085/backenddemo/getallpersons")
	/*
	 *   [404, HTML] - response
	 *   [500 , HTML]
	 *   [200, [JSON objects]
	 */
	}
	
	personService.savePerson=function(person){
		console.log(person)
		return $http.post("http://localhost:8085/backenddemo/saveperson",person)
	}
	personService.getPersonById=function(id){
		return $http.get("http://localhost:8085/backenddemo/getpersonbyid/"+id)
	}
	
	personService.updatePerson=function(person){
		return $http.put("http://localhost:8085/backenddemo/updateperson",person)
	}
	
	personService.deletePerson=function(id){
		return $http['delete']("http://localhost:8085/backenddemo/deleteperson/"+id);
	}
	
	
	
	return personService;
})
