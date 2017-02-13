app.controller('SmsViewController', function($scope, $http, $location, smsViewService) {

    $scope.init = function () {
        var promise = smsViewService.getSmsStats();
        promise.success(function (data) {
            $scope.stats = data;
            console.log(data);
        }).error(function() {});
    };
});