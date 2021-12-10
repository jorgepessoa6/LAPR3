# Realização de UC2 Remover um parque

## Racional

| Fluxo Principal                                                                                        | Questão: Que Classe...                                      | Resposta                                       | Justificação                                                                                                         |
|:-------------------------------------------------------------------------------------------------------|:------------------------------------------------------------|:-----------------------------------------------|:---------------------------------------------------------------------------------------------------------------------|
| 1. O administrativo inicia a remoção de um parque. | ... interage com o utilizador? | RemoverParqueUI                          | Pure Fabrication, pois não se justifica atribuir esta responsabilidade a nenhuma classe existente no Modelo de Domínio. |
|| ... coordena o UC?                                                                              | RemoverParqueController                                | Controller.                                    |                                                                                                                                                                                                            
| 2.	O sistema solicita o parque a remover. |                  |                                                |                                                                                                                      |
| 3.	O administrativo introduz o parque a remover.   | ... guarda os dados introduzidos?                    | Empresa                                     | Information Expert (IE)                                                                                              |
| 4.	 O sistema valida e apresenta o parque a remover ao administrativo, pedindo confirmação.                                                             | ... valida os dados do parque (validação local)? | Parque                                     | IE: Parque possui os seus próprios dados                                                                                                                   |
|| ... valida os dados do parque (validação global)?                                           | Empresa                                               | IE: A Empresa contém/agrega parques |                                                                                                                      |
| 5. O administrativo confirma.                                                                     |                                                             |                                                |                                                                                                                      |
| 6.	O sistema remove o parque e informa o administrativo do sucesso da operação.                           | ... remove o parque especificado?                            | Empresa                                 | IE: A Empresa contém/agrega parques                                                                 |
|| ... notifica o administrativo?                                                                                   | RemoverParqueUI                                        |                                                |                                                                                                                      |

## Sistematização ##

 Do racional resulta que as classes conceptuais promovidas a classes de software são:

 * Empresa
 * Parque

Outras classes de software (i.e. Pure Fabrication) identificadas:  

 * RemoverParqueUI  
 * RemoverParqueController

##	Diagrama de Sequência

![SD_UC2.png](SD_UC2.png)

##	Diagrama de Classes

![CD_UC2.png](CD_UC2.png)

