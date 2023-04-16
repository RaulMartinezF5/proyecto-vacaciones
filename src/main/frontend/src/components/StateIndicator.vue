<script setup>
import { computed } from 'vue';

const props = defineProps(
    {
        state: {
            type : String,
            default: "Pendiente",
        },
    }
)
const typeStatePicker = computed(() => {
    const options = {
        'rechazada': 'rechazada',
        'Accept': 'aceptada',
    }

    return options[props.state]
})

</script>

<template>
    <div class="state">
        <p :class="['state', typeStatePicker]">{{ state }}</p>
    </div>
</template>

<style lang="scss" scoped>
@use "../assets/scss/variables.scss" as c;

.state {
    background-color: map-get($map: c.$colors, $key: "Yellow");
    width: 15vw;
    p {
        color: black;
        font-size: 3vh;
        font-family: 'Poppins', sans-serif;
        font-weight: bold; 
        text-align: center;
        padding: 3%;
    }  
}
.rechazada{
    background-color: map-get($map: c.$colors, $key: "Red");
}
.aceptada{
    background-color: map-get($map: c.$colors, $key: "Green");
}
</style>
