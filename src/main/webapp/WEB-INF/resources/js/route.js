/**
 * Created by roshane on 9/3/17.
 */
(function () {
    angular.module("demoApp")
        .config(['$locationProvider', '$routeProvider', configuration]);

    function configuration($locationProvider, $routeProvider) {
        console.log('bootstrapping application routes');

        $routeProvider.when('/', {
            templateUrl: '/resources/templates/studentList.html',
            controller: 'studentListController as $ctrl'
        }).when('/edit/:regNumber', {
            templateUrl: '/resources/templates/studentEdit.html',
            controller: 'studentEditController as $ctrl',
            resolve: {
                csResponse: function ($http, $route) {
                    console.log('resolving ', $route.current.params.regNumber);
                    return $http.get('api/students/' + $route.current.params.regNumber);
                }
            }
        }).when('/view/:regNumber', {
            templateUrl: '/resources/templates/studentView.html',
            controller: 'studentViewController as $ctrl',
            resolve: {
                csResponse: function ($http, $route) {
                    console.log('resolving ', $route.current.params.regNumber);
                    return $http.get('api/students/' + $route.current.params.regNumber);
                }
            }
        }).when('/new', {
            templateUrl: '/resources/templates/studentEdit.html',
            controller: 'studentEditController as $ctrl',
            resolve: {
                csResponse: function () {
                    return null;
                }
            }
        }).otherwise('/');

        $locationProvider.html5Mode(true);
    }
})();