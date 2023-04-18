<script setup>
import CardHistorial from '../../components/CardHistorial.vue';
import { useAdminStore } from '../../stores/adminStore';
import { onBeforeMount } from 'vue';

const adminStore = useAdminStore()

onBeforeMount(() => {
    adminStore.listAllRequests()
})
</script>
<template>
    <h1>HISTORIAL DE SOLICITUDES</h1>
    <div>
        
        <CardHistorial v-for="request of adminStore.allRequests" :request="request" />
    </div>
    
</template>
<style lang="scss" scoped> 
</style>