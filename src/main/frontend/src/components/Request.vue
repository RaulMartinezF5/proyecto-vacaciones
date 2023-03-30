<script setup>
import { ref } from 'vue';


    const remainingDays = ref("7")

</script>

<template>
    <div class="container">
        <v-text-field color="#FF4700" label="Start date" type="date" v-model="firstDay"> </v-text-field>
        <v-text-field color="#FF4700" label="End date" type="date" v-model="lastDay"> <v-icon icon="mdi-vuetify"></v-icon></v-text-field>
        <v-textarea class="textarea" color="#FF4700" label="Description" type="date" v-model="lastDay"> </v-textarea>
        <p>Dias restantes de vacaciones: {{ remainingDays }}</p>
        
    </div>

</template>

<style lang="scss" scoped>
    
    .container {
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-gap: 2%;
    }
    .textarea{
        grid-column: 1 / span 2;
    }
</style>