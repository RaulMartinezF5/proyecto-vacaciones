<script setup>
import Header from '../../components/Header.vue';

</script>

<template>
<Header/>
<h1>CREAR USUARIO</h1>
<div class="container">
    <v-form>
   <input type="text" v-model="searchTerm">
   <input type="text" v-model="searchTerm">
   <input type="text" v-model="searchTerm">
   <input type="text" v-model="searchTerm">
   <input type="text" v-model="searchTerm">
   <input type="text" v-model="searchTerm">
   <input type="text" v-model="searchTerm">
   <input type="text" v-model="searchTerm">
   <input type="text" v-model="searchTerm">
   <input type="text" v-model="searchTerm">

</v-form> 
</div>
</template>

<style scoped lang="scss">
h1{
    text-align: center;
    margin-top: 2.5vw;
   
}

.container {
  max-width: 600px; /* Ajusta el ancho del contenedor según tus necesidades */
  margin: 0 auto; /* Centra el contenedor horizontalmente */
}
</style>