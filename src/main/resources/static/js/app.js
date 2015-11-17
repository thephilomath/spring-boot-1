var libApp = angular.module("libApp", [])

libApp.controller("bookController", 
	function ($scope, $http)	{
		$scope.addBook = function()	{
			var request = $http( {
				method  : "POST",
				url		: "/library/add",
				data	: {
					"name" 	: $scope.book.name,
					"author": $scope.book.author,
					"isbn"	: $scope.isbn,
					"category": $scope.category
				}
			});
			request.success(
				function (response)	{
					angular.element(document.querySelector("#divstatus")).css("visibility", "visible");
					if (response.status == "success")	{
						angular.element(document.querySelector("#divstatus")).addClass("alert-success");
						$scope.statusmsg="Book has been added successfully!";
						$scope.book = null; 
					}
					else	{
						angular.element(document.querySelector("#divstatus")).addClass("alert-danger");
						$scope.statusmsg="Error:" + response.detail;
					}
				});
			
			request.error(
				function (response)	{
					angular.element(document.querySelector("#divstatus")).css("visibility", "visible");
					angular.element(document.querySelector("#divstatus")).addClass("alert-danger");
					$scope.statusmsg="Error:" + response.detail;
				});
				
		}
	
	});
