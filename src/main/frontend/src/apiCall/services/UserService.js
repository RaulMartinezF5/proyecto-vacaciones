import axios from "axios";

export default class UserService {
  constructor() {
    this.baseUrl = 'http://localhost:8080/api/request';
  }

  async userInfo(username) {
    const response = axios.get(this.baseUrl + `/user/${username}`, { withCredentials: true });

    const getBody = await response;

    console.log(getBody.data);
    console.log(getBody.status);

    return getBody.data;
  }

  async EditUserInfo(username, info) {
    axios.defaults.withCredentials = true;
    const response = axios.put(this.baseUrl + `/user/edit/${username}`, info);

    const getStatus = (await response).status;

    return getStatus;
  }
}
