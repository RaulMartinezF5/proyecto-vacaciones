<script setup>
import { ref } from 'vue';
import { useAdminStore } from '../stores/adminStore'
import CreateUserPayload from '../apiCall/payloads/CreateUserPayload'
import ButtonComponent from '../components/ButtonComponent.vue';


const adminStore = useAdminStore()

const props = defineProps({
    view: {
        type: String,
        default: 'create'
    }
})

const name = ref('');
const surnames = ref('');
const dni = ref('');
const email = ref('');
const vacationDays = ref('');
const startDay = ref('');
const finishDay = ref('');
const position = ref('');
const role = ref('');
const workplace = ref('');

const createUser = async () => {

    const payload = new CreateUserPayload(dni.value,name.value,surnames.value,email.value,adminStore.randomPassword(),vacationDays.value,position.value,role.value, workplace.value, startDay.value,finishDay.value)
    
    console.log(payload.password);
    await adminStore.createUser(payload)
}


</script>

<template>
    <div class="container">
        <div class="input-wrapper"> <v-text-field color="#FF4700" label="Nombre" variant="solo" v-model="name">
            </v-text-field></div>
        <div class="input-wrapper"><v-text-field color="#FF4700" label="Apellidos" variant="solo" v-model="surnames">
            </v-text-field></div>
        <div class="input-wrapper"> <v-text-field color="#FF4700" label="DNI/NIE/Pasaporte" variant="solo" v-model="dni">
            </v-text-field></div>
        <div class="input-wrapper"><v-text-field color="#FF4700" label="Correo electrónico" variant="solo" v-model="email">
            </v-text-field></div>
        <div class="input-wrapper"> <v-text-field color="#FF4700" label="Cantidad de Vacaciones" variant="solo"
                v-model="vacationDays"> </v-text-field></div>
        <div class="input-wrapper"><v-select color="#FF4700" label="Posicion" variant="solo"
                :items="['Formador', 'Coformador', 'Responsable de Promocion']" v-model="position"> </v-select></div>
        <div class="input-wrapper"><v-select color="#FF4700" label="Tipo de Usuario" variant="solo"
                :items="['Responsable', 'Empleado', 'Admin']" v-model="role"> </v-select></div>
        <div class="input-wrapper"><v-select color="#FF4700" label="Lugar de trabajo" variant="solo"
                :items="['Asturias', 'Madrid', 'Barcelona', 'Malaga', 'Sevilla', 'Norte']" v-model="workplace"> </v-select>
        </div>
        <div class="input-wrapper"> <v-text-field color="#FF4700" label="Fecha de entrada" variant="solo" type="date"
                v-model="startDay"> </v-text-field></div>
        <div class="input-wrapper"><v-text-field color="#FF4700" label="Fecha de baja" variant="solo" type="date"
                v-model="finishDay"> </v-text-field></div>
    </div>
    <div v-if="view != 'create'" class="button-zone">
        <div class="button-wrapper">
            <ButtonComponent :type="'warning'" :button="'EDITAR'" />
        </div>
        <div class="button-wrapper">
            <ButtonComponent :type="'reject'" :button="'DAR DE BAJA'" />
        </div>
    </div>
    <div v-if="view === 'create'" class="button-zone">
        <div class="button-wrapper">
            <ButtonComponent :button="'CREAR'" @click="createUser()"/>
        </div>
    </div>
</template>

<style lang="scss" scoped>
@use "../assets/scss/variables.scss" as c;

.container {
    display: grid;
    grid-template-columns: 32% 32%;
    gap: 1vh;
    width: 100%;
    justify-content: center;

    .input-wrapper {
        border-radius: 10px;

    }




}

.button-zone {
    width: 100%;
    display: flex;
    justify-content: space-evenly;
    align-items: center;

    .button-wrapper {
        width: 30%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
}</style>