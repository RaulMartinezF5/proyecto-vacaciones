<script setup>
import FormComponent from '../../components/FormComponent.vue';
import ButtonComponent from '../../components/ButtonComponent.vue';

</script>

<template>
    <h1>CREAR USUARIO</h1>
    <div class="form-wrapper">

        
            <FormComponent />
        
        <div class=" button-zone">
            <div class="button">
                <ButtonComponent :button="'CREAR'" />
            </div>
        </div>
    </div>
</template>

<style lang="scss" scoped>
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



    .form {
        
    }

    .button-zone {
        width: 100%;
        display: flex;
        justify-content: flex-end;
        
    }

    .button {
        width: 40%;
        margin-top: 2vw;
        display: flex;
        justify-content: center;
        align-items: center;
        color: white;
        font-weight: 700;
    }
}
</style>