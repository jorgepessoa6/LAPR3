# UC13 - Remover um veículo

## Formato Breve

O administrativo inicia a remoção de um veículo. O sistema solicita o veículo a remover. O administrativo introduz o veículo a remover. O sistema valida e apresenta o veículo a remover ao administrativo, pedindo confirmação. O administrativo confirma. O sistema remove o veículo e informa o administrativo do sucesso da operação.

## SSD
![UC13-SSD.png](SSD_UC13.png)

## Formato Completo

### Ator principal

Administrativo

### Partes interessadas e seus interesses
* **Administrativo:** pretende remover um veículo do sistema.
* **Utilizador:** pretende não utilizar veículos que já não existem.
* **Empresa:** pretende que a informação relativa aos veículos esteja atualizada.

### Pré-condições
O veículo tem de estar registado no sistema.

### Pós-condições
A informação do veículo é removida do sistema.

## Cenário de sucesso principal (ou fluxo básico)

1. O administrativo inicia a remoção de um veículo.
2. O sistema solicita o veículo a remover.
3. O administrativo introduz o veículo a remover.
4. O sistema valida e apresenta o veículo a remover ao administrativo, pedindo confirmação.
5. O administrativo confirma.
6. O sistema remove o veículo e informa o administrativo do sucesso da operação.

### Extensões (ou fluxos alternativos)

a. O administrativo solicita o cancelamento da remoção do veículo.

> O caso de uso termina.

4a. Dados mínimos obrigatórios em falta.
>	1. O sistema informa quais os dados em falta.
>	2. O sistema permite a introdução dos dados em falta (passo 3)
>
	>	2a. O administrativo não altera os dados. O caso de uso termina.

4b. O sistema detecta que os dados introduzidos (ou algum subconjunto dos dados) são inválidos.
> 1. O sistema alerta o administrativo para o facto. 
> 2. O sistema permite a sua alteração (passo 3).
> 
	> 2a. O administrativo não altera os dados. O caso de uso termina. 

### Requisitos especiais
\-

### Lista de Variações de Tecnologias e Dados
\-

### Frequência de Ocorrência
\-

### Questões em aberto
\-