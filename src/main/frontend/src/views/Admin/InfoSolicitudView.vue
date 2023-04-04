<script setup>
import ButtonComponent from '../../components/ButtonComponent.vue';
import Header from '../../components/Header.vue';
import rechazada from '../../components/Rechazada.vue';


</script>


<template>
    <Header />


    <div class="mainContainer">
        <div class="responsable">
            <h2 class="Responsable"> Responsable</h2>
            <div class="Button">
                <ButtonComponent :button="'Equipo'" />
                <ButtonComponent :button="'Empleado'" />
            </div>
        </div>

        <div class="rechazada">
            <h1 class="titulo">
                Información de Solicitud
            </h1>
            <div class="usuario">
                <h2 class="solicitud">Solicitud:</h2>
                <rechazada />
            </div>
            <div class="texto">
                <textarea name="fecha" id="fecha" placeholder="Fecha" cols="70" rows="2"></textarea>
                <textarea name="Escribe comentario" placeholder="Comentario" id="comentario" cols=70 rows=5></textarea>
            </div>
        </div>
    </div>
</template>


<style lang="scss" scoped>
.mainContainer {
    display: flex;
    justify-content: space-around;
    margin: 2% 5%;

    .responsable {
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        width: 30%;
        flex-wrap: wrap;
        align-content: center;
    }
    .usuario{
        display: flex;
        flex-direction: row;
    }


    .rechazada {
        width: 65%;


    }
}








// .rechazada {
//     display: flex;
//     flex-direction: row;
//     margin-left: 70px;
//     margin-top: 53px;


// }

// #comentario {
//     display: flex;
//     margin-top: 30px;
//     margin-bottom: 20px;
//     margin-left: 190px;
//     background-color: white;
// }

// #fecha {
//     display: flex;
//     margin-top: 30px;
//     margin-left: 190px;
//     background-color: white;
// }


// .button {
//     margin-top: 20px;
//     color: white;
// }

// .texto {
//     margin-left: 500px;
//     background-color: #D9D9D9;
//     border-style: groove;
// } </style>