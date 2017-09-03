/**
 * Created by roshane on 9/4/17.
 */

(function(){
    angular.module('demoApp')
        .controller('studentViewController', ['csResponse', studentViewController]);

    function studentViewController(csResponse) {
        console.log('initializing studentViewController');
        var self=this;
        self.currentStudent = csResponse.data.data; 
    }
})();
