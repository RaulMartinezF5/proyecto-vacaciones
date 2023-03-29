<script setup>
import { RouterLink, RouterView } from 'vue-router';
import iconArrowLeft from '@/assets/img/iconArrowLeft.png';

</script>

<template>
    <main>
<nav>
    <button class="button-arrow"><img :src="iconArrowLeft" alt="Flecha botón para retoceder" class="arrow"></button>
    <h2>Historial de solicitudes</h2>
</nav>
</main>
</template>

<style scoped lang="scss">
main{
    display: flex;
    width: 70%;
    
nav{
    width: 70%;
    display: flex;
    justify-content: space-between;
    .button-arrow{

        .arrow{
            
        }
    }   
}}

</style>