<script setup>
import { ref } from 'vue';
import ButtonComponent from './ButtonComponent.vue';

const responsableDocument = ref('')
const employeDocument = ref('')
const emits = defineEmits(['emitEmploye'],['emitResponsable'] )

const employeEmit = ()=>{ 

    emits('emitEmploye',employeDocument.value)
}
const responsableEmit = ()=>{

    emits('emitResponsable', responsableDocument.value)
}
const props = defineProps({
    employes: {
        type: Array,
        required: true
    },
    responsables: {
        type: Array,
        required: true
    },
    employesOfResponsable: {
        type: Array,
        required: false
    }
})

</script>
<template>
    <div class="create-teams-wrapper">
        <div class="input-zone">

            <select v-model="responsableDocument" placeholer="Responsable" name="responsables" id="responsables" @change="responsableEmit()">
                <option v-for="responsable of responsables" :value="`${responsable.document}`">{{ `${responsable.profile.firstName} ${responsable.profile.lastName}` }}</option>
            </select>
            <select v-model="employeDocument" placeholder="Empleados" name="employes" id="employes" @change="employeEmit()">
                <option v-for="employe of employes" :value="employe.document">{{ `${employe.profile.firstName} ${employe.profile.lastName}`}}</option>
            </select>
        </div>
        <div class="list-zone">
            <ul>
                <li v-for="employe of employesOfResponsable">{{ `${employe.profile.firstName} ${employe.profile.lastName}` }}</li>
            </ul>
        </div>
        <div class="button-zone">
            <ButtonComponent  :button="'Añadir'"/>
        </div>
    </div>
</template>
<style lang="scss" scoped>
@use '../assets/scss/main' as *;

.create-teams-wrapper {
    width: 100%;
    @include flexDisplay(column, center, center);
    gap: 3vh;

    .input-zone {
        width: 100%;
        @include flexDisplay(column, center, center);
        gap: 2vh;

        select {
            width: 80%;
            text-align: center;
            height: 4vh;
            box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
            border-radius: 5px;
        }
    }

    .list-zone {
        width: 80%;
        height: 40vh;
        @include flexDisplay(column, center, center);
        box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
        border-radius: 5px;
    }

    .button-zone{
        width: 50%;
        border-radius: 10px;
    }
}
</style>