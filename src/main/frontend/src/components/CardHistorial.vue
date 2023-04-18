<script setup>
import StateIndicator from "./StateIndicator.vue";

const props = defineProps({
  request: {
    type: Object
  }
});


const fake = {
  name: "iyan",
  nameschool: "AST",
  date: "2015-12-16",
  description: "Lorem Ips dolor sit am",
  days: 5,
  checked: "Raul",
  state: null,
};


</script>

<template>
  <div class="main">
    
    <div class="wrapper">
      <h2>{{ request.name }}</h2>
      <v-card class="wrapper-card">
        <v-card-text>
          <div class="card-titulos d-flex">
            <p class="school d-flex text-h6 font-weight-bold">
              Nombre de la escuela:
              {{ request.schoolOfUser }}
            </p>
            <p class="relative font-weight-medium mt-1">
              {{ request.requestUser.startDate }} {{ request.requestUser.endDate }}
            </p>
            <p class="relative font-weight-medium mt-1">
              <StateIndicator :state="request.requestUser.state"/>
            </p>
          </div>

          <div class="card-container d-flex">
            <div class="counter d-flex flex-column">
              <p class="uno text-sm font-weight-bold">
                Dias solicitados:{{ request.requestUser.quantityOfDays }}
              </p>
              <p class=" dos text-sm font-weight-bold">
                Revisado por: {{ fake.checked }}
              </p>
              <p class=" card-description d-flex top-12 ml-1 mr-1" >
                {{ request.requestUser.issue }}
              </p>

            </div>
          </div>

        </v-card-text>
      </v-card>
    </div>
  </div>
</template>

<style lang="scss" scoped>
h1 {
  display: flex;
  justify-content: center;
}

.wrapper {
  width: 100%;
  background-color: #d9d9d9;
  display: flex;
  justify-content: space-around;
  align-items: center;
  flex-direction: column;
  align-items: center;


  .wrapper-card {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    flex-wrap: wrap;
    justify-content: center;
    align-self: center;
    width: 90%;
    margin-bottom: 2%;

    .card-titulos {
      display: flex;
      justify-content: space-around;

      .school {
        display: flex;
        justify-self: flex-start;

      }
    }

    .card-container {
      display: flex;
      flex-direction: row;
      justify-content: space-between;

      .card-description {
        display: flex;

      }

      .counter {
        display: flex;
        width: 100%;
        font-size: 18px;
      }
    }
  }
}
</style>
