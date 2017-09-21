/**
 * 
 */

var app=angular.module("app",['ngRoute'])
app.config(function($routeProvider){
 
	$routeProvider
	
	.when('/link1',{
		templateUrl:'views/link1view.html',
		controller:'Link1Controller'
	})
	.when('/link2',{
		templateUrl:'views/link2view.html',
		controller:'Link2Controller'
	})
	.when('/getallpersons',{
		templateUrl:'views/getallpersons.html',
		controller:'PersonController'
	})
	.when('/addnewperson',{
		templateUrl:'views/personform.html',
		controller:'PersonController'
	})
	.when('/getpersonbyid/:id',{
		templateUrl:'views/editpersonform.html',
		controller:'PersonDetailController'
	})
	.otherwise({
		templateUrl:'views/home.html'
	})

})