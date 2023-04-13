<script setup>
import Request from "../components/Request.vue"
import StateIndicator from '../components/StateIndicator.vue';

const props = defineProps(
    {
        request: {
            type: Object,
        },
    }
)
</script>

<template>

    <div class="wrapper">
        <div class="select">
            <i class=“fa-solid fa-location-dot” style= "color: #000000"></i>
             <!-- <font-awesome-icon icon="fa-solid fa-user-secret" />  -->

            <h2 class="solicitud">Solicitud de dias de: </h2>
            <select class="label fas fa-chevron-down">
                <option value="vacaciones"> vacaciones</option>
                <option value="permisos"> permisos</option>
            </select>

        </div>
        <div class="container">
            <Request class="request" />

        </div>
        <h2 class="listado">Listado de solicitudes</h2>
        <div class="request-wrapper">
                    <p class="startDate">13/04/2023</p>
                    <p class="finishDate">14/04/2023</p>
                    <StateIndicator class="state" :state="'aceptada'" />
         </div> 
    </div>
</template>

<style scoped lang="scss">
@use "../assets/scss/variables.scss" as c;

.wrapper {
    width: 90%;
    margin-left: 4%;
    border-radius: 10px;
    margin-top: 3vh;


    .select {
        display: flex;
        margin-bottom: 3VH;;
        justify-content: center;
        width: 100%;
        align-items: center;
        margin-top: 3vh;
        font-weight: bold;
       
        .solicitud {

        }

        .label {
            margin-left: 10px;
            font-size: 25px;

        }
    }

    .container {
        display: flex;
        justify-content: center;
        flex-direction: column;
        background-color: #D9D9D9;
    }
}

.listado {
    text-align: center;
    margin-top: 3vh;
}
.request-wrapper {
    border: solid 2px;
    border-color: map-get($map: c.$colors, $key: "Orange");
    border-radius: 0.5vw;
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-block: 2vh;
    
    
}

p {
    margin: 2vh;
    font-size: 3vh;
}

.workerName {
    font-size: 4vh;
}

.state{
    margin-right: 2vw;
}
</style>
