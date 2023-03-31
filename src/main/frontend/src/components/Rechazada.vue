<script setup>

</script>

<template>
    <div class="rechazada">
        <p>RECHAZADA</p>
    </div>
</template>

<style lang="scss" scoped>
@use "../assets/scss/variables.scss" as c;

.rechazada {
    width: 7vw;
    height: 2vw;
    background-color: map-get($map: c.$colors, $key: "Coral");
    display: flex;
    justify-content: center;
    align-items: center;
    p {
        color: black;
        font-size: small;
        text-align: center;
        display: flex; 
    }
}
</style>