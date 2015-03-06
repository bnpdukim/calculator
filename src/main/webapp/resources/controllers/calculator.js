angular
.module("calculator")
.constant("plusURI", "/operation/plus")
.constant("minusURI", "/operation/minus")
.constant("multiplyURI", "/operation/multiply")
.constant("divisionURI", "/operation/division")
.constant("summaryURI", "/operation/summary")
.controller("calculatorCtrl", 
	function($scope, $location, $http, context, plusURI, minusURI, multiplyURI, divisionURI, summaryURI) {
		$scope.numberPattern = new RegExp("^\\d*$");
	
		$scope.result = {};
		
		
		$scope.operand = {
			plus:{},
			minus:{},
			multiply:{},
			division:{}
		};		
		
		$scope.plus = function() {
			var req = generationCalculationRequest(plusURI, $scope.operand.plus.left, $scope.operand.plus.right);
			
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
			var req = generationCalculationRequest(minusURI, $scope.operand.minus.left, $scope.operand.minus.right); 
			
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
			var req = generationCalculationRequest(multiplyURI, $scope.operand.multiply.left, $scope.operand.multiply.right);
			
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
			var req = generationCalculationRequest(divisionURI, $scope.operand.division.left, $scope.operand.division.right); 
			
			$http(req)
			.success( function(data){
				console.log('success : ' + data);
				$scope.result.division = data.value;
			})
			.error(function(error){
				console.log('error code : ' + error.code + 'error : message ' + error.message );
			});
		};
		
		$scope.querySummary = function() {
			var req = generationSummaryRequest(summaryURI); 
			console.log("req : " + req);
			$http(req)
			.success( function(data){
				$scope.summary = data;
				$location.path("/summary");
			})
			.error(function(error){
				console.log('error code : ' + error.code + 'error : message ' + error.message );
			});
		};
		
		var generationCalculationRequest = function( operationURI, operandLeft, operandRight){
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
		
		var generationSummaryRequest = function( summaryURI ){
			return {
				method: 'GET',
				url: context+summaryURI,
				headers: {
					'Content-Type' : 'application/json', 
					'Accept' : 'application/json'
				}
			};
		};
	}
);
