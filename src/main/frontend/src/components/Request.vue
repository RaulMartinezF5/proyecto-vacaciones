<script setup>
import { ref } from 'vue';
import ButtonComponent from './ButtonComponent.vue';
import Calendar from './Calendar.vue';
    // const firstDay = ref("");
    // const lastDay = ref("");
    // const description = ref("");
    // const remainingDays = ref("7");

</script>

<template>
    <div class="container">
        <!-- <v-text-field color="#FF4700" label="Start date" type="date" v-model="firstDay"> </v-text-field>
        <v-text-field color="#FF4700" label="End date" type="date" v-model="lastDay"> </v-text-field>
        <p id="remainingDaysParagraph">Dias restantes de vacaciones: {{ remainingDays }}</p> -->
        <Calendar class="calendar"/>
        <v-textarea class="textarea" color="#FF4700" bg-color="white" label="Description" type="date" v-model="description"> </v-textarea>
       <div class="container__btn">
           <h2>Dias correspondientes de vacaciones:</h2>
        <ButtonComponent class="button" :button="'Enviar Solicitud'"/>
        </div> 
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
        border-radius: 10px;
      
        .textarea{
            grid-column: 1 / span 2;
            border-radius: 10px;
          
        }
        
        .calendar{
            display: flex;
            justify-content: center;
    

        }
        .container__btn{
            display: flex;
            justify-content: space-between;
            align-items: center;
           

            .button{
                width: 15vw;
                height: 5vh;
                border-radius: 10px;
                border: 2px solid black;
                font-size: 12px;
            }
        }
        
    }

</style>