<script setup>
import FormComponent from '../../components/FormComponent.vue';
import ButtonComponent from '../../components/ButtonComponent.vue';

</script>

<template>
    <h1>INFORMACION DEL USUARIO</h1>
    <div class="form-wrapper">


        <FormComponent :view="'userDetails'" />

        
    </div>
</template>

<style scoped lang="scss">

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
    align-items: center;

    row-gap: 2vh;

}


</style>