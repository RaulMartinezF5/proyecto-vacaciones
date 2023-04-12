<script setup>
import Request from "../components/Request.vue"
</script>

<template>
    <div class="wrapper">
        <div class="select">
            <h2 class="solicitud">Solicitud de dias de: </h2>
            <!-- <v-select class="label" label="" :items="['vacaciones', 'permisos']" variant="solo"></v-select> -->
            <select class="label">
                <option value="vacaciones"><i class="fas fa-chevron-down"></i> vacaciones</option>
                <option value="permisos"><i class="fas fa-chevron-down"></i> permisos</option>
            </select>

        </div>
        <div class="container">
            <Request class="request" />

        </div>
    </div>
    <h2 class="listado">Listado de solicitudes</h2>
    <div>

    </div>
</template>

<style scoped lang="scss">
.wrapper {
    width: 90%;
    margin-left: 4%;
    border-radius: 10px;
    margin-top: 3vh;


    .select {
        display: flex;
  
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


        .request {}
    }
}

.listado {
    text-align: center;
    margin-top: 3vh;
}
</style>
