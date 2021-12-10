# UC7 - Estacionar um veiculo

## Formato Breve

O utilizador registado inicia o pedido de estacionar/acabar a trip. O sistema solicita o email e a localizacao do utilizador. O utilizador registado introduz os dados solicitados. O sistema valida e apresenta o calor a pagar e notificação se esta bem ou mal estacionado. O utilizador registado confirma. O sistema bloqueia o veiculo e informa do sucesso da operação.

## SSD
![UC8-SSD.png](SSD_UC8.png)

## Formato Completo

### Ator principal

Utilizador Registado

### Partes interessadas e seus interesses
* **Utilizador Registado:** pretende acabar a trip
* **Empresa:** pretende que as trips sejam efectuados com sucesso.

### Pré-condições
O utilizador já tem de estar registado.

### Pós-condições
O veiculo é bloquado e a trip terminada é efectuado.

## Cenário de sucesso principal (ou fluxo básico)

1. O utilizador registado inicia o pedido de estacionar/acabar a trip.
2.  sistema solicita o email e a localizacao do utilizador.
3. O utilizador registado introduz os dados solicitados.
4. O sistema valida e apresenta o calor a pagar e notificação se esta bem ou mal estacionado.
5. O utilizador registado confirma.
6. O sistema bloqueia o veiculo e informa do sucesso da operação.

### Extensões (ou fluxos alternativos)

a. O utilizador solicita o cancelamento da fim da trip.

> O caso de uso termina.

4a. Dados mínimos obrigatórios em falta.
>	1. O sistema informa quais os dados em falta.
>	2. O sistema permite a introdução dos dados em falta (passo 3)
>
	>	2a. O utilizador não altera os dados. O caso de uso termina.

4b. O sistema detecta que os dados introduzidos (ou algum subconjunto dos dados) são inválidos.
> 1. O sistema alerta o administrativo para o facto. 
> 2. O sistema permite a sua alteração (passo 3).
> 
	> 2a. O utilizador não altera os dados. O caso de uso termina. 

### Requisitos especiais
\-

### Lista de Variações de Tecnologias e Dados
\-

### Frequência de Ocorrência
\-

### Questões em aberto
\-