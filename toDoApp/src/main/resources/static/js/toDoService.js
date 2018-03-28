'user strict';
(function () {
   angular.module('app').service('toDoService', toDoService);

   toDoService.$inject = ['$http'];
   function toDoService($http){
       var thisObj = this;
       var toDos = [];

       thisObj.addToDo = function(toDoObj){
           
        toDos.push(toDoObj);

        console.log('toDoService : ', toDos);
       }

       thisObj.getAllToDo = function(){
           return toDos;
       }

   }

})();