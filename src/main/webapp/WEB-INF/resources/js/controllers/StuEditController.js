/**
 * Created by roshane on 9/4/17.
 */
(function () {
    angular.module('demoApp')
        .controller('studentEditController', ['$http', '$location', 'csResponse', studentEditController]);

    function studentEditController($http, $location, csResponse) {
        console.log('initializing student edit controller');
        var self = this;
        self.isNewEntry = false;
        if (csResponse) {
            self.currentStudent = csResponse.data.data;
            self.isNewEntry = false;
        } else {
            self.isNewEntry = true;
            self.currentStudent = {
                firstName: "",
                lastName: "",
                address: {
                    number: "",
                    street: "",
                    city: ""
                },
                regNumber: ""
            }
        }

        self.saveChanges = function () {
            console.log(self.currentStudent);
            if (!self.isNewEntry) {
                $http.put('api/students', self.currentStudent)
                    .then(function (response) {
                        console.log(response);
                        $location.path('view/' + self.currentStudent.regNumber);
                    }, function (err) {
                        console.error(err);
                    });
            } else {
                if (self.isValidEntry()) {
                    $http.post('api/students', self.currentStudent)
                        .then(function (response) {
                            console.log(response);
                            $location.path('view/' + response.data.data.regNumber);
                        }, function (err) {
                            console.error(err);
                        });
                } else {
                    alert('Please fill all required fields');
                }
            }
        };

        self.isValidEntry = function () {

            var keys = Object.keys(self.currentStudent);
            for (var i = 0; i < keys.length; i++) {
                if (self.currentStudent[keys[i]].length == 0) {
                    return false;
                }
            }
            return true;
        };
    }
})();