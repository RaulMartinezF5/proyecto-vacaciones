<script setup>
import { ref } from 'vue';
import { useAdminStore } from '../stores/adminStore';
import CreateUserPayload from '../apiCall/payloads/CreateUserPayload';
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



const nameRules = [
  (value) => !!value || 'Es necesario un nombre.',
  (value) => value.length <= 30 || 'El nombre debe tener 30 caracteres o menos.'
]

const surnamesRules = [
  (value) => !!value || 'Es necesario un apellido.',
  (value) => value.length <= 40 || 'El apellido debe tener 40 caracteres o menos.'
]

const dniRules = [
  (value) => !!value || 'DNI/NIE/Pasaporte es necesario',
  (value) => /^[a-zA-Z0-9]+$/.test(value) || 'DNI/NIE/Pasaporte solo puede tener números y letras.',
  (value) => value.length <= 20 || 'DNI/NIE/Pasaporte debe tener menos de 20 caracteres'
]

const emailRules = [
  (value) => !!value || 'Email es necesario.',
  (value) => /.+@.+\..+/.test(value) || 'Email debe tener un formato válido.'
]


const positionRules = [
  (value) => !!value || 'Es necesaria una posición.'
]

const roleRules = [
  (value) => !!value || 'Tipo de usuario es necesario.'
]

const workplaceRules = [
  (value) => !!value || 'Lugar de trabajo es necesario.'
]


const createUser = async () => {

    const payload = new CreateUserPayload(dni.value,name.value,surnames.value,email.value,adminStore.randomPassword(),vacationDays.value,position.value,role.value, workplace.value, startDay.value,finishDay.value)
    
    console.log(payload.password);
    await adminStore.createUser(payload)
}

const submitForm = async () => {
  if (
    name.value &&
    surnames.value &&
    dni.value &&
    email.value &&
    vacationDays.value &&
    position.value &&
    role.value &&
    workplace.value &&
    startDay.value &&
    finishDay.value
  ) {
    await createUser()
  }
}
</script>

<template>
    <v-form @keyup.enter="submitForm()">

    <div class="container">
        <div class="input-wrapper"> <v-text-field color="#FF4700" label="Nombre" variant="solo" v-model="name" :rules="nameRules">
            </v-text-field></div>

        <div class="input-wrapper"><v-text-field color="#FF4700" label="Apellidos" variant="solo" v-model="surnames" :rules="surnamesRules">
            </v-text-field></div>

        <div class="input-wrapper"> <v-text-field color="#FF4700" label="DNI/NIE/Pasaporte" variant="solo" v-model="dni" :rules="dniRules">
            </v-text-field></div>

        <div class="input-wrapper"><v-text-field color="#FF4700" label="Correo electrónico" variant="solo" v-model="email" :rules="emailRules">
            </v-text-field></div>

        <div class="input-wrapper"> <v-text-field color="#FF4700" label="Cantidad de Vacaciones" variant="solo"
                v-model="vacationDays"> </v-text-field></div>

        <div class="input-wrapper"><v-select color="#FF4700" label="Posición" variant="solo"
                :items="['Formador', 'Coformador', 'Responsable de Promoción']" v-model="position" :rules="positionRules"> </v-select></div>

        <div class="input-wrapper"><v-select color="#FF4700" label="Tipo de Usuario" variant="solo"
                :items="['Responsable', 'Empleado', 'Admin']" v-model="role" :rules="roleRules"> </v-select></div>

        <div class="input-wrapper"><v-select color="#FF4700" label="Lugar de trabajo" variant="solo"
                :items="['Asturias', 'Madrid', 'Barcelona', 'Málaga', 'Sevilla', 'Norte']" v-model="workplace" :rules="workplaceRules"> </v-select>
        </div>

        <div class="input-wrapper"> <v-text-field color="#FF4700" label="Fecha de alta" variant="solo" type="date"
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
    </v-form>
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
        text-transform: uppercase;
    }
}
</style>