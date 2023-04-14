<script setup>
import iconArrowLeft from '@/assets/img/iconArrowLeft.png';
import ButtonComponent from './ButtonComponent.vue';
import StateIndicator from './StateIndicator.vue';


const fake = {
    name: "iyan",
    nameschool: "AST",
    date: "2015-12-16",
    description: "Lorem Ips dolor sit am",
    days: 5,
    checked: "Raul",
    state: null,
};


</script>
<template>
    <div class="mainContainer">
        <div>
            <div class="microheader">
                <button class="button-arrow"><img :src="iconArrowLeft" alt="Flecha botón para retoceder"
                        class="arrow"></button>
                <h1 class="titulo">
                    INFORMACIÓN DE SOLICITUD
                </h1>
            </div>
            <div class="usuario">
                <h2 class="empleado"> Natalia Rojo</h2>
                <h2 class="solicitud">Solicitud:
                    <StateIndicator />
                </h2>

            </div>

            <div class="texto">
                <p id="fecha"> pepon </p>
                <p id="comentario"> Lorem ipsum dolor sit Lorem ipsum dolor sit amet consectetur adipisicing elit. Inventore
                    illum dolorem illo minus in est quaerat veritatis similique id nulla dignissimos, magni dolores
                    pariatur! Neque incidunt, ad enim minima reprehenderit, cumque laboriosam est saepe blanditiis suscipit
                    debitis asperiores? Accusantium a eum ullam neque impedit! Nisi dolore a libero quia atque!</p>
            </div>
            <div class="comment-section" v-if="fake.state == null">
                <v-textarea class="textarea" rows="3" color="#FF4700" bg-color="white" label="Añada un comentario si lo desea"
                    hide-details="true"> </v-textarea>
                <div class="buttons-section">
                    <ButtonComponent :button="'Aceptar'" :type="'accept'" />
                    <ButtonComponent :button="'Rechazar'" :type="'reject'" />
                </div>
            </div>
        </div>
    </div>
</template>
<style lang="scss" scoped>
.mainContainer {
    width: 100%;
    display: flex;
    justify-content: space-around;

    .usuario {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
    }

    .solicitud {
        display: flex;
    }

    .empleado {
        display: flex;
    }
        .titulo {
            margin-left: 30%;
        }

        .microheader {
            display: flex;
            flex-direction: row;
            margin-block: 2%;
        }
    }

    .texto {
        display: flex;
        flex-direction: column;
        background-color: #D9D9D9;
        padding: 2%;
        border-radius: 10px;
        margin-top: 1%;
        gap: 2vh;


    }

    .textarea {
        padding: 2%;        
    }

    #fecha {
        background-color: white;
        border-radius: 10px;
        padding: 1vw;
    }

    #comentario {
        background-color: white;
        border-radius: 10px;
        padding: 1vw;
    }

    .comment-section {
        display: flex;
        background-color: #D9D9D9;
        margin-top: 2%;
        border-radius: 10px;
    }

    .buttons-section {
        display: flex;
        flex-direction: column;
        padding-right: 2%;
        justify-content: center;
        gap: 4vh;
    }
</style>