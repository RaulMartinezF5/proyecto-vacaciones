export default class ResponsableService{
    baseUrl
    constructor(){
        this.baseUrl = 'http://localhost:8080/api/responsable'
    }

     async allRequest(idResponsable){
        const response = axios.get(this.baseUrl + `/allTeamRequests/${idResponsable}` , {withCredentials: true});
        const getBody = await response;
        return getBody.data;
    
    
    }
}

       

