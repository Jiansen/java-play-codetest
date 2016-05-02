(function() {
    'use strict';
    angular.module('app', [])
           .controller('controller', ['$scope', '$http', function CustomerController($scope, $http) {
              $scope.customJsonText= '';
              $scope.sortedCustomers=[];
              $scope.empty = function() {
                $scope.customJsonText= 'type json content OR drop a .json file here';
                $scope.sortedCustomers=[];
              }
              $scope.submit = function() {
                 $scope.sortedCustomers = [];
                 $http.post('/customers', $scope.customJsonText).then(onSuccess, onFail);
              }

              function onSuccess(resp) {
                 $scope.sortedCustomers = resp.data;
              }
              function onFail(resp) {
                 alert('Failure: check input data and Internet connection');
              }
           }])
           /*
           copied and modified from
           http://plnkr.co/edit/D8hu32H0tPYnx64ZjW57?p=preview
           */
           .directive('plkrFileDropZone', [function () {
           		return {
           			restrict: 'EA',
           			scope: {content:'='},
           			link: function (scope, element, attrs) {

                  scope.content = "type json content OR drop a .json file here";

           				var processDragOverOrEnter;

           				processDragOverOrEnter = function (event) {
           					if (event !== null) {
           						event.preventDefault();
           					}
           					event.dataTransfer.effectAllowed = 'copy';
           					return false;
           				};

           				element.bind('dragover', processDragOverOrEnter);
           				element.bind('dragenter', processDragOverOrEnter);
           				element.bind('drop', handleDropEvent);

                   function insertText(loadedFile) {

               			scope.content = loadedFile.target.result;
                     scope.$apply();
                   }

           				function handleDropEvent(event) {

           					if (event !== null) {
           						event.preventDefault();
           					}
           					var reader = new FileReader();
           					reader.onload = insertText;
           					reader.readAsText(event.dataTransfer.files[0]);

           				}
           			}
           		};
           	}]);
})();
