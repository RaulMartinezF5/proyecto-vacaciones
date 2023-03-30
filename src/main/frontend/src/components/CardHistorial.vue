<script setup>
import { ref,defineProps } from "vue";

const props = defineProps({
    Request :Object,
})
</script>

<template>
  <div class="d-flex justify-center  flex-row">
    <v-card width="600">
      <v-card-text>
        <div><v-card-title :="props.name">Andrés P.</v-card-title></div>
        <p class="font-weight-medium  " :="props.date">12/12/12-13/05/21</p>
        <p class="text-h6 font-weight-bold" :="props.days">Dias solicitados: 15</p>
        <p class="text-h6 font-weight-bold" :="props.checked">Revisado por: Iyan</p>
        <p class="text-h6 font-weight-bold" :="props.name_school">Nombre de la escuela</p>
        <div class="text--primary" :="description"> well meaning and kindly "a benevolent smile"</div>
      </v-card-text>
    </v-card>
  </div>
</template>

<style lang="scss" scoped></style>
