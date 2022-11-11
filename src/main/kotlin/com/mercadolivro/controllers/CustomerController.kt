package com.mercadolivro.controllers

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.model.PostCustomerRequest
import com.mercadolivro.model.PutRequestCustomer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customer")
class CustomerController {

    //lista mutavel
    val customers = mutableListOf<CustomerModel>()

    @GetMapping
    fun getCustomer(): MutableList<CustomerModel> {
        return customers

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {

        var id = if (customers.isEmpty()){

            "1"
        } else {

            customers.last().id.toInt() + 1



        }.toString()

        customers.add( CustomerModel(id,customer.nome, customer.email))




    }
    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customers.filter { it.id == id }.first()



    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: String,@RequestBody customer: PutRequestCustomer) {
        customers.filter { it.id == id }.first().let {
            it.nome = customer.nome;
            it.email = customer.email
        }



    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: String) {
        customers.removeIf { it.id == id }
        }




}