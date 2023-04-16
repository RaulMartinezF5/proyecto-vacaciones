<script setup>
import { ref, watch } from "vue";
// import dayjs from "dayjs";

const startDate = ref("")
const endDate = ref("")


/* const nonWorkingDays = ref(["Saturday", "Sunday"]); */
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
    /*  if(!startDate.value || !endDate.value){
         remainingWorkingDays.value = 0;
         return;
     }
 
     let remainingDays = 0;
     let date = dayjs(startDate.value);
 
     while(date.isBefore(dayjs(endDate.value))){
         if(!nonWorkingDays.value.includes(date.format("dddd"))){
             remainingDays++;
 
         }
         date = date.add(1,"day");
     }
 
     remainingWorkingDays.value = remainingDays; */
};

/*
watch(startDate, calculate);
watch(endDate, calculate);


const setSelectedDates = (start, end) => {
    startDate.value = start;
    endDate.value = end;
      calculate(); 
};*/
</script>
<template>
    <div class="dates-wrapper">
        <input class="date-info" type="date" v-model="startDate">
        <input class="date-info" type="date" v-model="endDate" @input="emitVacationDays()">
    </div>
    <!-- <p> {{ remainingWorkingDays }}</p> -->
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