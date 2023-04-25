<script setup>
import { Pie } from "vue-chartjs";
import { Chart as ChartJS,Title, Tooltip, Legend,  ArcElement } from "chart.js";
import { ref, defineProps } from "vue";

//recuerda mirar los elementos que conforman la grafica,  importarlos y luego aplicarlo   en register
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
    <!--aqui podemos cambiar data por donugut-->
    <Pie :data="graph" :options="options" />
  </div>
</template>

<style></style>
