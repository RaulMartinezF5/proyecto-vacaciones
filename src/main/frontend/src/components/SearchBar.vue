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
      <input v-model="searchQuery" type="text" placeholder="&#128269 Filtrar usuarios..."/>
    </v-form> 

</template>

<style lang="scss" scoped>
@use "../assets/scss/variables.scss" as c;

input{
width: 75%;
height: 3vw;
border-color: map-get($map: c.$colors, $key: "Black");
border: 2px solid;
margin-right: 1vw;
border-radius: 0.5rem;
}

</style>