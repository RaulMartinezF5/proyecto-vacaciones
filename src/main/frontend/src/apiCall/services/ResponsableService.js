export default class ResponsableService{
    baseUrl
    constructor(){
        this.baseUrl = 'http://localhost:8080/api/responsable'
    }

    async changeRequestState(document, idRequest, state){
        axios.defaults.withCredentials = true
        const response = axios.put(this.baseUrl + `/request/${idRequest}/user/${document}/${state}`)

        const getStatus = (await response).status

        return getStatus
    }
}