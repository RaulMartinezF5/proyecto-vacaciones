<script>
import { Pie } from 'vue-chartjs';
import { Title, Tooltip, Legend, Chart as ChartJS, ArcElement } from 'chart.js';
import {ref} from'vue'

//recuerda mirar los elementos que conforman la grafica  importarlos y luego aplicarlo   en register
ChartJS.register(Title, Tooltip, Legend, ArcElement);

const data= {
  labels:['gijon', 'aviles','bali'],
  datasets:[{
    label:'Vacaciones',
    cutout:'10%',
    data:['200','200','30'],
    backgroundColor:['rgb(255, 99, 132)', 'rgb(54, 162, 235)', 'rgb(255, 205, 86)'],
    hoverOffset:4
  }]

}


const options = {
 responsive:true,
 aspectRatio:4
}




/// chart en circulos 
//reducir el tamaño de la grafica con cutout :'50%'




</script>
<template>
  <div class="about">

    <!-- <Bar :data="data" :options="options" /> -->

    <!--aqui podemos cambiar data por donugut-->
    <Pie :data="data" :options="options" />


  </div>
</template>
<style></style>