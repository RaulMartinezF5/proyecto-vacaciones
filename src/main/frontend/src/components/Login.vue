<script setup>
const validate = () => ({
  name: "",
  nameRules: [
    (value) => {
      if (value?.length > 3) return true;
      return "must be contains at least 3 characters";
    },
  ],
  password: "",
  passwordRules: [
    (value) => {
      if (/[0-9]/.test(value)) return true;
      return "password nust be contains digits";
    },
  ],
});
</script>
<template>
  <v-sheet width="37%" class="form mx-auto">
    <v-img :width="'50%'" aspect-ratio="16/9" cover src="../../src/assets/img/logo-login.jpg" class="img"></v-img>
    <v-form ref="form">
      <v-text-field color="#FF4700" v-model="name" :counter="10" :rules="nameRules" label="User Name" required
        class="form__name"></v-text-field>

      <v-text-field v-model="password" color="#FF4700" :counter="10" :rules="passwordRules" label="Password" required
        class="form__pass"></v-text-field>

      <div class="btn">
        <v-btn color="#FF4700" rounded="xs" :width="'50%'" @click="validate">
          Login
        </v-btn>
      </div>
    </v-form>
  </v-sheet>
</template>
<style lang="scss" scoped>
.form {
  box-shadow: 1px 3px 10px 1px rgba(0, 0, 0, 0.48);
  border-radius: 12px;

  .img {
    display: flex;
    max-width: 100%;
    align-content:center;
    position: relative;
    justify-self: center;
    left: 90px;

  }

  .form__name {
    margin: 40px;
    border-radius: 12px;
  }

  .form__pass {
    margin: 40px;
  }

  .btn {
    display: flex;
    justify-content: center;
    width: 100%;
    padding-bottom: 50px;


  }
}
</style>
