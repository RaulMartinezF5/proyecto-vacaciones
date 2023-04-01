<script setup>

</script>

<template>
   <v-form>
   <input type="text" v-model="searchTerm">
        <v-btn @click="validate">
          BUSCAR
        </v-btn>
</v-form> 

</template>

<style lang="scss" scoped>
@use "../assets/scss/variables.scss" as c;

input{
width: 80vw;
height: 2vw;
border-color: map-get($map: c.$colors, $key: "Black");
border: 2px solid;
margin-right: 1rem;
margin-left: 5vw;
}
.v-btn{
   width: 10vw;
   background-color:  map-get($map: c.$colors, $key: "Orange");
    color:white;
    border-radius: 10px;
    margin-left: 1rem;
    font-weight: 700;

}

</style>