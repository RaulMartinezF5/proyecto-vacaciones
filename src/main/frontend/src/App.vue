<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>
<template>
   <header>
    <!-- <nav>
      <RouterLink to="/">Home</RouterLink> 
  <header>
    <nav>
      <RouterLink to="/">Home</RouterLink>

      <RouterLink to="/about">About</RouterLink>
    </nav> -->
  </header>


 <!-- <CardHistorial/> -->


  <main>
  
    <RouterView />

</template> 

<style scoped lang="scss">

*{
    font-family: 'Poppins', sans-serif; 
}

</style>
