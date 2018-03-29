'user strict';
(function () {

    angular.module('app')
        .controller('MainCtrl', MainCtrl);
    MainCtrl.$inject = ['$scope', 'toDoService']

    function MainCtrl($scope, toDoService) {
        var vm = this;
        //Retrieve all data
        getAllToDo();
        console.log(vm.toDos);

        vm.add = function () {
            let toDoObj = {
                value: vm.toDo,
                completed: false
            }
            toDoService.addToDo(toDoObj).then(function (data) {
                console.log('toDo added successfully ', data);
                vm.toDo = '';
                getAllToDo();
            }, function (error) {
                console.log('toDo add Error ', error);
            }
            );
        }

        function getAllToDo() {
            toDoService.getAllToDo().then(function (data) {
                console.log('get all success ', data);
                vm.toDos = data.data;
            }, function (error) {
                console.log('Error from getAllTodo');
            });
        }

        vm.delete = function (id) {
            toDoService.delete(id).then(function (data) {
                console.log('Delete success ', data);
                getAllToDo();
            }, function (error) {
                console.log('Error from DELETE');
            });
        }

        vm.update = function (id, updateItem) {
            toDoService.update(id, updateItem).then(function (data) {
                console.log('update success ', data);
                getAllToDo();
            }, function (error) {
                console.log('Error from update');
            });
        }


    };
})();