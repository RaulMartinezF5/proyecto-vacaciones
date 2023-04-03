<script setup>
import { ref } from 'vue';
import ButtonComponent from './ButtonComponent.vue';

    const firstDay = ref("");
    const lastDay = ref("");
    const description = ref("");
    const remainingDays = ref("7");

</script>

<template>
    <div class="container">
        <v-text-field color="#FF4700" label="Start date" type="date" v-model="firstDay"> </v-text-field>
        <v-text-field color="#FF4700" label="End date" type="date" v-model="lastDay"> </v-text-field>
        <v-textarea class="textarea" color="#FF4700" label="Description" type="date" v-model="description"> </v-textarea>
        <p id="remainingDaysParagraph">Dias restantes de vacaciones: {{ remainingDays }}</p>
        <ButtonComponent class="button" :button="'Enviar Solicitud'"/>

    </div>

</template>

<style lang="scss" scoped>
@use "../assets/scss/variables.scss" as c;
    
    .container {
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-gap: 2%;
        background-color: map-get($map: c.$colors, $key: "Grey" );
        padding: 3%;
        border-radius: 30px;
    }
    .textarea{
        grid-column: 1 / span 2;
    }
    #remainingDaysParagraph, .button{
        justify-self: center;
    }

</style>