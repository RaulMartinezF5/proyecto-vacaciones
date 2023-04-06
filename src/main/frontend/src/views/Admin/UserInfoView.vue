<script setup>
import FormComponent from '../../components/FormComponent.vue';
import ButtonComponent from '../../components/ButtonComponent.vue';

</script>

<template>
    <h1>INFORMACION DEL USUARIO</h1>
    <div class="form-wrapper">


        <FormComponent />

        <div class=" button-zone">
            <div class="button-editar">
                <ButtonComponent :type="'warning'" :button="'Editar'" />
            </div>
            <div class="button-baja">
                <ButtonComponent :type="'reject'" :button="'Dar de baja'" />
            </div>
        </div>
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

    row-gap: 2vh;



    .form {
        
    }

    .button-zone {
        width: 100%;
        display: flex;
        justify-content: flex-end;
    


        .button {
        width: 15vw;
        margin-top: 2vw;
        display: flex;
        color: black;
        font-weight: 700;
        align-items: center;
        margin-right: 14vw;
        font-size: medium;
    
    }
    }

  
}


</style>