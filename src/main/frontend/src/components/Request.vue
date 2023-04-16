<script setup>
import { ref,reactive } from 'vue';
import ButtonComponent from './ButtonComponent.vue';
import Calendar from './Calendar.vue';
// const firstDay = ref("");
// const lastDay = ref("");
const basicRequestData = reactive({
    'days': 0,
    'startDate': '',
    'endDate': '',
    'issue': ''
})
// const remainingDays = ref("7");

const vacationDays = (quantityOfDays)=>{
    basicRequestData.days = quantityOfDays.days
    basicRequestData.startDate = quantityOfDays.startDate
    basicRequestData.endDate = quantityOfDays.endDate
}

const emit = defineEmits(['emitBasicEmitInfo'])

const emitBasicInfo = () => {
    if(basicRequestData.startDate === '') return
    emit('emitBasicEmitInfo', basicRequestData)
}
</script>

<template>
    <div class="request-info-wrapper">
        <!-- <v-text-field color="#FF4700" label="Start date" type="date" v-model="firstDay"> </v-text-field>
                        <v-text-field color="#FF4700" label="End date" type="date" v-model="lastDay"> </v-text-field>
                        <p id="remainingDaysParagraph">Dias restantes de vacaciones: {{ remainingDays }}</p> -->
        <div class="date-inputs-space">
            <Calendar @emit-vacation-days="vacationDays"/>
        </div>
        <div class="issue-zone">
            <div class="text-wrapper">
                <v-textarea color="#FF4700" bg-color="white" label="Comentario" v-model="basicRequestData.issue">
                </v-textarea>
            </div>
        </div>
        <div class="button-zone">
            <h2>Dias correspondientes de vacaciones: {{ basicRequestData.days }}</h2>
            <div class="button-wrapper">
                <ButtonComponent :button="'Enviar Solicitud'"  @click="emitBasicInfo()"/>
            </div>
        </div>
    </div>
</template>

<style lang="scss" scoped>
@use '../assets/scss/main' as *;

.request-info-wrapper {
    width: 100%;
    @include gridDisplay(auto, 1);
    background-color: map-get($map: $colors, $key: "Grey");
    border-radius: 10px;
    row-gap: 1vh;

    .date-inputs-space {
        width: 100%;
        @include flexDisplay(row, center, center);
        @include positionGrid(1, 1, 1, 1);
    }

    .issue-zone {
        width: 100%;
        @include flexDisplay(row, center, center);

        .text-wrapper {
            width: 90%;
            @include flexDisplay(row, center, center);
            border-radius: 10px;
            overflow: hidden;
        }
    }


    .button-zone {
        width: 100%;
        height: 10vh;
        @include positionGrid(3, 1, 4, 1);
        display: flex;
        justify-content: space-around;
        align-items: center;

        .button-wrapper {
            width: 30%;
            border-radius: 10px;
            border: 2px solid black;
            overflow: hidden;
        }
    }
}
</style>