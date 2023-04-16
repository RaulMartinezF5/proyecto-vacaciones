<script setup>
import Request from "../components/Request.vue"

</script>

<template>
    <div class="request-wrapper">
        <div class="card-request">
            <div class="selection-zone">
                <h3>Solicitud de dias de: </h3>
                <select class="label">
                    <option value="vacaciones"> vacaciones</option>
                    <option value="permisos"> permisos</option>
                </select>
            </div>
            <div class="request-space">
                <Request />
            </div>
        </div>
    </div>
</template>

<style scoped lang="scss">
@use "../assets/scss/variables.scss" as c;
@use '../assets/scss/main' as *;

.request-wrapper {
    width: 100%;
    @include flexDisplay(row, center, center);

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
        }
    }

}
</style>
