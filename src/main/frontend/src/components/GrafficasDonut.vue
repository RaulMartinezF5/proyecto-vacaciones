<script setup>
import { Pie } from 'vue-chartjs';
import { Title, Tooltip, Legend, Chart as ChartJS, ArcElement } from 'chart.js';
import { ref, onMounted, onBeforeMount } from 'vue'


//recuerda mirar los elementos que conforman la grafica,  importarlos y luego aplicarlo   en register
ChartJS.register(Title, Tooltip, Legend, ArcElement);

const donut = ref(null);

const data = {
  labels: ['Gijon', 'Aviles', 'Bali'],
  datasets: [{
    label: 'Vacaciones',
    cutout: '10%',
    data: ['200', '200', '30'],
    backgroundColor: ['rgb(255, 99, 132)', 'rgb(54, 162, 235)', 'rgb(255, 205, 86)'],
    hoverOffset: 4
  }]
}



const options = {
  responsive: true,
  aspectRatio: 4
}




onMounted(() => {
  console.log('montado');
  const chart = new ChartJS(donut.value, {
    type: 'pie',
    data: data,
    options: options
  })

})



/// chart en circulos
//reducir el tamaño de la grafica con cutout :'50%'

</script>


<template>
  <div class="about">

    <!-- <Bar :data="data" :options="options" /> -->

    <!--aqui podemos cambiar data por donugut-->
    <Pie :data="data" :options="options" />
    <canvas>
      

    </canvas>



  </div>
</template>
<style></style>








