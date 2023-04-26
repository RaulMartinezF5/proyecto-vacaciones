<script setup>
import { Bar } from "vue-chartjs";
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale, } from "chart.js";
import { ref } from 'vue';

ChartJS.register(CategoryScale,LinearScale,BarElement,Title,Tooltip,Legend);


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
 
</template>
<style lang="scss" scoped></style>