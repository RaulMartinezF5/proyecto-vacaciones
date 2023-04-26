<script setup>
import UserListComponent from '../../components/UserListComponent.vue';
import SearchBar from '../../components/SearchBar.vue';
import { useAdminStore } from '../../stores/adminStore';
import { onBeforeMount, computed, ref} from 'vue';
import { useRouter } from 'vue-router'

const router = useRouter();
const adminStore = useAdminStore();
const searchQuery = ref("");


const filteredInactiveUsers = computed(() => {
    if (!searchQuery.value) return adminStore.allInactiveUsers
    return adminStore.allInactiveUsers.filter((user) =>
        user.firstName.toLowerCase().includes(searchQuery.value.toLowerCase()))
});


const find = (parameter)=>{
    searchQuery.value= parameter;
    console.log(parameter);
}

function navigateToUserInfoView(user) {
    router.push({ name: 'userDetailsView', params: { document: user.id } })
}

onBeforeMount(async () => {
    await adminStore.listAllUsers()
    await adminStore.listAllRawUsers()
})

</script>

<template>
    <h1 id="title">Lista de usuarios de baja</h1>
    <div class="d-flex flex-column">
        <SearchBar v-model=searchQuery @update:query-value="find" />
        <div class="user-list-wrapper">
            <UserListComponent v-for="(user, key) of filteredInactiveUsers" :key="index" :school="adminStore.SchoolOfUser[key]"
                :profile="user" @click="navigateToUserInfoView(user)"></UserListComponent>
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

.user-list-wrapper {

    display: flex;
    flex-direction: column;

    gap: 1vh;
}
</style>