<script setup>
const props = defineProps({
    button:{
        type:String,
        default: 'button'
    }})


</script>

<template>
        <v-btn class="button">{{button}}</v-btn> 


</template>

<style scoped lang="scss">
.button {
    display: flex;
    background-color: #FF4700;
    justify-content: center;
    width: 150px;
}



</style>