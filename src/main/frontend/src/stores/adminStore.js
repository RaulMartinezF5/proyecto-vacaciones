import { defineStore } from "pinia";
import Repository from "../apiCall/Repository";

export const useAdminStore = defineStore('adminStore',{
    state: ()=>({
        allUsers: []
    }),
    actions:{
        async createUser(payload){

            const repository = new Repository('admin')

            const service = repository.chooseAdminService()

            const response = await service.createUser(payload)

            console.log(response.status);
        },
        async listAllUsers(){
            const repository = new Repository('admin')

            const service = repository.chooseAdminService()

            const response = await service.listAllUsers()

            console.log(response.status);

            const data = response.data
            const profiles = []
            for (const user of data) {
                
                if(user.profile != undefined) profiles.push(user.profile)
            }

            this.allUsers = profiles
        },
        randomPassword(){
            const randomPass = Math.random().toString(36).slice(2)

            return randomPass
        },
        encoder(username, password) {
            const infoEncode = window.btoa(`${username}:${password}`);
            return infoEncode;
        }
    }
})