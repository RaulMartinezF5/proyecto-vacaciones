<script setup>
import { RouterLink, RouterView } from "vue-router";
import FormComponent from "./components/FormComponent.vue";

</script>

<template>
  <header>
    <nav>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/about">About</RouterLink>
    </nav>
  </header>

 
  <main>
  
    <RouterView />
  </main>
</template>

<style lang="scss" scoped></style>
