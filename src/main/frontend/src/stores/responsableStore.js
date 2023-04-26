import { useRouter } from 'vue-router';
import { defineStore } from 'pinia';
import Repository from '../apiCall/Repository';
import {useAuthStore} from '../stores/authStore'


export const useResposableStore = defineStore('responsableStore', {
  state: () => ({
    allRequests: [],
    allEmployes: [], 
    temporalUser: {},
    temporalInfoRequest: {}
  }),
  actions: {
    async listAllRequests(document) {
      const repository = new Repository('responsable')

      const service = repository.chooseResponsableService()

      const response = await service.listAllRequestS(document)


      this.allRequests = response
    },
    async listAllEmployes(document) {
      const repository = new Repository('responsable')

      const service = repository.chooseResponsableService()

      const response = await service.listAllEmployes(document)

      const allEmployes = []

      for (const user of response) {

        if (user.profile != undefined && user.contractedUser != 'inactive') {
          allEmployes.push(user)
        }
      }

      this.allEmployes = allEmployes
    },
    async changeStateOfRequest(document, idRequest, state){
      const authStore = useAuthStore()
      const repository = new Repository('responsable')

      const service = repository.chooseResponsableService()

      const response = await service.changeRequestState(document, idRequest, state)

     await this.listAllEmployes(authStore.username)
     await this.listAllRequests(authStore.username)

    },
    findUserOfRequest(idRequest){
      
      for (const employe of this.allEmployes) {
          if(employe.requests.find(request => request.id == idRequest)) this.temporalUser = employe
      }
    },
    async createARequestDetail(idRequest){
      const authStore = useAuthStore()
      await this.listAllEmployes(authStore.username)
      await this.listAllRequests(authStore.username)

      this.findUserOfRequest(idRequest) 

      const temporal ={
        
          name: `${this.temporalUser.profile.firstName} ${this.temporalUser.profile.lastName}`,
          requestUser: this.allRequests.find(request => request.id == idRequest),
          schoolOfUser: 'school',
          userDocument: this.temporalUser.document
      
      }
      this.temporalInfoRequest = temporal
      

    }
  }
});
