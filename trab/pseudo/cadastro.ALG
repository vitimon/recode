algoritmo "cadastramento e consulta agencia de viagens"

var

   cadastroCliente : vetor[0..100,0..2] de caractere
   quantCliente : inteiro
   cadastroDestino : vetor[0..100,0..1] de caractere
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
                              cadastroCliente[quantCliente,0] <- nome
                              escreval("Qual o cpf do novo cliente?")
                              leia(nome)
                              cadastroCliente[quantCliente,1] <- nome
                              escreval("Qual o email do novo cliente?")
                              leia(nome)
                              cadastroCliente[quantCliente,2] <- nome
                              quantCliente <- quantCliente + 1
                              menuInicial()
                         caso 2
                              escreval("Qual o nome do novo destino?")
                              leia(nome)
                              cadastroDestino[quantDestino,0] <- nome
                              escreval("Qual o preço do novo destino?")
                              leia(nome)
                              cadastroDestino[quantDestino,1] <- nome
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
                              escreval( "NOME     CPF       email")
                              para num de 1 ate 100 faca
                              se cadastroCliente[num] = "" entao
                                 escreval("fim da clientela")
                                 interrompa
                              senao
                                   escreval(cadastroCliente[num,0]+" "+cadastroCliente[num,1]+" "+cadastroCliente[num,2])
                              fimse
                              fimpara
                              menuConsulta()
                         caso 2
                              escreval("DESTINO   PREÇO")
                              para num de 1 ate 100 faca
                              se cadastroDestino[num] = "" entao
                                 escreval("fim das opções de destino")
                                 interrompa
                              senao
                                   escreval(cadastroDestino[num,0]+" "+cadastroDestino[num,1])
                              fimse
                              fimpara
                               menuConsulta()
                                   
                         outrocaso
                                   menuInicial()

                   fimprocedimento

      menuInicial()

fimalgoritmo