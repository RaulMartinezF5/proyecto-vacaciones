<script setup>
import UserListComponent from '../../components/UserListComponent.vue';
import SearchBar from '../../components/SearchBar.vue';
import { useAdminStore } from '../../stores/adminStore';
import { onBeforeMount, computed , ref , onMounted } from 'vue';

const adminStore = useAdminStore();

onBeforeMount(async () => {
    await adminStore.listAllUsers()
});

const searchQuery = ref("") ;
const users = adminStore.allUsers ;

const filteredUsers = computed(() => {
  if (!searchQuery.value) return users
  console.log("entra en la computada");
  return users.filter(console.log("entra en la computada 2"),user => 
  user['name'].toLowerCase().includes(searchQuery.value.toLowerCase()))

});
</script>

<template>

    <h1 id="title">Lista de Usuarios</h1>
    <div class="d-flex flex-column">
        <SearchBar v-model="searchQuery"/>
        <div class="user-list-wrapper">
            <UserListComponent v-for="(user, key) of filteredUsers" :key="index"
                :school="adminStore.SchoolOfUser[key]" :profile="user"></UserListComponent>
        </div>
    </div>
</template>

<style scoped lang="scss">
@use '../../assets/scss/variables.scss' as c;

#title {
    text-align: center;
    margin-top: 2%;
    margin-bottom: 2%;
}
.user-list-wrapper{

    display: flex;
    flex-direction: column;
    
    gap: 1vh;
}
</style>