(function() {
    'use strict';

    angular
        .module('servertWikiApp')
        .controller('ServantLevelController', ServantLevelController);

    ServantLevelController.$inject = ['$scope','$stateParams',  'ServanrtLevelService', 'JhiLanguageService'];

    function ServantLevelController($scope,$stateParams, ServanrtLevelService, JhiLanguageService) {
    	var vm = this;

        vm.authorities = ['ROLE_USER', 'ROLE_ADMIN'];
        vm.clear = clear;
        vm.languages = null;
        vm.save = save;
        

        JhiLanguageService.getAll().then(function (languages) {
            vm.languages = languages;
        });

        function clear () {
        }

        function onSaveSuccess (result) {
            vm.isSaving = false;
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
        	ServanrtLevelService.getServantType(null,
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
