
app.controller('LoginController', function($scope, $http, $location, authService) {
    $scope.credentials = {};

    $scope.login = function() {
        var promise = authService.login($scope.credentials);
        promise.success(function () {
            $scope.authenticate();
            $location.path('sms-view');
        }).error(function() {
            $scope.login.error = true;
        });
    };
});