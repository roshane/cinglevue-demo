/**
 * Created by roshane on 9/4/17.
 */

(function(){
    angular.module('demoApp')
        .controller('studentViewController',['$http',studentViewController]);
    
    function studentViewController($http,$routeParams){
        console.log('initializing studentViewController');
        var self=this;
        
        
        
    }
})();
