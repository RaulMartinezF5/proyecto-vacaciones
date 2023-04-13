// import axios from 'axios';  
// import { ref } from 'vue';

// export default class apiRequest{
//     request;
//     constructor(){
//         this.request = ref([]);
//     }
//     getRequest(){
//         return this.request.value;
//     }

//     async fetchAllRequest(){
//         try{
//             const response = await axios.get('http://localhost:8080/api/request')
//             .then((response) =>{
//                  this.request.value = response.data.feed.entry;
//             })
           
//         }catch(error){
            
//         }
//     }
// }