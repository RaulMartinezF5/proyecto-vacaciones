import AuthService from "./services/AuthService";
import UserService from "./services/UserService";

export default class Repository{
     api;

    constructor(api){
        this.api = api;
    }

     chooseAuthService() {
        if(this.api === 'auth') return new AuthService()
    }
    
    chooseUserService(){
        if(this.api === 'basic') return new UserService()
    }
}