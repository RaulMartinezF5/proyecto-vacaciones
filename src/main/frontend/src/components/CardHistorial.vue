<script setup>
import { computed } from "vue";
import StateIndicator from "./StateIndicator.vue";

const props = defineProps({
  request: {
    type: Object
  }
});

const emits = defineEmits(['emitRequestDetails'])

const emitRequestDetails = () => {
  emits('emitRequestDetails', {
    userDocument: props.request.userDocument,
    requestId: props.request.requestUser.id
  })
}
const fake = {
  name: "iyan",
  nameschool: "AST",
  date: "2015-12-16",
  description: "Lorem Ips dolor sit am",
  days: 5,
  checked: "Raul",
  state: null,
};

const invertedDate = computed(() => {
  const startDateParts = props.request.requestUser.startDate.split('-');
  startDateParts.reverse();
  const newStartDate = startDateParts.join('/');

  const endDateParts = props.request.requestUser.endDate.split('-');
  endDateParts.reverse();
  const newEndDate = endDateParts.join('/');

  return `${newStartDate} - ${newEndDate}`;
});

</script>

<template>

    
    <div class="wrapper" @click="emitRequestDetails()">
      <h2>{{ request.name }}</h2>
      <v-card class="wrapper-card">
        <v-card-text>
          <div class="card-titles d-flex">
            <p class="school d-flex text-h6 font-weight-bold">
              Nombre de la escuela:
              {{ request.schoolOfUser }}
            </p>
            <p class=" dates relative font-weight-medium mt-1">
              {{ invertedDate }}
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

              <p class="dos text-sm font-weight-bold">
                Revisado por: {{ fake.checked }}
              </p>

            </div>

            <p class="card-description d-flex" >
                {{ request.requestUser.issue }}
              </p>
          </div>

        </v-card-text>
      </v-card>
    </div>

</template>

<style lang="scss" scoped>

.wrapper {
  width: 100%;
  background-color: #d9d9d9;
  display: flex;
  justify-content: space-around;
  align-items: center;
  flex-direction: column;
  align-items: center;

  h1 {
  display: flex;
  justify-content: center;
}

  .wrapper-card {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    flex-wrap: wrap;
    justify-content: center;
    align-self: center;
    width: 90%;
    margin-bottom: 2%;

    .card-titles {
      display: flex;
      justify-content: space-around;

      .school {
        display: flex;
        justify-self: flex-start;

      }
      .dates{
        display: flex;
      }
    }

    .card-container {
      flex-direction: row-reverse;
      justify-content: space-between;

      .card-description {
        margin: 3% 0 0 3%;
      }

      .counter {
        margin: 3% 3% 1% 0;
        align-items: flex-end;
        width: 100%;
        font-size: 1rem;
      }
    }
  }
}
</style>
