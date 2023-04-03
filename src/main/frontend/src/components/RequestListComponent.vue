<script setup>
import Aceptada from './Aceptada.vue';

const props = defineProps(
    {
        workerName: {
            type: String,
            default: "worker",
        },
        date: {
            type: Date,
            default: '10/10/2022 - 15/10/2022',
        },
        days: {
            type: Number,
            default: 15,
        }

    }
)

</script>

<template>
   <section class="requestSection">
    <p class="workerName">{{ workerName }}</p>
    <p class="date">{{ date }}</p>
    <p class="days">Días de vacaciones: {{ days }} </p>
    <Aceptada/>

   </section>
</template>

<style lang="scss" scoped>
@use "../assets/scss/variables.scss" as c;
.requestSection{
    border: solid 2px;
    border-color: map-get($map: c.$colors, $key: "Coral");
    border-radius: 0.5vw;
    width: 80%;
    display: flex;
    justify-content: space-around;
    align-items: center;
    
    p{
        margin-block: 2vh;
        font-size: 3vh;
    }
    .workerName{
        font-size: 4vh;
    }
    
}
</style>