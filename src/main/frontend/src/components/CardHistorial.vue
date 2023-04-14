<script setup>
import { defineProps } from "vue";
import StateIndicator from "./StateIndicator.vue";


const props = defineProps({
  Request: Object,
});
</script>

<template>
  <div class="main">
    <h1>HISTORIAL DE SOLICITUDES</h1>
    <div class="wrapper" style="background-color: #d9d9d9">
    <h2>  Andrés Perez {{ props.name }}</h2>
      <v-card class="wrapper-card" width="1000" style="margin-top: 20px">
        <v-card-text>
          <div class="card-titulos d-flex">
            <p class="school d-flex text-h6 font-weight-bold">
              Nombre de la escuela: 
              {{ props.nameschool }}
            </p>
            <p class="relative font-weight-medium mt-1">
              {{ props.date }} 00/02/2022 - 15/02/2022
            </p>
            <p class="relative font-weight-medium mt-1">
              <StateIndicator />
            </p>
          </div>

          <div class="card-container d-flex ">
            <p class=" card-description d-flex top-12 ml-1 mr-12 text-justify" v-bind="props.description">
              Lorem Ipsum  Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
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
  </div>
</template>

<style lang="scss" scoped>

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
  border-radius: 10px;
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
        margin-top: 6vh;



      }
    }
  }
}
</style>
