import axios from "axios";

export default class AdminService {
    constructor() {
        this.baseUrl = 'http://localhost:8080/api/admin';
    }

    async createUser(payload) {
        axios.defaults.withCredentials = true
        const response = axios.post(this.baseUrl + `/createUser`, payload)

        const getBody = await response

        return getBody
    }
    async fireUser(document){
        axios.defaults.withCredentials == true
        const response = axios.put(this.baseUrl + `/fireUser/${document}`)

        const getBody = await response;
    }
    async restoreUser(document){
        axios.defaults.withCredentials == true
        const response = axios.put(this.baseUrl + `/restoreUser/${document}`)

        const getBody = await response;
    }
    async editUser(payload, document){
        axios.defaults.withCredentials = true
        const response = axios.put(this.baseUrl + `/modifyUser/${document}`, payload)

        const getBody = await response

        return getBody
    }
    async listAllUsers() {
        axios.defaults.withCredentials = true
        const response = axios.get(this.baseUrl + `/allusers`)

        const getBody = await response

        return getBody
    }
    async schoolOfUser(document){
        axios.defaults.withCredentials = true
        const response = axios.get(this.baseUrl + `/user/${document}/School`)

        const getSchool = (await response).data.school

        return getSchool
    }

    async changeRequestState(document, idRequest, state){
        axios.defaults.withCredentials = true
        const response = axios.put('http://localhost:8080/api/' + `responsable/request/${idRequest}/user/${document}/${state}`)

        const getStatus = (await response).status

        return getStatus
    }

    async listAllResponsables(){
        axios.defaults.withCredentials = true
        const response = axios.get(this.baseUrl + `/allResponsables`)

        const getBody = (await response).data

        return getBody
    }

    async listAllUserWithoutSelected(document){
        axios.defaults.withCredentials = true
        const response = axios.get(this.baseUrl + `/allUsersWithoutActualUser/${document}`)

        const getBody = (await response).data

        return getBody
    }

    async asignEmployeToResponsable(documentResponsable,  documentEmploye){
        axios.defaults.withCredentials = true
        const response = axios.put(this.baseUrl + `/createTeams/responsable/${documentResponsable}/employe/${documentEmploye}`)

        const getStatus = (await response).status

        return getStatus
    }

    async listAllEmployesOfResponsable(document){
        axios.defaults.withCredentials = true
        const response = axios.get(this.baseUrl + `/responsable/${document}/allEmployes`)

        const getBody = (await response).data

        return getBody;
    }
}