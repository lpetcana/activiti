'use strict';

/**
 * CarController
 * @constructor
 */
var TaskController = function(myService, $scope, $http, $location) {
    $scope.fetchTasksList = function() {
        $http.get('tasks/tasklist.json').success(function(taskList){
            $scope.tasks = taskList;
        });
    };


    $scope.changeView = function(task){
        $scope.task = task;
        var earl = '/tasks/' + task.id;
        console.log(earl);
        $location.path(earl);
    };

    console.log('taskController read');


    $scope.task = myService.get();

    $scope.fetchTasksList();
};