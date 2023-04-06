<script setup>

</script>

<template>
   <v-form width="900" class="d-flex flex-row justify-center mb-7">
   <input type="text" v-model="searchTerm">
        <v-btn @click="validate" class="v-btn" id="button">
          BUSCAR
        </v-btn>
</v-form> 

</template>

<style lang="scss" scoped>
@use "../assets/scss/variables.scss" as c;

input{
width: 50vw;
height: 2vw;
border-color: map-get($map: c.$colors, $key: "Black");
border: 2px solid;
margin-right: 1vw;
}

#button{
   background-color: map-get($map: c.$colors, $key: "Orange");
    color:white;
    border-radius: 10px;
    font-weight: 700;  
}

</style>