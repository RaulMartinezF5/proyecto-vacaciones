<script setup>
import { onBeforeMount, ref } from 'vue';
import SelectionComponent from '../../components/SelectionComponent.vue';
import { useAdminStore } from '../../stores/adminStore'

const adminStore = useAdminStore()

onBeforeMount(async () => {
    await adminStore.listAllResponsables()
})
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
const responsableDocument = ref('')
const selectEmploye =async (element)=>{
    await adminStore.asignEmployeToResponsable(responsableDocument.value, element)
    await adminStore.listAllEmployesOfResponsable(responsableDocument.value)
}
const selectResponsable =async  (element)=>{
    responsableDocument.value = element
   await adminStore.listAllUserWithoutResponsable(element)
   await adminStore.listAllEmployesOfResponsable(element)
}
</script>
<template>
    <div class="create-teams-wrapper">
        <h1>CREAR EQUIPOS</h1>
        <SelectionComponent :employes-of-responsable="adminStore.employesOfResponsable" :employes="adminStore.allUsersWithoutResponsable" :responsables="adminStore.responsables" @emit-employe="selectEmploye" @emit-responsable="selectResponsable" />
    </div>
</template>
<style lang="scss" scoped>
@use '../../assets/scss/main' as *;
.create-teams-wrapper{
    @include flexDisplay(column, center, center)
}
</style>