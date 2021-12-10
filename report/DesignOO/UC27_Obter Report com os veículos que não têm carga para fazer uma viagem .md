# Realização de UC27 Obter Report com os veículos que não têm carga para fazer uma viagem

## Racional

| Fluxo Principal                                                                                        | Questão: Que Classe...                                      | Resposta                                       | Justificação                                                                                                         |
|:-------------------------------------------------------------------------------------------------------|:------------------------------------------------------------|:-----------------------------------------------|:---------------------------------------------------------------------------------------------------------------------|
| 1. O administrador inicia a obtenção do report com os veículos que não têm carga para fazer uma viagem. | ... interage com o utilizador? | ObterReportUI                          | Pure Fabrication, pois não se justifica atribuir esta responsabilidade a nenhuma classe existente no Modelo de Domínio. |
|| ... coordena o UC?                                                                              | ObterReportController                                | Controller.                                    |                                                                                                                                                                                                            
| 2.O sistema solicita os dados necessários (km). |                  |                                                |                                                                                                                      |
| 3.O administrador introduz os dados solicitados.   | ... guarda os dados introduzidos?                    | Empresa                                     | Information Expert (IE)                                                                                              |
| 4. O sistema valida e apresenta os dados, pedindo que os confirme.                                                             | ... valida os dados da scooter (validação local)? | Scooter                                     | IE: Scooter possui os seus própios atributos.                                                                                                                   |
|| ... valida os dados da Scooter (validação global)?                                           | Empresa                                               | IE: A Empresa contém/agrega Scooters |                                                                                                            |
| 5. O administrativo confirma.                                                                     |                                                             |                                                |                                                                                                                      |
| 6.O sistema atualiza a bateria da scooter.                        | ... cria o report?                            | Empresa                                 | IE: A Empresa contém/agrega Scooters                                                                |
|| ... notifica o administrativo?                                                                                   | ObterReportUI                                        |                                                |                                                                                                                      |

 Do racional resulta que as classes conceptuais promovidas a classes de software são:

 * Empresa
 * Scooter

Outras classe## Sistematização ##

s de software (i.e. Pure Fabrication) identificadas:  

 * ObterReportUI  
 * ObterReportController

##	Diagrama de Sequência

![SD_UC27.jpg](SD_UC27.jpg)

##	Diagrama de Classes

![CD_UC27.jpg](CD_UC27.jpg)
