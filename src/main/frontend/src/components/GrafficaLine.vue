<script setup>
import { Line } from 'vue-chartjs';
import { ref } from 'vue'

const props = defineProps({
  graph: Object,
});

const line = ref(null);

  const  options = {
    type:Object,
      responsive: true,
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }

</script>

<template>
  <div class="about">
    <Line :data="graph" :options="options"/>

 
  </div>
</template>

<style lang="scss" scoped></style>