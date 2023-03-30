<script setup>
import { RouterLink, RouterView } from "vue-router";
import Pendiente from "./components/pendiente.vue";

</script>

<template>
  <header>
    <nav>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/about">About</RouterLink>
    </nav>
  </header>
  <Pendiente />

  <main>

    <RouterView />
  </main>
</template>

<style lang="scss" scoped></style>
