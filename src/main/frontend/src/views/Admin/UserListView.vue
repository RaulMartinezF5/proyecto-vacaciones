<script setup>
import UserListComponent from '../../components/UserListComponent.vue';
import SearchBar from '../../components/SearchBar.vue';
import { useAdminStore } from '../../stores/adminStore';
import { onBeforeMount } from 'vue';

const adminStore = useAdminStore()

onBeforeMount(async () => {
    await adminStore.listAllUsers()
})
</script>

<template>
    <h1 id="title">Lista de Usuarios</h1>
    <div class="d-flex flex-column">
<SearchBar></SearchBar>

<UserListComponent v-for="user of adminStore.allUsers" :profile="user"></UserListComponent>
</div>
</template>

<style scoped lang="scss">
@use '../../assets/scss/variables.scss' as c;

#title {
    text-align: center;
    margin-top: 2%;
    margin-bottom: 2%;
}

</style>