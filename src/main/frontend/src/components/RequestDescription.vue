<script setup>
import iconArrowLeft from '@/assets/img/iconArrowLeft.png';
</script>
<template>
    <div class="mainContainer">
        <div class="Rechazada">
            <div class="microheader">
                <button class="button-arrow"><img :src="iconArrowLeft" alt="Flecha botón para retoceder" class="arrow"></button>
                <h1 class="titulo">
                    INFORMACIÓN DE SOLICITUD
                </h1>
            </div>
            <div class="usuario">
                <h2 class="empleado"> Paula Frias</h2>
                <h2 class="solicitud">Solicitud:</h2>
                <rechazada />
            </div>
            <div class="texto">
                <p id="fecha"> pepon </p>
                <p id="comentario"> pepin </p>
            </div>
            <div class="comment-section" v-if="fake.state == null">

            <div class="buttons-section">
                <ButtonComponent :button="'Aceptar'" :type="'accept'"/>
                <ButtonComponent :button="'Rechazar'" :type="'reject'"/>
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
        justify-content: space-between;
        margin-top: 10%;
        margin-right: 15%;
        .solicitud{
            margin-left: 45%;
        }
    }
    .empleado{
        display: flex;
    }
    .Rechazada {
        width: 75%;
        .titulo{
            margin-left: 20%;
        }
        .microheader{
            display: flex;
            flex-direction: row;
            margin-top: 3%;
        }
    }
    .texto{
        display: flex;
        flex-direction: column;
        background-color:#D9D9D9;
        padding: 3% 5%;
        border-radius: 10px;
        margin-top: 5%;
        
        
    }

    #fecha{
        background-color: white;
        border-radius: 10px;
        padding-left: 3%;
        padding-top: 3%;
        margin-bottom: 3%;
    }
    
    #comentario{
        background-color: white;
        border-radius: 10px;
        padding-left: 3%;
        padding-top: 3%;
        margin-bottom: 3%;
    }
}
</style>