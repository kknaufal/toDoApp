'user strict';
(function () {
    angular.module('app').service('toDoService', toDoService);

    toDoService.$inject = ['$http'];
    function toDoService($http) {

        const parentURL = 'http://localhost:8080/';
        var thisObj = this;
        var toDos = [];

        thisObj.addToDo = function (toDoObj) {
            return postOrPut('toDos', toDoObj, 'POST');
        }

        thisObj.update = function (id, toDoObj) {
            return postOrPut('toDos/'+ id, toDoObj, 'PUT');
        }

        thisObj.getAllToDo = function () {
            return getOrDelete('toDos', 'GET');
        }

        thisObj.delete = function (id) {
            return getOrDelete('toDos/'+id, 'DELETE');
        }

        function postOrPut(url, postData, ACTION) {
            console.log('insert Data ', postData);
            return $http({
                method: ACTION,
                url: parentURL + url,
                data: postData,
                dataType: 'application/json',
                timeout: 1 * 10 * 1000,
                headers: { 'Content-Type': 'application/json' }
            });
        }

        function getOrDelete(url, ACTION) {
            return $http({
                method: ACTION,
                url: parentURL + url,
                timeout: 1 * 10 * 1000,
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            });
        }

    }

})();