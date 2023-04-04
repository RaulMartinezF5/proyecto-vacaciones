<script setup>
import { RouterLink, RouterView } from "vue-router";
import FormComponent from "./components/FormComponent.vue";
</script>
<template>
  <main>
    <RouterView />
    <RequestListView/>
    
  </main>
</template> 

<style lang="scss" scoped></style>
