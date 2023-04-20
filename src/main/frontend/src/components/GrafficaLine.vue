<script setup>
import { Line } from 'vue-chartjs';
import {Chart as ChartJS,Title,Tooltip, Legend, BarElement, CategoryScale,LinearScale} from 'chart.js'
import { ref, defineProps } from 'vue'


ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend)

const props = defineProps({
  type: Object,
});

const line = ref(null);
const labels = ['Asturias', 'Barcelona', 'Málaga', 'Madrid'];

const data = {
  labels: labels,
  datasets: [{
    labels: 'Graffica Line',
    backgroundColor: 'rgb(255, 99, 132)',
    tension: 0.1   
}]
};
 
// onMounted(() => {
//     const chart = new ChartJS(line.value, {
//       type: 'line',
//       data: data,
   
//     })
  
//   })

   

</script>

<template>
  <div class="about">
    <!--aqui podemos cambiar data por donugut-->
    <Line :data="data" />
  </div>
</template>

<style></style>































