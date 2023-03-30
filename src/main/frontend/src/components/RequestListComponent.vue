<script setup></script>

<template>
   <section class="requestSection">
    <p class="workerName">Andrés Pérez</p>
    <p class="date">10-02-2022</p>
    <p class="days">Días de vacaciones: 26</p>
   </section>
</template>

<style lang="scss" scoped>
@import '../assets/scss/variables.scss';
.requestSection{
    border: $Orange solid 2px;
    width: 80%;
    display: flex;
    .workerName{
        display: inline-flex;
    }
    .date{
        display: inline-flex;
    }
    .days{
        display: inline-flex;
    }
}
</style>