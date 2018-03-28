'user strict';
(function () {

    angular.module('app')
    .controller('MainCtrl', MainCtrl);
    MainCtrl.$inject = ['$scope', 'toDoService']
    
    function MainCtrl($scope, toDoService) {
        var vm = this;

        vm.toDos  = toDoService.getAllToDo();
        console.log(vm.toDos);

        vm.add = function(){
            let toDoObj = {
                value: vm.toDo, 
                isCompleted: false
            }
            toDoService.addToDo(toDoObj);
            console.log('toDo added successfully ');
            vm.toDos = toDoService.getAllToDo();
        }

        vm.delete = function(id){

        }

        
    };
})();