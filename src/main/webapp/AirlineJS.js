var myMomondo = angular.module('myMomondo', []);
myMomondo.controller('AirlineController', ['$http', '$scope', function ($http, $scope) {
        $scope.title = "HamzaConnection Airways";
        $scope.destination;
        $scope.origin;
        $scope.date = "2017-01-01";
        $scope.passengers = 1;
        $scope.show = false;
        $scope.temp = [];
        $scope.travelDate = [];
        $scope.time = [];
        setTimeout(function () {
            console.log($scope.passengers);
            console.log($scope.date);
            console.log($scope.destination);
            console.log($scope.origin);
            console.log($scope.show);

        }, 2000);
        $scope.search = function () {
            $http.get('http://localhost:8080/momondo/api/flights/' + $scope.origin + '/' + $scope.destination + '/' + $scope.date + '/' + $scope.passengers)
                    .success(function (data, status) {
                        $scope.data = data;
                        for (var i = 0; i < data.flights.length; i++) {
                            $scope.temp = data.flights[i].date.split("T");
                            $scope.travelDate.push($scope.temp[0]);
                            $scope.time.push($scope.temp[1].substring(0,5));
                        }
                        $scope.show = true;
                        console.log("Works!");
                        console.log(data.airline);
                        console.log(data.flights);
                        console.log(status);
                        console.log($scope.show);
                    })
                    .error(function (status) {
                        console.log("nope");
                        console.log(status);
                    });
        };
        $scope.book = function () {
            $http.post('http://localhost:8080/momondo/api/flights/' + "id")
                    .success(function (data, status) {
                        $scope.data = data;

                        console.log("Works!");
                        console.log(status);
                    })
                    .error(function (status) {
                        console.log("nope");
                        console.log(status);
                    });
        };
    }]);