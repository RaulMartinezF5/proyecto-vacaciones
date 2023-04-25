<script setup>
import { Bar } from "vue-chartjs";
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale, } from "chart.js";
import { ref, defineProps,onMounted } from 'vue';

ChartJS.register(CategoryScale,LinearScale,BarElement,Title,Tooltip,Legend);
import {Chart} from 'chart.js';


const props = defineProps({
  graph: Object,
});

const bar = ref(null);



const options = {
  type: Object,
  responsive: true,
  default: () => { },
};

</script>


<template>
  <Bar :data="graph" :options="options" />
 
<div>


</div>
</template>
<style lang="scss" scoped></style>












 




























































































