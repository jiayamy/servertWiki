(function () {
    'use strict';

    angular
        .module('servertWikiApp')
        .factory('ServertRolesService', ServertRolesService);

    ServertRolesService.$inject = ['$resource'];

    function ServertRolesService ($resource) {
        var service = $resource('api/servertRoles', {}, {
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
