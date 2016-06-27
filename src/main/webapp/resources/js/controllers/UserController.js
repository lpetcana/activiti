'use strict';

var UserController = function($scope, $http) {
    $scope.fetchAllUsers(function () {
        $http.get('users/userlist.json').success(function (userList) {
            $scope.users = userList;
        });
    });

    $scope.fetchAllUsers();

};