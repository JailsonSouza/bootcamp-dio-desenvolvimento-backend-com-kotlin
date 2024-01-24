enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Aluno(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 80)

data class Formacao(val nome: String, val nivel: Nivel = Nivel.BASICO, var conteudos: MutableList<ConteudoEducacional>) {
	
    val inscritos = mutableListOf<Aluno>()
    
	
    fun matricular(vararg listaDeAlunos: Aluno) {
        var message : String
        for (aluno in listaDeAlunos) {
            if (!inscritos.contains(aluno)) {
                inscritos.add(aluno)
                message = "Aluno ${aluno.nome} cadastrado com sucesso na Formação $nome."
                print("-".repeat((message.length / 2)-4))
                print(" ALERTA ")
                println("-".repeat((message.length / 2)-4))
                println(message)
                println("-".repeat(message.length))
            } else {
                message = "ERROR ao tentar cadastrar! O aluno ${aluno.nome} já está matriculado na Formação."
                print("-".repeat((message.length / 2)-4))
                print(" ALERTA ")
                println("-".repeat((message.length / 2)-4))
                println(message)
                println("-".repeat(message.length))
            }
            println()
        }
    }
    
}

fun imprimirListaDeInscritos(listaDeInscritos: Formacao) {
    if (listaDeInscritos.inscritos.isNotEmpty()) {
        println("\n------------------ ALUNOS INSCRITOS NA FORMAÇÃO ${listaDeInscritos.nome} - NIVEL ${listaDeInscritos.nivel} ---------------------")
        for (inscrito in listaDeInscritos.inscritos) {
            println("Nome: ${inscrito.nome}.")
        }
        println("----------------------------------------------------------------------------------------")
    } else {
        println("Não há alunos inscritos na formação ${listaDeInscritos.nome}.")
    }
}

fun imprimirListaDeCursos(listaDeCursos: Formacao) {
    if (listaDeCursos.conteudos.isNotEmpty()) {
    	println("\n----------------- GRADES DE CURSOS DA FORMAÇÃO ${listaDeCursos.nome} - NIVEL ${listaDeCursos.nivel} ---------------------------")
        for (curso in listaDeCursos.conteudos) {
            println("${curso.nome}.")
        }
        println("--------------------------------------------------------------------------------------------------------")
    } else {
        println("Não há cursos devidamente cadastrados na formação ${listaDeCursos.nome}.")
    }
	
}

fun main() {

    val aluno01 = Aluno("Matheus")
    val aluno02 = Aluno("Douglas")
    val aluno03 = Aluno("Joaozinho")

    val curso01 = ConteudoEducacional("Conhecendo Kotlin e sua Documentação Oficial")
    val curso02 = ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin", 2)
    val curso03 = ConteudoEducacional("Estrutura de Controle de Fluxo e Coleções em Kotlin", 2)
    val curso04 = ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Prática com Kotlin", 2)
    val curso05 = ConteudoEducacional("O Poder das Funções em Kotlin", 2)
    val curso06 = ConteudoEducacional("Tratamento de Exceções em Kotlin", 2)
	val curso07 = ConteudoEducacional("LifeCycle Hooks Angular", 2)
    val curso08 = ConteudoEducacional("Single Page Aplication com Angular", 2)
    
    val formacaoKotlin = Formacao("KOTLIN", Nivel.BASICO, mutableListOf(curso01, curso02, curso03, curso04, curso05, curso06))
    formacaoKotlin.matricular(aluno01, aluno02)
    formacaoKotlin.matricular(aluno02)
    imprimirListaDeInscritos(formacaoKotlin)
    imprimirListaDeCursos(formacaoKotlin)
    
    println()
    
    val formacaoAngular = Formacao("ANGULAR FRAMEWORK", Nivel.INTERMEDIARIO, mutableListOf(curso07, curso08))
    //formacaoAngular.matricular(aluno01, aluno03)
    imprimirListaDeInscritos(formacaoAngular)
    imprimirListaDeCursos(formacaoAngular)
}