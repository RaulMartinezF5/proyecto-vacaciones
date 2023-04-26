<script setup>
import iconArrowLeft from '@/assets/img/iconArrowLeft.png';
import RequestListComponent from '../../components/RequestListComponent.vue';
import { useRouter } from 'vue-router';
import { useResposableStore } from '../../stores/responsableStore';
import { onBeforeMount,onUpdated } from 'vue';

import { reactive,ref } from 'vue';
import { useRoute } from 'vue-router';


const respoStore = useResposableStore();
const router = useRouter();
const route = useRoute()

onBeforeMount(() =>{
    respoStore.allRequest();
})

const navigateTo = (info) =>{
    router.push({name:'requestDetailsView', params:{ document: info.userDocument,idRequest: info.requestId }})
}

onUpdated(async () =>{
    await respoStore.allRequest()
})


const back = () =>{

    router.push({name: 'requestListView'})
}



</script>

<template>
    <div class="sectionContainer">
        <nav>
            <button class="button-arrow"><img :src="iconArrowLeft" alt="Flecha botón para retoceder" class="arrow" @click="back()"></button>
            <h2>Historial de solicitudes</h2>
        </nav>
        <div class="componentList">
            <ul>
                <li v-for="request of respoStore.allRequest" :key="index">
                    <RequestListComponent   @emit-request-details="navigateTo" :request="request" />
                </li>
            </ul>
        </div>
    </div>
</template>

<style scoped lang="scss">
.sectionContainer {
    margin-top: 2vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    .componentList {
        width: 80%;
        display: flex;
        flex-direction: column;
    }
}

nav {
    width: 75%;
    display: flex;
    justify-content: space-between;    
    text-align: center; 
    h2{
        align-self: center;
    }
}
li {
    list-style: none;

}

</style>



           


                