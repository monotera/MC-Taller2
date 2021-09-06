# Taller 2 parte 1

## Project setup client

### Pre requirements
You must have npm and vue installed

### npm intallation
Here is a guide for installing npm
https://nodejs.org/es/download/package-manager/

### vue installation
After installing npm, just run the `npm install vue` command<br/>
If you want to have a view of the project with a graphical interface, you can install vue cli with the following command `npm install -g @vue/cli`

### Project setup
1. Clone the repository.
2. You will find the `package.json`. You can run `npm i` to install the dependencies.

### Dependencies

* vuex
* vuetify
* vue-router
* vue
* sass-loader
* connect-history-api-fallback
* core-js

### DevDependencies

* babel-eslint
* eslint
* eslint-plugin-vue
* vue-template-compiler

### Scripts

* Compiles and hot-reloads for development `npm run serve`
* Run vue graphic interface `vue ui`
* Compiles and minifies for production `npm run build`
* Lints and fixes files `npm run lint`


## Project setup server

### Pre requirements
* You must have java 11 
* Maven installed

### Dependencies
* jaxws-ri
* jersey-container-grizzly2-http
* jersey-hk2
* gson
* jersey-media-json-jackson
### Run and project settings
* Clone the repository
* Open the terminal in the directory where you cloned this repository
* run the command `mvn clean install exec::java`

## Tutorial on how to use the app

<img src="https://github.com/monotera/MC-Taller2/blob/master/Resources/product_list.png" alt="list_of_products" width="700"/>
When the application starts, the list of products from the database will be displayed. Here you will have several options to proceed.

<img src="https://github.com/monotera/MC-Taller2/blob/master/Resources/mod_step.png" alt="list_of_products" width="500"/>
One action you can take is to change the place of departure and the place of arrival. In the product card you must select the button "Modificar lugar"

<img src="https://github.com/monotera/MC-Taller2/blob/master/Resources/modificar_step.png" alt="list_of_products" width="500"/>

