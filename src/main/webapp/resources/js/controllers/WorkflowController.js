'use strict';

//angular.module('AngularSpringApp').controller('WorkflowController',['$scope'])
var WorkflowController = function ($scope, $http) {
    $scope.fetchWorkflowList = function () {
        $http.get('workflows/workflowlist.json').success(function (workflowList) {
            $scope.wfs = workflowList;
        });
    };

    $scope.addNewWorkflow = function (newWorkflow) {
        $http.post('workflows/addWorkflow/' + newWorkflow).success(function () {
            $scope.fetchWorkflowList();
        });
        $scope.workflowName = '';
    };

    $scope.removeWorkflow = function (workflow) {
        $http.delete('workflows/removeWorkflow/' + workflow).success(function () {
            $scope.fetchWorkflowList();
        });
    };
    
    $scope.doAction = function () {
        $http.get('workflows/www.json').success(function (workflowList) {
            
        });
    };


    $scope.fetchWorkflowList();
};