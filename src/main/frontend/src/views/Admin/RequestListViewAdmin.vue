<script setup>
import CardHistorial from '../../components/CardHistorial.vue';
import { useAdminStore } from '../../stores/adminStore';
import { onBeforeMount } from 'vue';
import { useRouter } from 'vue-router'

const adminStore = useAdminStore()
const router = useRouter()

onBeforeMount(() => {
    adminStore.listAllRequests()
})
const navigateTo = (info)=>{
    router.push({name: 'requestDetailsView', params:{document: info.userDocument, idRequest: info.requestId }})
}
</script>
<template>
    <h1>HISTORIAL DE SOLICITUDES</h1>
    <div> 
        <CardHistorial @emit-request-details="navigateTo" v-for="request of adminStore.allRequests" :request="request" />
    </div>
    
</template>
<style lang="scss" scoped> 
</style>