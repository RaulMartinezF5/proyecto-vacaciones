<script setup>
import { defineProps } from "vue";

const props = defineProps({
  Request: Object,

});

</script>

<template>
  <div class="d-flex justify-center">
    <v-card width="900">
      <v-text>

       <div class="d-flex justify-space-between"> 

        <v-card-title class="d-flex font-weight-light">Andrés P.</v-card-title>
        
          <p class="d-flex text-h6 font-weight-bold mr-14 ml-2 text-uppercase worker-color">
            Formador
          </p>

        </div>

        <div class="d-flex justify-space-between">

          <p class="d-flex font-weight-bold location" v-bind="props.description">
            Escuela: Gijón
          </p>

          <div class="d-flex flex-column">

  <p class="text-sm font-weight-bold">Dias restantes: 15{{ props.days }}</p>
</div>
        
        </div>
      </v-text>
    </v-card>
  </div>
</template>

<style lang="scss" scoped>
@use '../assets/scss/variables.scss' as c;

.worker-color {
  color: map-get($map: c.$colors, $key: "Orange");
}
.location {
  font-size: 1.2rem;
}
</style>
