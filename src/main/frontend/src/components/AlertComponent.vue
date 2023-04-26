<script setup>
const props = defineProps({
    message: {
        type: String,
        default: "message alert"
    }
})

</script>


<template>
    <div class="Alert">
        <v-alert text="message alert" border="bottom"
      border-color="deep-purple accent-4"
      elevation="2"></v-alert>
       
    </div>
</template>

<style lang="scss" scoped>
.v-alert {
    color:black

}

.Alert {
    border-radius: 10%;

}
</style>