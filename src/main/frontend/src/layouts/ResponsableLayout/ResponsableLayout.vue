<script setup>
import { RouterView } from 'vue-router';
</script>
<template>
    <!-- aquí deben ir nuestros componentes que se repitan en el responsable -->
<main>
<RouterView/>
</main>
</template>
<style lang="scss" scoped>
main{
    display: flex;
    width: 100%;
}
</style>