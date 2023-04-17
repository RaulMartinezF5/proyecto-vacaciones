<script setup>
import StateIndicator from './StateIndicator.vue';
const props = defineProps({
    request: {
        type: Object,
        required: true
    }
})
</script>
<template>
    <div class="simple-request-wrapper">
        <div class="dates-zone">
            <h4>{{ request.startDate }}</h4>
            <h4>{{ request.endDate }}</h4>
        </div>
        <div class="status-zone">
            <StateIndicator :state="request.state"/>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../assets/scss/main' as *;
    .simple-request-wrapper{
        width: 100%;
        @include flexDisplay(row, space-around, center);
        border-radius: 10px;
        height: 6vh;
        border: map-get($map: $colors, $key: "Orange") 2px solid;

        .dates-zone{
            width: 40%;
            @include flexDisplay(row, space-around, center);
        }
        .status-zone{
            width: 30%;
            @include flexDisplay(row, center, center);

        }
    }
</style>
