angular
.module("calculator")
.constant("plusURI", "/operand/plus")
.constant("minusURI", "/operand/minus")
.constant("multiplyURI", "/operand/multiply")
.constant("divisionURI", "/operand/division")
.controller("calculatorCtrl", 
	function($scope, $location, $http, context, plusURI, minusURI, multiplyURI, divisionURI) {
		$scope.numberPattern = new RegExp("^\\d*$");
	
		$scope.result = {};
		
		
		$scope.operand = {
			plus:{},
			minus:{},
			multiply:{},
			division:{}
		};
			
		
		var generationRequest = function( operationURI, operandLeft, operandRight){
			console.log('left operand : ' + operandLeft+', right operand : '+operandRight);
			var req = {
				method: 'POST',
				url: context+operationURI,
				headers: {
					'Content-Type' : 'application/json', 
					'Accept' : 'application/json'
				},
				data : {}
			};
			
			req.data.left = operandLeft;
			req.data.right = operandRight;
			
			console.log('left operand : ' + req.data.left + ', right operand : '+ req.data.right);
			
			return req;
		};
		
		
		$scope.plus = function() {
			var req = generationRequest(plusURI, $scope.operand.plus.left, $scope.operand.plus.right);
			
			console.log(req);
				
			$http(req)
			.success( function(data){
				console.log('success : ' + data);
				$scope.result.plus = data.value;
			})
			.error(function(error){
				console.log('error code : ' + error.code + 'error : message ' + error.message );
			});
		};
		
		$scope.minus = function() {
			var req = generationRequest(minusURI, $scope.operand.minus.left, $scope.operand.minus.right); 
			
			$http(req)
			.success( function(data){
				console.log('success : ' + data);
				$scope.result.minus = data.value;
			})
			.error(function(error){
				console.log('error code : ' + error.code + 'error : message ' + error.message );
			});
		};
		
		$scope.multiply = function() {
			var req = generationRequest(multiplyURI, $scope.operand.multiply.left, $scope.operand.multiply.right);
			
			$http(req)
			.success( function(data){
				console.log('success : ' + data);
				$scope.result.multiply = data.value;
			})
			.error(function(error){
				console.log('error code : ' + error.code + 'error : message ' + error.message );
			});
		};
		
		$scope.division = function() {
			var req = generationRequest(divisionURI, $scope.operand.division.left, $scope.operand.division.right); 
			
			$http(req)
			.success( function(data){
				console.log('success : ' + data);
				$scope.result.division = data.value;
			})
			.error(function(error){
				console.log('error code : ' + error.code + 'error : message ' + error.message );
			});
		};
	}
);
