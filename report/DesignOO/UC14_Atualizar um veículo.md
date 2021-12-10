# Realização de UC14 Atualizar um Veículo

## Racional

| Fluxo Principal                                                                                        | Questão: Que Classe...                                      | Resposta                                       | Justificação                                                                                                         |
|:-------------------------------------------------------------------------------------------------------|:------------------------------------------------------------|:-----------------------------------------------|:---------------------------------------------------------------------------------------------------------------------|
| 1. O administrativo inicia a atualização de um veículo. | ... interage com o utilizador? | AtaulizarVeiculoUI                          | Pure Fabrication, pois não se justifica atribuir esta responsabilidade a nenhuma classe existente no Modelo de Domínio. |
|| ... coordena o UC?                                                                              | AtualizarVeiculoController                                | Controller.                                    |                                                                                                                                                                                                            
| 2.	O sistema solicita o veiculo. |                  |                                                |                                                                                                                      |
| 3.	O administrativo introduz o veículo a atualizar.   | ... guarda os dados introduzidos?                    | Empresa                                     | Information Expert (IE)                                                                                              |
| 4.	 O sistema valida e solicita a inserção dos novos dados do veículo.                                                             | ... valida os dados do veiculo (validação local)? | Veiculo                                     | IE: Veículo possui os seus próprios dados                                                                                                                   |
|| ... valida os dados do veiculo (validação global)?                                           | Empresa                                               | IE: A Empresa contém/agrega parques |                                                                                                                      |
| 5. O administrativo insere os novos dados do veículo.                                                            | 
|												|
											|
| 6. O sistema valida, pedindo confirmação                                   | ... valida os dados do veiculo (validação local)? | Veiculo                                    | IE: Veiculo possui os seus próprios dados                                                                                                                   |
|| ... valida os dados do veiculo (validação global)?                                           | Empresa                                               | IE: A Empresa contém/agrega parques |                                                                                                                      |
| 7.O administrativo confirma.                                                         | 
|												|
											|
| 8.	O sistema atualiza o veículo e informa o administrativo do sucesso da operação.                       | ... atualiza o veículo especificado?                            | Empresa                                 | IE: A Empresa contém/agrega parques                                                                 |
|| ... notifica o administrativo?                                                                                   | AtualizarVeiculoUI                                        |                                                |                                                                                                                      |

## Sistematização ##

 Do racional resulta que as classes conceptuais promovidas a classes de software são:

 * Empresa
 * Veiculo

Outras classes de software (i.e. Pure Fabrication) identificadas:  

 * AtualizarVeiculoUI  
 * AtualizarVeiculoController

##	Diagrama de Sequência

![SD_UC14.jpg](SD_UC14.jpg)

##	Diagrama de Classes

![CD_UC14.jpg](CD_UC14.jpg)