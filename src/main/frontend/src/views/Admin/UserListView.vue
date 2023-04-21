<script setup>
import UserListComponent from '../../components/UserListComponent.vue';
import SearchBar from '../../components/SearchBar.vue';
import { useAdminStore } from '../../stores/adminStore';
import { onBeforeMount } from 'vue';
import { useRouter } from 'vue-router'
const adminStore = useAdminStore()

onBeforeMount(async () => {
    await adminStore.listAllUsers()
})

const router = useRouter()

function navigateToUserInfoView(user) {
  router.push({ name: 'userDetailsView', params: { document: user.id }})
}
</script>

<template>

    <h1 id="title">Lista de Usuarios</h1>
    <div class="d-flex flex-column">
        <SearchBar></SearchBar>
        <div class="user-list-wrapper">
            <UserListComponent v-for="(user, key) of adminStore.allUsers" :key="index"
                :school="adminStore.SchoolOfUser[key]" :profile="user" @click="navigateToUserInfoView(user)"></UserListComponent>
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