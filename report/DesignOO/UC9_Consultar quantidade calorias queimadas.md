# Realização de UC9 Consultar quantidade de calorias queimadas

## Racional

| Fluxo Principal                                                                                        | Questão: Que Classe...                                      | Resposta                                       | Justificação                                                                                                         |
|:-------------------------------------------------------------------------------------------------------|:------------------------------------------------------------|:-----------------------------------------------|:---------------------------------------------------------------------------------------------------------------------|
| 1. O cliente pede informações das calorias queimadas entre dois parques.. | ... interage com o utilizador? | CalcularCaloriasUI                          | Pure Fabrication, pois não se justifica atribuir esta responsabilidade a nenhuma classe existente no Modelo de Domínio. |
|| ... coordena o UC?                                                                              | CalcularCaloriasController                                | Controller.                                    |                                                                                                                                                                                                            
| 2.	O sistema solicita os dados necessários (i.e. parque inicial, paque final, vento, velocidade,km). |                  |                                                |                                                                                                                      |
| 3.	O Cliente introduz os dados solicitados.   | ... guarda os dados introduzidos?                    | Empresa                                     | Information Expert (IE)                                                                                              |
| 4.	 O sistema valida e apresenta os dados, pedindo que os confirme.                                                             | ... valida os dados do parque (validação local)? | Parque                                     | IE: Parque possui os seus próprios dados                                                                                                                   |
|| ... valida os dados do parque (validação global)?                                           | Empresa                                               | IE: A Empresa contém/agrega parques |                                                                                                                      |
| 5. O administrativo confirma.                                                                     |                                                             |                                                |                                                                                                                      |
| 6. O sistema calcula a quantidade de calorias e informa o cliente do sucesso da operação.                           | ... calcula as calorias gastas?                            | Empresa                                 | IE: A Empresa contém/agrega parques                                                                 |
|| ... notifica o administrativo?                                                                                   | CalcularCaloriasUI                                        |                                                |                                                                                                                      |

 Do racional resulta que as classes conceptuais promovidas a classes de software são:

 * Empresa
 * Parque

Outras classe## Sistematização ##

s de software (i.e. Pure Fabrication) identificadas:  

 * CalcularCaloriasUI  
 * CalcularCaloriasController

##	Diagrama de Sequência

![SD_UC9.jpg](SD_UC9.jpg)

##	Diagrama de Classes

![CD_UC9.jpg](CD_UC9.jpg)