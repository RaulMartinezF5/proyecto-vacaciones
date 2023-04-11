import { defineStore } from 'pinia';
import apiRequest from '../services/ApiCall';

export const encryptionStore = defineStore('encryptionStore', {
  state: () => ({
    statusLogin: 0,
    roleLogin: '',
    isAuthenticated: false,
    username: '',
  }),
  actions: {
    async login(username, password) {
      const encodeInfo = this.encoder(username, password);

      const repository = new Repository('auth');

      const service = repository.chooseApi();

      const response = await service?.login(encodeInfo);

      this.username = response.username;
      this.roleLogin = response.role;
      this.isAuthenticated = true;

      if (this.username != '') return 'auth';
    },
    encoder(username, password) {
      const infoEncode = window.btoa(`${username}:${password}`);
      return infoEncode;
    },
  },
});
