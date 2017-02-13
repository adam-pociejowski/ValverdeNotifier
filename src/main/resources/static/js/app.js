var app = angular.module('App', ['ngAnimate', 'ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider.when('/login', {
            templateUrl : 'login.html',
            controller : 'LoginController'
        }).when('/sms-view', {
            templateUrl : 'sms-view.html',
            controller : 'SmsViewController'
        }).otherwise(
            { redirectTo: '/sms-view'}
        );
    });