var app = angular.module('payments');

app.controller('paymentCtrl', function ($scope, paymentService) {
    var self = this;
    self.user = {};
    self.items = [];
    self.freightValue = 0;
    self.discountValue = 0;
    self.orderId = '';
    self.paymentList = [];
    $scope.userList = [];

    function setUser() {
        return {
            fullName: self.user.fullName,
            email: self.user.email,
            document: self.user.document
        };
    }

    self.listUsers = function () {
        paymentService.listUsers().then(function (response) {
            $scope.userList = response.data;
        });
    };
    self.listUsers();

    self.submit = function () {
        var user = setUser();
        paymentService.registerUser(user)
            .then(function (response) {
                self.listUsers();
                self.user = {};
            })
            .catch(function (error) {
                self.message = error.data;
            });
    };

    self.addItem = function () {
        self.items.push({
            name: '',
            value: 0,
            user: ''
        });
    };

    self.removeItem = function (index) {
        self.items.splice(index, 1);
    };

    function setOrder() {
        var order = {
            items: [],
            freightValue: self.freightValue,
            discountValue: self.discountValue
        };

        angular.forEach(self.items, function (item) {
            order.items.push({
                name: item.name,
                value: item.value,
                userId: item.user.id 
            });
        });

        return order;
    }

    self.calculatePayment = function () {
        var order = setOrder();
        paymentService.calculatePayment(order)
            .then(function (response) {
                $scope.paymentList = response.data.paymentList;
            })
            .catch(function (error) {
                self.message = error.data;
            });
    };
});
