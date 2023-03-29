<script setup>
import { RouterLink } from "vue-router";
import { computed } from "@vue/reactivity";
import { ref } from "vue";
const date = computed({
    get() {
        let today = new Date();
        let day = today.getDate();
        let month = today.getMonth() + 1;
        let year = today.getFullYear();
        day = ("0" + day).slice(-2);
        month = ("0" + month).slice(-2);
        return `${day}/${month}/${year}`;
    },
});

const hourElement = ref('')
function updateTime() {
  const currentDate = new Date();
  const hour = currentDate.getHours();
  const minutes = currentDate.getMinutes();
  const seconds = currentDate.getSeconds();

  hourElement.value = `${hour}:${minutes}:${seconds}`;
}

setInterval(updateTime, 1000);

</script>

<template>
    <header>
        <figure>
            <img src="../assets/logo.png" alt="FactoriaF5">
        </figure>
        <div id="info">
            <p id="date">{{ date }}</p>
        </div>
        <div>
            <p id="hour">{{ hourElement }}</p>
        </div>
     <button class="logout"><img src="../assets/🦆 icon _log out_.png" alt=""></button>
    </header>
</template>

<style  lang="scss" scoped>
header {
    width: 100%;
  display: flex;
  
}

figure {
    margin: 0;
    width: 48vw;
    margin-left: 1vw;
    margin-top: 1vw;
}

img {
    height: 7vw;
}

#info {
    display: flex;
    display: block;
    justify-content: center;
   
    }

    #date {
      font-family: Dosis;
      font-size: 1.5vw;
      position: absolute;
      right: 2vw;
      top: 2.5vw;
      margin-right: 15vw;
    }

    #hour {
      font-family: Dosis;
      font-size: 1.5vw;
      position: absolute;
      right: 2vw;
      top: 2.5vw;
      margin-right: 9vw;
    }

    .logout{
      width: 0.5vw;  
      height: 0.5vw;
      position: absolute;
      right: 2vw;
      top: 2.5vw;
      margin-right: 5vw;
    }

</style >