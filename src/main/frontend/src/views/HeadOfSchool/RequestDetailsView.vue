<script setup>
import RequestDescription from '../../components/RequestDescription.vue';
import iconArrowLeft from '@/assets/img/iconArrowLeft.png';
import { onBeforeMount, onUpdated, reactive, ref } from 'vue';
import { useRouter } from 'vue-router';
import { useResposableStore } from '../../stores/responsableStore';
import { useRoute } from 'vue-router';
import { useAuthStore } from '../../stores/authStore';

const respoStore = useResposableStore()
const authStore = useAuthStore()
const route = useRoute()
const userDocument = route.params.document
const idRequest = route.params.idRequest
const router = useRouter()
let OneRequest = reactive({})


onBeforeMount(async () => {
    await respoStore.listAllRequests(authStore.username)
  await respoStore.createARequestDetail(route.params.idRequest)
})


const acceptRequest = async () => {
    await respoStore.changeStateOfRequest(userDocument, idRequest, 'Accept')
    await  respoStore.createARequestDetail(route.params.idRequest)
}

const rejectRequest = async () =>{
    await respoStore.changeStateOfRequest(userDocument, idRequest, 'Reject')
    await respoStore.createARequestDetail(route.params.idRequest)
}


const backTo = () => {
    router.push({ name: 'requestListView' })
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
            <RequestDescription :request="respoStore.temporalInfoRequest" @accept-emit="acceptRequest" @reject-emit="rejectRequest()" />

        </div>

    </div>
</template>

<style scoped lang="scss">
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