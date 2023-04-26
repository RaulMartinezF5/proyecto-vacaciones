<script setup>
import { Pie } from "vue-chartjs";
import { Chart as ChartJS,Title, Tooltip, Legend,  ArcElement } from "chart.js";
import { ref } from "vue";

ChartJS.register(Title, Tooltip, Legend, ArcElement);
 
const props = defineProps({
  graph: Object,
});


const donut = ref(null);



const options = {
  type:Object,
  responsive: true,
  aspectRatio: 1.2,
};


</script>

<template>
  <div class="about">
    <Pie :data="graph" :options="options" />
  </div>
</template>

<style lang="scss" scoped></style>
