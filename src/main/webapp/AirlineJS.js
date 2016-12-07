var myMomondo = angular.module('myMomondo', []);
myMomondo.controller('AirlineController', ['$http', '$scope', function ($http, $scope) {
        $scope.title = "HamzaConnection Airways";
        $scope.destination = "STN";
        $scope.origin = "CPH";
        $scope.date = "2017-01-03";
        $scope.passengers = 3;
        $scope.show = false;
        setTimeout(function () {
            console.log($scope.passengers);
            console.log($scope.date);
            console.log($scope.destination);
            console.log($scope.origin);
            console.log($scope.show);
        }, 2000);
        $scope.search = function () {
            $http.get('http://localhost:8080/momondo/api/flights/'+$scope.origin + '/' + $scope.destination + '/' + $scope.date + '/' + $scope.passengers)
                    .success(function (data, status) {
                        $scope.data = data;
                        
                        $scope.show = true;
                        console.log("Works!");
                        console.log(data.flights);
                        console.log(status);
                        console.log($scope.show);
                    })
                    .error(function (status) {
                        console.log("nope");
                        console.log(status);
                    });
        };
    }]);