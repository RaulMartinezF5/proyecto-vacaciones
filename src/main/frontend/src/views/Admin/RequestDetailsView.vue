<script setup>
import RequestDescription from '../../components/RequestDescription.vue';
import iconArrowLeft from '@/assets/img/iconArrowLeft.png';
import { useRouter } from 'vue-router';

const router = useRouter()

const backTo = ()=>{
    router.push({name: 'requestListViewAdmin'})
}

</script>


<template>
    <div class="mainContainer">
        <div class="microheader">
                <button class="button-arrow"><img :src="iconArrowLeft" alt="Flecha botón para retoceder"
                        class="arrow" @click="backTo()"></button>
                <h1 class="titulo">
                    INFORMACIÓN DE SOLICITUD
                </h1>
            </div>
        <RequestDescription/>
    </div>
</template>


<style lang="scss" scoped>

.microheader 
{
            display: flex;
            flex-direction: row;
            margin-block: 2%;
}
</style>







