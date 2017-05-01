/**
 * Created by Артем Константинович on 10.10.2016.
 */
let App = angular.module('mainView', []);

App.controller('AuthController',['$scope','$http', function ($scope, $http) {
    let vm = $scope;
    vm.user = null;
    vm.isLoggined = false;
    checkUser();

    vm.registerUser = function () {
        let user = getRegUser();
        if (user.name !=='' && user.password !== '') {
            $http.post('http://localhost:8080/registration', user).then(function (response) {
                if (response.data === 200) {
                    vm.isLoggined = !!putUserFromBackToLS();
                    //window.location = "http://localhost:8080/main.html";
                } else {
                    showError('regError', 'User with this name already exist.');
                }
            });
        } else {
            showError('regError', 'Fill in the fields.');
        }
    };

    vm.login = function () {
        let user = getUser();
        if (user.name !=='' && user.password !== '') {
            $http.post('http://localhost:8080/login', user).then(function (response) {
                if(response.data === 200) {
                    checkUser();
                    //window.location.href = "http://localhost:8080/main.html";
                } else {
                    showError('loginError', 'Invalid credentials.');
                }
            });
        } else {
            showError('loginError', 'Fill in the fields.');
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
        element.innerHTML = '<div class="alert alert-danger">' + msg + '</div>';
    }

    function checkUser() {
        let user = window.localStorage.getItem('user');
        $http.get('http://localhost:8080/user/get').then((response) => {
            if (user) {
                if (user === JSON.stringify(response.data)) {
                    vm.user = response.data;
                    vm.isLoggined = true;
                } else {
                    window.localStorage.removeItem('user');
                }
            } else {
                if (response.data) {
                    window.localStorage.setItem('user', JSON.stringify(response.data));
                    vm.user = response.data;
                    vm.isLoggined = true;
                }
            }
        });
    }
    vm.logout = function () {
        $http.get('http://localhost:8080/logOut').then(function () {
            window.localStorage.removeItem('user');
            vm.isLoggined = false;
            vm.user = null;
        });

    }
}]);
