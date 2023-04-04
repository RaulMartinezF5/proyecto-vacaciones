<script setup>
import { RouterLink, RouterView } from 'vue-router';
import Login from "../components/Login.vue";
import { defineProps } from "vue";

</script>

<template>
<router-link :to="{name:'userListView'}"><button>userList</button></router-link>
<Login />

</template>

<style lang="scss" scoped>
  
</style>
