<script setup>
import { ref } from 'vue';


const name = ref("");
const surnames = ref("");
const dni = ref("");
const email = ref("");
const vacationDays = ref("");
const startDay = ref("");
const finishDay = ref("");
const position = ref("");
const role = ref("");
const workplace = ref();





const props = defineProps(
    {
        id:{
            type:Number
        },
        view:{
            type:String,
            // default: "create"
        },
        role:{
            type:String,
            // default: "admin"
        }
    }
)


  

</script>

<template>
<div class="container">
    <v-text-field color="#FF4700" label="Nombre" v-model="name">  </v-text-field>
    <v-text-field color="#FF4700" label="Apellidos" v-model="surnames"> </v-text-field>
    <v-text-field color="#FF4700" label="DNI/NIE/Pasaporte" v-model="dni"> </v-text-field>
    <v-text-field color="#FF4700" label="Correo electrónico" v-model="email"> </v-text-field>
    <v-text-field color="#FF4700" label="Cantidad de Vacaciones" v-model="vacationDays"> </v-text-field>
    <v-select color="#FF4700" label="Posición" :items="['Formador','Coformador','Responsable de Promoción']"   v-model="position"> </v-select>
    <v-select color="#FF4700" label="Tipo de Usuario" :items="['Responsable de Escuela','Empleado']" v-model="role"> </v-select>
    <v-select color="#FF4700" label="Lugar de trabajo" :items="['Asturias', 'Madrid', 'BCN-FemCoders', 'AST-Rural Camp',]" multiple chips v-model="workplace"> </v-select>
    <v-text-field color="#FF4700" label="Fecha de entrada" type="date" v-model="startDay"> </v-text-field>
    <v-text-field color="#FF4700" label="Fecha de baja" type="date" v-model="finishDay"> </v-text-field>
</div>

    
</template>

<style lang="scss" scoped>
@import "../assets/scss/variables.scss";
    .container {
        display: grid;
        grid-template-columns: 32% 32%;
        gap: 2%;
        width: 100%;
        justify-content: center;
    }



</style>