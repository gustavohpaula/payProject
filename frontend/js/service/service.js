var app = angular.module('payments');
var baseUrl = "http://localhost:8080";

app.service('paymentService', function ($http) {
    return {
        registerUser: function (user) {
            return $http.post(baseUrl + '/users/create', user);
        },
        listUsers: function () {
            return $http.get(baseUrl + '/users');
        },
        calculatePayment: function (order) {
            return $http.post(baseUrl + '/order/createOrder', order);
        }
    };
});
