(function () {
    'use strict';

    angular
        .module('servertWikiApp')
        .factory('ServanrtLevelService', ServanrtLevelService);

    ServanrtLevelService.$inject = ['$resource'];

    function ServanrtLevelService ($resource) {
        var service = $resource('api/servertLevel', {}, {
            'query': {method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'save': { method:'POST' },
            'update': { method:'PUT' },
            'delete':{ method:'DELETE'},
            'getServantType':{
            	url:'api/servertType',
            	method:'GET',
            	isArray:true
            },
            getLevelInfo:{
            	url:'api/getLevelInfo',
            	method:'POST'
            }
        });

        return service;
    }
})();
