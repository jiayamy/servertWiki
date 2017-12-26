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
        vm.intList = [1,2,3,4,5,6,7,8,9];
        

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
            	ServertRolesService.update(vm.servant, onSaveSuccess, onSaveError);
            } else {
            	ServertRolesService.save(vm.servant, onSaveSuccess, onSaveError);
            }
        }
        
        vm.loadType = loadType;
        vm.servantType = {};
        vm.loadType();
        function loadType(){
        	ServertRolesService.getServantType(null,
        			function(result){
        				vm.servantType = result;
        			});
        }
    }
})();
