/**
 * Created by Артем Константинович on 10.10.2016.
 */
let App = angular.module('mainView', []);

App.controller('AuthController',['$scope','$http', function ($scope, $http) {
    let vm = $scope;

    vm.registerUser = function () {
        user = getRegUser();
        if (user.name !='' && user.password != '') {
            $http.post('http://localhost:8080/registration', getRegUser()).then(function (response) {
                if (response.data === 200) {
                    window.location = "http://localhost:8080/main.html";
                } else {
                    showError('regError', 'User with this name already exist.');
                }
            });
        } else {
            showError('regError', 'Fill in the fields.');
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

    function getRegUser() {
        return {
            name: getInputValue('userRegName'),
            password: getInputValue('userRegPassword')
        }
    }

    function getInputValue(input) {
        return document.getElementById(input).value
    }

    function showError(id, msg) {
        element = document.getElementById(id);
        element.innerHTML = '<div class="alert alert-danger"><strong>Danger!</strong> ' + msg + '</div>';
    }
}]);
