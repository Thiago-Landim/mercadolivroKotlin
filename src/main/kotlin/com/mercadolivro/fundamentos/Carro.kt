package com.mercadolivro.fundamentos

class Carro(var cor: String, val anoFabricacao:Int) {
}
    fun main(){
        var carro = Carro("Branco",2022)
        println(carro.cor)
        carro.cor = "Azul"
        println(carro.cor)


}