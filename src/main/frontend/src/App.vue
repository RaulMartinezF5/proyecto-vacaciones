<script setup>
import { RouterLink, RouterView } from "vue-router";
import RequestListView from "./views/HeadOfSchool/RequestListView.vue";
import RequestListViewAdmin from "./views/Admin/RequestListViewAdmin.vue";
</script>
<template>
    <RequestListViewAdmin/>
   
</template> 

<style lang="scss" scoped>
@use './assets/scss/variables.scss' as c;
*{
  font-family: 'Poppins', sans-serif;
}

</style>
