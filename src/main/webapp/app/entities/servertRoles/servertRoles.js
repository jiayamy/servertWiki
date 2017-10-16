(function() {
    'use strict';

    angular
        .module('servertWikiApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('servertRoles', {
            parent: 'entity',
            url: '/user-management?page&sort',
            data: {
                authorities: ['ROLE_ADMIN'],
                pageTitle: 'userManagement.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/admin/user-management/user-management.html',
                    controller: 'UserManagementController',
                    controllerAs: 'vm'
                }
            },            params: {
                page: {
                    value: '1',
                    squash: true
                },
                sort: {
                    value: 'id,asc',
                    squash: true
                }
            },
            resolve: {
                pagingParams: ['$stateParams', 'PaginationUtil', function ($stateParams, PaginationUtil) {
                    return {
                        page: PaginationUtil.parsePage($stateParams.page),
                        sort: $stateParams.sort,
                        predicate: PaginationUtil.parsePredicate($stateParams.sort),
                        ascending: PaginationUtil.parseAscending($stateParams.sort)
                    };
                }],
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('user-management');
                    return $translate.refresh();
                }]

            }        
        });
    }
})();
