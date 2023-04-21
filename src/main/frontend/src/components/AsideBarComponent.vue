<script setup>
import { useAuthStore } from '../stores/authStore';
import ButtonComponent from './ButtonComponent.vue';
import { computed, ref } from 'vue';

function uploadPhoto() {
    let fileInput = document.getElementById("photo-upload");
    let file = fileInput.files[0];
}


const authStore = useAuthStore();



const props = defineProps(
    {
        image: {
            type: String,
            default: '../assets/img/user-default-icon.png'
        }
    }
)


const userRole = computed(() => {
    const roles = {
        'ROLE_ADMIN': 'ADMIN',
        'ROLE_RESPONSABLE': 'RESPONSABLE',
        'ROLE_USER': 'USER'
    }
    return roles[authStore.roleLogin]
})

const showRole = computed(() => {
    if (test.value == 'ROLE_USER') return 'EMPLEADO'
    if (test.value == 'ROLE_RESPONSABLE') return 'RESPONSABLE'
    if (test.value == 'ROLE_ADMIN') return 'ADMIN'
})

const emits = defineEmits(['navigateTo'])

const emitRoute = (navigation) => {
    emits('navigateTo', navigation)
}

</script>
<template>
    <aside>
        <div class="image-zone">
            <img src="../assets/img/user-default-icon.png" alt="user default icon">

            <h1>{{ userRole }}</h1>
            <div class="inputPhoto"><input type="file" name="photo" id="photo-upload"  accept="image/*"></div>
            <div class="buttonPhoto">
                <ButtonComponent :button="'AÑADIR'"/>
            </div>
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
            <div v-if="authStore.roleLogin == 'ROLE_USER'" class="navigation">
                <div class="nav-button-wrapper">
                    <ButtonComponent @click="emitRoute('myRequests')" :button="'EMPLEADO'" />
                </div>
            </div>
            <div v-if="authStore.roleLogin == 'ROLE_RESPONSABLE'" class="navigation">
                <div class="nav-button-wrapper">
                    <ButtonComponent @click="emitRoute('employeResponsableView')" :button="'EMPLEADO'" />
                </div>
                <div class="nav-button-wrapper">
                    <ButtonComponent @click="emitRoute('requestListView')" :button="'RESPONSABLE'" />
                </div>
            </div>
            <div v-if="authStore.roleLogin == 'ROLE_ADMIN'" class="navigation">
                <div class="nav-button-wrapper">
                    <ButtonComponent @click="emitRoute('createUserView')" :button="'CREAR USUARIO'" />
                </div>
                <div class="nav-button-wrapper">
                    <ButtonComponent @click="emitRoute('requestListViewAdmin')" :button="'PETICIONES'" />
                </div>
                <div class="nav-button-wrapper">
                    <ButtonComponent @click="emitRoute('stadisticsView')" :button="'INFORMES'" />
                </div>
                <div class="nav-button-wrapper">
                    <ButtonComponent @click="emitRoute('userListView')" :button="'USUARIOS'" />
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

    .image-zone {
        @include positionGrid(2, 1, 3, 1);
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;

        img {
            width: 50%;
            height: 70%;
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
        @include positionGrid(3, 1, 6, 1);

        .info-wrapper {
            width: 90%;
            border: map-get($map: $colors, $key: "Orange") solid 2px;
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    }

    .inputPhoto {
        display: flex;
        justify-content: center;
        align-items: center;
        margin-left: 1vw;
        margin-top: 2vh;
        width: 47%;
    }

    .buttonPhoto {
        width: 90%;
        height: 5vh;
        border-radius: 10px;
        overflow: hidden;
        margin-top: 1vh;
    }
}
</style>
