<script setup>

</script>

<template>
    <div class="aceptada">
        <p>ACEPTADA</p>
    </div>
</template>

<style lang="scss" scoped>
@use "../assets/scss/variables.scss" as c;

.aceptada {
    width: 7vw;
    height: 2vw;
    background-color: map-get($map: c.$colors, $key: "Green");
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