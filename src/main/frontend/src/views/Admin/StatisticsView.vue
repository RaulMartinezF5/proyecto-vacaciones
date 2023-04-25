<script setup>
import iconArrowLeft from '@/assets/img/iconArrowLeft.png';
import ButtonComponent from '../../components/ButtonComponent.vue';
import {ref ,onBeforeMount} from 'vue';
import GrafficaLine from '../../components/GrafficaLine.vue';
import GrafficaBar from '../../components/GrafficaBar.vue';
import GrafficasDonut from '../../components/GrafficasDonut.vue';
import {useAdminStore} from '../../stores/adminStore';
import {useAuthStore} from '../../stores/authStore'


const adminstore = useAdminStore ();
const authstore = useAuthStore();



onBeforeMount(() => {
    adminstore.listAllRequests();
  
})


    

const schoolsName = ref([]);
const valuesSchool = ref([]);

const schoolsData = () =>{
  let quatitySchool = new Map();
  
  for (const request of adminstore.allRequests) {
      if (request.schoolOfUser != undefined) {
          if (quatitySchool.has(request.schoolOfUser)) {
              quatitySchool.set(request.schoolOfUser,quatitySchool.get(request.schoolOfUser)+1)
            
            
           }
          if (!quatitySchool.has(request.schoolOfUser)) {
             quatitySchool.set(request.schoolOfUser,1) 
             schoolsName.value.push(request.schoolOfUser);
          }
      }

  }
  
  for (const entry of quatitySchool.values()) {
    valuesSchool.value.push(entry)
  }
 
  return quatitySchool

}


       
const labels= schoolsData();

const datas = {
  labels: schoolsName.value,
  datasets: [{
    label: 'Grafica',
    data: valuesSchool.value,
    backgroundColor: [
      'rgba(255, 99, 132, 0.2)',
      'rgba(255, 159, 64, 0.2)',
      'rgba(255, 205, 86, 0.2)',
      'rgba(75, 192, 192, 0.2)',
      'rgba(54, 162, 235, 0.2)',
      'rgba(153, 102, 255, 0.2)',
      'rgba(201, 203, 207, 0.2)'
    ],
    borderColor: [
      'rgb(255, 99, 132)',
      'rgb(255, 159, 64)',
      'rgb(255, 205, 86)',
      'rgb(75, 192, 192)',
      'rgb(54, 162, 235)',
      'rgb(153, 102, 255)',
      'rgb(201, 203, 207)'
    ],
    borderWidth: 1
  }]
};

    

  


</script>


<template>
    <div class="mainContainer">
        <div class="microheader">
            
            <h1 class="Titulo">
                INFORMES 
            </h1>
        </div>

        <div class="buttons">
            <ButtonComponent :button="'Escuela'" class="buttonFix"/>
            <ButtonComponent :button="'Puesto'" class="buttonFix"/>
            <ButtonComponent :button="'Estado'" class="buttonFix"/>
        </div>

        <div class="container">
            <div class="container__graficas">
                <div class="grafica__bar">
                    
                          <GrafficaBar :graph="datas"/> 
                      </div>
                      <div class="grafica__line">
                          <GrafficaLine :graph="datas"/>
                      </div>
                    
            </div>
            <div class="container__donut">
                <div class="grafica__donut">
                    <GrafficasDonut :graph="datas"/>
                </div>
            </div>

        </div>
            

    </div>
</template>


<style scoped lang="scss">
.mainContainer {
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    padding: 2% 5%;

    .microheader {
        display: flex;
        justify-content: center;
        .button-arrow{
            position: absolute;
            left: 24%;
        }
    }
    .buttons {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        width: 100%;
        margin-top: 2%;
        .buttonFix {
            width: 25%;
        }
    }
    .container {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        height: 100%;
        width: 100%;
        margin-top: 2%;
        
        .container__graficas{
            display: flex;
            flex-direction: column;
            height: 100%;
            width: 48%;
        
            .grafica__bar{
               
                background-color: white;
                height: 250px;
                border: 1px solid black;
                margin-top: 2%;
                margin-left: 0%;
                width: 100%;
               
            }
            
            .grafica__line {
               
                background-color: white;
                height: 250px;
                border: 1px solid black;
                margin-top: 2%;
                margin-left: 0%;
                width: 100%;
            }
        }
        .container__donut{
                display: flex;
                position: relative;
                bottom: 56%;
                width: 48%;
                height: 100%;
    
            .grafica__donut {
                    height: 510px;
                    background-color: white;
                    border: 1px solid black; 
                    margin-top: 2%;
                    margin-left: 0;
                    width: 100%;
                    
                }
            }
        }   
    }  


</style>