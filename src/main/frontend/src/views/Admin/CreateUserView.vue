<script setup>
import Header from '../../components/Header.vue';
import FormComponent from '../../components/FormComponent.vue';
import ButtonComponent from '../../components/ButtonComponent.vue';

</script>

<template>

<h1>CREAR USUARIO</h1>
<div class="form"><FormComponent/></div>
<div class="button"><ButtonComponent :button="'CREAR'"/></div>
</template>

<style>

h1{
    text-align: center;
    margin-top: 2.5vw;
}


.form{
    margin-top: 5vw;
}

.button{
margin-top: 3vw;
display: flex;
justify-content: center;
align-items: center;
color: white;
font-weight: 700;

}
</style>