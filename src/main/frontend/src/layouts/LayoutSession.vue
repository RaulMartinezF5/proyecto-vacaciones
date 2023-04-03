<script setup>
import { RouterView } from 'vue-router';
import AsideBarComponent from '../components/AsideBarComponent.vue';
</script>
<template>
    <main>
        <div class="aside-space">
            <AsideBarComponent />
        </div>
        <section>
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
        height: 100vh;
    }
}
</style>