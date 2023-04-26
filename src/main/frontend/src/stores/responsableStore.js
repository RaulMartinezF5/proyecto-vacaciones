import { useRouter } from 'vue-router';
import { defineStore } from 'pinia';
import Repository from '../apiCall/Repository';


export const useResposableStore = defineStore('responsableStore', {
  state: () => ({
      
      allRequest: [],
}),
actions: {
    async allRequest(idResponsable){
        const repository = new Repository('responsable')

        const service = repository.chooseResponsableService()

        const response = await service.allRequest(idResponsable)

        this.allRequest = response
    }
  },
});
