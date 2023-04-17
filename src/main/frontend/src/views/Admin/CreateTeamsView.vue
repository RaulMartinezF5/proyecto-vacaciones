<script setup>
import SelectionComponent from '../../components/SelectionComponent.vue';
const responsables = [
    'Cristina',
    'Rebeca',
    'Ana'
]
const employes = [
    'Giaco',
    'Maria',
    'Crsitina 2'
]
</script>
<template>
    <div class="create-teams-wrapper">
        <h1>CREATE TEAMS</h1>
        <SelectionComponent :employes="employes" :responsables="responsables"/>
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/scss/main' as *;
.create-teams-wrapper{
    @include flexDisplay(column, center, center)
}
</style>