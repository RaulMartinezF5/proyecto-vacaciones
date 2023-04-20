<script setup>
import FormComponent from '../../components/FormComponent.vue';

</script>

<template>
    <h1>CREAR USUARIO</h1>
    <div class="form-wrapper">

            <FormComponent />
        

    </div>
</template>

<style lang="scss" scoped>
    h1 {
        text-align: center;
        margin-top: 3vh;
        text-transform: uppercase;
    }
.form-wrapper {
    width: 100%;
    height: 90vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    row-gap: 2vh;

}
</style>