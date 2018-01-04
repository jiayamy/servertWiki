(function() {
    'use strict';

    angular
        .module('servertWikiApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
    	$stateProvider
        .state('servant-level', {
            parent: 'admin',
            url: '/servertType',
            data: {
                authorities: ['ROLE_ADMIN'],
                pageTitle: 'servant-level.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/admin/servant-level/servant-level.html',
                    controller: 'ServantLevelController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('servant-level');
                    return $translate.refresh();
//                }],
//                entity: ['ServantTypeList', function(ServanrtLevelService) {
//                    return ServanrtLevelService.getServantType();
                }]
            }
        });
    }
})();
