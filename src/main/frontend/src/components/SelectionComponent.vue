<script setup>
import ButtonComponent from './ButtonComponent.vue';

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

const emits = defineEmits(['selecEmploye', 'selectResponsable'])

const emitResponsable = (document) => {
    emits('selectResponsable', document)
}
const emitEmploye = (document) => {
    emits('selecEmploye', document)
}
</script>
<template>
    <div class="create-teams-wrapper">
        <div class="input-zone">
            <select name="responsables" id="responsables" @select="emitResponsable">
                <option v-for="responsable of responsables" :value="responsable">{{ responsable }}</option>
            </select>
            <select name="employes" id="employes" @select="emitEmploye">
                <option v-for="employe of employes" :value="employe">{{ employe }}</option>
            </select>
        </div>
        <div class="list-zone">
            <ul>
                <li v-for="employe of employesOfResponsable">{{ employe }}</li>
            </ul>
        </div>
        <div class="button-zone">
            <ButtonComponent :button="'Añadir'"/>
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
            border: 2px map-get($map: $colors, $key: "Orange") solid;
            border-radius: 10px;
        }
    }

    .list-zone {
        width: 80%;
        height: 40vh;
        @include flexDisplay(column, center, center);
        border: 2px map-get($map: $colors, $key: "Orange") solid;
        border-radius: 10px;
    }

    .button-zone{
        width: 50%;
        border-radius: 10px;
    }
}</style>