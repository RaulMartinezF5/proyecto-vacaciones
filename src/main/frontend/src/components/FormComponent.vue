<script setup>
// import { Ref } from 'vue';


// const name = ref("hola");
/* const surnames = ref("");
const dni = ref("");
const email = ref("");
const vacationDays = ref("");
const startDay = ref("");
const finishDay = ref("");
const position = ref("");
const role = ref("");
const workingPlace = ref(""); */



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
    <v-text-field class="field" color="#FF4700" label="Nombre"> {{ name }} </v-text-field>
    <v-text-field class="field" color="#FF4700" label="Apellidos"> </v-text-field>
    <v-text-field class="field" color="#FF4700" label="DNI/NIE/Pasaporte"> </v-text-field>
    <v-text-field class="field" color="#FF4700" label="Correo electrónico"> </v-text-field>
    <v-text-field class="field" color="#FF4700" label="Cantidad de Vacaciones"> </v-text-field>
    <v-select label="Posición" :items="['Formador','Coformador','Responsable de Promoción']"></v-select>
    <v-select label="Tipo de Usuario" :items="['Responsable de Escuela','Empleado']"></v-select>
    <v-select label="Lugar de trabajo" :items="['Asturias', 'Madrid', 'BCN-FemCoders', 'AST-Rural Camp',]" multiple chips></v-select>
    
    <v-menu>
    </v-menu>
    <v-text-field slot="activator" label="Fecha de entrada" prepend-icon="date_range"></v-text-field>
    <v-date-picker v-model="startDate"></v-date-picker>




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

    .field{

        border-radius: 100px;
        
    }



</style>