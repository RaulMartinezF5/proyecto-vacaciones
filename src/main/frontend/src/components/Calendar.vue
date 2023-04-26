<script setup>
import { ref } from "vue";

const startDate = ref("")
const endDate = ref("")


const remainingWorkingDays = ref(0);

const emit = defineEmits(['emitVacationDays'])

const emitVacationDays = ()=>{
    emit('emitVacationDays', calculate())
    remainingWorkingDays.value = 0
}

const calculate = () => {
    let startLocalDate = new Date(startDate.value)
    let finishLocalDate = new Date(endDate.value)
    let changeFecha = new Date(startDate.value)
    if (startDate.value === '') return
    for (let index = startLocalDate.valueOf() / 86400000; index < finishLocalDate.valueOf() / 86400000; index++) {

        changeFecha.setDate(changeFecha.getDate() + 1)
        if (changeFecha.getDay() != 0 && changeFecha.getDay() != 6) remainingWorkingDays.value++

    }

    const requestBasicData = {
        'days': remainingWorkingDays.value,
        'startDate': startDate.value,
        'endDate': endDate.value
    }
    
    return requestBasicData

};

</script>
<template>
    <div class="dates-wrapper">
        <input class="date-info" type="date" v-model="startDate">
        <input class="date-info" type="date" v-model="endDate" @input="emitVacationDays()">
    </div>
</template>

<style lang="scss" scoped>
@use '../assets/scss/main' as *;

.dates-wrapper {
    width: 100%;
    height: 10vh;
    @include flexDisplay(row, space-around, center);

    .date-info {
        @include flexDisplay(row, space-around, center);
        width: 40%;
        height: 6vh;
        border-radius: 10px;
        background-color: white;
        text-align: center;
    }

}
</style>