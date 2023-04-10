<script setup>
import iconArrowLeft from '@/assets/img/iconArrowLeft.png';
import RequestListComponent from '../../components/RequestListComponent.vue';
import { reactive } from 'vue';


const FakeList = reactive([
    {
        workerName: "fake",
        date: '16/12/2023 - 1/1/2024',
        days: 7
    },
    {
        workerName: "hola",
        date: '16/12/2023 - 1/1/2024',
        days: 9
    },
    {
        workerName: "fake 4",
        date: '16/12/2023 - 1/1/2024',
        days: 10
    },
    {
        workerName: "fake 5",
        date: '16/12/2023 - 1/1/2024',
        days: 10
    },
    {
        workerName: "fake 6",
        date: '16/12/2023 - 1/1/2024',
        days: 15
    },
    {
        workerName: "fake 7",
        date: '16/12/2023 - 1/1/2024',
        days: 15
    },
]);

</script>

<template>
    <div class="sectionContainer">
        <nav>
            <button class="button-arrow"><img :src="iconArrowLeft" alt="Flecha botón para retoceder" class="arrow"></button>
            <h2>Historial de solicitudes</h2>
        </nav>
        <div class="componentList">
            <ul>
                <li v-for="(row, index) of FakeList" :key="index">
                    <RequestListComponent :request="row"/>
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