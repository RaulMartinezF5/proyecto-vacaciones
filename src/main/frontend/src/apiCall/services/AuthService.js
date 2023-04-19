import axios from "axios";


export default class AuthService {
  constructor() {
    this.baseUrl = 'http://localhost:8080/api';
  }

  async register(registerInfo) {
    const json = {
      'usernameAndPass': registerInfo.getUserPassword,
      'emailAndPass': registerInfo.getEmail
    };

    const response = axios.post(this.baseUrl + '/register', json);

    const getBody = await response;

    return getBody;
  }

  async login(loginInfo) {
    const response = await axios.get(`${this.baseUrl}/login`, {
      headers: {
        Authorization: `Basic ${loginInfo}`
      },
      withCredentials: true
    });

    const getBody = response;

    console.log(response.data);

    return getBody.data;
  }

  async logout() {
    const response = await axios.get(`${this.baseUrl}/logout`, {
      withCredentials: true
    });
  
    const getBody = response;
  
    console.log(response.status);
  
    return getBody.data;
  }

}

