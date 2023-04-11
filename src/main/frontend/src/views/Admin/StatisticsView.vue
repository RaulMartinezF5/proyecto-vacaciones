<script setup>
import iconArrowLeft from '@/assets/img/iconArrowLeft.png';
import rechazada from '../../components/Rechazada.vue';

</script>

<template>
<div class="mainContainer">
        <div class="header">
            <div class="microheader">
                <button class="button-arrow"><img :src="iconArrowLeft" alt="" class="arrow"></button>
                <h1 class="Titulo">
                    INFORMES ESTADISTICOS
                </h1>
            </div>

            <div class="buttons">
                <rechazada />
                <rechazada />
                <rechazada />
             </div>

             <div class="container">
                <div class="grafic"></div>
                <div class="grafic2"></div>
                <div class="grafic3"></div>
             </div>

            </div>

        </div>
        
        
    </template>


<style scoped lang="scss">

.mainContainer {
    width: 100%;
    display: flex;
    justify-content: space-around;
    margin: 2% 5%;
}
.buttons{
display: flex;
flex-direction: row;
justify-content: space-between;
}
.container{
    display: flex;
    flex-direction: column;
    height: 100%;
}
.grafic{
    display: flex;
    background-color: red;
    margin-top: 20%;
}
.grafic2{
    background-color: black;
    margin-top: 20%;
    margin-left: 70%;
}
.grafic3{
    background-color: aqua;
    margin-top: 20%;
}























</style>