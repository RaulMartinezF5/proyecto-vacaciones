<script setup>
import RequestDescription from '../../components/RequestDescription.vue';
import iconArrowLeft from '@/assets/img/iconArrowLeft.png';
import { onBeforeMount, reactive } from 'vue';
import { useRouter } from 'vue-router';
import { useAdminStore } from '../../stores/adminStore';
import { useRoute } from 'vue-router';

const adminStore = useAdminStore()
const route = useRoute()
const userDocument = route.params.document
const idRequest = route.params.idRequest
const router = useRouter()
let OneRequest = reactive({})

onBeforeMount(() => {

    OneRequest = adminStore.infoRequest(idRequest)
})

const acceptRequest = async () => {
    await adminStore.changeStateOfRequest(userDocument, idRequest, 'Accept')
    OneRequest = adminStore.infoRequest(idRequest)
    
}

const rejectRequest = async () => {
    await adminStore.changeStateOfRequest(userDocument, idRequest, 'Reject')
    OneRequest = adminStore.infoRequest(idRequest)
}



const backTo = () => {
    router.push({ name: 'requestListViewAdmin' })
}

</script>


<template>
    <div class="mainContainer">
        <div class="microheader">
            <button class="button-arrow"><img :src="iconArrowLeft" alt="Flecha botón para retoceder" class="arrow"
                    @click="backTo()"></button>
            <h1 class="titulo">
                INFORMACIÓN DE SOLICITUD
            </h1>
        </div>
        <div class="request-space">
            <RequestDescription :request="adminStore.IndividualRequest" @accept-emit="acceptRequest" @reject-emit="rejectRequest()"/>
        </div>
    </div>
</template>


<style lang="scss" scoped>
@use '../../assets/scss/main' as *;

.mainContainer {
    width: 100%;
    @include flexDisplay(column, center, center);

    .microheader {
        width: 100%;
        @include gridDisplay(1,3);
        margin-top: 1vh;
        margin-bottom: 1vh;

        .button-arrow{
            @include flexDisplay(row, flex-start, center)
        }
    }
    .request-space{
        width: 90%;
        @include flexDisplay(row, center, center);
    }
}
</style>







