<script setup>
import Login from "../components/Login.vue";
import apiRequest from "../services/ApiCall";
import { ref, onBeforeMount } from "vue";

const api = new apiRequest();
const requests = ref([]);

onBeforeMount( async() => {
  await api.fetchAllRequest();
  requests.value = api.getRequest();
});
</script>

<template>
  <Login />

</template>

<style lang="scss" scoped>
  
</style>
