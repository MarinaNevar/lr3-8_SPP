/**
 * Created by Артем on 29.01.2017.
 */
var App = angular.module('blog.controller', []);

App.controller('BlogController',['$scope','$http', function ($scope, $http) {
    var vm = $scope;
    vm.posts = [];
    vm.user = null;
    console.log(123);
    getPosts();

    $http.get('http://localhost:8080/user/current').then(function (response) {
        vm.user = response.data[0];
        console.log(response);
    });

    vm.addPost = function () {
        let post = {
            title:  document.getElementById("newPostTitle").value,
            text: document.getElementById("newPostBody").value,
            authorName: vm.user
        };
        if(vm.user && post.title && post.text) {
            $http.post('http://localhost:8080/add/post', post).then(function () {
                getPosts();
            });
        }
    };

    vm.addComment = function (postId) {
        let comment = {
            postId:  postId,
            text: document.getElementById("newComment").value,
            authorName: vm.user
        };
        if(vm.user && comment.text) {
            $http.post('http://localhost:8080/add/comment', comment).then(function () {
                getPosts();
            });
        }
    };

    function getPosts() {
        $http.get('http://localhost:8080/get/post').then(function (response) {
            vm.posts = response.data;
            console.log(response);
        });
    }
}]);
