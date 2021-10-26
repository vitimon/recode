algoritmo "cadastramento e consulta agencia de viagens"

var

   cadastroCliente : vetor[0..100] de caractere
   quantCliente : inteiro
   cadastroDestino : vetor[0..100] de caractere
   quantDestino: inteiro


inicio
      escreval("BEM VINDE")
      quantCliente <- 1
      quantDestino <- 1
      procedimento menuInicial()
                   var num : inteiro
                   inicio
                         escreval("O que gostaria de fazer? 1 = cadastrar cliente | 2 = cadastrar destino | 3 = consultar | 4 = sair")
                         leia(num)
                         escolha num
                         caso 1
                              menuCadastro(1)
                         caso 2
                              menuCadastro(2)
                         caso 3
                              menuConsulta()
                         outrocaso
                                  fimalgoritmo
                         
                   fimprocedimento
      procedimento menuCadastro(tipoCadastro : inteiro)
                   var nome : caractere
                   inicio
                         escolha tipoCadastro
                         caso 1
                              escreval("Qual o nome do novo cliente?")
                              leia(nome)
                              cadastroCliente[quantCliente] <- nome
                              quantCliente <- quantCliente + 1
                              menuInicial()
                         caso 2
                              escreval("Qual o nome do novo destino?")
                              leia(nome)
                              cadastroDestino[quantDestino] <- nome
                              quantDestino <- quantDestino + 1
                              menuInicial()

                         menuInicial()

                   fimprocedimento
      procedimento menuConsulta()
                   var num : inteiro
                   inicio
                         escreval("O que quer consultar? 1 = cliente | 2 = destino | 3 = voltar")
                         leia(num)
                         escolha num
                         caso 1

                              para num de 1 ate 100 faca
                              se cadastroCliente[num] = "" entao
                                 escreval("fim da clientela")
                                 interrompa
                              senao
                                   escreval(cadastroCliente[num])
                              fimse
                              fimpara
                              menuConsulta()
                         caso 2
                         
                              para num de 1 ate 100 faca
                              se cadastroDestino[num] = "" entao
                                 escreval("fim das opções de destino")
                                 interrompa
                              senao
                                   escreval(cadastroDestino[num])
                              fimse
                              fimpara
                               menuConsulta()
                                   
                         outrocaso
                                   menuInicial()

                   fimprocedimento

      menuInicial()

fimalgoritmo