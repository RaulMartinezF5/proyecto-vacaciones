<script setup>
import { Pie } from "vue-chartjs";
import { Chart as ChartJS,Title, Tooltip, Legend,  ArcElement } from "chart.js";
import { ref, defineProps } from "vue";

//recuerda mirar los elementos que conforman la grafica,  importarlos y luego aplicarlo   en register
ChartJS.register(Title, Tooltip, Legend, ArcElement);
 
const props = defineProps({
  type: Object,
 
});


const donut = ref(null);

const data = {
  labels: ["Gijon", "Aviles", "Bali"],
  datasets: [
    {
      label: "Vacaciones",
      cutout: "10%",
      data: {
        type: Object,
        required : true
      },
      backgroundColor: [
        "rgb(255, 99, 132)",
        "rgb(54, 162, 235)",
        "rgb(255, 205, 86)",
      ],
      
      hoverOffset: 4,
    },
  ],
};

const options = {
  responsive: true,
  aspectRatio: 4,
};

// onMounted(() => {
//   console.log("montado");
//   const chart = new ChartJS(donut.value, {
//     type: "pie",
//     data: data,
//     options: options,
//   });
// });
</script>

<template>
  <div class="about">
    <!--aqui podemos cambiar data por donugut-->
    <Pie :data="data" :options="options" />
  </div>
</template>

<style></style>
