<script setup>
import { computed } from 'vue';
const props = defineProps({
    button: {
        type: String,
        default: 'button'
    },
    type: {
        type: String,
        default: 'default'
    }
})

const typeButtonPicker = computed(() => {
    const options = {
        'reject': 'reject',
        'accept': 'accept',
        'warning': 'warning',
        'action': 'action',
        'default': 'default'
    }

    return options[props.type]
})
</script>

<template>
    <v-btn :class="['button', typeButtonPicker]">{{ button }}</v-btn>
</template>

<style lang="scss" scoped>
@use '../assets/scss/variables.scss' as *;

.button {
    display: flex;
    justify-content: center;
    width: 100%;
    font-weight: bolder;
}

.default {
    background-color: map-get($map: $colors, $key: "Orange");
    color: map-get($map: $colors, $key: "White");

}

.action {
    background-color: map-get($map: $colors, $key: "Orange");
    color: map-get($map: $colors, $key: "Black");
    border: map-get($map: $colors, $key: "Black") solid 2px;
}

.reject{
    background-color: map-get($map: $colors, $key: "Red");
    color: map-get($map: $colors, $key: "Black");
    border: map-get($map: $colors, $key: "Black") solid 2px;
}
.accept{
    background-color: map-get($map: $colors, $key: "Green");
    color: map-get($map: $colors, $key: "Black");
    border: map-get($map: $colors, $key: "Black") solid 2px;
}
.warning{
    background-color: map-get($map: $colors, $key: "Yellow");
    color: map-get($map: $colors, $key: "Black");
    border: map-get($map: $colors, $key: "Black") solid 2px;
}
</style>