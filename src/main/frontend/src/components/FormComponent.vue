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
   <div class="input-wrapper" > <v-text-field color="#FF4700" label="Nombre" variant="solo" v-model="name">  </v-text-field></div>
   <div class="input-wrapper" ><v-text-field color="#FF4700" label="Apellidos" variant="solo" v-model="surnames"> </v-text-field></div>
   <div class="input-wrapper" > <v-text-field color="#FF4700" label="DNI/NIE/Pasaporte" variant="solo" v-model="dni"> </v-text-field></div>
   <div class="input-wrapper" ><v-text-field color="#FF4700" label="Correo electrónico" variant="solo" v-model="email"> </v-text-field></div>
   <div class="input-wrapper" > <v-text-field color="#FF4700" label="Cantidad de Vacaciones" variant="solo" v-model="vacationDays"> </v-text-field></div>
    <div class="input-wrapper" ><v-select color="#FF4700" label="Posicion" variant="solo" :items="[ 'Formador', 'Coformador', 'Responsable de Promocion']"  v-model="workplace"> </v-select></div>
    <div class="input-wrapper" ><v-select color="#FF4700" label="Tipo de Usuario" variant="solo" :items="[ 'Responsable de Escuela', 'Empleado',]"  v-model="workplace"> </v-select></div>
    <div class="input-wrapper" ><v-select color="#FF4700" label="Lugar de trabajo" variant="solo" :items="['Asturias', 'Madrid', 'BCN-FemCoders', 'AST-Rural Camp',]" multiple chips v-model="workplace"> </v-select></div>
    <div class="input-wrapper" > <v-text-field color="#FF4700" label="Fecha de entrada" variant="solo" type="date" v-model="startDay"> </v-text-field></div>
    <div class="input-wrapper" ><v-text-field color="#FF4700" label="Fecha de baja" variant="solo" type="date" v-model="finishDay"> </v-text-field></div>
</div>

   
</template>

<style lang="scss" scoped>
@use "../assets/scss/variables.scss" as c;
    .container {
        display: grid;
        grid-template-columns: 32% 32%;
        gap: 2vh;
        width: 100%;
        justify-content: center;
    }

    .input-wrapper {
        border-radius: 10px;
        border : map-get($map: c.$colors, $key: "Orange") solid 2px;
        overflow: hidden;
        height: 6vh;
    }

</style>