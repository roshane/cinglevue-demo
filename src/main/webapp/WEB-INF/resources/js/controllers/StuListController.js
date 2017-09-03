/**
 * Created by roshane on 9/3/17.
 */
(function () {

    angular.module('demoApp')
        .controller("studentListController", ['$http', studentListController]);

    function studentListController($http) {
        console.info('initializing studentController');
        var self = this;
        self.students = null;
        self.error = null;
        self.deleteItem = null;
        self.searchTxt = null;

        self.loadStudents = function () {
            console.log('loading students');
            var url = '';
            if (self.isNullOrEmpty(self.searchTxt)) {
                url = 'api/students/';
            } else {
                url = 'api/students/firstNameLike/' + self.searchTxt;
            }

            $http.get(url)
                .then(function (response) {
                    self.students = response.data.data.content;
                }, function (err) {
                    console.error(err);
                });
        };

        self.setDeleteItem = function (student) {
            console.log('delete student ', student);
            self.deleteItem = student;
        };

        self.clearDeleteItem = function () {
            self.deleteItem = null;
        };

        self.deleteStudent = function () {
            if (self.deleteItem) {
                $http.delete('api/students/' + self.deleteItem.regNumber)
                    .then(function (response) {
                        if (self.students.length) {
                            var i = self.students.indexOf(self.deleteItem);
                            self.students.splice(i, 1);
                            self.deleteItem = null;
                        }
                    }, function (err) {
                        console.error(err);
                    });
            }
        };

        self.clearData = function () {
            self.deleteItem = null;
            self.students = null;
            self.error = null;
        };

        self.isNullOrEmpty = function (str) {
            return str == null || str.length == 0;
        };
    }
})();
