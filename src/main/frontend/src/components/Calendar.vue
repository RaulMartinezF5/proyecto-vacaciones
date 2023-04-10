<script setup>
import {ref, watch} from "vue";
import dayjs from "dayjs";

const startDate = ref("");
const endDate = ref("");

const nonWorkingDays = ref(["Saturday", "Sunday"]);
const remainingWorkingDays = ref(0);


const calculate = () =>{
    if(!startDate.value || !endDate.value){
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

    remainingWorkingDays.value = remainingDays;
};


watch(startDate, calculate);
watch(endDate, calculate);

const setSelectedDates = (start, end) => {
    startDate.value = start;
    endDate.value = end;
     calculate();
};








</script>
<template>
    <div>
        <!--mostramos el calendario-->

        <div>
         <input type="date" v-model="startDate" @input="setSelectedDates(startDate,endDate)">
         <input type="date" v-model="endDate" @input="setSelectedDates(startDate,endDate)">
        </div>
         
        <p>Dias habiles restantes: {{ remainingWorkingDays }}</p>
       
    </div>
</template>
<style lang="scss" scoped>
</style>