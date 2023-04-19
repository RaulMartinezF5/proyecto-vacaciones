import { useRouter } from 'vue-router';
import { defineStore } from 'pinia';
import Repository from '../apiCall/Repository';


export const useAuthStore = defineStore('authStore', {
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

      const service = repository.chooseAuthService();

      const response = await service.login(encodeInfo);

      this.username = response.username;
      this.roleLogin = response.role;
      this.isAuthenticated = true;

      if (this.username != '') return 'auth';
    },
    encoder(username, password) {
      const infoEncode = window.btoa(`${username}:${password}`);
      return infoEncode;
    },
    async logout() {
      const api = new Repository('auth');
      const apiAuth = api.chooseAuthService();
    
      await apiAuth.logout();
    
      this.cleanLoginSession();
    
      const router = useRouter();
      router.push({ name: 'LoginView' });
    },
    
    cleanLoginSession(){
      this.statusLogin = 0
      this.roleLogin = ''
      this.isAuthenticated = false
      this.username = ''
    }
  },
});
