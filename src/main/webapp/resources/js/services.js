'use strict';

/* Services */

var AppServices = angular.module('AngularSpringApp.services', []);

AppServices.value('version', '0.1');

AppServices.factory("messageService", function($q){
    return {
        getMessage: function(){
            console.log("promise");
            return $q.when("Hello World!");
        }
    };
});

AppServices.factory('myService', function() {
    var savedData = {};
    function set(data) {
        savedData = data;
    }
    function get() {
        return savedData;
    }

    return {
        set: set,
        get: get
    }
});