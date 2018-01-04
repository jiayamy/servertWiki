(function() {
    'use strict';

    angular
        .module('servertWikiApp')
        .controller('ServertRolesDialogController',ServertRolesDialogController);

    ServertRolesDialogController.$inject = ['$scope','$stateParams', '$uibModalInstance', 'entity', 'ServertRolesService', 'JhiLanguageService'];

    function ServertRolesDialogController ($scope,$stateParams, $uibModalInstance, entity, ServertRolesService, JhiLanguageService) {
        var vm = this;

        vm.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
        vm.clear = clear;
        vm.languages = null;
        vm.save = save;
        vm.user = entity;
        vm.levelList = [1,2,3,4,5,6,7,8,9];
        vm.toolLevelList = [1,2,3,4,5];
        

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
            vm.servant.type = vm.servant.info.servertType;
            vm.servant.servertId = vm.servant.info.servertId;
            console.log(vm.servant.id);
            if (vm.servant.id != null) {
            	ServertRolesService.update(vm.servant, onSaveSuccess, onSaveError);
            } else {
            	ServertRolesService.save(vm.servant, onSaveSuccess, onSaveError);
            }
        }
        //查询英灵类型
        vm.loadType = loadType;
        vm.servantType = {};
        vm.servantList = {};
        vm.loadType();
        function loadType(){
        	ServertRolesService.getServantType(null,
        			function(result){
        				vm.servantType = result;
        			});
        }
        
        $scope.getServantList = function(){
        	vm.servantList = vm.servant.typeList.servertInfos;
        	
        }
        
        $scope.getServantAHInfo = function(){
        	var level = vm.servant.level;
        	if(level < 1 || level > 100){
        		alert('level should be 1~100');
        		vm.servant.level = "";
        	}
        	var servert = new Object();
        	if(vm.servant.info == null){
        		alert("choose the type of servant firstly");
        	}
        	servert.servertId = vm.servant.info.servertId;
        	servert.level = vm.servant.level;
        	ServertRolesService.getLevelInfo(servert, function(result){
        		vm.servant.atk = result.atk;
        		vm.servant.hp = result.hp;
        	})
        }
    }
})();
