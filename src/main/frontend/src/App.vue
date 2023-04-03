<script setup>
import { RouterLink, RouterView } from "vue-router";
import FormComponent from "./components/FormComponent.vue";
import RequestListComponent from "./components/RequestListComponent.vue";

</script>

<template>


  <RouterView />
  <header>
    <nav>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/about">About</RouterLink>
    </nav>
  </header>

  <RequestListComponent/>
</template>

<style lang="scss" scoped></style>
