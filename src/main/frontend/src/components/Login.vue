<script>
export default {
  data: () => ({
    firstName: "",
    firstNameRules: [
      (value) => {
        if (value?.length > 3) return true;

        return "First name must be at least 3 characters.";
      },
    ],
  }),
};
</script>
<template>
  <v-sheet width="37%" class="form mx-auto">
    <v-img :width="500" aspect-ratio="16/9" cover class="img"></v-img>

    <v-form ref="form">
      <v-text-field
        color="#FF4700"
        v-model="name"
        :counter="10"
        :rules="nameRules"
        label="User Name"
        required
        class="form__name"
      ></v-text-field>

      <v-text-field
        v-model="password"
        color="#FF4700"
        :counter="10"
        :rules="nameRules"
        label="Password"
        required
        class="form__pass"
      ></v-text-field>

      <div class="d-flex flex-column btn">
        <v-btn color="#FF4700" block rounded="xs" @click="validate">
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
}
.img {
  background-image: url("../assets/img/logo-login.jpg");
  width: 500px;
  height: 200px;
  justify-content: center;
  display: flex;
  margin-left: 70px;
  align-self: center;
}

.form__name {
  margin: 40px;
  border-radius: 12px;
}
.form__pass {
  margin: 40px;
}
.btn {
  max-width: 50%;
  margin-left: 130px;
  padding-bottom: 50px;
}
</style>
