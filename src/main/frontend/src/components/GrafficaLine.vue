<script setup>
import { Line } from 'vue-chartjs';
// import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale } from 'chart.js'
import { ref, defineProps, onMounted } from 'vue'
import Chart from 'chart.js/auto';

// ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend)

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
    <!--aqui podemos cambiar data por donugut-->
    <Line :data="graph" :options="options"/>

 
  </div>
</template>

<style></style>































