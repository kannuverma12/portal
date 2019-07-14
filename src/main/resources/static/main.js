var app = angular.module("EmployeeManagement", []);

// Controller Part
app.controller("EmployeeController", function($scope, $http) {

  $scope.employees = [];

  _refreshEmployeeData("name");

  $scope.getAllEmployees = function(sortBy) {
    console.log("sortBy = "+sortBy);
    _refreshEmployeeData(sortBy)
  }

  // HTTP DELETE- delete employee by Id
  // Call: http://localhost:8080/employee/{empId}
  $scope.deleteEmployee = function(employee) {
    $http({
      method: 'DELETE',
      url: '/employee/' + employee.empId
    }).then(_success, _error);
  };

  // get all employees collection
  function _refreshEmployeeData(sortBy) {
    $http({
      method: 'POST',
      url: 'http://localhost:7000/v1/portal/employees?sortBy='+sortBy
      //params : {"sortBy" : sortBy}
    }).then(
      function(res) { // success
        $scope.employees = res.data;
      },
      function(res) { // error
        console.log("Error: " + res.status + " : " + JSON.stringify(res.data));
      }
    );
  }

  function _success(res) {
    _refreshEmployeeData("name");
  }

  function _error(res) {
    var data = res.data;
    var status = res.status;
    var header = res.header;
    var config = res.config;
    alert("Error: " + status + ":" + data);
  }


});
