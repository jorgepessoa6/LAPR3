# Mostrar veículos disponíveis de um parque

## Racional

| Fluxo Principal                                                                                        | Questão: Que Classe...                                      | Resposta                                       | Justificação                                                                                                         |
|:-------------------------------------------------------------------------------------------------------|:------------------------------------------------------------|:-----------------------------------------------|:---------------------------------------------------------------------------------------------------------------------|
| 1. O utilizador registado inicia a consulta de veículos disponíveis num parque.. | ... interage com o utilizador? | MostrarVeiculosUI                          | Pure Fabrication, pois não se justifica atribuir esta responsabilidade a nenhuma classe existente no Modelo de Domínio. |
|| ... coordena o UC?                                                                              | MostrarVeiculosController                                | Controller.                                    |                                                                                                                                                                                                            
| 2.	O sistema solicita o parque que pretende. |                  |                                                |                                                                                                                      |
| 3.	O utilizador registado introduz o parque.   | ... guarda os dados introduzidos?                    | Empresa                                     | Information Expert (IE)                                                                                              |
| 4.	 O sistema valida e mostra os veículos disponíveis no parque e pede confirmação.                                                             | ... valida os dados do parque (validação local)? | Parque                                     | IE: Parque possui os seus próprios dados                                                                                                                   |
|| ... valida os dados do parque (validação global)?                                           | Empresa                                               | IE: A Empresa contém/agrega parques |                                                                                                                      |
| 5. O utilizador registado confirma.                                                                     |                                                             |                                                |                                                                                                                      |
| 6.	O sistema informa o utilizador registado do sucesso da operação.                           | |                                  |                                                                   |
|| ... notifica o administrador?                                                                                   | MostrarVeiculosUI                                        |                                                |                                                                                                                      |

## Sistematização ##

 Do racional resulta que as classes conceptuais promovidas a classes de software são:

 * Empresa
 * Parque

Outras classes de software (i.e. Pure Fabrication) identificadas:  

 * MostrarVeiculosUI  
 * MostrarVeiculosController

##	Diagrama de Sequência

![SD_UC6.jpg](SD_UC6.jpg)

##	Diagrama de Classes

![CD_UC6.jpg](CD_UC6.jpg)

