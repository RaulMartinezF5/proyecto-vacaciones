<script setup>

const props = defineProps({
  profile: {
    type: Object
  },
  school: {
    type: String
  }

});

</script>

<template>
  <div class="d-flex justify-center card-container">
    <v-card width="80%" class="card">
      <v-text>

        <div class="d-flex justify-space-between">

          <v-card-title class="d-flex font-weight-light ml-10 mt-3">
            {{ profile.firstName }} 
            {{ profile.lastName }}
          </v-card-title>

          <p class="d-flex text-h6 font-weight-bold mr-10 mt-3 text-uppercase worker-color">
            {{ profile.position }}
          </p>

        </div>

        <div class="d-flex justify-space-between">

          <p class="d-flex font-weight-bold ml-10 mb-3 location" v-bind="props.description">
            Lugar de trabajo: {{ school }}
          </p>

          <div class="d-flex flex-column">

            <p class="text-sm font-weight-bold mr-10 mb-3 vacations">Vacaciones restantes: {{ profile.hollydays }}</p>
          </div>

        </div>
      </v-text>
    </v-card>
  </div>
</template>

<style lang="scss" scoped>
@use '../assets/scss/variables.scss' as c;

.card {
  border: solid 2.5vh map-get($map: c.$colors, $key: "Grey");
  ;

  .worker-color {
    color: map-get($map: c.$colors, $key: "Orange");
  }

  .location {
    font-size: 1.2rem;
  }

  .vacations {
    font-size: 1.2rem;
  }
}
</style>