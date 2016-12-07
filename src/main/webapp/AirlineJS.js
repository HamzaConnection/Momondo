var myMomondo = angular.module('myMomondo', []);
myMomondo.controller('AirlineController', ['$http', '$scope', function ($http, $scope) {
        $scope.title = "HamzaConnection Airways";
        $scope.destination = "";
        $scope.origin = "";
        $scope.date = "";
        $scope.passengers = document.getElementById("passengers").value;
        setTimeout(function () {
            console.log($scope.passengers);
            console.log($scope.date);
            console.log($scope.destination);
            console.log($scope.origin);
        }, 5000);
        $scope.search = function () {
            $http.get('http://localhost:8080/momondo/api/flights/'+$scope.origin + '/' + $scope.destination + '/' + $scope.date + '/' + $scope.passengers)
                    .success(function (data, status) {
                        $scope.data = data;
                        console.log("Works!");
                        console.log(data[0]);
                        console.log(status);
                    })
                    .error(function (status) {
                        console.log("nope");
                        console.log(status);
                    });
        };
    }]);