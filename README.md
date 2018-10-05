# Triângulo via Web Service Restful

Escreva um **Web Service Restful** para resolver o problema proposto em http://www.ramon.pro.br/exercicio-de-programacao-triangulo/.

Informação      | Valor
----------------|-----------------------------------------------------------------------
**URL**         | `http://localhost:8080/dcs-jaxrs-triangulo/webresources/triangulo/`**lado1**`/`**lado2**`/`**lado3**
**Método**      | `GET`
**Status Code** | `200` se é um triângulo ou `404` se não foi possível "encontrar" um triângulo com os lados enviados.

**Atenção:** use um formulário HTML para entrar com os lados e **AJAX** para fazer a chamada ao web service. Trate os erros adequadamente, ou seja, por meio de códigos de status HTTP (exemplo: quando não for um triângulo, pode-se retornar um 404 indicando que não foi encontrado um triângulo com os lados enviados).
