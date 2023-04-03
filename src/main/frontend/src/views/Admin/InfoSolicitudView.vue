<script setup>
import ButtonComponent from '../../components/ButtonComponent.vue';
import Header from '../../components/Header.vue';
import rechazada from '../../components/Rechazada.vue';


</script>


<template>
    <Header />
    <h1 class="titulo">
        Información de Solicitud
    </h1>

    <div class="responsable">
        <h2 class="Responsable"> Responsable</h2>
    </div>


    <div class="rechazada">
        <h2 class="solicitud">Solicitud:</h2>
        <rechazada />
    </div>
    <div class="texto">
        <textarea name="fecha" id="fecha" placeholder="Fecha" cols="70" rows="2"></textarea>
        <textarea name="Escribe comentario" placeholder="Comentario" id="comentario" cols=70 rows=5></textarea>
    </div>


    <div class="Button">
        <ButtonComponent :button="'Equipo'" />
        <ButtonComponent :button="'Empleado'" />
    </div>
</template>


<style lang="scss" scoped>
.Responsable {
    // margin-left: 70px;
    // margin-right: 700px;
    // margin-top: 150px;
}

.titulo {
    display: flex;
    justify-content: end;
    margin-right: 350px;
    margin-top: 30px;
}

.solicitud {
    display: flex;
    margin-top: 50px;
    margin-left: 590px;
}

.rechazada {
    display: flex;
    flex-direction: row;
    margin-left: 70px;
    margin-top: 53px;


}

#comentario {
    display: flex;
    margin-top: 30px;
    margin-bottom: 20px;
    margin-left: 190px;
    background-color: white;
}

#fecha {
    display: flex;
    margin-top: 30px;
    margin-left: 190px;
    background-color: white;
}


.button {
    margin-top: 20px;
    color: white;
}

.texto {
    margin-left: 500px;
    background-color: #D9D9D9;
    border-style: groove;
}
</style>