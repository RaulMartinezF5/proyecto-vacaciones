<script setup>
import { onBeforeMount, onUpdated, ref } from "vue";
import Request from "../components/Request.vue"
import { useAuthStore } from '../stores/authStore'
import { useUserStore } from '../stores/userStore'
import CreateRequestPayload from "../apiCall/payloads/CreateRequestPayload";
import SimpleRequestComponent from "../components/SimpleRequestComponent.vue";

const authStore = useAuthStore()
const userStore = useUserStore()

const typeOfRequest = ref('Vacaciones')
const cause = ref('')

onBeforeMount(async () => {
    await userStore.viewAllRequests(authStore.username)
})

const createRequest = async (element) => {

    if(typeOfRequest.value === 'Vacaciones') cause.value = 'Vacaciones'
    let payload = new CreateRequestPayload(element.issue, 'Default', element.startDate, element.endDate, typeOfRequest.value, cause.value, element.days)
    

    userStore.createRequest(payload, authStore.username)
 
}

onUpdated(async () => {
    await userStore.viewAllRequests(authStore.username)
    })
</script>

<template>
    <div class="request-wrapper">
        <div class="card-request">
            <div class="selection-zone">
                <h3>Solicitud de dias de: </h3>
                <select v-model="typeOfRequest" class="label">
                    <option value="Vacaciones">Vacaciones</option>
                    <option value="Permiso">Permiso</option>
                </select>
            </div>

            <div class="request-space">
                <div class="cause-request-zone" v-if="typeOfRequest === 'Permiso'">
                    <h3>motivo del permiso: </h3>
                    <select v-model="cause" class="label">
                        <option value="Matrimonio">Matrimonio</option>
                        <option value="Nacimiento hijo/a">Nacimiento hijo/a</option>
                    </select>
                </div>
                <Request @emit-basic-emit-info="createRequest" />
            </div>
        </div>
        <div class="user-requests-zone">
            <SimpleRequestComponent v-for="request of userStore.allUserRequests" :request="request"/>
        </div>
    </div>
</template>

<style scoped lang="scss">
@use '../assets/scss/main' as *;

.request-wrapper {
    width: 100%;
    @include flexDisplay(column, center, center);
    gap: 2vh;

    .card-request {
        width: 90%;
        border-radius: 10px;
        margin-top: 2vh;
        @include flexDisplay(column, center, center);

        .selection-zone {
            width: 100%;
            @include flexDisplay(row, center, center);
            font-weight: bold;

            .label {
                margin-left: 1%;
            }
        }

        .request-space {
            width: 100%;
            @include flexDisplay(column, center, center);

            .cause-request-zone {
                width: 100%;
                @include flexDisplay(row, center, center);
                background-color: map-get($map: $colors, $key: "Grey");
            }
        }
    }

    .user-requests-zone{
        width: 90%;
        @include flexDisplay(column, center, center);
        gap: 2vh;
    }

}
</style>
