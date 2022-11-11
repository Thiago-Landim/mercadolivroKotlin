package com.mercadolivro.fundamentos

class Pessoa (var nome: String, var idade:Int){
    override fun toString(): String {
        return "Classe: PEssoa. Nome:${nome}, idade: ${idade}"
    }

}

    fun main(){
        var thiago = Pessoa("Thiago",37)


        println(thiago)


    }


