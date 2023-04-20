<script setup>
	import { ref, watch } from "vue";


const props = defineProps({
  queryValue: String,
});

const emit = defineEmits(["update:queryValue"]);

const searchQuery = ref(props.queryValue);
watch(searchQuery, newValue => {
  emit("update:queryValue", newValue);
});

</script>

<template>
    <v-form width="900" class="d-flex flex-row justify-center mb-7">
        <v-text-field v-model="searchTerm" density="compact" variant="solo" label="Buscar usuario"
          append-inner-icon="mdi-magnify" ></v-text-field>
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

#searchButton{
   background-color: map-get($map: c.$colors, $key: "Orange");
    color:white;
    border-radius: 10px;
    font-weight: 700;  
}

</style>