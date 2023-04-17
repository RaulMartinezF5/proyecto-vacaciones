import { defineStore } from "pinia";
import Repository from "../apiCall/Repository";

export const useUserStore = defineStore('userStore', {
    state:()=> ({
        allUserRequests: []
    }),
    actions:{
        async createRequest(payload, document){
            const repository = new Repository('user')

            const service = repository.chooseUserService()

            const response = await service.makeRequest(payload, document)

            return response
        },
        async viewAllRequests(document){
            const repository = new Repository('user')

            const service = repository.chooseUserService()

            const response = await service.viewAllRequest(document)
            
            this.allUserRequests = response
        }
    }
})