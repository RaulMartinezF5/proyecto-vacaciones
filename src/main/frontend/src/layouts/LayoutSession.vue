<script setup>
import { RouterView } from 'vue-router';
import AsideBarComponent from '../components/AsideBarComponent.vue';
import { useRouter } from 'vue-router';
import Header from '../components/Header.vue'

const router = useRouter()

const navigate = (navigateTo)=>{

    router.push({name: navigateTo})
}
</script>
<template>
    <Header></Header>
    <main>
        <div class="aside-space">
            <AsideBarComponent @navigate-to="navigate" />
        </div>
        <section class="views-wrapper">
            <RouterView />
        </section>
    </main>
</template>
<style lang="scss" scoped>
main {
    width: 100%;
    display: flex;
    flex-direction: row;

    .aside-space {
        width: 20%;
        height: 90vh;
    }
    .views-wrapper{
        width: 80%;
    }
}
</style>