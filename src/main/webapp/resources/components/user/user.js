angular.module("user", [])
.constant("loginURI", "/j_spring_security_check")
.constant("logoutURI", "/j_spring_security_logout")
.directive("userSummary", function() {
	return {
		restrict: "EA",
		templateUrl: "resources/components/user/userSummary.html",
		
		controller: function($scope, $http, $location, context, loginURI, logoutURI) {
			var user = {};
			
			var initUserPassword = function() {
				if( angular.isDefined($scope.user.password) ) {
					delete $scope.user.password;
				}
			};
			
			var initUserRole = function() {
				if( angular.isDefined($scope.user.role) ) {
					delete $scope.user.role;
				}
			};
			
			var generationLoginRequest = function( uri, id, pw){
				console.log("context : " + context+", uri : " + uri+", id"+id+", pw"+pw);
				var req = {
					method: 'POST',
					url: context+uri,
					headers: {
						'Content-Type' : 'text/html', 
					},
					params : {j_username:id,j_password:pw}
				};
				
				return req;
			};
			
			var generationLogoutRequest = function( uri ){
				console.log("context : " + context+", uri : " + uri);
				var req = {
					method: 'POST',
					url: context+uri,
					headers: {
						'Content-Type' : 'text/html', 
					}
				};
				
				return req;
			};
			
			$scope.login = function() {
				console.log("login called");
				var loginRequest = generationLoginRequest(loginURI, $scope.user.id, $scope.user.password);
				
				$http(loginRequest)
				.success( function(data){
					console.log('success : ' + data);
					$scope.user.auth = true;
					$scope.user.role = 'admin';
					initUserPassword();
				})
				.error(function(){
					console.log('error' );
					$scope.user.auth = false;
					initUserRole();					
					initUserPassword();
				});
				
				return user;
			}
			
			$scope.logout = function() {
				console.log("logout called");
				var logoutRequest = generationLogoutRequest(logoutURI);
				
				$http(logoutRequest)
				.success( function(data){
					console.log('success : ' + data);
					$scope.user.auth = false;
					initUserRole();
					initUserPassword();
					$location.path("/calculator");
				})
				.error(function(error){
					console.log('error code : ' + error.code + 'error : message ' + error.message );
					$scope.user.auth = false;
					initUserRole();					
					initUserPassword();
				});
			}
		}
	};
});