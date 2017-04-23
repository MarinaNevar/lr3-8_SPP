/**
 * Created by Артем Константинович on 10.10.2016.
 */
let App = angular.module('mainView', []);

App.controller('AuthController',['$scope','$http', function ($scope, $http) {
    let vm = $scope;

    vm.registerUser = function () {
        if (getUser()) {
            $http.post('http://localhost:8080/registration', getUser()).then(function (response) {
                if (response.data === 200) {
                    window.location = "http://localhost:8080/blog.html";
                } else {
                    alert("user with this name already exist");
                }
            });
        } else {
            alert("Enter username");
        }
    };

    vm.login = function () {
        if (getUser()) {
            $http.post('http://localhost:8080/login', getUser()).then(function (response) {
                if(response.data === 200) {
                    window.location.href = "http://localhost:8080/blog.html";
                } else {
                    alert("we can't find user with this name");
                }
            });
        } else {
            alert("Enter username");
        }
    };

    function getUser() {
        return {
            name: getInputValue('userName'),
            password: getInputValue('userPassword')
        }
    }


    function getInputValue(input) {
        return document.getElementById(input).value
    }
}]);
