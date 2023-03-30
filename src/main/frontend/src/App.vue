<script setup>
import { RouterLink, RouterView } from "vue-router";
import CardHistorial from "./components/CardHistorial.vue";
import LoginView from "./views/LoginView.vue";


</script>

<template>
  <!-- <header>
    <nav>
      <RouterLink to="/">Home</RouterLink> 
      <RouterLink to="/about">About</RouterLink>
    </nav>
  </header> -->
  <CardHistorial/>


  <main>

  <RouterView />
  </main>
</template>

<style lang="scss" scoped>

</style>
