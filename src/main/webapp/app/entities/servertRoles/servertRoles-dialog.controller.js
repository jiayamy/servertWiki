(function() {
    'use strict';

    angular
        .module('servertWikiApp')
        .controller('ServertRolesDialogController',ServertRolesDialogController);

    ServertRolesDialogController.$inject = ['$stateParams', '$uibModalInstance', 'entity', 'ServertRolesService', 'JhiLanguageService'];

    function ServertRolesDialogController ($stateParams, $uibModalInstance, entity, ServertRolesService, JhiLanguageService) {
        var vm = this;

        vm.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
        vm.clear = clear;
        vm.languages = null;
        vm.save = save;
        vm.user = entity;


        JhiLanguageService.getAll().then(function (languages) {
            vm.languages = languages;
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function onSaveSuccess (result) {
            vm.isSaving = false;
            $uibModalInstance.close(result);
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        function save () {
            vm.isSaving = true;
            if (vm.user.id !== null) {
            	ServertRolesService.update(vm.user, onSaveSuccess, onSaveError);
            } else {
            	ServertRolesService.save(vm.user, onSaveSuccess, onSaveError);
            }
        }
    }
})();
