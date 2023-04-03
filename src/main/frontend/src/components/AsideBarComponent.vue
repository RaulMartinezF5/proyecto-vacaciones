<script setup>
import ButtonComponent from './ButtonComponent.vue';
import { computed, ref } from 'vue';

const test = ref('ROLE_RESPONSABLE')

const showRole = computed(()=>{
    if(test.value == 'ROLE_USER') return 'EMPLEADO'
    if(test.value == 'ROLE_RESPONSABLE') return 'RESPONSABLE'
    if(test.value == 'ROLE_ADMIN') return 'ADMIN'
}) 

</script>
<template>
        <aside>
            <div class="image-zone"></div>

            <h1>{{ showRole }}</h1>

            <div v-if="test == 'ROLE_USER'" class="user-info-zone">
                <h1>Nombre</h1>
                <h1>Escuela</h1>
                <h1>Fechas de alta</h1>
                <h1>Cargo</h1>
            </div>

            <div class="navigation-zone">
                <div v-if="test == 'ROLE_USER'" class="navigation">
                    <ButtonComponent :button="'EMPLEADO'" />
                </div>
                <div v-if="test == 'ROLE_RESPONSABLE'" class="navigation">
                    <ButtonComponent :button="'EMPLEADO'" />
                    <ButtonComponent :button="'RESPONSABLE'" />
                </div>
                <div v-if="test == 'ROLE_ADMIN'" class="navigation">
                    <ButtonComponent :button="'CREAR USUARIO'" />
                    <ButtonComponent :button="'PETICIONES'" />
                    <ButtonComponent :button="'INFORMES'" />
                    <ButtonComponent :button="'USUARIOS'" />
                </div>
            </div>
        </aside>
</template>
<style lang="scss" scoped>
@use '../assets/scss/mixins.scss' as *;
aside{
    width: 100%;
    height: 100%;
    @include gridDisplay(10,1);
    .navigation-zone{
        width: 100%;
    }
}
</style>