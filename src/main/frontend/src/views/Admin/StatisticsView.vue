<script setup>
import iconArrowLeft from '@/assets/img/iconArrowLeft.png';
import ButtonComponent from '../../components/ButtonComponent.vue';


</script>

<template>
    <div class="mainContainer">
        <div class="microheader">
            <button class="button-arrow"><img :src="iconArrowLeft" alt="" class="arrow"></button>
            <h1 class="Titulo">
                INFORMES ESTADISTICOS
            </h1>
        </div>

        <div class="buttons">
            <ButtonComponent :button="'Escuela'" class="buttonFix"/>
            <ButtonComponent :button="'Puesto'" class="buttonFix"/>
            <ButtonComponent :button="'Estado'" class="buttonFix"/>
        </div>

        <div class="container">
            <div class="pepin">
                <div class="grafic"><canvas id="myChart" style="width:100%;max-width:700px"></canvas></div>
                <div class="grafic2"></div>
            </div>
            <div class="pepon">
                <div class="grafic3"></div>
            </div>

        </div>
            

    </div>
</template>


<style scoped lang="scss">
.mainContainer {
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    padding: 2% 5%;

    .microheader {
        display: flex;
        justify-content: center;
        .button-arrow{
            position: absolute;
            left: 24%;
        }
    }
    .buttons {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        width: 100%;
        margin-top: 2%;
        .buttonFix {
            width: 25%;
        }
    }
    .container {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        height: 100%;
        width: 100%;
        margin-top: 2%;
        
        .pepin{
            display: flex;
            flex-direction: column;
            height: 100%;
            width: 48%;
        
            .grafic {
                height: 180px;
                background-color: red;
                margin-top: 2%;
                margin-left: 0%;
                width: 100%;
            }
            
            .grafic2 {
                height: 180px;
                background-color: black;
                margin-top: 2%;
                margin-left: 0%;
                width: 100%;
            }
        }
        .pepon{
                display: flex;
                width: 48%;
                height: 100%;
    
            .grafic3 {
                    height: 366px;
                    background-color: aqua;
                    margin-top: 2%;
                    margin-left: 0;
                    width: 100%;
                }
            }
        }   
    }  


</style>