<!-- <script>
import { Bar } from 'vue-chartjs'
import {Chart as ChartJS,Title,Tooltip, Legend, BarElement, CategoryScale,LinearScale} from 'chart.js'

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend)


export default {
  name: 'App',
  components: {
    Bar
  },
  data() {
    return {
      data: {
        labels: ['January', 'February', 'March'],
        datasets: [{ data: [10, 20, 12] }],
      },
      options: {
        responsive: true
      }
    }
  }
}

</script>
<template>

   <Bar :data="data" :options="options" />


</template>
<style lang="scss" scoped></style> -->