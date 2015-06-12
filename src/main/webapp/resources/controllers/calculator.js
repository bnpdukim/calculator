angular.module("calculator").constant("plusURI", "/operation/plus").constant(
		"minusURI", "/operation/minus").constant("multiplyURI",
		"/operation/multiply").constant("divisionURI", "/operation/division")
		.constant("summaryURI", "/operation/summary").constant("oauthURI", "/oauth/token").controller(
				"calculatorCtrl",
				function($scope, $location, $http, context, oauthURI, plusURI, minusURI,
						multiplyURI, divisionURI, summaryURI) {
					$scope.numberPattern = new RegExp("^\\d*$");

					$scope.result = {};

					$scope.operand = {
						plus : {},
						minus : {},
						multiply : {},
						division : {}
					};
					
					$scope.user = {};
					$scope.refresh = {};
					$scope.login = {};

					$scope.authToken = function() {
						var req = generationAuthenticationRequest(oauthURI,
								'my-trusted-client',
								$scope.user.id,
								$scope.user.password);

						console.log(req);

						$http(req).success(function(data) {
							console.log('success : ' + data);
							$scope.refresh = data;
							$scope.login = data;
						}).error(
								function(error) {
									console.log('error : ' + error);
								});
					};
					
					$scope.refreshToken = function() {
						console.log('clicked refresh');
						
						var req = generationRefreshRequest(oauthURI,
								'my-trusted-client',
								$scope.login.refresh_token);

						console.log(req);

						$http(req).success(function(data) {
							console.log('success : ' + data);
							$scope.refresh = data;
						}).error(
								function(error) {
									console.log('error : ' + error);
								});
					};
					
					$scope.plus = function() {
						var req = generationCalculationRequest(plusURI, $scope.refresh.access_token,
								$scope.operand.plus.left,
								$scope.operand.plus.right);

						console.log(req);

						$http(req).success(function(data) {
							console.log('success : ' + data);
							$scope.result.plus = data.value;
						}).error(
								function(error) {
									console.log('error' + error);
								});
					};

					$scope.minus = function() {
						var req = generationCalculationRequest(minusURI, $scope.refresh.access_token,
								$scope.operand.minus.left,
								$scope.operand.minus.right);

						$http(req).success(function(data) {
							console.log('success : ' + data);
							$scope.result.minus = data.value;
						}).error(
								function(error) {
									console.log('error' + error);
								});
					};

					$scope.multiply = function() {
						var req = generationCalculationRequest(multiplyURI, $scope.refresh.access_token,
								$scope.operand.multiply.left,
								$scope.operand.multiply.right);

						$http(req).success(function(data) {
							console.log('success : ' + data);
							$scope.result.multiply = data.value;
						}).error(
								function(error) {
									console.log('error' + error);
								});
					};

					$scope.division = function() {
						var req = generationCalculationRequest(divisionURI, $scope.refresh.access_token,
								$scope.operand.division.left,
								$scope.operand.division.right);

						$http(req).success(function(data) {
							console.log('success : ' + data);
							$scope.result.division = data.value;
						}).error(
								function(error) {
									console.log('error' + error);
								});
					};

					$scope.querySummary = function() {
						var req = generationSummaryRequest(summaryURI, $scope.refresh.access_token);
						console.log("req : " + req);
						$http(req).success(function(data) {
							$scope.summary = data;
							$location.path("/summary");
						}).error(
								function(error) {
									console.log('error summary : ' + error);
								});
					};

					var generationAuthenticationRequest = function(oauthURI,
							clientId, username, password) {
						var req = {
							method : 'POST',
							url : context + oauthURI,
							headers : {
								'Content-Type' : 'application/json',
								'Accept' : 'application/json'
							},
							params:{'grant_type':'password', 'client_id':clientId,'username':username, 'password':password}
						};

						return req;
					};					
					
					var generationRefreshRequest = function(oauthURI,
							clientId, refreshToken) {
						var req = {
							method : 'POST',
							url : context + oauthURI,
							headers : {
								'Content-Type' : 'application/json',
								'Accept' : 'application/json'
							},
							params:{'grant_type':'refresh_token', 'client_id':clientId,'refresh_token':refreshToken}
						};

						return req;
					};
					
					var generationCalculationRequest = function(operationURI, accessToken,
							operandLeft, operandRight) {
						console.log('left operand : ' + operandLeft
								+ ', right operand : ' + operandRight+', accessToken : ' + accessToken);
						var req = {
							method : 'POST',
							url : context + operationURI,
							headers : {
								'Content-Type' : 'application/json',
								'Accept' : 'application/json'
							},
							params:{'access_token':accessToken},
							data : {}
						};

						req.data.left = operandLeft;
						req.data.right = operandRight;

						console.log('left operand : ' + req.data.left
								+ ', right operand : ' + req.data.right);

						return req;
					};

					var generationSummaryRequest = function(summaryURI, accessToken) {
						return {
							method : 'GET',
							url : context + summaryURI,
							headers : {
								'Content-Type' : 'application/json',
								'Accept' : 'application/json'
							},
							params:{'access_token':accessToken}
						};
					};
				});
