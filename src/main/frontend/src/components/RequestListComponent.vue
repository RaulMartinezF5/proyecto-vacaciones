<script setup>
import StateIndicator from './StateIndicator.vue';

const props = defineProps({
        request: {
            type: Object,
        },
    })



const emits = defineEmits(['emitRequestDetails'])

const emitRequestDetails = () => {
  emits('emitRequestDetails', {
    userDocument: props.request.userDocument,
    requestId: props.request.requestUser.id
  })
}

</script>

<template>
    <div class="request-wrapper"  @click="emitRequestDetails()">
                <p class="workerName">{{ request.workerName }}</p>
                <p class="date">{{ request.startDate }} - {{ request.finishDate }}</p>                 
                <p class="days">Días de vacaciones: {{ request.days }} </p>
                <StateIndicator :state="'aceptada'" />
    </div>
</template>

<style lang="scss" scoped>
@use "../assets/scss/variables.scss" as c;


.request-wrapper {
    border: solid 2px;
    border-color: map-get($map: c.$colors, $key: "Orange");
    border-radius: 0.5vw;
    width: 100%;
    display: flex;
    justify-content: space-around;
    align-items: center;
    margin-block: 2vh;

p {
    margin-block: 2vh;
    font-size: 3vh;
}

.workerName {
    font-size: 4vh;
}
}
</style>