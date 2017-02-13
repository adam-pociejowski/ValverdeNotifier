'use strict';

app.controller('AppController', function($scope, $http, $location, authService) {
    $scope.isAuthenticated = false;
    $scope.loggedUser = {};

    $scope.authenticate = function () {
        var promise = authService.authenticate();
        promise.success(function (response) {
            $scope.isAuthenticated = true;
            $scope.loggedUser = response.name;
        }).error(function () {
            $scope.isAuthenticated = false;
            $scope.loggedUser = null;
            $location.path('login');
        });
    };

    $scope.logout = function () {
        var promise = authService.logout();
        promise.success(function () {
            $location.path('login');
            $scope.addAlert();
        }).error(function () {

        });
    };
});