(function() {
    'use strict';

    angular
        .module('servertWikiApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('activities', {
            abstract: true,
            parent: 'app'
        });
    }
})();
