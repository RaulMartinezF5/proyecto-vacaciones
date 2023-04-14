<script setup>
import { defineProps } from "vue";
import Aceptada from "./Aceptada.vue";

const props = defineProps({
  Request: Object,
});
</script>

<template>
<<<<<<< HEAD
  <div class="card d-flex justify-center ">
    <v-card width="900">
      <v-text>
        <v-card-title class="d-flex justify-center">Andrés P.</v-card-title>
        <div class="d-flex">
          <p class="d-flex text-h6 font-weight-bold mr-14 ml-2">
            Nombre de la escuela
          </p>
          <p class="relative font-weight-medium mt-1">12/12/12-13/05/21</p>
        </div>
        <div class="d-flex">
          <p class="d-flex top-12 ml-4 mr-2" v-bind="props.description">
            well meaning and kindly "a benevolent smile",
            dasdhkahskdhahsfkhaksfhkahsfhalsfhlashflhasl,
        
          </p>
          <div class="d-flex flex-column">
  <p class="text-sm font-weight-bold">Dias solicitados: {{ props.days }}</p>
  <p class="text-sm font-weight-bold">Revisado por: {{ props.checked }}</p>
</div>
        
        </div>
      </v-text>
    </v-card>
=======
  <div class="main">
    <h1>HISTORIAL DE SOLICITUDES</h1>
    <div class="wrapper" style="background-color: #d9d9d9">
    <h2>{{ props.name }}</h2>
      <v-card class="wrapper-card" width="1000" style="margin-top: 100px">
        <v-card-text>
          <div class="card-titulos d-flex">
            <p class="school d-flex text-h6 font-weight-bold">
              Nombre de la escuela:
              {{ props.nameschool }}
            </p>
            <p class="relative font-weight-medium mt-1">
              {{ props.date }}
            </p>
            <p class="relative font-weight-medium mt-1">
              <Aceptada />
            </p>
          </div>

          <div class="card-container d-flex">
            <p class=" card-description d-flex top-12 ml-1 mr-1" v-bind="props.description">
            
              {{ props.description }}
            </p>
            <div class="counter d-flex flex-column">
              <p class="uno text-sm font-weight-bold">
                Dias solicitados: 12{{ props.days }}
              </p>
              <p class=" dos text-sm font-weight-bold">
                Revisado por: Iyan {{ props.checked }}
              </p>
            </div>
          </div>
        </v-card-text>
      </v-card>
    </div>
>>>>>>> 95ba72bca477f39d5a0622c511062dafb429a4e1
  </div>
</template>

<style lang="scss" scoped>
<<<<<<< HEAD
.card{
  margin-top: 16vh;
}

=======

.main{
  padding-right: 25px;

}


h1 {
  display: flex;
  justify-content: center;
  margin: 12px 12px;
}


.wrapper {
  width: 100%;
  display: flex;
  justify-content: space-around;

  margin-right: 2vw;
  align-items: center;
  flex-direction: column;
  align-items: center;

  
  .wrapper-card {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    flex-wrap: wrap;
    margin: 2vw;
    justify-content: center;
    align-self: center;
   

    .card-titulos {
      display: flex;
      justify-content: space-around;

      .school {
        display: flex;
        justify-self: flex-start;

      }
    }

    .card-container {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      gap: 10px;

      .card-description {
        display: flex;

      }


      .counter {
        display: flex;
        width: 100%;
        font-size: 18px;
        margin-top: 12px;



      }
    }
  }
}
>>>>>>> 95ba72bca477f39d5a0622c511062dafb429a4e1
</style>
