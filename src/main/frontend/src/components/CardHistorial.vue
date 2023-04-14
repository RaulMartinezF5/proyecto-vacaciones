<script setup>
import { defineProps } from "vue";

const props = defineProps({
  Request: Object,
  
});

</script>

<template>
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
  </div>
</template>

<style lang="scss" scoped>
.card{
  margin-top: 16vh;
}

</style>
