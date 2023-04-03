<script setup>
import ButtonComponent from './ButtonComponent.vue';
import { computed, ref } from 'vue';

const props = defineProps(
    {
        image: {
            type: String,
            default: '../assets/img/user-default-icon.png'
        }
    }
)

const test = ref('ROLE_ADMIN')

const showRole = computed(() => {
    if (test.value == 'ROLE_USER') return 'EMPLEADO'
    if (test.value == 'ROLE_RESPONSABLE') return 'RESPONSABLE'
    if (test.value == 'ROLE_ADMIN') return 'ADMIN'
})


</script>
<template>
    <aside>
        <div class="image-zone">
            <img src="../assets/img/user-default-icon.png" alt="user default icon">

            <h1>{{ showRole }}</h1>
        </div>

        <div v-if="test == 'ROLE_USER'" class="user-info-zone">
            <div class="info-wrapper">
                <h4>Nombre</h4>
            </div>
            <div class="info-wrapper">
                <h4>Escuela</h4>
            </div>
            <div class="info-wrapper">
                <h4>Fecha de alta</h4>
            </div>
            <div class="info-wrapper">
                <h4>Cargo</h4>
            </div>

        </div>

        <div class="navigation-zone">
            <div v-if="test == 'ROLE_USER'" class="navigation">
                <div class="nav-button-wrapper">
                    <ButtonComponent :button="'EMPLEADO'" />
                </div>
            </div>
            <div v-if="test == 'ROLE_RESPONSABLE'" class="navigation">
                <div class="nav-button-wrapper">
                    <ButtonComponent :button="'EMPLEADO'" />
                </div>
                <div class="nav-button-wrapper">
                    <ButtonComponent :button="'RESPONSABLE'" />
                </div>
            </div>
            <div v-if="test == 'ROLE_ADMIN'" class="navigation">
                <div class="nav-button-wrapper">
                    <ButtonComponent :button="'CREAR USUARIO'" />
                </div>
                <div class="nav-button-wrapper">
                    <ButtonComponent :button="'PETICIONES'" />
                </div>
                <div class="nav-button-wrapper">
                    <ButtonComponent :button="'INFORMES'" />
                </div>
                <div class="nav-button-wrapper">
                    <ButtonComponent :button="'USUARIOS'" />
                </div>
            </div>
        </div>
    </aside>
</template>
<style lang="scss" scoped>
@use '../assets/scss/_main.scss' as *;

aside {
    width: 100%;
    height: 100%;
    @include gridDisplay(10, 1);

    .image-zone{
        @include positionGrid(2, 1, 6, 1);
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
        img{
            width: 80%;
            height: 80%;
        }
    }

    .navigation-zone {
        width: 100%;
        @include positionGrid(7, 1, 11, 1);
        display: flex;
        flex-direction: column;
        align-items: center;

        .navigation {
            width: 90%;
            @include gridDisplay(4, 1);
            row-gap: 2vh;

            .nav-button-wrapper {
                width: 100%;
                border-radius: 10px;
                overflow: hidden;
            }
        }

    }

    .user-info-zone {
        display: flex;
        flex-direction: column;
        align-items: center;
        row-gap: 1vh;
        width: 100%;

        .info-wrapper {
            width: 90%;
            border: map-get($map: $colors, $key: "Orange") solid 2px;
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    }
}
</style>