'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/cars', {
        templateUrl: 'cars/layout',
        controller: CarController
    });

    $routeProvider.when('/workflows', {
        templateUrl: 'workflows/layout',
        controller: WorkflowController
    });

    $routeProvider.when('/trains', {
        templateUrl: 'trains/layout',
        controller: TrainController
    });

    $routeProvider.when('/tasks', {
        templateUrl: 'tasks/layout',
        controller: TaskController
    });

    $routeProvider.when('/tasks/:taskId', {
        templateUrl: 'tasks/taskEdit',
        controller: TaskController,
        resolve: {
            task: function( myService ,$route) {
                var taskId = $route.current.params.taskId;
                myService.set(taskId);
                console.log('been here, which is more than ok!');
                console.log(taskId);
                

            }

        }
    });


    
    $routeProvider.when('/railwaystations', {
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });

    $routeProvider.when('/users', {
        templateUrl: 'users/layout',
        controller: UserController
    });
    
    $routeProvider.otherwise({redirectTo: '/workflows'});
}]);
