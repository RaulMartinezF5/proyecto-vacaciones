<script setup>
import { Line } from 'vue-chartjs';
import { ref, onMounted } from 'vue'
import Chart from 'chart.js/auto';

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