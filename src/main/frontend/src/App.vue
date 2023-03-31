<script setup>
import { RouterLink, RouterView } from "vue-router";
import FormComponent from "./components/FormComponent.vue";
import CardHistorial from "./components/CardHistorial.vue";

</script>

<template>
   <header>
    <!-- <nav>
      <RouterLink to="/">Home</RouterLink> 
      <RouterLink to="/about">About</RouterLink>
    </nav> -->
  </header>

 <CardHistorial/>

  <main>

  <RouterView />
  </main>
</template> 

<style lang="scss" scoped>

</style>
