<script setup>
import RequestDescription from '../../components/RequestDescription.vue';
</script>

<template>
    <div class="container">
        <RequestDescription class="RequestDescription"/>

    </div>



</template>

<style scoped lang="scss">
    .container{
        display: flex;
        justify-content: center;
        .RequestDescription{
            width: 90%;
        }
    }
</style>