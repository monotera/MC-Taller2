<template>
  <v-main>
    <v-container class="update-wrapper">
      <h1>Modificar Lugares</h1>
      <v-row align="center" justify="center">
        <v-col cols="12" sm="4"
          ><v-form ref="form" v-model="valid" lazy-validation>
            <v-text-field
              v-model="arrival"
              :counter="20"
              :rules="nameRules"
              label="Lugar de llegada"
              required
            ></v-text-field>
            <v-text-field
              v-model="depature"
              :counter="20"
              :rules="nameRules"
              label="Lugar de salida"
              required
            ></v-text-field>
            <v-btn
              :disabled="!valid"
              color="success"
              class="mr-4"
              @click="validate"
            >
              Enviar!
            </v-btn>
          </v-form>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>

<script>
import axios from "axios";
export default {
  data: () => ({
    valid: true,
    arrival: "",
    depature: "",
    nameRules: [
      (v) => !!v || "Name is required",
      (v) => (v && v.length <= 20) || "Name must be less than 10 characters",
    ],
    select: null,
  }),

  methods: {
    validate() {
      if (this.$refs.form.validate()) {
        let url = `${this.$store.getters.getUrlBase}update_trip_place?id=${this.$route.query.id}&name=${this.nameText}&arrival=${this.arrival}&depature=${this.depature}`;
        axios.put(url).then(() => {
          this.$router.push("/");
        });
      }
    },
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
  width: 100%;
  margin-top: 5rem;
}
</style>
