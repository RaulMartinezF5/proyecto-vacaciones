<script setup>
import { RouterLink, RouterView } from "vue-router";
import  GrafficasDonut from "./components/GrafficasDonut.vue"
</script>
<template>
  <RouterView />

  <GrafficasDonut/>
</template> 

<style scoped lang="scss">
* {
  font-family: 'Poppins', sans-serif;
}
</style>
