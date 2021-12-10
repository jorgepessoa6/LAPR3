# UC26 - Obter Report com os veículos que não têm carga para fazer uma viagem

## Formato Breve

O administrador inicia a obtenção do report com os veículos que não têm carga para fazer uma viagem. O sistema solicita os dados necessários (km). O administrador introduz os dados solicitados. O sistema valida e apresenta os dados, pedindo que os confirme. O administrador confirma. O sistema apresenta os veiculos que não têm carga para fazer a viagem.

## SSD
![SSD_UC26.jpg](SSD_UC26.jpg)


## Formato Completo

### Ator principal

Administrador

### Partes interessadas e seus interesses
* **Administrador:** pretende saber os veículos que não têm carga para efetuar a viagem.


### Pré-condições
n/a

### Pós-condições
n/a

## Cenário de sucesso principal (ou fluxo básico)

1. O administrador inicia a obtenção do report com os veículos que não têm carga para fazer uma viagem.
2. O sistema solicita os dados necessários (km).
3. O administrador introduz os dados solicitados.
4. O sistema valida e apresenta os dados, pedindo que os confirme.
5. O administrador confirma.
6. O sistema apresenta os veiculos que não têm carga para fazer a viagem.

### Extensões (ou fluxos alternativos)

*a. O administrador solicita o cancelamento das informações.

> O caso de uso termina.

	
4a. Dados mínimos obrigatórios em falta.
>	1. O sistema informa quais os dados em falta.
>	2. O sistema permite a introdução dos dados em falta (passo 3).
>
	>	2a. O administrador não altera os dados. O caso de uso termina.


4b. O sistema detecta que os dados introduzidos (ou algum subconjunto dos dados) são inválidos.
> 1. O sistema alerta o cliente para o facto. 
> 2. O sistema permite a sua alteração (passo 3).
> 
	> 2a. O administrador não altera os dados. O caso de uso termina. 

### Requisitos especiais
\-

### Lista de Variações de Tecnologias e Dados
\-

### Frequência de Ocorrência
\-

### Questões em aberto