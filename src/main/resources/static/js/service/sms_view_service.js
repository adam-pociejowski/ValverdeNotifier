app.factory('smsViewService', ['$http', function ($http) {

    var BASE_URL = '/rest/statistics';
    return {
        getSmsStats: function () {
            return $http.get(BASE_URL + '/getstats');
        }
    };
}]);
