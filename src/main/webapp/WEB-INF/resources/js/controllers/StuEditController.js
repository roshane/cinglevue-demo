/**
 * Created by roshane on 9/4/17.
 */
(function () {
    angular.module('demoApp')
        .controller('studentEditController', ['$http', '$routeParams', 'csResponse', studentEditcontroller]);

    function studentEditcontroller($http, $routeParams, csResponse) {
        console.log('initializing student edit controller');
        var self = this;
        self.currentStudent = csResponse.data.data;
        console.log(self.currentStudent);

        self.saveChanges = function () {
            console.log(self.currentStudent);
            $http.put('api/students', self.currentStudent)
                .then(function (response) {
                    console.log(response);
                }, function (err) {
                    console.error(err);
                })
        };
    }
})();