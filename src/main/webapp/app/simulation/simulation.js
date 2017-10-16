(function() {
    'use strict';

    angular
        .module('servertWikiApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('simulation', {
            abstract: true,
            parent: 'app'
        });
    }
})();
