<script setup>
import { RouterLink, RouterView } from 'vue-router';
import iconArrowLeft from '@/assets/img/iconArrowLeft.png';
import RequestListComponent from '../../components/RequestListComponent.vue';
</script>

<template>
    <div class="sectionContainer">
<nav>
    <button class="button-arrow"><img :src="iconArrowLeft" alt="Flecha botón para retoceder" class="arrow"></button>
    <h2>Historial de solicitudes</h2>
</nav>
<div class="componentList">
<RequestListComponent></RequestListComponent>
</div>
</div>
</template>

<style scoped lang="scss">
.sectionContainer {
    display: flex;
    width: 70%;
    flex-direction: column;
    
nav{
    width: 100%;
    display: flex;
    justify-content: space-between;
  
}
.componentList{
    display: flex;
    width: 80%;
}
}

</style>