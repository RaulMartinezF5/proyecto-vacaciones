<script setup>
import ButtonComponent from '../../components/ButtonComponent.vue';
import Header from '../../components/Header.vue';


</script>


<template>
<Header/>
<h1 class="titulo">
    Información de Solicitud
</h1>

<div class="Button">
    <ButtonComponent :button= "'Equipo'" />
    <ButtonComponent :button= "'Empleado'" />
</div>







</template>


<style lang="scss" scoped>
.Button{
    float: left;
    margin-left: 80px;
    margin-top: 350px;
    margin-bottom: 20px;
}
.titulo{
    display: flex;
    justify-content: end;
    margin-right: 350px;
    margin-top: 30px;
}
.solicitud{
    display: flex;
    justify-content: end;
    margin-right: 300px;
    margin-top: 70px;
}


</style>