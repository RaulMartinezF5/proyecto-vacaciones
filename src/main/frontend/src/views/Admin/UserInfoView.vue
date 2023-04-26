<script setup>
import FormComponent from '../../components/FormComponent.vue';
import { useRoute } from 'vue-router';
import { computed, onBeforeMount, ref } from 'vue';
import { useAdminStore } from '../../stores/adminStore';

const route = useRoute()
const adminStore = useAdminStore()
const adviceEdit = ref(false)
const adviceUserFired = ref(false)

onBeforeMount(async () => {
    await adminStore.findTemporalUser(parseInt(route.params.document))
})

const editUserExist = async (emit) => {
    await adminStore.editUser(emit, emit.document)
    await adminStore.findTemporalUser(parseInt(route.params.document))

    adviceEdit.value = true
    setTimeout(() => {
        adviceEdit.value = false
    }, 2000);
}

</script>

<template>
    <div class="info-user-wrapper">
        <h1>INFORMACION DEL USUARIO</h1>
        <transition>
            <v-alert v-if="adviceEdit == true" type="success" title="Usuario editado" width="30%"></v-alert>
        </transition>
        <transition>
            <v-alert v-if="adviceUserFired == true" type="warnning" title="Usuario editado" width="30%"></v-alert>
        </transition>

        <div class="form-wrapper">

            <FormComponent @emit-edit-user="editUserExist" :user="adminStore.temporalUserInfo" :view="'userDetails'" />
        </div>
    </div>
</template>

<style lang="scss" scoped >
@use '../../assets/scss/main' as *;

.info-user-wrapper {

    @include flexDisplay(column, normal, center);
    width: 100%;
    height: 100%;

    h1 {
        text-align: center;
        margin-top: 3vh;
    }

    .form-wrapper {
        width: 100%;
        height: 90vh;
        display: flex;
        flex-direction: column;
        justify-content: center;
        row-gap: 2vh;

    }

    .v-enter-active,
    .v-leave-active {
        transition: opacity 0.5s ease;
    }

    .v-enter-from,
    .v-leave-to {
        opacity: 0;
    }
}
</style>