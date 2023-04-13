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
       


        <div class="wrapper">
         <input type="date" class="start" v-model="startDate" @input="setSelectedDates(startDate,endDate)">
         <input type="date"  class="end" v-model="endDate" @input="setSelectedDates(startDate,endDate)">
        </div>
        <!-- <p> {{ remainingWorkingDays }}</p> -->
         
       
    </div>
</template>

<style lang="scss" scoped>
.wrapper{
    display: flex;
    justify-content: center;
    gap: 30px;
    margin-bottom: 30px;
    
    input{
       display: flex;
       justify-content: space-around;
        width: 25vw;
        height: 7vh;
        border-radius: 10px;
        background-color: white;
        font-size: 25px;
        margin: 30px;
      
        input .start{
  
        }
        input .end{
        


        }
    }
   
}
</style>