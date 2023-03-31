<script setup>
// import Header from "../components/Header.vue"
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

  <!-- <Header></Header> -->
  <!-- <Login /> -->

  <Header></Header>
  <Login />


</template>

<style lang="scss" scoped>
  
</style>
