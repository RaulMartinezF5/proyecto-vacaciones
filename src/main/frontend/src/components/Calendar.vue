<script>
import VueDatepicker from 'vue-datepicker';
import moment from 'moment';


// definimos las variables las que alacenen las fechas seleccionadas en el calendario

export default {
    components:{
        Datepicker,
    },
    data(){
        return {
    
            startDate:null,
            endDate:null,
            CountFinal:null,
        };

    },

    methods: {
        Count(){
            if(this.start && this.endDate){
                const start = moment(this.startDate);
                const end = moment(this.endDate);
                const CountFinal = end.diff(strat,'days') + 1
                this.CountFinal = CountFinal
            }
        },
    },

};

</script>
<template>
    <div>
        <!--mostramos el calendario-->
        <datepicker v-model="startDate" :range-end="endDate" @input="Count"></datepicker>
        <datepicker v-model="endDate" :range-end="startDate" @input="Count"></datepicker>
        <div>{{ CountFinal}}</div>
        
    </div>
</template>
<style lang="scss" scoped>
</style>