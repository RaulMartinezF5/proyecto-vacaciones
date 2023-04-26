import AdminService from "./services/AdminService";
import AuthService from "./services/AuthService";
import UserService from "./services/UserService";
import ResponsableService from "./services/ResponsableService"
export default class Repository{
     api;

    constructor(api){
        this.api = api;
    }

     chooseAuthService() {
        if(this.api === 'auth') return new AuthService()
    }
    
    chooseUserService(){
        if(this.api === 'user') return new UserService()
    }

    chooseAdminService(){
        if(this.api === 'admin') return new AdminService()
    }

    chooseResponsableService(){
        if(this.api === 'responsable') return new ResponsableService()
    }
}