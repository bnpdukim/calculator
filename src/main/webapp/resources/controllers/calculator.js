angular
.module("calculator")
.constant("newRequestTokenURI", "/auth/request")
.constant("verifyEmailURI", "/auth/request/:requestToken/email")
.constant("verifyPhoneURI", "/auth/request/:requestToken/phone")
.constant("createUserURI", "/users")
.controller("calculatorCtrl", 
	function($scope, $location, $http, context, newRequestTokenURI, verifyEmailURI, verifyPhoneURI, createUserURI) {
		$scope.numberPattern = new RegExp("^\\d*$");
	
		$scope.resultForm = {};
		
		
		$scope.operand = {
			plus:{},
			minus:{},
			multiply:{},
			division:{}
		};
			
		$scope.rest = {
				requestToken : {status:true},
				email : {status:true},
				phone : {status:true},
				nickname : {status:true}				
		};
		
		$scope.applicationForm = {
			device : {
				model:"iron1",vendorCode:"ap",version:"4.3.3"
			},
			profile :{
				
			}
		};
		
		$scope.userInput = {};
		
		$scope.newRequestToken = function() {
			var req = {
				method: 'GET',
				url: context+newRequestTokenURI,
				headers: {
					'Content-Type' : 'application/json', 
					'Accept' : 'application/json'
				}
			};
			
			$http(req)
			.success( function(data){
				console.log('success : ' + data.requestToken);
				$scope.applicationForm.requestToken = data.requestToken;
				$scope.rest.requestToken.status = true;
			})
			.error(function(error){
				console.log('error code : ' + error.code + 'error : message ' + error.message );
				$scope.rest.requestToken.error = error;
				$scope.rest.requestToken.status = false;
				initRequestToken();
			});
		};
		
		$scope.nextRequestToken = function() {
			initRestStatus();
			$location.path("/email");
		};
		
		$scope.verifyEmailEvidence = function() {
			var uriPath = verifyEmailURI.replace(":requestToken", $scope.applicationForm.requestToken);
			console.log(uriPath);			
			
			var req = {
					method: 'POST',
					url: context+uriPath,
					headers: {
						'Content-Type' : 'application/json', 
						'Accept' : 'application/json'
					},
					data : {keyword:$scope.applicationForm.evidence}
				};
				
			
			console.log($scope.applicationForm.evidence);
			$http(req)
			.success( function(data){
				console.log('success : ' + data);
				$scope.resultForm.secretCodeForEmail = data.code;
				$scope.rest.email.status = true;
			})
			.error(function(error){
				console.log('error code : ' + error.code + 'error : message ' + error.message );
				$scope.rest.email.error = error;
				$scope.rest.email.status = false;
				initEmail();
			});
		};
		
		$scope.beforeEmailEvidence = function() {
			initEmail();
			$location.path("/requestToken");
		};
		
		$scope.verifyPhoneEvidence = function() {
			var uriPath = verifyPhoneURI.replace(":requestToken",$scope.applicationForm.requestToken);
			console.log(uriPath);			
			
			var req = {
					method: 'POST',
					url: context+uriPath,
					headers: {
						'Content-Type' : 'application/json', 
						'Accept' : 'application/json'
					},
					data : {keyword:$scope.applicationForm.profile.phone}
				};
			

			$http(req)
			.success( function(data){
				console.log('success : ' + data);
				$scope.resultForm.secretCodeForPhone = data.code;
				$scope.rest.phone.status = true;
			})
			.error(function(error, status, headers, config){
				console.log('error code : ' + error.code + 'error : message ' + error.message );
				$scope.rest.phone.error = error;
				$scope.rest.phone.status = false;
				initPhone();
			});
		};
		
		$scope.beforePhoneEvidence = function() {
			initPhone();
			$location.path("/email");
		};
		
		$scope.initPhoneEvidence = function() {
			initPhone();
			$location.path("/nickname"); 
		};
		
		$scope.registNickname = function() {
			var req = {
					method: 'PUT',
					url: context+createUserURI,
					headers: {
						'Content-Type' : 'application/json', 
						'Accept' : 'application/json'
					},
					data : $scope.applicationForm
				};
			
			console.log('req');
			
			
			
			$http(req)
			.success( function(data){
				console.log('success : ' + data);
				$scope.resultForm.idToken = data.idToken;
				$scope.resultForm.accessToken = data.accessToken;
				$scope.resultForm.jid = data.jid;
				$scope.resultForm.sip = data.sip;
				$scope.rest.nickname.status = true;
			})
			.error(function(error){
				console.log('error code : ' + error.code + 'error : message ' + error.message );
				$scope.rest.nickname.error = error;
				$scope.rest.nickname.status = false;
				initNickname();
			});	
		};
		
		$scope.beforeNickname = function() {
			initNickname();
			$location.path("/phone"); 
		};
		
		$scope.first = function() {
			initAll();
			$location.path("/newRequestToken"); 
		};
		
		var initAll = function() {
			initNickname();
			initPhone();
			initEmail();
			initRequestToken();
			initRestStatus();
		};
		
		var initRestStatus = function() {
			$scope.rest.requestToken.status = true;
			$scope.rest.email.status = true;
			$scope.rest.phone.status = true;
			$scope.rest.nickname.status = true;
		}
		
		var initRequestToken = function() {
			if( angular.isDefined($scope.applicationForm.requestToken) ) {
				delete $scope.applicationForm.requestToken;
			}
		};
		
		var initEmail = function() {
			if( angular.isDefined($scope.applicationForm.evidence) ) {
				delete $scope.applicationForm.evidence;
			}
			
			if( angular.isDefined($scope.resultForm.secretCodeForEmail) ) {
				delete $scope.resultForm.secretCodeForEmail;
			}
			
			if( angular.isDefined($scope.userInput.secretCodeForEmail) ) {
				delete $scope.userInput.secretCodeForEmail;
			}
			
		};
		
		var initPhone = function() {
			if( angular.isDefined($scope.applicationForm.profile.phone) ) {
				delete $scope.applicationForm.profile.phone;
			}
			
			if( angular.isDefined($scope.resultForm.secretCodeForPhone) ) {
				delete $scope.resultForm.secretCodeForPhone;
			}
			
			if( angular.isDefined($scope.userInput.secretCodeForPhone) ) {
				delete $scope.userInput.secretCodeForPhone;
			}
		};
		
		var initNickname = function() {
			if( angular.isDefined($scope.applicationForm.profile.nickname) ) {
				delete $scope.applicationForm.profile.nickname;
			}
			
			if( angular.isDefined($scope.resultForm.idToken) ) {
				delete $scope.resultForm.idToken;
			}
			
			if( angular.isDefined($scope.resultForm.accessToken) ) {
				delete $scope.resultForm.accessToken;
			}
			
			if( angular.isDefined($scope.resultForm.jid) ) {
				delete $scope.resultForm.jid;
			}
			
			if( angular.isDefined($scope.resultForm.sip) ) {
				delete $scope.resultForm.sip;
			}
		};
	}
);
