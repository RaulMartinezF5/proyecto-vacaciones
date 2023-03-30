<script setup>

</script>

<template>
    <div class="pendiente">
        <p>PENDIENTE</p>
    </div>
</template>

<style lang="scss" scoped>
@use "../assets/scss/variables.scss" as c;

.pendiente {
    width: 10vw;
    height: 2.5vw;
    background-color: map-get($map: c.$colors, $key: "Yellow");

    p {
        color: map-get($map: c.$colors, $key: "Black");
        font-size: larger;
        text-align: center;

    }
}
</style>